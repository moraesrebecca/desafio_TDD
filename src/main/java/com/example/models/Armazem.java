package com.example.models;

import java.util.TreeMap;

public class Armazem {
    private TreeMap<Ingrediente, Integer> estoque;
    private final int QUANTIDADE_PADRAO = 0;

    public Armazem() {
        this.estoque = new TreeMap<>();
    }

    /**
     * Cadastra no estoque um novo ingrediente.
     *
     * A quantidade deve ser setada como zero.
     * @param ingrediente
     * @throws IllegalArgumentException ("Ingrediente já cadastrado") caso o ingrediente já esteja cadastrado.
     */
    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        handleIngredienteJaCadastrado(ingrediente);

        estoque.put(ingrediente, QUANTIDADE_PADRAO);
    }

    private void handleIngredienteJaCadastrado(Ingrediente ingrediente) {
        if(estoque.containsKey(ingrediente))
            throw new IllegalArgumentException("Ingrediente já cadastrado");
    }

    /**
     * Descadastra no estoque um ingrediente.
     *
     * @param ingrediente
     * @throws IllegalArgumentException ("Ingrediente não encontrado") caso o ingrediente não exista no estoque.
     */
    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        handleIngredienteInexistente(ingrediente);
        estoque.remove(ingrediente);
    }

    /**
     * Adiciona uma determinada quantidade de um ingrediente específico no estoque.
     *
     * @param ingrediente
     * @param quantidadeAdicionada
     * @throws IllegalArgumentException ("Ingrediente não encontrado ou quantidade inválida") caso o ingrediente não
     *  exista no estoque ou a quantidade informada seja menor ou igual a zero.
     */
    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidadeAdicionada) {
        handleIngredienteInexistente(ingrediente);
        handleQuantidadeInvalida(quantidadeAdicionada);

        final int novaQuantidade = estoque.get(ingrediente) + quantidadeAdicionada;
        estoque.replace(ingrediente, novaQuantidade);
    }

    private void handleQuantidadeInvalida(Integer quantidade) {
        if (quantidade <= 0)
            throw new IllegalArgumentException("Quantidade inválida");
    }

    /**
     * Reduz a quantidade de um determinado ingrediente no estoque.
     *
     * @param ingrediente
     * @param quantidadeRemovida
     * @throws IllegalArgumentException ("Ingrediente não encontrado ou quantidade inválida") caso o ingrediente não
     *  exista, a quantidade em estoque seja insuficiente para ser removida ou a quantidade solicitada para remoção
     *  seja menor ou igual a zero.
     */
    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidadeRemovida) {
        handleIngredienteInexistente(ingrediente);
        handleQuantidadeInvalida(quantidadeRemovida);
        handleQuantidadeInsuficiente(ingrediente, quantidadeRemovida);

        final int novaQuantidade = estoque.get(ingrediente) - quantidadeRemovida;
        estoque.replace(ingrediente, novaQuantidade);
    }

    private void handleQuantidadeInsuficiente(Ingrediente ingrediente, Integer quantidade) {
        final int quantidadeAtual = estoque.get(ingrediente);
        if (quantidade > quantidadeAtual) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
    }

    /**
     * Busca a quantidade de um determinado ingrediente no estoque.
     *
     * @param ingrediente
     * @return quantidade do ingrediente no estoque
     * @throws IllegalArgumentException ("Ingrediente não encontrado") caso não exista o ingrediente.
     */
    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {
        handleIngredienteInexistente(ingrediente);

        return estoque.get(ingrediente);
    }

    private void handleIngredienteInexistente(Ingrediente ingrediente) {
        if (!estoque.containsKey(ingrediente))
            throw new IllegalArgumentException("Ingrediente não encontrado");
    }
}
