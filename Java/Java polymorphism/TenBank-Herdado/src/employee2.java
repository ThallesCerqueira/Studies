public class employee2 {
    private String name;
    private String cpf;
    private double salary;
    private int type = 0; // 0 - Employee, 1 - Manager

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    public double getBonus(){
        if(this.type == 0){
            return this.salary * 0.1;
        }else{
            return this.salary * 0.2;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return this.salary;
    }
}
