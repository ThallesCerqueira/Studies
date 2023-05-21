#include <stdlib.h>

typedef struct Node {

    int key;
    int level;
    struct Node *left;
    struct Node *right;

} Node;

Node* startNode();
Node* newNode();
Node* insert( Node* node, int key );