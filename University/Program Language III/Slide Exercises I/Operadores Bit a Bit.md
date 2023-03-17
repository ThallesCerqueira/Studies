# Question: Faça uma pesquisa sobre outros tipos de operadores em Java: Operadores bit a bit e Operadores compostos e de atribuição.

## Operadores Bit a Bit (Bitwise)

Os operadores são chamados de bit a bit porque realizam uma comparação dos operando no nível de seus bits.

### Operador E "&" bit a bit
Este faz a comparação entre os operandos semelhante ao conectivo lógico Conjunção "^". E que o resultado é true se ambos operandos forem 1.

Por exemplo:
    "2 & 3" é semelhante a "10 & 11" (Desconsiderando os 14 bits restantes).

Portanto, a operação é feita da seguinte forma

        1 0
        1 1
       -----
        1 0

E a tabela da verdade fica:

     Operando 1 | Operando 2 | Resultado
        1             1            1
        1             0            0
        0             1            0
        0             0            0



### Operador OU "|" bit a bit
Este faz a comparação entre os operandos semelhante ao conectivo lógico Disjunção "V". E que o resultado será true se algum dos operandos forem 1.

Por exemplo:
    "4 | 5" é semelhante a "100 | 101" (Desconsiderando os 13 bits restantes).

Portanto, a operação é feita da seguinte forma

        1 0 0
        1 0 1
       -------
        1 0 1

E a tabela de verdade fica:

     Operando 1 | Operando 2 | Resultado
         1            1            1
         1            0            1
         0            1            1
         0            0            0


### Operador Ou Exclusivo "^" bit a bit
Este faz a comparação entre os operandos semelhante ao conectivo lógico Ou Exclusivo. E que o resultado será true se apenas um dos operandos for 1.

Por exemplo:
    "4 ^ 5" é semelhante a "100 ^ 101" (Desconsiderando os 13 bits restantes).

Portanto, a operação é feita da seguinte forma

        1 0 0
        1 0 1
       -------
        0 0 1

E a tabela de verdade fica:

     Operando 1 | Operando 2 | Resultado
         1            1            0
         1            0            1
         0            1            1
         0            0            0


### Operador Complemento "~" bit a bit
Este operador faz a negação do operando. Ou seja, se for 1, vira 0 e vice versa.

Por exemplo:
    "\~5" é semelhante a "\~101" (Desconsiderando os 13 bits restantes).

Portanto, a operação é feita da seguinte forma

        ~ 1 0 1
        --------
          0 1 0

E a tabela da verdade fica:

    Operando 1 | Resultado
        1           0
        0           1
