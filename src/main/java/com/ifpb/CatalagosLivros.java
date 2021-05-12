package com.ifpb;

import java.util.ArrayList;

public class CatalagosLivros {
    private String nome;
    private String classificacao;
    private ArrayList<livro> livros;

    public CatalagosLivros() {
        livros = new ArrayList<livro>();
    }

    public CatalagosLivros(String nome) {
        this();
        setNome(nome);
    }

    public CatalagosLivros(String nome, String classificacao) {
        this(nome);
        setclassificacao(classificacao);
    }

    public String getNome() {
        return nome;
    }

    public String getclassificacao() {
        return classificacao;
    }

    public int getQuantidade() {
        return livros.size();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setclassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void incluirLivro(livro livro) throws NullPointerException {
        if (livro == null) {
            throw new NullPointerException("Erro de Objeto Livro null");
        } else {
            livros.add(livro);
        }
    }

    public livro obterLivro(int cod) {
        for (livro livro : livros) {
            if (livro != null) {
                if (livro.getId() == cod) {
                    return livro;
                }
            }
        }
        return null;
    }

    public ArrayList<livro> obterLivro(String tit) {
        ArrayList<livro> lista = new ArrayList<livro>();

        for (livro livro : livros) {
            if (livro != null) {
                if (livro.getTitulo().indexOf(tit) >= 0) {
                    lista.add(livro);
                }
            }
        }
        return lista;
    }

    public livro getLivro(int posicao) throws IndexOutOfBoundsException {
        if (posicao < this.getQuantidade())
            return livros.get(posicao);
        else
            throw new IndexOutOfBoundsException("Índice de Livro Inválido!");
    }

}
