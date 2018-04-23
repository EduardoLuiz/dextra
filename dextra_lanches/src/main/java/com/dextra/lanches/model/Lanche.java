package com.dextra.lanches.model;

import java.util.List;

public class Lanche {

	private String nomeDoLanche;
	private List<Ingrediente> ingredientes;
	private Double precoDoLanche;
	private String descricaoDoPedido; 
	
	public Lanche () {}

	public Lanche(String nomeDoLanche, List<Ingrediente> ingredientes, Double precoDoLanche, String descricaoDoPedido) {
		this.nomeDoLanche = nomeDoLanche;
		this.ingredientes = ingredientes;
		this.precoDoLanche = precoDoLanche;
		this.descricaoDoPedido = descricaoDoPedido;
	}

	@Override
	public String toString() {
		return "Lanche [nomeDoLanche=" + nomeDoLanche + ", ingredientes=" + ingredientes != null ? ingredientes.toString() : "" + ", precoDoLanche="
				+ precoDoLanche + ", descricaoDoPedido=" + descricaoDoPedido + "]";
	}

	public String getNomeDoLanche() {
		return nomeDoLanche;
	}

	public void setNomeDoLanche(String nomeDoLanche) {
		this.nomeDoLanche = nomeDoLanche;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Double getPrecoDoLanche() {
		return precoDoLanche;
	}

	public void setPrecoDoLanche(Double precoDoLanche) {
		this.precoDoLanche = precoDoLanche;
	}

	public String getDescricaoDoPedido() {
		return descricaoDoPedido;
	}

	public void setDescricaoDoPedido(String descricaoDoPedido) {
		this.descricaoDoPedido = descricaoDoPedido;
	}

}
