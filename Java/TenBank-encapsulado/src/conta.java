public class conta {
    private double Saldo;
    private int Agencia;
    private int Numero;
    private cliente titular;
    private static int total;

    public conta(int saldo, int Agencia){
        conta.total++;
        System.out.println("O total de contas é: " + conta.total);
        this.Saldo = saldo;
        this.Agencia = Agencia;
    }

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
        if(numero > 0){
            this.Numero = numero;
        }else{
            System.out.println("Números menos ou iguais a zero não são permitidos.");
            return;
        }
    }

    public int getAgencia(){
        return Agencia;
    }

    public void setAgencia(int Agencia){
        if(Agencia > 0){
            this.Agencia = Agencia;
        }else{
            System.out.println("Valores menos ou iguais a zero não são permitidos.");
            return;
        }
        
    }

    public void setTitular(cliente cliente){
        this.titular = cliente;
    }

    public cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return conta.total;
    }
}
