public class LampadaTresEstados {

    private int estadoDaLampada;

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
