public class conta {
    private double Saldo;
    private int Agencia;
    private int Numero;
    private cliente titular;

    public void deposita(double valor){
        Saldo+= valor;
    }

    public boolean saque(double valor){
        
        if(valor >= 0){
            if(Saldo >= valor){
                Saldo -= valor;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean transfere(double valor, conta destino){

        if(Saldo >= valor){

            Saldo -=valor;
            destino.Saldo += valor;

            return true;
        }

        return false;

    }

    public double getSaldo(){
        return Saldo;
    }

    public int getNumero(){
        return Numero;
    }

    public void setNumero(int numero){
        this.Numero = numero;
    }

    public int getAgencia(){
        return Agencia;
    }

    public void setAgencia(int Agencia){
        this.Agencia = Agencia;
    }
}
