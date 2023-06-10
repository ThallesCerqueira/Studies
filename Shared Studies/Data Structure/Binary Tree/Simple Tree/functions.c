#include <stdio.h>
#include <stdlib.h>
#include "functions.h"

Node* startNode( )  {

    return NULL;

}

Node* newNode() {

    Node* node = ( Node* ) malloc( sizeof( Node ) );
    node->left = NULL;
    node->right = NULL;

    return node;

}

// Inserção recursiva.
Node* insert( Node* node, int key, int level ) {

    if( node == NULL ) {

        node = newNode();
        node->key = key;
        node->level = level;

    }else if( key < node->key ) {

        node->left = insert( node->left, key, ++level );

    }else{

        node->right = insert( node->right, key, ++level );

    }

    return node;

}

// Pesquisa recursiva.
Node* search( Node* node, int key ) {

    if( node == NULL ) return NULL;

    if( key == node->key ) return node;

    if( key < node->key ) {

        return search( node->left, key );

    }else {

        return search( node->right, key );

    }

}

// Somatório para os nós da árvore, recursivo.
int sumNode( Node* node ) {

    if( !node ) return 0;

    return ( sumNode( node->left ) + 1 + sumNode( node->right ) );


}

// Print da árvore, não recursivo.
void printTree( Node* node ) {

    if( node != NULL) {
        
        printf(" %d ", node->key );
        printTree( node->left );
        printTree( node->right );

    }

}

// Busca não recursiva, guarda o endereço do nó ascendente.
Node* buscaNo( Node* node, int key, Node** father ) {

    Node* atual = node;
    *father = NULL;
    
    while( atual ) {
        
        if( atual->key == key ) {
            return atual;
        }

        *father = atual;

        if( key < atual->key ) {
            atual = atual->left;
        }else{
            atual = atual->right;
        }

        return NULL;
    }

}

// Remoção não recursiva.
Node* removeNode( Node* root, int key ) {

    Node *father, *node, *p, *q;

    node = buscaNo( root, key, &father );

    if( node == NULL ) return root;

    // Verifica se há nós NULL adjacentes.
    if( !node->left || !node->right ) {
        
        if( !node->left ) q = node->right;
        else q = node->left;
    
    } else {
        p = node;
        q = node->left;

        while( q->right ) {
            p = q;
            q = q->right;
        }
    }

}