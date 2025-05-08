import java.awt.*;
import java.util.List;
import javax.swing.*;

public class GestaoLivrosUI extends JFrame {

    private DefaultListModel<Livro> listModel = new DefaultListModel<>();
    private JList<Livro> listaLivros = new JList<>(listModel);

    public GestaoLivrosUI() {
        setTitle("Gestão de Livros");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        atualizarLista();

        JScrollPane scrollPane = new JScrollPane(listaLivros);
        add(scrollPane, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel();
        JButton adicionarBtn = new JButton("Adicionar");
        JButton removerBtn = new JButton("Remover");
        JButton atualizarBtn = new JButton("Atualizar");

        botoesPanel.add(adicionarBtn);
        botoesPanel.add(removerBtn);
        botoesPanel.add(atualizarBtn);
        add(botoesPanel, BorderLayout.SOUTH);

        adicionarBtn.addActionListener(e -> adicionarLivro());
        removerBtn.addActionListener(e -> removerLivro());
        atualizarBtn.addActionListener(e -> atualizarLista());

        setVisible(true);
    }

    private void atualizarLista() {
        listModel.clear();
        List<Livro> livros = LivroDAO.getLivros();
        for (Livro l : livros) {
            listModel.addElement(l);
        }
    }

    private void adicionarLivro() {
        JTextField isbnField = new JTextField();
        JTextField tituloField = new JTextField();
        JTextField autorField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel("Título:"));
        panel.add(tituloField);
        panel.add(new JLabel("Autor:"));
        panel.add(autorField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Livro", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String isbn = isbnField.getText().trim();
            String titulo = tituloField.getText().trim();
            String autor = autorField.getText().trim();

            if (!isbn.isEmpty() && !titulo.isEmpty() && !autor.isEmpty()) {
                LivroDAO.adicionarLivro(isbn, titulo, autor);
                atualizarLista();
            } else {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.");
            }
        }
    }

    private void removerLivro() {
        Livro selecionado = listaLivros.getSelectedValue();
        if (selecionado != null) {
            LivroDAO.removerLivro(selecionado);
            atualizarLista();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum livro selecionado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestaoLivrosUI::new);
    }
}
