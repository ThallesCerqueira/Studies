#include <stdio.h>



int main(){
    float n1,n2;
    char nome[100];

    FILE *fp;
    fp = fopen("arquivo.txt", "r");
    
    fgets(nome,100,fp);
    fscanf(fp, "%f", &n1);
    fscanf(fp, "%f", &n2);
    printf("%s - ", nome);
    printf("%f - ", n1);
    printf("%f", n2);
    printf("\n");
    

    fclose(fp);
    return 0;
}