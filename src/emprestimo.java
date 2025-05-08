import java.util.Date;

public class emprestimo {
    private int id;
    private livro livro;
    private membro membro;
    private Date dataEmprestimo;
    private Date dataDevolucaoPrevista;
    private Date dataDevolucaoEfetiva;

    public emprestimo(int id, livro livro, membro membro, Date dataEmprestimo, Date dataDevolucaoPrevista) {
        this.id = id;
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoEfetiva = null;
    }

    public int getId() { return id; }
    public livro getLivro() { return livro; }
    public membro getMembro() { return membro; }
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
