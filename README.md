# Sistema de Biblioteca em Java

Sistema simples de gerenciamento de biblioteca desenvolvido em Java. O projeto funciona pelo terminal e permite cadastrar livros, cadastrar usuarios, listar registros, emprestar livros e devolver livros.

## Funcionalidades

- Cadastrar livros
- Cadastrar usuarios
- Listar livros cadastrados
- Listar usuarios cadastrados
- Emprestar livros
- Devolver livros
- Verificar disponibilidade dos livros

## Tecnologias utilizadas

- Java
- Programacao orientada a objetos
- ArrayList para armazenamento em memoria
- Scanner para entrada de dados pelo terminal

## Estrutura do projeto

```text
src/
  Main.java
  model/
    Livro.java
    Usuario.java
  service/
    Biblioteca.java
  util/
    Menu.java
```

## Como rodar o projeto

### Pelo VS Code

1. Abra a pasta do projeto no VS Code.
2. Verifique se a extensao Java esta instalada.
3. Abra o arquivo `Main.java`.
4. Clique em `Run` ou `Executar`.
5. Use o menu no terminal para interagir com o sistema.

### Pelo terminal

Entre na pasta do projeto e compile os arquivos:

```bash
javac -d bin src/Main.java src/model/*.java src/service/*.java src/util/*.java
```

Depois execute:

```bash
java -cp bin Main
```

## Exemplo de uso

```text
===== SISTEMA DE BIBLIOTECA =====
1 - Cadastrar livro
2 - Cadastrar usuario
3 - Listar livros
4 - Listar usuarios
5 - Emprestar livro
6 - Devolver livro
0 - Sair
Escolha uma opcao:
```

## Conceitos praticados

Este projeto foi criado para praticar conceitos fundamentais de Java, como:

- Classes e objetos
- Encapsulamento
- Construtores
- Metodos
- Pacotes
- Listas com ArrayList
- Estrutura de menu com switch
- Entrada de dados com Scanner

## Melhorias futuras

Algumas ideias para evoluir o projeto:

- Salvar os dados em arquivos
- Usar banco de dados MySQL ou SQLite
- Criar historico de emprestimos
- Impedir cadastro de livros com ID repetido
- Criar uma interface grafica
- Transformar o projeto em uma API com Spring Boot

## Autor

Desenvolvido como projeto de estudos em Java.
