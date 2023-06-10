

typedef struct Node {

    int key;
    struct Node *left;
    struct Node *right;
    int hight;

} Node;

Node* startNode();
Node* newNode( int key );
Node* rotacionaDireita( Node* raiz );
Node* rotacionaEsquerda( Node* raiz );
int max( int a, int b );