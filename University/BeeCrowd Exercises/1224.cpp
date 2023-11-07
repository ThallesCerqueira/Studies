#include <iostream>
#include <vector>

using namespace std;

// Grupo: Thalles Cerqueira, Mateus Lisboa, André Dutra 

int main() {
    int numCartas;

    while (cin >> numCartas) {
        vector<int> valoresCartas(numCartas);

        for (int i = 0; i < numCartas; ++i) {
            cin >> valoresCartas[i];
        }

        vector<vector<long long>> dp(numCartas, vector<long long>(2));

        for (int i = 0; i < numCartas - 1; ++i) {
            dp[i][0] = max(valoresCartas[i], valoresCartas[i + 1]);
        }

        int jogadorAtual = 0;
        int jogadorAnterior = 1;

        for (int tamanhoIntervalo = 4; tamanhoIntervalo <= numCartas; tamanhoIntervalo += 2) {
            jogadorAnterior = jogadorAtual;
            jogadorAtual = !(jogadorAtual & 1);

            for (int i = 0, j = tamanhoIntervalo - 1; j < numCartas; ++i, ++j) {
                dp[i][jogadorAtual] = max(valoresCartas[i] + min(dp[i + 1][jogadorAnterior], dp[i + 2][jogadorAnterior]),
                                  valoresCartas[j] + min(dp[i][jogadorAnterior], dp[i + 1][jogadorAnterior]));
            }
        }

        cout << dp[0][jogadorAtual] << endl;
    }

    return 0;
}
