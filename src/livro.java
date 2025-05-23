public class livro {
    private int id;
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public livro(int id, String isbn, String titulo, String autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String toString() {
        return titulo + " (" + autor + ") - " + (disponivel ? "Disponível" : "Emprestado");
    }
}
