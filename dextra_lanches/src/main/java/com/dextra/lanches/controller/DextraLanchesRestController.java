package com.dextra.lanches.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dextra.lanches.model.Lanche;
import com.dextra.lanches.service.LancheService;

@RestController
public class DextraLanchesRestController {

	@RequestMapping(value = "/preco-final", method = RequestMethod.POST)
	public String calcularPrecoDoLanche(@RequestBody Lanche lanche) { 
		System.out.println(lanche.toString());
		return new LancheService(lanche).calcularPreco().getDescricaoDoPedido().replaceAll("\n", " ||------------> "); 
	}
	
}
