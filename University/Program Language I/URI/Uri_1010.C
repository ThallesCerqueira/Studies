#include <stdio.h>

int main(){
  
    int cdg1, cdg2, qnt1, qnt2;
    float vlr1, vlr2, pcr1, pcr2, pgr;
    scanf("%i %i %f", &cdg1, &qnt1, &vlr1);
    scanf("%i %i %f", &cdg2, &qnt2, &vlr2);

    pcr1 = qnt1 * vlr1;
    pcr2 = qnt2 * vlr2;
    pgr = pcr1 + pcr2;

    printf("VALOR A PAGAR: R$%.2f\n", pgr);

    return 0;
}