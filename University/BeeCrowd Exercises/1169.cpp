#include <iostream>
#include <cmath>

// Grupo: Thalles Cerqueira, Mateus Lisboa, André Dutra 

// Função para calcular a quantidade de grãos de trigo em kg
double calcular_quantidade_em_kg(int n) {
    double quantidade_de_graos = pow(2.0, n) - 1.0;
    double quantidade_em_kg = quantidade_de_graos / 12.0 / 1000.0;
    return quantidade_em_kg;
}

int main() {
    // Leitura do número de casos de teste
    int num_casos;
    std::cin >> num_casos;

    // Loop para cada caso de teste
    for (int i = 0; i < num_casos; i++) {
        // Leitura do número de casas no tabuleiro
        int num_casas;
        std::cin >> num_casas;

        // Cálculo da quantidade de grãos de trigo em kg
        double quantidade_em_kg = calcular_quantidade_em_kg(num_casas);

        // Impressão da quantidade em kg
        std::cout << static_cast<long long>(quantidade_em_kg) << " kg" << std::endl;
    }

    return 0;
}
