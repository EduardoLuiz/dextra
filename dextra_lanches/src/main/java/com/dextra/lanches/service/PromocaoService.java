package com.dextra.lanches.service;

import com.dextra.lanches.model.Ingrediente;
import com.dextra.lanches.model.Lanche;
import com.dextra.lanches.util.Constants;

public class PromocaoService {

	private Lanche lanche;
	private Double descontos = 0.0;

	public PromocaoService(Lanche lanche) {
		this.lanche = lanche;
	}

	public Double calcularDescontos() {

		temMuitaCarne();
		temMuitoQueijo();
		ehLight(); // último desconto; cálculo deve ser feito sobre o valor final

		lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nTotal de Descontos: " + descontos);
		return descontos;
	}

	private void temMuitoQueijo() {
		Integer count = 0;
		Double precoAtual = 0.00;
		for (Ingrediente ingrediente : lanche.getIngredientes()) {
			if (Constants.QUEIJO.equals(ingrediente.getNome())) {
				count+= ingrediente.getQuantidade();
				precoAtual = ingrediente.getPreco();
			}
		}

		if (count >= 3) {
			lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nVocê escolheu " + count
					+ " porções de Queijo, mas vai pagar apenas " + (count - (count / 3))
					+ " no desconto 'Muito Queijo': ");
			count = count - // calcular quanto descontar
					(count - (count / 3)); // calcular quanto vai pagar
			descontos = precoAtual * count;
			lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "-" + (precoAtual * count));
			lanche.setPrecoDoLanche(lanche.getPrecoDoLanche() - descontos);
		}
	}

	private void temMuitaCarne() {
		Integer count = 0;
		Double precoAtual = 0.00;
		for (Ingrediente ingrediente : lanche.getIngredientes()) {
			if (Constants.HAMBURGER_DE_CARNE.equals(ingrediente.getNome())) {
				count+= ingrediente.getQuantidade();
				precoAtual = ingrediente.getPreco();
			}
		}

		if (count >= 3) {
			lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "\nVocê escolheu " + count
					+ " porções de Hambúrguer de carne, mas vai pagar apenas " + (count - (count / 3))
					+ " no desconto 'Muita Carne': ");
			count = count - // calcular quanto descontar
					(count - (count / 3)); // calcular quanto vai pagar
			descontos = precoAtual * count;
			lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "-" + (precoAtual * count));
			lanche.setPrecoDoLanche(lanche.getPrecoDoLanche() - descontos);
		}
	}

	private void ehLight() {
		boolean temAlface = false;
		boolean temBacon = false;
		for (Ingrediente ingrediente : lanche.getIngredientes()) {
			if (Constants.ALFACE.equals(ingrediente.getNome())) {
				temAlface = true;
			} else if (Constants.BACON.equals(ingrediente.getNome())) {
				temBacon = true;
			}
		}

		if (temAlface && !temBacon) {
			lanche.setDescricaoDoPedido(
					lanche.getDescricaoDoPedido() + "\nVocê ganhou um desconto de 10% na promoção 'Light': ");
			descontos = lanche.getPrecoDoLanche() * Constants.DESCONTO_LANCHE_LIGTH;
			lanche.setDescricaoDoPedido(lanche.getDescricaoDoPedido() + "-" + descontos);
			lanche.setPrecoDoLanche(lanche.getPrecoDoLanche() - descontos);
		}
	}

}
