public abstract class livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numeroPaginas;

    public livro(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public int getNumeroPaginas() { return numeroPaginas; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }


    public abstract String getFormato();

    
    public final int calcularTempoPublicacao() {
        return java.time.LocalDate.now().getYear() - anoPublicacao;
    }

    public String toString() {
        return String.format("%s (%d) - %s, %d páginas", titulo, anoPublicacao, autor, numeroPaginas);
    }
}

