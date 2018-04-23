var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
		var url = $location.absUrl() + "preco-final";
		
		var config = {
                headers : {
                	'Accept': 'text/plain'
                }
        }
		
		var data = {
			nomeDoLanche: $scope.nomeDoLanche,
			ingredientes: [	{ nome: 'queijo', preco: 1.5, quantidade: $scope.ingredientes.nome.queijo },
							{ nome: 'hamburgerDeCarne', preco: 3.0, quantidade: $scope.ingredientes.nome.hamburgerDeCarne },
							{ nome: 'ovo', preco: 0.8, quantidade: $scope.ingredientes.nome.ovo },
							{ nome: 'alface', preco: 0.4, quantidade: $scope.ingredientes.nome.alface },
							{ nome: 'bacon', preco: 2.0, quantidade: $scope.ingredientes.nome.bacon } ]
        };
		
		$http.post(url, angular.toJson(data), config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		$scope.nomeDoLanche = "";
		$scope.ingredientes.nome.alface = "";
		$scope.ingredientes.nome.bacon = "";
		$scope.ingredientes.nome.hamburgerDeCarne = "";
		$scope.ingredientes.nome.ovo = "";
		$scope.ingredientes.nome.queijo = "";
	}
});
