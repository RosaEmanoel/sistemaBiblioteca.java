public class livroFisico extends livro {
    public livroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
    }

    @Override
    public String getFormato() {
        return "Físico";
    }

    @Override
    public String toString() {
        return "[Físico] " + super.toString();
    }
}
