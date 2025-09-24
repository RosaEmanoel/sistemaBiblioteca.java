import java.util.List;
import java.util.Scanner;

public class main {
    private static biblioteca biblioteca = new biblioteca();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            String menu = """
                    === Sistema Biblioteca ===
                    Escolha uma das opções abaixo:
                    1 - Adicionar Livro
                    2 - Listar Acervo
                    3 - Pesquisar Livro
                    4 - Remover Livro
                    5 - Atualizar Livro
                    6 - Contagem de Livros
                    7 - Pesquisar por Ano
                    8 - Livro mais Antigo
                    9 - Livro mais Novo
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = Input.scanInt("Opção: ", scan);

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> listarAcervo();
                case 3 -> pesquisarLivro();
                case 4 -> removerLivro();
                case 5 -> atualizarLivro();
                case 6 -> System.out.println("Total de livros: " + biblioteca.contagem());
                case 7 -> pesquisarPorAno();
                case 8 -> {
                    livro antigo = biblioteca.livroMaisAntigo();
                    System.out.println(antigo != null ? "Mais antigo: " + antigo + " | Formato: " + antigo.getFormato()
                            : "Acervo vazio");
                }
                case 9 -> {
                    livro novo = biblioteca.livroMaisNovo();
                    System.out.println(
                            novo != null ? "Mais novo: " + novo + " | Formato: " + novo.getFormato() : "Acervo vazio");
                }
                case 0 -> System.out.println("Volte Sempre!!!");
                default -> System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarLivro() {
        System.out.println("1 - Livro Físico");
        System.out.println("2 - Livro Digital");
        int tipo = Input.scanInt("Escolha o tipo: ", scan);

        String titulo = Input.scanString("Digite o Título: ", scan);
        String autor = Input.scanString("Digite o Autor: ", scan);
        int anoPublicacao = Input.scanInt("Digite o ano de publicação: ", scan);
        int numeroPaginas = Input.scanInt("Digite o número de páginas: ", scan);

        livro livro = null;
        if (tipo == 1) { // livro físico
            String dimensoes = Input.scanString("Digite as dimensões (cm) (ex: 32x35): ", scan);
            int numeroExemplares = Input.scanInt("Digite o número de exemplares: ", scan);
            livro = new livroFisico(titulo, autor, anoPublicacao, numeroPaginas,numeroExemplares, dimensoes);
        } else if (tipo == 2) { // livro digital
            String formatoArquivo = Input.scanString("Digite o formato do arquivo: ", scan);
            double tamanhoArquivo = Input.scanInt("Digite o tamanho do arquivo (MB): ", scan);
            livro = new livroDigital(titulo, autor, anoPublicacao, numeroPaginas, formatoArquivo, tamanhoArquivo);
        }

        if (livro != null) {
            try {
                biblioteca.adicionar(livro);
                System.out.println("Livro adicionado com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void listarAcervo() {
        List<livro> acervo = biblioteca.pesquisar();
        if (acervo.isEmpty()) {
            System.out.println("Acervo vazio.");
        } else {
            int i = 1;
            for (livro l : acervo) {
                System.out.println(i++ + " - " + l + " | Formato: " + l.getFormato());
            }
        }
    }

    private static void pesquisarLivro() {
        String termo = Input.scanString("Digite o título ou autor: ", scan);
        List<livro> resultados = biblioteca.pesquisar(termo);
        imprimirLista(resultados);
    }

    private static void removerLivro() {
        listarAcervo();
        int indice = Input.scanInt("Digite o número do livro que deseja remover: ", scan) - 1;
        var acervo = biblioteca.pesquisar();
        if (indice >= 0 && indice < acervo.size()) {
            livro removido = acervo.get(indice);
            if (biblioteca.remover(removido)) {
                System.out.println("Livro removido com sucesso.");
            } else {
                System.out.println("Erro ao remover livro.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void atualizarLivro() {
        listarAcervo();
        int indice = Input.scanInt("Digite o número do livro que deseja atualizar: ", scan) - 1;
        var acervo = biblioteca.pesquisar();
        if (indice >= 0 && indice < acervo.size()) {
            livro antigo = acervo.get(indice);
            System.out.println("Atualizando: " + antigo);

            String titulo = Input.scanString("Novo Título: ", scan);
            String autor = Input.scanString("Novo Autor: ", scan);
            int anoPublicacao = Input.scanInt("Novo Ano de Publicação: ", scan);
            int numeroPaginas = Input.scanInt("Novo Número de Páginas: ", scan);
            String dimensoes = Input.scanString("Digite as dimensões (cm) (ex: 32x35): ", scan);
            int numeroExemplares = Input.scanInt("Digite o número de exemplares: ", scan);
            String formatoArquivo = Input.scanString("Digite o formato do arquivo: ", scan);
            double tamanhoArquivo = Input.scanInt("Digite o tamanho do arquivo (MB): ", scan);

            livro atualizado;
            if (antigo instanceof livroFisico) {
                atualizado = new livroFisico(titulo, autor, anoPublicacao, numeroPaginas);
            } else {
                atualizado = new livroDigital(titulo, autor, anoPublicacao, numeroPaginas, formatoArquivo,
                        tamanhoArquivo);
            }

            try {
                biblioteca.atualizar(indice, atualizado);
                System.out.println("Livro atualizado com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void pesquisarPorAno() {
        int ano = Input.scanInt("Digite o ano que deseja pesquisar: ", scan);
        List<livro> livros = biblioteca.pesquisarPorAno(ano);
        imprimirLista(livros);
    }

    private static void imprimirLista(List<livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            int i = 1;
            for (livro l : livros) {
                System.out.println(i++ + " - " + l + " | Formato: " + l.getFormato());
            }
        }
    }
}
