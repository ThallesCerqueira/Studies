public class Lampada {

    private int valorLuminosidade;
    private int estadoDaLampada;

    public Lampada( int luminosidade ) {

        if(luminosidade >= 0 && luminosidade <= 100)
            this.valorLuminosidade = luminosidade;
        else{
            this.valorLuminosidade = 0;
        }

        atribuirEstado();

    }

    private void atribuirEstado() {

        if(valorLuminosidade == 100){
            acende();
        } else if ( valorLuminosidade > 0 && valorLuminosidade < 100 ) {
            meiaLuz();
        }else{
            apaga();
        }

    }

    private void acende() { estadoDaLampada = 1; }

    private void meiaLuz() { estadoDaLampada = 2; }

    private void apaga() { estadoDaLampada = 3; }

    public void mostraEstado() {

        if(estadoDaLampada  == 1) {
            System.out.println("A lâmpada está acesa!");
        } else if (estadoDaLampada == 2) {
            System.out.println("A lâmpada está meia-Luz!");
        }else{
            System.out.println("A lâmpada está apagada!");
        }

    }

    public boolean estaLigada() {

        if(estadoDaLampada == 1){
            return true;
        }
        return false;
    }

}