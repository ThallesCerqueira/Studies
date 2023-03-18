#include <stdio.h>
#include <ctype.h>

int main(){

    char array[] = "Copies the STRING pointed to, by SRC to DEST";
    int i = 0;

    while(array[i] != '\0'){

        if(array[i] == 'a') array[i] = 'A';
        else if(array[i] == 'e') array[i] = 'E';
        else if(array[i] == 'i') array[i] = 'I';
        else if(array[i] == 'o') array[i] = 'O';
        else if(array[i] == 'u') array[i] = 'U';
        else if(array[i] == 'B') array[i] = 'b';
        else if(array[i] == 'C') array[i] = 'c';
        else if(array[i] == 'D') array[i] = 'd';
        else if(array[i] == 'F') array[i] = 'f';
        else if(array[i] == 'G') array[i] = 'g';
        else if(array[i] == 'H') array[i] = 'h';
        else if(array[i] == 'J') array[i] = 'j';
        else if(array[i] == 'K') array[i] = 'k';
        else if(array[i] == 'L') array[i] = 'l';
        else if(array[i] == 'M') array[i] = 'm';
        else if(array[i] == 'N') array[i] = 'n';
        else if(array[i] == 'P') array[i] = 'p';
        else if(array[i] == 'Q') array[i] = 'q';
        else if(array[i] == 'R') array[i] = 'r';
        else if(array[i] == 'S') array[i] = 's';
        else if(array[i] == 'T') array[i] = 't';
        else if(array[i] == 'V') array[i] = 'v';
        else if(array[i] == 'W') array[i] = 'w';
        else if(array[i] == 'X') array[i] = 'x';
        else if(array[i] == 'Y') array[i] = 'y';
        else if(array[i] == 'Z') array[i] = 'z';

        int aux2 = isspace(array[i]);

        if(aux2 != 0) array[i] = '_';

        i++;
    }

    i = 0;
    while(array[i] != '\0'){
        printf("%c", array[i]);
      i++;
    }

}