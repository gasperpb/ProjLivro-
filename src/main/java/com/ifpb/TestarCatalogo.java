package com.ifpb;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TestarCatalogo {
        public static void main(String[] args) {
                CatalagosLivros catalo = new CatalagosLivros();

                JOptionPane.showMessageDialog(null,
                                "* Bem-vindo ao Programa ProjLivro  !\n"
                                                + "* Cadastro de Livros com Consulta em um catalogo !\n",
                                null, JOptionPane.INFORMATION_MESSAGE);

                catalo.setNome(JOptionPane.showInputDialog("Nome do Catalogo:"));
                catalo.setclassificacao(JOptionPane.showInputDialog("classificacao do livro:"));

                livro livro;
                ArrayList<livro> listaLivros;
                int opcao = 0, cont;
                String opcoes = "Catalogo: " + catalo.getNome() + "\nclassificacao: " + catalo.getclassificacao()
                                + "\n\n***Opções*** " + "\n1. Cadastrar Livro" + "\n2. Pesquisar Livro (código)"
                                + "\n3. Pesquisar Livro (título)" + "\n4. Listar Livros" + "\n5. Informações"
                                + "\n6. Finalizar" + "\n\nSelecione a opção: ";

                while (opcao != 6) {
                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes,
                                        "Catalogo " + catalo.getNome(), JOptionPane.QUESTION_MESSAGE));

                        switch (opcao) {
                                case 1:
                                        try {
                                                catalo.incluirLivro(digitarLivro());
                                        } catch (NullPointerException ex) {
                                                ex.printStackTrace();
                                        } catch (ArrayIndexOutOfBoundsException ex) {

                                        } catch (Exception ex) {

                                        }
                                        JOptionPane.showMessageDialog(null, "Livro Cadastrado!\nTotal: "
                                                        + catalo.getQuantidade() + " livro(s)");
                                        break;
                                case 2:
                                        livro = catalo.obterLivro(Integer.parseInt(
                                                        JOptionPane.showInputDialog("Digite código para pesquisar:")));
                                        if (livro != null)
                                                mostrarLivro(livro, catalo.getNome());
                                        else
                                                JOptionPane.showMessageDialog(null, "Livro Não classificado!");
                                        break;
                                case 3:
                                        listaLivros = catalo.obterLivro(JOptionPane
                                                        .showInputDialog("Digite Título do Livro para pesquisar:"));
                                        cont = 0;
                                        if (listaLivros.size() > 0) {
                                                for (livro liv : listaLivros) {
                                                        cont++;
                                                        mostrarLivro(liv, catalo.getNome() + " " + cont + " / "
                                                                        + listaLivros.size());
                                                }
                                        } else
                                                JOptionPane.showMessageDialog(null, "Título de Livro Não localizado!");
                                        break;
                                case 4: {
                                        StringBuffer lista = new StringBuffer();
                                        lista.append("Lista de Livros Cadastrados:\n");
                                        for (int i = 0; i < catalo.getQuantidade(); i++) {
                                                livro = catalo.getLivro(i);
                                                lista.append(livro.getId() + " - " + livro.getTitulo() + " - " + " - "
                                                                + livro.getAutor() + " pags.\n");
                                        }
                                        lista.append("Total: " + catalo.getQuantidade() + " livro(s)");
                                        JOptionPane.showMessageDialog(null, lista.toString());
                                        break;
                                }
                                case 5:
                                        JOptionPane.showMessageDialog(null, "Informações do catalogo\n"
                                                        + "Nome da catalogo: " + catalo.getNome() + "\n"
                                                        + "classificação: " + catalo.getclassificacao() + "\n"
                                                        + "Existem até o momento\n" + catalo.getQuantidade()
                                                        + " livro(s) cadastrado(s)");
                                        break;
                        }
                }
                System.out.println("#### Fim do Programa ###");

        }

        static livro digitarLivro() {
                livro liv = new livro(0, null, null, null);
                liv.setId(Integer.parseInt(JOptionPane.showInputDialog("Código do Livro:")));
                liv.setTitulo(JOptionPane.showInputDialog("Título do Livro:"));
                liv.setAutor(JOptionPane.showInputDialog("Autor do Livro:"));

                return liv;
        }

        static void mostrarLivro(livro x, String bib) {
                String texto = "Livro:\n" + "\nCódigo: " + x.getId() + "\nTítulo: " + x.getTitulo() + "\nAutor: "
                                + x.getAutor();
                JOptionPane.showMessageDialog(null, texto, "Catalogo: " + bib, JOptionPane.WARNING_MESSAGE);
        }

}
