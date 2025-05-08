public class membro {
    private int id;
    private String numeroSocio;
    private String primeiroNome;
    private String apelido;
    private String email;

    public membro(int id, String numeroSocio, String primeiroNome, String apelido, String email) {
        this.id = id;
        this.numeroSocio = numeroSocio;
        this.primeiroNome = primeiroNome;
        this.apelido = apelido;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNumeroSocio() { return numeroSocio; }
    public String getPrimeiroNome() { return primeiroNome; }
    public String getApelido() { return apelido; }
    public String getEmail() { return email; }
    public String getNomeCompleto() { return primeiroNome + " " + apelido; }

    @Override
    public String toString() {
        return numeroSocio + ": " + getNomeCompleto() + " - " + email;
    }
}
