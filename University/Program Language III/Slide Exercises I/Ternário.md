# Operador Ternário

O operador ternário possui uma funcionalidade semelhante ao do If...Else e ele é representado pelo símbolo "?"

Por exemplo:

    condição ? valor se for verdareiro : valor se for falso;
    
E agora o exemplo em Java:

```JAVA
public class Main {

    public static void Main() {
    
        int A = 10;
        int B = 2;

        A = A > B ? 2: 10;
        
        System.out.println( "Valor de com ternário: " + A );
    
    }

}
```
