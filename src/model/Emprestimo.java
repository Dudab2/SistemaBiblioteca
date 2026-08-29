package model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Livro livro, Usuario usuario) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
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

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
    }

    public boolean estaAtivo() {
        return dataDevolucao == null;
    }

    @Override
    public String toString() {
        return "ID Emprestimo: " + id +
                " | Livro: " + livro.getTitulo() +
                " | Usuario: " + usuario.getNome() +
                " | Data emprestimo: " + dataEmprestimo +
                " | Data devolucao: " +
                (dataDevolucao == null ? "-" : dataDevolucao) +
                " | Status: " +
                (estaAtivo() ? "Emprestado" : "Devolvido");
    }
}