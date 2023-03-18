#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

double calcPi(int n);
double result;

int main(){

    int seed, termo;

    seed = time(NULL);
    srand(seed);
    termo = 5 + rand()%21;

    calcPi(termo);

    printf("%lf", result);

    return 0;
}

double calcPi(int termo){
    
    double somatorio;
    double result_somatorio = 0;
    
    for(int i = 0; i < termo; i++){
        somatorio = pow(-1, i) / (2 * i + 1);
        result_somatorio += somatorio;
    }

    result = result_somatorio * 4;

    return result;
}