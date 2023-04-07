import math

def main():

    #Declarando variáveis
    valorMedio = dPadrao = auxiliar = porcentoValorMedio = 0
    vetMultimetros = []
    tamVet = 10

    print("Equipe de manutenção - Bem vindo!\n")

    #Leitura dos valores dos multímetros
    for i in range(tamVet):
        vetMultimetros.append( float( input(f"Entre com a voltagem do {i+1}º multímetro: ") ) )
        valorMedio += ( vetMultimetros[i] / tamVet )

    #Cálculo do Desvio Padrão
    for i in range(tamVet):
        auxiliar = (vetMultimetros[i] - valorMedio) * (vetMultimetros[i] - valorMedio)

        dPadrao +=  math.sqrt( auxiliar / tamVet )

    #Cálculo da porcentagem do valor Médio
    porcentoValorMedio = valorMedio * 0.10

    #Estética
    print()

    #Output dos valores lidos
    for i in range(tamVet):
        print(f"Voltagem do {i+1}º Multímetro: {vetMultimetros[i]}")

    #Output do valor médio
    print(f"\nValor médio: {valorMedio}")

    #Output da porcentagem do valor médio
    print(f"Porcento valor médio: {porcentoValorMedio}")

    #Output do desvio padrão
    print(f"Desvio Padrão: {dPadrao}")

    #Output do estado do Multímetro
    if dPadrao > porcentoValorMedio:
        print("RESULTADO: Multímetro com defeito!")
    else:
        print("RESULTADO: Multímetro em perfeitas condições.")


main()