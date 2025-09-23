public class livroFisico extends livro {
    public livroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
    }

    public String getFormato() {
        return "Físico";
    }

    public String toString() {
        return "[Físico] " + super.toString();
    }
}

