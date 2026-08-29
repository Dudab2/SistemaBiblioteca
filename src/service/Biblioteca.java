package service;

import java.util.ArrayList;
import java.util.List;

import model.Livro;
import model.Usuario;
import model.Emprestimo;

import dao.livroDAO;
import dao.UsuarioDAO;

public class Biblioteca {

    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    private livroDAO livroDAO;
    private UsuarioDAO usuarioDAO;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();

        this.livroDAO = new livroDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarLivro(Livro livro) {
        livroDAO.cadastrar(livro);
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
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

        List<Usuario> usuariosBanco = usuarioDAO.listarUsuarios();

        if (usuariosBanco.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }

        for (Usuario usuario : usuariosBanco) {
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

        Emprestimo emprestimo =
            buscarEmprestimoAtivoPorLivro(idLivro);

        if (emprestimo == null) {
            System.out.println("Emprestimo nao encontrado.");
            return;
        }

        livro.devolver();
        emprestimo.devolver();

        System.out.println("Livro devolvido com sucesso!");
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println(
            "Usuario: " + emprestimo.getUsuario().getNome()
        );
        System.out.println(
            "Data de devolucao: " +
            emprestimo.getDataDevolucao()
        );
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

    public Emprestimo buscarEmprestimoAtivoPorLivro(int idLivro) {

        for (Emprestimo emprestimo : emprestimos) {

            if (
                emprestimo.getLivro().getId() == idLivro
                && emprestimo.estaAtivo()
            ) {
                return emprestimo;
            }
        }

        return null;
    }
}