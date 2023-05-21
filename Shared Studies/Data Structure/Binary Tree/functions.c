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

int search( Node* node, int key ) {

    if( node == NULL ) return 0;

    if( key == node->key ) return 1;

    if( key < node->key ) {

        return search( node->left, key );

    }else {

        return search( node->right, key );

    }

}
