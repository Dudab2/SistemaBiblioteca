package service;

import java.util.ArrayList;
import java.util.List;
import model.Livro;
import model.Usuario;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario cadastrado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void emprestarLivro(int idLivro) {
        Livro livro = buscarLivroPorId(idLivro);

        if (livro == null) {
            System.out.println("Livro nao encontrado.");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Livro ja esta emprestado.");
            return;
        }

        livro.emprestar();
        System.out.println("Livro emprestado com sucesso!");
    }

    public void devolverLivro(int idLivro) {
        Livro livro = buscarLivroPorId(idLivro);

        if (livro == null) {
            System.out.println("Livro nao encontrado.");
            return;
        }

        if (livro.isDisponivel()) {
            System.out.println("Esse livro ja esta disponivel.");
            return;
        }

        livro.devolver();
        System.out.println("Livro devolvido com sucesso!");
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }

        return null;
    }
}