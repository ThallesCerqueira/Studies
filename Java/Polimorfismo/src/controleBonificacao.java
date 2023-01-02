public class controleBonificacao {

    private double soma;

    public void registra(employee f){
        double boni = f.getBonus();
        this.soma = this.soma + boni;
    }

    public double getSoma() {
        return soma;
    }
}
