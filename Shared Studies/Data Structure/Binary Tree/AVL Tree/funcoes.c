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

Node* insere( Node* raiz, int key ) {

    int alturaNo;

    // Se a árvore estiver vazia.
    if( !raiz ) return newNode( key );

    // Primeira possibilidade de inserção.
    if( key < raiz->key ) {
        
        raiz->left = insere( raiz->left, key );

        // Verificando se a inserção mudou o Fator de Balanceamento para +- 2.
        alturaNo = altura( raiz->left ) - altura( raiz->right );
        if( alturaNo == 2 || alturaNo == -2 ) {

            // Decidindo o tipo de rotação.
            if( key < raiz->left->key ) {
                raiz = rotacionaDireita( raiz );
            } else {
                raiz = rotacionaEsquerdaDireita( raiz );
            }

        }

    } else {
        // Segunda possibilidade de inserção.
        if( key > raiz->key ) {

            raiz->right = insere( raiz->right, key );

            // Verificando se a inserção mudou o Fator de Balanceamento para +- 2.
            alturaNo = altura( raiz->left ) - altura( raiz->right );
            if( alturaNo == 2 || alturaNo == -2 ) {

                // Decidindo o tipo de rotação.
                if( key > raiz->right->key ) {
                    
                    raiz = rotacionaEsquerda( raiz );

                } else {

                    raiz = rotacionaDireitaEsquerda( raiz );

                }

            }

        }

    }

    raiz->hight = max( altura( raiz->left ), altura( raiz->right ) ) + 1;

    return raiz;

}

Node* search( Node* node, int key ) {

    if( node == NULL ) return NULL;

    if( key == node->key ) return node;

    if( key < node->key ) {

        return search( node->left, key );

    }else {

        return search( node->right, key );

    }

}

Node* rotacionaDireita( Node* raiz ) {

    Node* auxiliar;

    // Rotacionando, redefinindo os ponteiros.
    auxiliar = raiz->left;
    raiz->left = auxiliar->right;
    auxiliar->right = raiz;

    // Recalculando as alturas.
    raiz->hight = max( altura( raiz->right), altura( raiz->left ) ) + 1;
    auxiliar->hight = max( altura( auxiliar->left ), altura( raiz->hight ) ) + 1;

    return auxiliar;

}

Node* rotacionaEsquerda( Node* raiz ) {

    Node* auxiliar;
    
    // Rotacionando, redefinindo os ponteiros.
    auxiliar = raiz->right;
    raiz->right = auxiliar->left;
    auxiliar->left = raiz;

    // Recalculando as alturas.
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

int altura( Node* raiz ) {
    if ( !raiz ) return -1;

    return raiz->hight;
}

Node* removeNo( Node* raiz, int key ) {

    // Se raiz é nula.
    if( raiz == NULL ) {
        return raiz; 
    } else {

        // Verificando se achou o Nó desejado.
        if( raiz->key == key ) {
            
            // Verificando se é NÓ Folha.
            if( raiz->left == NULL && raiz->right == NULL ) {
                
                free( raiz );
                return NULL;

            } else {

                // Verificando se o NÓ tem 2 filhos.
                if( raiz->left != NULL && raiz->right != NULL ) {

                    Node* aux = raiz->left;

                    // Indo até o último Nó à direita, da subArvore à esquerda.
                    while( aux->right != NULL ) aux = aux->right;

                    raiz->key = aux->key;
                    aux->key = key;
                    raiz->left = removeNo( raiz->left, key );

                    return raiz;

                } else {

                    // Caso em que o NÓ possui 1 filho apenas.
                    Node * aux;

                    if( raiz->left != NULL ) {

                        aux = raiz->left;
                    
                    } else {

                        aux = raiz->right;

                    }

                    free( raiz );

                    return aux;

                }

            }

        } else {

            if( key < raiz->key ) {

                raiz->left = removeNo( raiz->left, key );

            } else {

                raiz->right = removeNo( raiz->right, key );

            }

        }

        // Recalculando altura dos nós.
        int altura1 = raiz->left->hight;
        int altura2 = raiz->right->hight

        raiz->hight = (altura1 > altura1 ? altura1: altura2) + 1;

        // Adicionar minha função de balancear.
        raiz = balancear( raiz );

        return raiz;
    }

}