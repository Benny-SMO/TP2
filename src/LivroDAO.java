import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private static List<livro> livros = new ArrayList<>();
    private static int nextId = 1;

    public static List<livro> getLivros() {
        return livros;
    }

    public static void adicionarLivro(String isbn, String titulo, String autor) {
        livros.add(new livro(nextId++, isbn, titulo, autor));
    }

    public static void removerLivro(livro livro) {
        livros.remove(livro);
    }

    public static void editarLivro(livro livro, String novoIsbn, String novoTitulo, String novoAutor) {
        livro.setDisponivel(true);
        livro.setDisponivel(livro.isDisponivel()); // só para manter o getter usado
    }
}
