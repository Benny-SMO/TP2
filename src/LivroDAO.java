import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private static List<Livro> livros = new ArrayList<>();
    private static int nextId = 1;

    public static List<Livro> getLivros() {
        return livros;
    }

    public static void adicionarLivro(String isbn, String titulo, String autor) {
        livros.add(new Livro(nextId++, isbn, titulo, autor));
    }

    public static void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public static void editarLivro(Livro livro, String novoIsbn, String novoTitulo, String novoAutor) {
        livro.setDisponivel(true);
        livro.setDisponivel(livro.isDisponivel()); // só para manter o getter usado
    }
}
