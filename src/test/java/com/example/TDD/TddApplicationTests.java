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
		Armazem armazem = new Armazem();
	}

	@Test
	void cadastrarIngredienteEmEstoqueTest_NovoIngrediente() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		assertEquals(0, armazem.consultarQuantidadeDoIngredienteEmEstoque(sorvete));

		armazem.cadastrarIngredienteEmEstoque(sorvete);
		assertEquals(1, armazem.consultarQuantidadeDoIngredienteEmEstoque(sorvete));
	}

	@Test
	void cadastraIngredienteEmEstoque_IngredienteJaCadastrado() {
		Ingrediente sorvete = new Base(TipoBase.Sorvete);

		armazem.cadastrarIngredienteEmEstoque(sorvete);

		assertThrows(IllegalArgumentException.class, () -> armazem.cadastrarIngredienteEmEstoque(sorvete));
	}

}
