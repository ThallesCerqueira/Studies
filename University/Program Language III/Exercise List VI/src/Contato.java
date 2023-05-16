public class Contato {

    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;

    public Contato( String nome, String email, String telefone, String dataNascimento ) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Contato( String nome, String email, String telefone ) {
        this( nome, email, telefone, "" );
    }

    public Contato( String nome, String email ) {
        this(nome, email, "", "");
    }

    public Contato( String nome ) {
        this(nome, "", "", "");
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void imprimirContato() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de Nascimento: " + dataNascimento);
    }

    int calcularIdade() {
        return 0;
    }

}
