package com.example.models;

import java.util.TreeMap;

public class Armazem {
    private TreeMap<Ingrediente, Integer> estoque;

    /**
     * Cadastra no estoque um novo ingrediente.
     *
     * A quantidade deve ser setada como zero.
     * @param ingrediente
     * @throws IllegalArgumentException ("Ingrediente já cadastrado") caso o ingrediente já esteja cadastrado.
     */
    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) { }

    /**
     * Descadastra no estoque um ingrediente.
     *
     * @param ingrediente
     * @throws IllegalArgumentException ("Ingrediente não encontrado") caso o ingrediente não exista no estoque.
     */
    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) { }

    /**
     * Adiciona uma determinada quantidade de um ingrediente específico no estoque.
     *
     * @param ingrediente
     * @param quantidade
     * @throws IllegalArgumentException ("Ingrediente não encontrado ou quantidade inválida") caso o ingrediente não
     *  exista no estoque ou a quantidade informada seja menor ou igual a zero.
     */
    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) { }

    /**
     * Reduz a quantidade de um determinado ingrediente no estoque.
     *
     * @param ingrediente
     * @param quantidade
     * @throws IllegalArgumentException ("Ingrediente não encontrado ou quantidade inválida") caso o ingrediente não
     *  exista, a quantidade em estoque seja insuficiente para ser removida ou a quantidade solicitada para remoção
     *  seja menor ou igual a zero.
     */
    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) { }

    /**
     * Busca a quantidade de um determinado ingrediente no estoque.
     *
     * @param ingrediente
     * @return quantidade do ingrediente no estoque
     * @throws IllegalArgumentException ("Ingrediente não encontrado") caso não exista o ingrediente.
     */
    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {
        return 0;
    }
}
