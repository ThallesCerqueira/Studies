#include <stdio.h>

int main(void){

    //Opção a
    char cha1, cha2, cha3;

    //Opção b
    printf("Bem-Vindo, digite por gentileza dois caracteres: \n");
    scanf("%c ", &cha1);
    scanf("%c", &cha2);

    //Opção c
    cha3 = cha1 - 1;
    printf("\nO caracter antecessor a [%c] é [%c]\n", cha1, cha3);

    //Opção d
    cha3 = cha2 + 1;
    printf("\nO caracter sucessor a [%c] é [%c]\n", cha2, cha3);

    //Opção e
    
    /*
    TENTATIVA INICIAL:
    cha1 >= 65 && cha1 <= 90 ? cha3 = 'A': cha3 = ' ';
    */

    /*
    TENTATIVA EXAUSTIVA:
    cha1 == 'A' || cha1 == 'B' ||cha1 == 'C' || cha1 == 'D' || cha1 == 'E' || cha1 == 'F' || cha1 == 'G' || cha1 == 'H' || cha1 == 'I' || cha1 == 'J' || cha1 == 'K' || cha1 == 'L' || cha1 == 'M' || cha1 == 'N' || cha1 == 'O' ||  cha1 == 'P' || cha1 == 'Q' || cha1 == 'R' || cha1 == 'S' || cha1 == 'T' || cha1 == 'U' || cha1 == 'V' || cha1 == 'W' || cha1 == 'X' || cha1 == 'Y' || cha1 == 'Z' ? cha3 = 'A' : cha3 = ' ';
    */ 

    if (cha1 >= 65 && cha1 <= 90){
        cha3 = 'A';
        printf("%c\n", cha3);
    }
    else{
        cha3 = ' ';
        printf("%c\n", cha3);
    }
    
    //Opção f
    if(cha2 >= 97 && cha2 <= 122){
        cha3 = 'a';
        printf("%c\n", cha3);
    }
    else{
        cha3 = ' ';
        printf("%c\n", cha3);
    }

    //Opção g
    if((cha1 >= 48 && cha1 <= 57) || (cha2 >= 48 && cha2 <= 57)){
        cha3 = '1';
        printf("%c\n", cha3);
    }
    else{
        cha3 = 'E';
        printf("%c\n", cha3);
    }

    return 0;
}