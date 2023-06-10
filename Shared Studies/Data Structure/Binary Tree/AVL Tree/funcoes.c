#include <stdio.h>
#include <stdlib.h>
#include "funcoes.h"

Node* newNode( int key ) {

    Node* node = ( Node* ) malloc( sizeof( Node ) );

    node->left = NULL;
    node->right = NULL;
    node->key = key;
    node->hight = 0;

    return node;

}

Node* startNode() {
    return NULL;
}

Node* rotacionaDireita( Node* raiz ) {

    Node* auxiliar;

    auxiliar = raiz->left;
    raiz->left = auxiliar->right;
    auxiliar->right = raiz;

    raiz->hight = max( altura( raiz->right), altura( raiz->left ) ) + 1;
    auxiliar->hight = max( altura( auxiliar->left, raiz->hight ) ) + 1;

    return auxiliar;

}

Node* rotacionaEsquerda( Node* raiz ) {

    Node* auxiliar;
    
    auxiliar = raiz->right;
    raiz->right = auxiliar->left;
    auxiliar->left = raiz;

    raiz->hight = max( altura( raiz->right), altura( raiz->left  ) ) + 1;
    auxiliar->hight = max( altura( auxiliar->right ), raiz->hight ) + 1;

    return auxiliar;

}

Node* rotacionaEsquerdaDireita( Node* raiz ) {
    raiz->left = rotacionaEsquerda( raiz->left );

    return rotacionaDireita( raiz );
}

Node* rotacionaDireitaEsquerda( Node* raiz ) {
    raiz->right = rotacionaDireita( raiz->right );

    return rotacionaEsquerda( raiz );
}

int max( int a, int b ) {
    if( a > b ) return a;
    return b;
}