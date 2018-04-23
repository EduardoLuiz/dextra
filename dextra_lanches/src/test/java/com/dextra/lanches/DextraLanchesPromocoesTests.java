package com.dextra.lanches;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dextra.lanches.model.Ingrediente;
import com.dextra.lanches.model.Lanche;
import com.dextra.lanches.service.LancheService;
import com.dextra.lanches.util.Constants;

public class DextraLanchesPromocoesTests {
	
	private static Lanche lanche;
	private static Double preco;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		preco = 0.00;
	}

	@Before
	public void setUp() throws Exception {
		lanche = new Lanche();
	}

	@Test
	public void testPromocaoLight() {
		
		preco = IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();
		preco += IngredientesInMemory.getAlfaceInMemory(1).getPreco();
		
		preco = preco - (preco * Constants.DESCONTO_LANCHE_LIGTH); 

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BURGER);
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(IngredientesInMemory.getAlfaceInMemory(1));
		
		lanche.setIngredientes(ingredientes);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(preco, lanche.getPrecoDoLanche());
	}
	
	@Test
	public void testPromocaoMuitaCarneCom3Porcoes() {
		
		preco = IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco() * 3;
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();
		
		preco = preco - IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco(); 

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BURGER);
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(IngredientesInMemory.getHamburgerDeCarneInMemory(2));
		
		lanche.setIngredientes(ingredientes);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(preco, lanche.getPrecoDoLanche());
	}
	
	@Test
	public void testPromocaoMuitaCarneCom6Porcoes() {
		
		preco = IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco() * 6;
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();
		
		preco = preco - (2 * IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco()); 

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BURGER);
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(IngredientesInMemory.getHamburgerDeCarneInMemory(5));
		lanche.setIngredientes(ingredientes);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(preco, lanche.getPrecoDoLanche());
	}
	
	@Test
	public void testPromocaoMuitoQueijoCom3Porcoes() {
		
		preco = IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco() * 3;
		
		preco = preco - IngredientesInMemory.getQueijoInMemory(1).getPreco(); 

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BURGER);
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(IngredientesInMemory.getQueijoInMemory(2));
		
		lanche.setIngredientes(ingredientes);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(preco, lanche.getPrecoDoLanche());
	}
	
	@Test
	public void testPromocaoMuitoQueijoCom6Porcoes() {
		
		preco = IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco() * 6;
		
		preco = preco - (2 * IngredientesInMemory.getQueijoInMemory(1).getPreco()); 

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BURGER);
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(IngredientesInMemory.getQueijoInMemory(5));
		
		lanche.setIngredientes(ingredientes);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(preco, lanche.getPrecoDoLanche());
	}
	
	@AfterClass
	public static void testInflacaoSobrePromocaoLight() {
		
		/* preço do hambúrger é alterado 'in memory' e os testes devem continuar funcionando */
		IngredientesInMemory.setInflamacaoSobreHamburger();
		IngredientesInMemory.setInflacao(true);
		
		/* teste para promocao light */
		preco = IngredientesInMemory.getHamburgerDeCarneInMemory(1).getPreco();
		preco += IngredientesInMemory.getQueijoInMemory(1).getPreco();
		preco += IngredientesInMemory.getAlfaceInMemory(1).getPreco();
		
		preco = preco - (preco * Constants.DESCONTO_LANCHE_LIGTH); 

		IngredientesInMemory.resetIngredientes(); 
		lanche.setNomeDoLanche(Constants.X_BURGER);
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(IngredientesInMemory.getAlfaceInMemory(1));
		
		lanche.setIngredientes(ingredientes);
		lanche = new LancheService(lanche).calcularPreco();
		System.out.println(lanche.getDescricaoDoPedido());

		Assert.assertEquals(preco, lanche.getPrecoDoLanche());
	}

}
