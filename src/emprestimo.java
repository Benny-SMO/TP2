import java.util.Date;

public class emprestimo {
    private int id;
    private Livro livro;
    private Membro membro;
    private Date dataEmprestimo;
    private Date dataDevolucaoPrevista;
    private Date dataDevolucaoEfetiva;

    public emprestimo(int id, Livro livro, Membro membro, Date dataEmprestimo, Date dataDevolucaoPrevista) {
        this.id = id;
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoEfetiva = null;
    }

    public int getId() { return id; }
    public Livro getLivro() { return livro; }
    public Membro getMembro() { return membro; }
    public Date getDataEmprestimo() { return dataEmprestimo; }
    public Date getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public Date getDataDevolucaoEfetiva() { return dataDevolucaoEfetiva; }
    public void setDataDevolucaoEfetiva(Date data) { this.dataDevolucaoEfetiva = data; }

    public String getEstado() {
        if (dataDevolucaoEfetiva != null) return "Devolvido";
        Date hoje = new Date();
        return hoje.after(dataDevolucaoPrevista) ? "Atrasado" : "Ativo";
    }

    @Override
    public String toString() {
        return livro.getTitulo() + "," + membro.getNomeCompleto() + "," + dataEmprestimo + "," +
                dataDevolucaoPrevista + "," + getEstado();
    }
}
