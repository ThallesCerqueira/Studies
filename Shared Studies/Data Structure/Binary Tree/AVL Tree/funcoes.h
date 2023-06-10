typedef struct Node {

    int key;
    struct Node *left;
    struct Node *right;
    int hight;

} Node;

Node* startNode();
Node* newNode( int key );
Node* insere( Node* raiz, int key );
Node* search( Node* node, int key );
Node* rotacionaDireita( Node* raiz );
Node* rotacionaDireitaEsquerda( Node* raiz );
Node* rotacionaEsquerda( Node* raiz );
Node* rotacionaEsquerdaDireita( Node* raiz );

int max( int a, int b );
int altura( Node* raiz )