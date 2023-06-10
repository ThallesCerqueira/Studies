#include <stdlib.h>

typedef struct Node {

    int key;
    int level;
    struct Node *left;
    struct Node *right;

} Node;

Node* startNode();
Node* newNode();
Node* insert( Node* node, int key, int level );
Node* search( Node* node, int key );
Node* buscaNo( Node* node, int key, Node** father );

int sumNode( Node* node );
void printTree( Node* node );