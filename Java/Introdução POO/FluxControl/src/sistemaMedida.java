public class sistemaMedida {
    public static void main(String[] args) {
        String tamanho = "P";

        switch (tamanho){
            case "P":{
                System.out.println("PEQUENO");
                break;
            }
            case "M":{
                System.out.println("MÉDIO");
                break;
            }
            case "G":{
                System.out.println("GRANDE");
                break;
            }
            default: 
                System.out.println("INDEFINIDO");
                
        }
    }
}
