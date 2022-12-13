//ESTRUTURAS
typedef struct estruturaCliente{
    int codigoCliente;
    char nome[20];
    float totalPagar;
}CLIENTE;

typedef struct estruturaProduto{
    int codigoProduto;
    float valorProduto;
    char nome[20];
}PRODUTO;

//FUNÇÕES (5/6)
void menuPrincipal();                                   //FUNCIONANDO
void menuCadastroCliente();                             //FUNCIONANDO
void excluirCliente(CLIENTE *cliente);                  //
void alterarCliente(CLIENTE *cliente, int qtdCliente);  //FUNCIONANDO
int cadastroCliente(CLIENTE *cliente, int qtdCliente);  //FUNCIONANDO
int incluirCliente(CLIENTE *cliente, int qtdCliente);   //FUNCIONANDO

//(4/5)
int cadastroProduto(PRODUTO *produto, int qtdProduto);  //FUNCIONANDO
int incluirProduto(PRODUTO *produto, int qtdProduto);   //FUNCIONANDO
void excluirProduto();                                  //
void alterarProduto(PRODUTO *produto, int qtdProduto);  //FUNCIONANDO
void menuCadastroProduto();                             //FUNCIONANDO

//
void venda(CLIENTE *cliente, int qtdCliente, PRODUTO *produto, int qtdProduto);

//(3/4)
void limparTela();                                                              //FUNCIONANDO
int localizaCodigoCliente(CLIENTE *cliente, int codigoCliente, int qtdCliente); //FUNCIONANDO
int localizaCodigoProduto(PRODUTO *produto, int codigoProduto, int qtdProduto); //FUNCIONANDO
int opcao();                                                                    //FUNCIONANDO