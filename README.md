Sistema de Biblioteca em Java
Descrição

Este projeto implementa um sistema de gerenciamento de acervo de livros em Java. O sistema suporta livros físicos e digitais, permitindo cadastrar, listar, pesquisar, atualizar e remover livros.

O projeto aplica conceitos de orientação a objetos, incluindo herança, polimorfismo, métodos abstratos e validação de dados.

Estrutura do Projeto

O projeto possui as seguintes classes:

1. livro (abstract)

Classe abstrata que representa um livro genérico.
Atributos:

titulo (String)

autor (String)

anoPublicacao (int)

numeroPaginas (int)

Métodos:

getFormato() – abstrato, implementado pelas subclasses (livroFisico, livroDigital)

calcularTempoPublicacao() – retorna quantos anos se passaram desde a publicação

toString() – retorna uma representação textual do livro

2. livroFisico e livroDigital

Subclasses de livro que representam livros físicos e digitais, respectivamente.

Implementam o método getFormato() para indicar "Físico" ou "Digital"

Sobrescrevem toString() para incluir o tipo de livro

3. biblioteca

Classe que representa o acervo de livros.

Atributos:

acervo (List<livro>) – armazena os livros

ANO_PUBLICACAO_MINIMO – ano mínimo permitido para publicação

Métodos principais:

adicionar(livro) – adiciona livro ao acervo, com validações e evitando duplicidade

remover(livro) – remove livro do acervo

atualizar(indice, livro) – atualiza um livro existente

pesquisar() – retorna todos os livros

pesquisar(String termo) – pesquisa por título ou autor

pesquisarPorAno(int ano) – pesquisa livros por ano

livroMaisAntigo() e livroMaisNovo() – retornam o livro mais antigo e mais novo

4. Input

Classe utilitária para leitura de dados do usuário via Scanner.

Métodos:

scanInt(String mensagem, Scanner scan) – lê um número inteiro, tratando erros de entrada

scanString(String mensagem, Scanner scan) – lê uma string não vazia

5. main

Classe principal que exibe o menu interativo e faz a interface com o usuário.

Funcionalidades do Menu:

Adicionar livro (físico ou digital)

Listar acervo (exibindo o tipo de livro)

Pesquisar livro por título ou autor

Remover livro

Atualizar livro

Contar livros cadastrados

Pesquisar por ano

Mostrar livro mais antigo

Mostrar livro mais novo

Sair do sistema

Funcionalidades do Sistema

Cadastro de livros com validação:

Título e autor obrigatórios

Ano de publicação ≥ 1900 e ≤ ano atual

Número de páginas > 0

Evita duplicidade de livro (mesmo título + autor + ano)

Polimorfismo:

livroFisico e livroDigital implementam getFormato()

Ao listar livros, o tipo (Físico/Digital) é exibido automaticamente

Atualização de livros:

Permite alterar todos os atributos mantendo o tipo original (físico ou digital)

Pesquisa e filtragem:

Por título ou autor

Por ano de publicação

Livro mais antigo e mais novo

Interface robusta:

Tratamento de entradas inválidas

Limpeza do buffer do Scanner para evitar leituras incorretas
