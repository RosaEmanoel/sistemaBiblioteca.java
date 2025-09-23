import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class biblioteca {
    private List<livro> acervo = new ArrayList<>();
    public static final int ANO_PUBLICACAO_MINIMO = 1900;

    public void adicionar(livro livro) throws Exception {
        validarLivro(livro);
        for (livro l : acervo) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo())
                    && l.getAutor().equalsIgnoreCase(livro.getAutor())
                    && l.getAnoPublicacao() == livro.getAnoPublicacao()) {
                throw new Exception("Livro já existe no acervo");
            }
        }
        acervo.add(livro);
    }

    public boolean remover(livro livro) {
        return acervo.remove(livro);
    }

    public livro atualizar(int indice, livro livroAtualizado) throws Exception {
        validarLivro(livroAtualizado);
        if (indice < 0 || indice >= acervo.size())
            throw new Exception("Índice inválido");
        acervo.set(indice, livroAtualizado);
        return livroAtualizado;
    }

    public List<livro> pesquisar() {
        return new ArrayList<>(acervo);
    }

    public List<livro> pesquisar(String termo) {
        return acervo.stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(termo.toLowerCase())
                        || l.getAutor().toLowerCase().contains(termo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<livro> pesquisarPorAno(int ano) {
        return acervo.stream()
                .filter(l -> l.getAnoPublicacao() == ano)
                .collect(Collectors.toList());
    }

    public int contagem() {
        return acervo.size();
    }

    public livro livroMaisAntigo() {
        return acervo.stream()
                .min(Comparator.comparingInt(livro::getAnoPublicacao))
                .orElse(null);
    }

    public livro livroMaisNovo() {
        return acervo.stream()
                .max(Comparator.comparingInt(livro::getAnoPublicacao))
                .orElse(null);
    }

    private void validarLivro(livro livro) throws Exception {
        if (livro == null) throw new Exception("Livro não pode ser nulo");
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) throw new Exception("Título obrigatório");
        if (livro.getAutor() == null || livro.getAutor().isEmpty()) throw new Exception("Autor obrigatório");
        int anoAtual = java.time.LocalDate.now().getYear();
        if (livro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO || livro.getAnoPublicacao() > anoAtual)
            throw new Exception("Ano inválido: entre " + ANO_PUBLICACAO_MINIMO + " e " + anoAtual);
        if (livro.getNumeroPaginas() <= 0) throw new Exception("Número de páginas deve ser maior que zero");
    }
}
