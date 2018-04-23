package com.dextra.lanches.model;

public class Ingrediente {

	private String nome;
	private Double preco;
	private Integer quantidade;

	public Ingrediente() {
	}

	public Ingrediente(String nome, Double preco, Integer quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.setQuantidade(quantidade);
	}

	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
