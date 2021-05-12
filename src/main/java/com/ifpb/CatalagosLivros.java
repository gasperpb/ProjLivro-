package com.ifpb;

import java.util.ArrayList;

public class CatalagosLivros {
    private String nome;
    private String local;
    private ArrayList<livro> livros;

    public CatalagosLivros() {
        livros = new ArrayList<livro>();
    }

    public CatalagosLivros(String nome) {
        this();
        setNome(nome);
    }

    public CatalagosLivros(String nome, String local) {
        this(nome);
        setLocal(local);
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public int getQuantidade() {
        return livros.size();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocal(String local) {
        this.local = local;
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
