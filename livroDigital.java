public class livroDigital extends livro {
    public livroDigital(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
    }


    public String getFormato() {
        return "Digital";
    }


    public String toString() {
        return "[Digital] " + super.toString();
    }
}

