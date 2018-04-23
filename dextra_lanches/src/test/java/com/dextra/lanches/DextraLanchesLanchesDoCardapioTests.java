package com.dextra.lanches;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dextra.lanches.model.Lanche;
import com.dextra.lanches.service.LancheService;
import com.dextra.lanches.util.Constants;

public class DextraLanchesLanchesDoCardapioTests {

	private static Lanche lanche;
	private static Double preco;

	@BeforeClass
	public static void beforeClass() {
		preco = 0.00;
		IngredientesInMemory.setInflacao(false);
	}

	@Before
	public void before() {
		lanche = new Lanche();
	}

	@Test
	public void testXBacon() {
		preco = IngredientesInMemory.getBaconInMemory(1).getPreco();
		preco += IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BACON);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(lanche.getPrecoDoLanche().toString(), preco, lanche.getPrecoDoLanche());
	}

	@Test
	public void testXBurger() {
		preco = IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BURGER);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(lanche.getPrecoDoLanche().toString(), preco, lanche.getPrecoDoLanche());
	}

	@Test
	public void testXEgg() {
		preco = IngredientesInMemory.getOvoInMemory(1).getPreco();
		preco += IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_EGG);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(lanche.getPrecoDoLanche().toString(), preco, lanche.getPrecoDoLanche());
	}

	@Test
	public void testXEggBacon() {
		preco = IngredientesInMemory.getBaconInMemory(1).getPreco();
		preco += IngredientesInMemory.getOvoInMemory(1).getPreco();
		preco += IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_EGG_BACON);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(lanche.getPrecoDoLanche().toString(), preco, lanche.getPrecoDoLanche());
	}

}
