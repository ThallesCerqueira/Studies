#include <stdio.h>

int main(){

    int a, b, c;

    printf("Digite o valor do lado a: ");
    scanf("%i", &a);

    printf("Digite o valor do lado b: ");
    scanf("%i", &b);

    printf("Digite o valor do lado c: ");
    scanf("%i", &c);

    if(a != 0 && b != 0 && c != 0){

        if(a*a == b*b + c*c){

            printf("Os lados digitados podem ser de um triângulo retângulo!\n");
        }else if (b*b == a*a + c*c){

            printf("Os lados digitados podem ser de um triângulo retângulo!\n");
        }else if(c*c == a*a + b*b){

            printf("Os lados digitados podem ser de um triângulo retângulo!\n");
        }else{

            printf("Os lados digitados não podem ser de um triângulo retângulo!\n");
        }
    }
    return 0;
}