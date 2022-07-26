package com.example.TDD;

import com.example.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TddApplicationTests {
	Armazem armazem = new Armazem();
	@BeforeEach
	void setUp() {
		armazem = new Armazem();
	}

	@Test
	void cadastrarIngredienteEmEstoqueTestNovoIngrediente() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		armazem.cadastrarIngredienteEmEstoque(sorvete);
		assertEquals(0, armazem.consultarQuantidadeDoIngredienteEmEstoque(sorvete));
	}

	@Test
	void cadastraIngredienteEmEstoqueIngredienteJaCadastrado() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		armazem.cadastrarIngredienteEmEstoque(sorvete);

		assertThrows(IllegalArgumentException.class, () -> armazem.cadastrarIngredienteEmEstoque(sorvete));
		//TODO: Verificar mensagem "Ingrediente já cadastrado"
	}

	@Test
	void consultarQuantidadeDoIngredienteEmEstoqueIngredienteNaoEncontrado() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		assertThrows(IllegalArgumentException.class, () -> armazem.consultarQuantidadeDoIngredienteEmEstoque(sorvete));
		//TODO: Verificar mensagem "Ingrediente não encontrado"

	}

	@Test
	void consultarQuantidadeDoIngredienteEmEstoque() {
		Ingrediente ingrediente = new Base(TipoBase.Sorvete);
		final int QUANTIDADE_INICIAL = 0;
		final int QUANTIDADE = 10;

		armazem.cadastrarIngredienteEmEstoque(ingrediente);

		assertEquals(QUANTIDADE_INICIAL, armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente));

		armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, QUANTIDADE);

		assertEquals(QUANTIDADE, armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente));
	}

	@Test
	void adicionarQuantidadeDoIngredienteEmEstoque() {
		Ingrediente ingrediente = new Fruta(TipoFruta.Banana);

		final int QUANTIDADE_INICIAL = 10;
		final int QUANTIDADE_ADICIONADA = 2;
		final int QUANTIDADE_TOTAL = QUANTIDADE_INICIAL + QUANTIDADE_ADICIONADA;

		armazem.cadastrarIngredienteEmEstoque(ingrediente);

		armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, QUANTIDADE_INICIAL);

		assertEquals(QUANTIDADE_INICIAL, armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente));

		armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, QUANTIDADE_ADICIONADA);

		assertEquals(QUANTIDADE_TOTAL, armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente));
	}

	@Test
	void adicionarQuantidadeDoIngredienteEmEstoqueIngredienteNaoEncontrado() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		assertThrows(IllegalArgumentException.class, () -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(sorvete, 10));
		//TODO: Verificar mensagem "Ingrediente não encontrado"
	}

	@Test
	void adicionarQuantidadeDoIngredienteEmEstoqueQuantidadeMenorOuIgualAZero() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		assertThrows(IllegalArgumentException.class, () -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(sorvete, 0));
		assertThrows(IllegalArgumentException.class, () -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(sorvete, -2));
		//TODO: Verificar mensagem "Quantidade inválida"
	}

	@Test
	void descadastrarIngredienteEmEstoque() {
		Ingrediente ingrediente = new Fruta(TipoFruta.Banana);

		armazem.cadastrarIngredienteEmEstoque(ingrediente);

		armazem.descadastrarIngredienteEmEstoque(ingrediente);

		assertThrows(IllegalArgumentException.class, () -> armazem.descadastrarIngredienteEmEstoque(ingrediente));
	}

	@Test
	void descadastrarIngredienteEmEstoqueIngredienteNaoEncontrado() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		assertThrows(IllegalArgumentException.class, () -> armazem.descadastrarIngredienteEmEstoque(sorvete));
		//TODO: Verificar mensagem "Ingrediente não encontrado"
	}

	@Test
	void reduzirQuantidadeDoIngredienteEmEstoque() {
		Ingrediente ingrediente = new Fruta(TipoFruta.Banana);

		final int QUANTIDADE_INICIAL = 10;
		final int QUANTIDADE_REDUZIDA = 3;
		final int QUANTIDADE_TOTAL = QUANTIDADE_INICIAL - QUANTIDADE_REDUZIDA;

		armazem.cadastrarIngredienteEmEstoque(ingrediente);

		armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, QUANTIDADE_INICIAL);

		armazem.reduzirQuantidadeDoIngredienteEmEstoque(ingrediente, QUANTIDADE_REDUZIDA);

		assertEquals(QUANTIDADE_TOTAL, armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente));
	}

	@Test
	void reduzirQuantidadeDoIngredienteEmEstoqueIngredienteNaoEncontrado() {
		Ingrediente ingrediente = new Base(TipoBase.Sorvete);
		final int QUANTIDADE_REDUZIDA = 3;

		assertThrows(IllegalArgumentException.class, () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(ingrediente, QUANTIDADE_REDUZIDA));
		//TODO: Verificar mensagem "Ingrediente não encontrado"
	}

	@Test
	void reduzirQuantidadeDoIngredienteEmEstoqueQuantidadeMenorOuIgualAZero() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		assertThrows(IllegalArgumentException.class, () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(sorvete, 0));
		assertThrows(IllegalArgumentException.class, () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(sorvete, -2));
		//TODO: Verificar mensagem "Quantidade inválida"
	}

	@Test
	void reduzirQuantidadeDoIngredienteEmEstoqueQuantidadeInsuficiente() {
		Ingrediente ingrediente = new Base(TipoBase.Sorvete);

		final int QUANTIDADE_REDUZIDA = 10;

		armazem.cadastrarIngredienteEmEstoque(ingrediente);

		assertThrows(IllegalArgumentException.class, () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(ingrediente, QUANTIDADE_REDUZIDA));
		//TODO: Verificar mensagem "Quantidade inválida"
	}

}
