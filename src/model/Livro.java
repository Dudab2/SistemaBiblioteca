package model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Titulo: " + titulo +
                " | Autor: " + autor +
                " | ISBN: " + isbn +
                " | Disponivel: " + (disponivel ? "Sim" : "Nao");
    }
}