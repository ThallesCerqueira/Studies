typedef struct
{
   int key;
   float val;
} TInfo;

typedef TInfo *PInfo;

typedef struct noArvBin{
   TInfo info;
   short int altura;
   struct noArvBin *esq;
   struct noArvBin *dir;
} noArvBin;

typedef noArvBin *PNoArvBin;

PNoArvBin newNoArvBin();
short int alturaDoNo(PNoArvBin arv);
PNoArvBin insereNoArv_B(PNoArvBin arv, TInfo info);
PNoArvBin insereNoArv_D(PNoArvBin arv, TInfo info);
int percorreArv(PNoArvBin arv, PInfo lista, int i);
PNoArvBin removeDaArv(PNoArvBin arv, int key);
void bubbleSort(PInfo lista, int n);
PInfo ordenaLista(PInfo lista, int tam);

void limpa( PNoArvBin arv );
void printArv( PNoArvBin arv );