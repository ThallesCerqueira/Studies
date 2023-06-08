from random import randint

def main():
    
    #Declaração de variáveis
    dado1 = dado2 = ponto = soma = 0
    i = 1

    dado1 = randint(0,5)
    dado2 = randint(0,5)

    soma = dado1 + dado2

    #Verificações
    if soma == 7 or soma == 11:

        print(f"Dado 1: {dado1}  Dado 2: {dado2}")
        print(f"Soma: {soma}")
        print("Você ganhou :-)")

    elif soma == 2 or soma == 3 or soma == 12:

        print(f"Dado 1: {dado1}  Dado 2: {dado2}")
        print(f"Soma: {soma}")
        print("Você perdeu :-(")

    else:

        ponto = soma
        soma = 0

        print(f"Dado 1: {dado1}  Dado 2: {dado2}")
        print(f"Ponto: {ponto}")

        print("\nIniciando estágio 2")

        while soma != ponto:
            dado1 = randint(0,5)
            dado2 = randint(0,5)

            soma = dado1 + dado2

            print(f"Dado 1: {dado1}  Dado 2: {dado2}")
            print(f"Jogada {i}: {soma}")

            if soma == ponto:
                print("Você ganhou :-)")
                break
            elif soma == 7:
                print("Você perdeu :-(")
                break

            i +=1
            
main()