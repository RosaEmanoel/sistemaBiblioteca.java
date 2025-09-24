public final class livroFisico extends livro {
    private int numeroExemplares;
    private String dimensoes;

    public livroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
    }

    public livroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas, int numeroExemplares,
            String dimensoes) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.numeroExemplares = numeroExemplares;
        this.dimensoes = dimensoes;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    @Override
    public String toString() {
        return super.toString() + ", Exemplares: " + numeroExemplares + ", Dimensões: " + dimensoes;
    }

    @Override
    public String getFormato() {
        return "Físico";
    }
}
