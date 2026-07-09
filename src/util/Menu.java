    package util;

import java.util.Scanner;
import model.Livro;
import model.Usuario;
import service.Biblioteca;

public class Menu {
    private Biblioteca biblioteca;
    private Scanner scanner;

    public Menu() {
        this.biblioteca = new Biblioteca();
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuario");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Listar usuarios");
            System.out.println("5 - Emprestar livro");
            System.out.println("6 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    biblioteca.listarLivros();
                    break;
                case 4:
                    biblioteca.listarUsuarios();
                    break;
                case 5:
                    emprestarLivro();
                    break;
                case 6:
                    devolverLivro();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void cadastrarLivro() {
        System.out.print("ID do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Livro livro = new Livro(id, titulo, autor, isbn);
        biblioteca.cadastrarLivro(livro);
    }

    private void cadastrarUsuario() {
        System.out.print("ID do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(id, nome, email);
        biblioteca.cadastrarUsuario(usuario);
    }

    private void emprestarLivro() {
        System.out.print("Digite o ID do livro: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine();

        biblioteca.emprestarLivro(idLivro);
    }

    private void devolverLivro() {
        System.out.print("Digite o ID do livro: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine();

        biblioteca.devolverLivro(idLivro);
    }
}