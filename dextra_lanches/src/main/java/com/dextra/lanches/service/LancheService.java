package com.dextra.lanches.service;

import java.util.ArrayList;
import java.util.List;

import com.dextra.lanches.IngredientesInMemory;
import com.dextra.lanches.model.Ingrediente;
import com.dextra.lanches.model.Lanche;
import com.dextra.lanches.util.Constants;

public class LancheService {

	private Lanche lanche;

	public LancheService(Lanche lanche) {
		this.lanche = lanche;
	}

	public Lanche calcularPreco() {

		qualTipoDeLanche();
		lanche.setPrecoDoLanche(0.0);
		calcularPrecoPelaSomaDosIngredientes();

		lanche.setPrecoDoLanche(lanche.getPrecoDoLanche() - new PromocaoService(lanche).calcularDescontos());

		lanche.setDescricaoDoPedido(
				lanche.getDescricaoDoPedido() + "\nPreco final do lanche: " + lanche.getPrecoDoLanche());

		return lanche;
	}

	private void calcularPrecoPelaSomaDosIngredientes() {

		for (Ingrediente ingrediente : lanche.getIngredientes()) {
			
			if (Constants.QUEIJO.equals(ingrediente.getNome())) {

				lanche.setPrecoDoLanche(
						lanche.getPrecoDoLanche() + ingrediente.getQuantidade() * ingrediente.getPreco());
				lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nPorções de Queijo ("
						+ ingrediente.getQuantidade() + ") * preço (" + ingrediente.getPreco() + "): "
						+ ingrediente.getQuantidade() * ingrediente.getPreco());
				
			} else if (Constants.OVO.equals(ingrediente.getNome())) {
				
				lanche.setPrecoDoLanche(
						lanche.getPrecoDoLanche() + ingrediente.getQuantidade() * ingrediente.getPreco());
				lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nPorções de Ovo ("
						+ ingrediente.getQuantidade() + ") * preço (" + ingrediente.getPreco() + "): "
						+ ingrediente.getQuantidade() * ingrediente.getPreco());
				
				
			} else if (Constants.HAMBURGER_DE_CARNE.equals(ingrediente.getNome())) {
				lanche.setPrecoDoLanche(
						lanche.getPrecoDoLanche() + ingrediente.getQuantidade() * ingrediente.getPreco());
				lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nPorções de Hambúrger de Carne ("
						+ ingrediente.getQuantidade() + ") * preço (" + ingrediente.getPreco() + "): "
						+ ingrediente.getQuantidade() * ingrediente.getPreco());
				
			} else if (Constants.BACON.equals(ingrediente.getNome())) {
				
				lanche.setPrecoDoLanche(
						lanche.getPrecoDoLanche() + ingrediente.getQuantidade() * ingrediente.getPreco());
				lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nPorções de Bacon ("
						+ ingrediente.getQuantidade() + ") * preço (" + ingrediente.getPreco() + "): "
						+ ingrediente.getQuantidade() * ingrediente.getPreco());
				
			} else if (Constants.ALFACE.equals(ingrediente.getNome())) {
				
				lanche.setPrecoDoLanche(
						lanche.getPrecoDoLanche() + ingrediente.getQuantidade() * ingrediente.getPreco());
				lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nPorções de Alface ("
						+ ingrediente.getQuantidade() + ") * preço (" + ingrediente.getPreco() + "): "
						+ ingrediente.getQuantidade() * ingrediente.getPreco());
				
			}
		}
	}

	private void qualTipoDeLanche() {

		switch (lanche.getNomeDoLanche()) {

		case Constants.X_BACON:
			lanche.setDescricaoDoPedido("\n\nCalculando preço para X-Bacon:");
			monteXBacon();
			break;
		case Constants.X_BURGER:
			lanche.setDescricaoDoPedido("\n\nCalculando preço para X-Burger:");
			monteXBurger();
			break;
		case Constants.X_EGG:
			lanche.setDescricaoDoPedido("\n\nCalculando preço para X-Egg:");
			monteXEgg();
			break;
		case Constants.X_EGG_BACON:
			lanche.setDescricaoDoPedido("\n\nCalculando preço para X-Egg Bacon:");
			monteXEggBacon();
			break;
		}

	}

	private void monteXEggBacon() {
		if(lanche.getIngredientes() == null) {
			List<Ingrediente> ingrediente = new ArrayList<>(); 
			ingrediente.add(IngredientesInMemory.getUmOvoInMemory(1)); 
			lanche.setIngredientes(ingrediente);
		} else {
			lanche.getIngredientes().add(IngredientesInMemory.getUmOvoInMemory(1));
		}
		lanche.getIngredientes().add(IngredientesInMemory.getUmBaconInMemory(1));
		lanche.getIngredientes().add(IngredientesInMemory.getUmHamburgerDeCarneInMemory(1));
		lanche.getIngredientes().add(IngredientesInMemory.getUmQueijoInMemory(1));
	}

	private void monteXEgg() {
		if(lanche.getIngredientes() == null) {
			List<Ingrediente> ingrediente = new ArrayList<>(); 
			ingrediente.add(IngredientesInMemory.getUmOvoInMemory(1)); 
			lanche.setIngredientes(ingrediente);
		} else {
			lanche.getIngredientes().add(IngredientesInMemory.getUmOvoInMemory(1));
		}
		lanche.getIngredientes().add(IngredientesInMemory.getUmHamburgerDeCarneInMemory(1));
		lanche.getIngredientes().add(IngredientesInMemory.getUmQueijoInMemory(1));
	}

	private void monteXBurger() {
		if(lanche.getIngredientes() == null) {
			List<Ingrediente> ingrediente = new ArrayList<>(); 
			ingrediente.add(IngredientesInMemory.getUmHamburgerDeCarneInMemory(1)); 
			lanche.setIngredientes(ingrediente);
		} else {
			lanche.getIngredientes().add(IngredientesInMemory.getUmHamburgerDeCarneInMemory(1));
		}
		lanche.getIngredientes().add(IngredientesInMemory.getUmQueijoInMemory(1));
	}

	private void monteXBacon() {
		if(lanche.getIngredientes() == null) {
			List<Ingrediente> ingrediente = new ArrayList<>(); 
			ingrediente.add(IngredientesInMemory.getUmBaconInMemory(1)); 
			lanche.setIngredientes(ingrediente);
		} else {
			lanche.getIngredientes().add(IngredientesInMemory.getUmBaconInMemory(1));
		}
		lanche.getIngredientes().add(IngredientesInMemory.getUmHamburgerDeCarneInMemory(1));
		lanche.getIngredientes().add(IngredientesInMemory.getUmQueijoInMemory(1));

	}

}
