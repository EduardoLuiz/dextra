package com.dextra.lanches;

import com.dextra.lanches.model.Ingrediente;
import com.dextra.lanches.util.Constants;

public class IngredientesInMemory {
	
	private static boolean inflacao = false; 
	
	private IngredientesInMemory() {
	}
	
	private static Ingrediente alface = new Ingrediente(Constants.ALFACE, 0.40, 0); 
	private static Ingrediente bacon = new Ingrediente(Constants.BACON, 2.00, 0); 
	private static Ingrediente hamburgerDeCarne = new Ingrediente(Constants.HAMBURGER_DE_CARNE, 3.00, 0); 
	private static Ingrediente ovo = new Ingrediente(Constants.OVO, 0.80, 0); 
	private static Ingrediente queijo = new Ingrediente(Constants.QUEIJO, 1.50, 0); 
	
	public static void resetIngredientes() {
		alface.setQuantidade(0);
		bacon.setQuantidade(0);
		hamburgerDeCarne.setQuantidade(0);
		ovo.setQuantidade(0);
		queijo.setQuantidade(0);
	}
	
	public static Ingrediente getAlfaceInMemory(Integer quantidade) {
		alface.setQuantidade(alface.getQuantidade() + quantidade);
		return alface; 
	}
	
	public static Ingrediente getBaconInMemory(Integer quantidade) {
		bacon.setQuantidade(bacon.getQuantidade() + quantidade);
		return bacon; 
	}
	
	public static Ingrediente getHamburgerDeCarneInMemory(Integer quantidade) {
		hamburgerDeCarne.setQuantidade(hamburgerDeCarne.getQuantidade() + quantidade);
		return hamburgerDeCarne; 
	}
	
	public static Ingrediente getOvoInMemory(Integer quantidade) {
		ovo.setQuantidade(ovo.getQuantidade() + quantidade);
		return ovo; 
	}
	
	public static Ingrediente getQueijoInMemory(Integer quantidade) {
		queijo.setQuantidade(queijo.getQuantidade() + quantidade);
		return queijo; 
	}
	
	public static Ingrediente getUmaAlfaceInMemory(Integer quantidade) {
		return new Ingrediente(Constants.ALFACE, 0.40, 1); 
	}
	
	public static Ingrediente getUmBaconInMemory(Integer quantidade) {
		return new Ingrediente(Constants.BACON, 2.00, 1);  
	}
	
	public static Ingrediente getUmHamburgerDeCarneInMemory(Integer quantidade) {
		if(inflacao) {
			return new Ingrediente(Constants.HAMBURGER_DE_CARNE, 3.60, 1); 
		}
		return new Ingrediente(Constants.HAMBURGER_DE_CARNE, 3.00, 1); 
	}
	
	public static Ingrediente getUmOvoInMemory(Integer quantidade) {
		return new Ingrediente(Constants.OVO, 0.80, 1); 
	}
	
	public static Ingrediente getUmQueijoInMemory(Integer quantidade) {
		return new Ingrediente(Constants.QUEIJO, 1.50, 1); 
	}
	
	public static void setInflamacaoSobreHamburger () {
		hamburgerDeCarne.setPreco(3.60); 
	}

	public static void setInflacao(boolean inflacao) {
		IngredientesInMemory.inflacao = inflacao;
	}
	
}
