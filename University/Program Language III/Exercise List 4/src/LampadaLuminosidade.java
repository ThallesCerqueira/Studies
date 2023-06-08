public class LampadaLuminosidade {

    private int valorLuminosidade;
    private int estadoDaLampada;

    public void setValorLuminosidade(int luminosidade){

        if(luminosidade >= 0 && luminosidade <= 100)
            this.valorLuminosidade = luminosidade;
        else{
            this.valorLuminosidade = 0;
        }
    }

    public void atribuirEstado() {

        if(valorLuminosidade == 100){
            acende();
        } else if ( valorLuminosidade > 0 && valorLuminosidade < 100 ) {
            meiaLuz();
        }else{
            apaga();
        }

    }

    public void acende() { estadoDaLampada = 1; }

    public void meiaLuz() { estadoDaLampada = 2; }

    public void apaga() { estadoDaLampada = 3; }

    public void mostraEstado() {

        if(estadoDaLampada  == 1) {
            System.out.println("A lâmpada está acesa!");
        } else if (estadoDaLampada == 2) {
            System.out.println("A lâmpada está meia-Luz!");
        }else{
            System.out.println("A lâmpada está apagada!");
        }

    }


}
