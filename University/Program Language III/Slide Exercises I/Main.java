public class Main {

    public static void main(String[] args) {

        //Exemplo 1

        //Operador bit a bit "&" bit a bit
        // 1 0
        // 1 1
        //-----
        // 1 0
        System.out.println( "Operador AND \"&\" bit a bit: " + (2 & 3) );

        //Operador bit a bit "|" OR
        //  1 0 0
        //  1 0 1
        // -------
        //  1 0 1
        System.out.println( "Operador OR \"|\" bit a bit: " +  (4 | 5) );

        //Operador Ou Exclusivo "^" bit a bit
        // 1 0 0
        // 1 0 1
        //-------
        // 0 0 1
        System.out.println( "Operador Ou Exclusivo \"^\" bit a bit: " + (4 ^ 5) );

        //Operador Complemento "~" bit a bit
        //~ 0000 0000 0000 0010
        // ---------------------
        //  1111 1111 1111 1101
        System.out.println( "Operador Complemento \"~\" bit a bit:  " + (~2) );



        //Exemplo 2
        int A = 10;
        System.out.println( "Valor de A: " + A );

        int B = 1;

        A = A + B;
        A += B;
        System.out.println( "A += B: " + A );

        A = A - B;
        A -= B;
        System.out.println( "A -= B: " + A );

        A = A * B;
        A *= B;
        System.out.println( "A *= B: " + A );

        A = A / B;
        A /= B;
        System.out.println( "A /= B: " + A );

        A = A % B;
        A %= B;
        System.out.println( "A %= B: " + A );


        //Exemplo 3
        A = 10;
        B = 2;

        A = A > B ? 2: 10;
        System.out.println( "Valor de com ternário: " + A );

    }

}
