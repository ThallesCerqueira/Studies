package Agenda;

public class Pessoa {

    private String nome;
    private String endereco;
    private long telefone;
    private String email;
    
    public Pessoa( String nome, String endereco, long telefone, String email ) {
        
        if( validaPessoa( nome, endereco, telefone, email ) ) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.email = email;
        } else {
            this.nome = "Desconhecido";
            this.endereco = "Desconhecido";
            this.telefone = 0;
            this.email = "Sem email";
        }
        
    }

    private boolean validaPessoa( String nome, String endereco, long telefone, String email ) {
        return nome != "" && endereco != "" && telefone >= 0 && email != "";
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Endereço: " + this.endereco + ", Telefone: " + this.telefone + ", Email: " + this.email;
    }

    public long getChave() {
        return telefone;
    }

}