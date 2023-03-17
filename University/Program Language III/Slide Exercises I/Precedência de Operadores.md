##Precedência de Operadores em Java

#Os operadores na Linguagem Java são:

    + Adição
    - Subtração
    * Multiplicação
    / Divisão
    % Resto da divisão

E a precedência se dar por:

    *  Multiplicação
    /  Divisão          -   Estes possuem a mesma ordem de precedência.
    %  Resto da divisão

    + Adição
    - Subtração         -   Estes possuem a mesma ordem de precedência.

    E por fim
    = Atribuição        -   Que é o ultimo a ser executado.


Utilização de parêntesis em Java

Vale ressaltar, que assim como na matématica, em Java, os operadores possuem suas precedêcias, como foi relatado acima, mas também
os parentêsis possuem seu nível de procedência, e que para estes, é o maior que há. Ou seja, se houver operandos entre parentêsis,
estes serão feitos primeiro, independente da precedência que há sobre os operadores aritméticos.

Por exemplo:
    (10 + 3) * 5 = 65, pois primeiro realiza-se a soma, para depois fazer a multiplicação.