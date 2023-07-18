public abstract class Moeda {

    // Atributos da classe
    protected double valor;

    // Construtor da classe
    public Moeda(double valor){
        this.valor = valor;

    }

    // Declaração de método abstrato
    public abstract String info();

    // Declaração de método abstrato
    public abstract double converter();

}