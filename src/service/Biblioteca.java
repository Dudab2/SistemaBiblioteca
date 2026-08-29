package service;

import java.util.ArrayList;
import java.util.List;
import model.Livro;
import model.Usuario;
import model.Emprestimo;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
    if (buscarLivroPorId(livro.getId()) != null) {
        System.out.println("Ja existe um livro com esse ID.");
        return;
    }
    livros.add(livro);
    System.out.println("Livro cadastrado com sucesso!");
    }

    public void cadastrarUsuario(Usuario usuario) {
    if (buscarUsuarioPorId(usuario.getId()) != null) {
        System.out.println("Ja existe um usuario com esse ID.");
        return;
    }
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

    public void emprestarLivro(int idLivro, int idUsuario) {
    Livro livro = buscarLivroPorId(idLivro);
    if (livro == null) {
        System.out.println("Livro nao encontrado.");
        return;
    }
    Usuario usuario = buscarUsuarioPorId(idUsuario);
    if (usuario == null) {
        System.out.println("Usuario nao encontrado.");
        return;
    }
    if (!livro.isDisponivel()) {
        System.out.println("Livro ja esta emprestado.");
        return;
    }
    livro.emprestar();
    int idEmprestimo = emprestimos.size() + 1;
    Emprestimo emprestimo = new Emprestimo(
        idEmprestimo,
        livro,
        usuario
    );
    emprestimos.add(emprestimo);
    System.out.println("Livro emprestado com sucesso!");
    System.out.println("Livro: " + livro.getTitulo());
    System.out.println("Usuario: " + usuario.getNome());
    System.out.println("Emprestimo registrado!");
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

    public Usuario buscarUsuarioPorId(int id) {
    for (Usuario usuario : usuarios) {
        if (usuario.getId() == id) {
            return usuario;
        }
    }
    return null;
    }
    public void listarEmprestimos() {
    if (emprestimos.isEmpty()) {
        System.out.println("Nenhum emprestimo registrado.");
        return;
    }
    for (Emprestimo emprestimo : emprestimos) {
        System.out.println(emprestimo);
    }
    }

}