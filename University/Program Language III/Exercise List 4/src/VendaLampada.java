public class VendaLampada {

    private int estadoDaLampada;
    private int quantidade;
    private int valor;

    public void acende() { estadoDaLampada = 1; }

    public void apaga() { estadoDaLampada = 0; }

    public void adicionarQuantidade( int quantidade ) { this.quantidade = quantidade; }

    public void removerQuantidade( int quantidade ) { this.quantidade = this.quantidade - quantidade; }

    public void mostrarQuantidade() {

        System.out.println("A quantidade atual de lâmpadas é: " + quantidade);

    }

    public void mudarValor( int valor ) { this.valor = valor; }

    public void valorAPagar( int quantasLampadas ) {

        int valorAPagar = quantasLampadas * valor;

        System.out.println("O valor a pagar é: " + valorAPagar);

    }

    public void mostraEstado() {

        if(estadoDaLampada == 1) {
            System.out.println("A lâmpada está acesa!");
        }else{
            System.out.println("A lâmpada está apagada!");
        }

    }

}
