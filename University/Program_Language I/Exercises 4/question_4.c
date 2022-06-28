#include <stdio.h>
#include <stdlib.h>
#include <time.h>

double calcPi(int n);

int main(){

    int seed, termo;

    seed = time(NULL);
    srand(seed);

    termo = 5 + rand()%21;

    printf("%d\n", termo);



    return 0;
}

double calcPi(termo){

}