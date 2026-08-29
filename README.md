# 📚 Sistema de Biblioteca em Java

Sistema de gerenciamento de biblioteca desenvolvido em **Java**, utilizando conceitos de **Programação Orientada a Objetos (POO)** e integração com banco de dados **MariaDB** através de **JDBC**.

O projeto está sendo desenvolvido com o objetivo de praticar organização de código, orientação a objetos, banco de dados e persistência de dados em uma aplicação Java.

## 🚀 Funcionalidades

Atualmente, o sistema possui:

- Cadastro de livros
- Cadastro de usuários
- Listagem de livros
- Listagem de usuários
- Empréstimo de livros
- Devolução de livros
- Registro e histórico de empréstimos
- Controle de disponibilidade dos livros
- Validação de IDs duplicados
- Persistência do cadastro de livros no MariaDB
- Geração automática de ID dos livros com `AUTO_INCREMENT`

> Algumas funcionalidades ainda utilizam armazenamento em memória com `ArrayList` e estão sendo gradualmente migradas para o banco de dados.

## 🛠️ Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)
- JDBC
- MariaDB
- SQL
- XAMPP
- SQLTools
- Visual Studio Code
- Git e GitHub

## 🗂️ Estrutura do projeto

```text
SistemaBiblioteca/
│
├── lib/
│   └── mariadb-java-client-3.5.10.jar
│
├── src/
│   ├── dao/
│   │   └── LivroDAO.java
│   │
│   ├── database/
│   │   └── Conexao.java
│   │
│   ├── model/
│   │   ├── Livro.java
│   │   ├── Usuario.java
│   │   └── Emprestimo.java
│   │
│   ├── service/
│   │   └── Biblioteca.java
│   │
│   ├── util/
│   │   └── Menu.java
│   │
│   └── Main.java
│
└── README.md
```

## 🗄️ Banco de dados

O projeto utiliza o banco de dados `biblioteca`, com as seguintes tabelas:

```text
livros
usuarios
emprestimos
```

A tabela de empréstimos relaciona livros e usuários através de chaves estrangeiras.

Atualmente, o cadastro de livros já é persistido no MariaDB utilizando JDBC e o padrão DAO.

O fluxo do cadastro funciona da seguinte forma:

```text
Menu
 ↓
Biblioteca
 ↓
LivroDAO
 ↓
Conexao
 ↓
MariaDB
```

## 🧠 Conceitos praticados

Durante o desenvolvimento estão sendo aplicados conceitos como:

- Classes e objetos
- Encapsulamento
- Construtores
- Métodos
- Collections (`ArrayList`)
- Relacionamento entre objetos
- DAO (Data Access Object)
- JDBC
- `PreparedStatement`
- Tratamento de exceções
- SQL
- Chaves primárias e estrangeiras
- `AUTO_INCREMENT`
- Persistência de dados

## 📌 Status do projeto

🚧 **Em desenvolvimento**

A integração com o banco de dados está sendo implementada gradualmente.

### Próximos passos

- Persistir usuários no banco de dados
- Persistir empréstimos e devoluções
- Buscar livros diretamente do banco
- Listar livros e usuários diretamente do banco
- Melhorar as validações de entrada
- Remover gradualmente a dependência dos `ArrayList`
- Melhorar o tratamento de erros

## 🎯 Objetivo

Este projeto faz parte dos meus estudos de **Java, Programação Orientada a Objetos e Banco de Dados**, buscando aplicar os conceitos aprendidos em uma aplicação prática.
