public final class livroDigital extends livro {
    private String formatoArquivo;
    private double tamanhoArquivo;

    public livroDigital(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
    }

    public livroDigital(String titulo, String autor, int anoPublicacao, int numeroPaginas, String formatoArquivo,
            double tamanhoArquivo) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.formatoArquivo = formatoArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Formato Arquivo: " + formatoArquivo + ", Tamanho: " + tamanhoArquivo + "MB";
    }

    @Override
    public String getFormato() {
        return "Digital";
    }
}
