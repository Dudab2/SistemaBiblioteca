package model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(int id, Livro livro, Usuario usuario) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    @Override
    public String toString() {
        return "ID Emprestimo: " + id +
                " | Livro: " + livro.getTitulo() +
                " | Usuario: " + usuario.getNome() +
                " | Data: " + dataEmprestimo;
    }
}