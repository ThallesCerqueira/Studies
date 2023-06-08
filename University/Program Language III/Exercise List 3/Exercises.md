## Questão 1 - 

    modelo VendaLampada
    início do modelo
        dado estadoDaLampada;
        dado quantidade;
        dado valor;

        operação acende()
            início
                estadoDaLampada = aceso;
            fim
        
        
        operação apaga()
            início
                estadoDaLampada = apagado;
            fim
        
        operação adicionarQuantidade( novaQuantidade )
            início
                quantidade = quantidade + novaQuantidade;
            fim

        operação removerQuantidade( NovaQuantidade )
            início
                quantidade = quantidade - novaQuantidade;
            fim

        operação mostrarQuantidadeAtual()
            início
                imprime "A quantidade atual de lâmpadas é:" + quantidade;
            fim
        
        operação mudarValor( novoValor )
            início
                valor = novoValor;
            fim

        operação valorAPagar( quantasLampadas )
            início
                valorAPagar = quantasLampadas * valor;
                imprime "O valor a pagar é:" + valorAPagar;
            fim

        operação mostraEstado()
            início
                se (estadoDaLampada == aceso)
                    imprime "A lâmpada está acesa";
                senão
                    imprime "A lâmpada está em meia-luz";
            fim

    fim do modelo

## Questão 2 -

    modelo Lampada
    início do modelo
        dado estadoDaLampada;

        operação acende()
            início
                estadoDaLampada = aceso;
            fim
        
        
        operação apaga()
            início
                estadoDaLampada = apagado;
            fim

        operação meiaLuz()
            início
                estadoDaLamapa = meiaLuz;
            fim

        operação mostraEstado()
            início
                se (estadoDaLampada == aceso)
                    imprime "A lâmpada está acesa";
                senão se (estadoDaLampada == apagado)
                    imprime "A lâmpada está apagada";
                senão
                    imprime "A lâmpada está em meia-luz";
            fim

    fim do modelo


## Questão 3 -

    modelo Lampada
    início do modelo
        dado estadoDaLampada;
        dado valorLuminosidade;

        operacao atribuiEstado()
            início
                se (valorLuminosidade == 100)
                    acende();
                senão se (valorLuminosidade > 0 e valorLuminosidade < 100)
                    meiaLuz();
                senão
                    apaga();
            fim

        operação acende()
            início
                estadoDaLampada = aceso;
            fim
        
        
        operação apaga()
            início
                estadoDaLampada = apagado;
            fim

        operação meiaLuz()
            início
                estadoDaLamapa = meiaLuz;
            fim

        operação mostraEstado()
            início
                se (estadoDaLampada == aceso)
                    imprime "A lâmpada está acesa";
                senão se (estadoDaLampada == apagado)
                    imprime "A lâmpada está apagada";
                senão
                    imprime "A lâmpada está em meia-luz";
            fim

    fim do modelo

## Questão 4 -
    modelo Lampada
    início do modelo
        dado estadoDaLampada;
        dado quantidade;
        dado valor;

        operação acende()
            início
                estadoDaLampada = aceso;
            fim
        
        
        operação apaga()
            início
                estadoDaLampada = apagado;
            fim
        
        operação adicionarQuantidade( novaQuantidade )
            início
                quantidade = quantidade + novaQuantidade;
            fim

        operação removerQuantidade( NovaQuantidade )
            início
                quantidade = quantidade - novaQuantidade;
            fim

        operação mostrarQuantidadeAtual()
            início
                imprime "A quantidade atual de lâmpadas é:" + quantidade;
            fim
        
        operação mudarValor( novoValor )
            início
                valor = novoValor;
            fim

        operação valorAPagar( quantasLampadas )
            início
                valorAPagar = quantasLampadas * valor;
                imprime "O valor a pagar é:" + valorAPagar;
            fim

        operação mostraEstado()
            início
                se (estadoDaLampada == aceso)
                    imprime "A lâmpada está acesa";
                senão
                    imprime "A lâmpada está em meia-luz";
            fim

        operação estaLigada()
            início
                se (estadoDaLampada == aceso)
                    retorne verdadeiro;
                senão
                    retorne falso;
            fim		

    fim do modelo

## Questão 5 -
	
	operação abreConta(nome, depósito, especial)
		início
			nomeDoCorrentista = nome;
			
			se (depósito < 0)
				saldo = 0;
			senão
				saldo = depósito;

			contaÉEspecial = especial;
		fim


## Questão 6 - 

	operação abreConta(nome, depósito, especial)
		início
			nomeDoCorrentista = nome;
			
			se (depósito < 0)
				imprime "Alerta, saldo negativo!"

				se (especial == verdadeiro)
					saldo = depósito;
				senão
					saldo = 0;
			senão
				saldo = depósito;

			contaÉEspecial = especial;
		fim
	
## Questão 7 -

    modelo HoraAproximada
    início do modelo
        dado hora, minuto;

        operação inicializaHora( aHora, oMinuto )
            início
                se horaVálida( aHora, oMinuto )
                    início
                        hora = aHora;
                        minuto = oMinuto;
                    fim
                senão
                    início
                        hora = 0;
                        minuto = 0;
                    fim
            fim

        operação horaVálida( aHora, oMinuto )
            início
                se ( (aHora >= 0) e (aHora <= 24) e (oMinuto >= 0) e (oMinuto <= 60) )
                    retorna verdadeiro;

                senão
                    retorna falso;
        
            fim
        
        operação mostraHora( aHora, oMinuto )
            início
                imprime aHora;
                imprime ":";
                imprime oMinuto;
            fim

    fim do modelo


## Questão 8 - 

    modelo HoraPrecisa
    início do modelo
        dado hora, minuto, segundos, centesimosSegundos;

        operação inicializaHora( aHora, oMinuto, oSegundos, oCentesimosSegundos )
            início
                se horaVálida( aHora, oMinuto, oSegundos, oCentesimosSegundos )
                    início
                        hora = aHora;
                        minuto = oMinuto;
                        segundos = oSegundos;
                        centesimosSegundos = oCentesimosSegundos;
                    fim
                senão
                    início
                        hora = 0;
                        minuto = 0;
                        segundos = 0;
                        centesimosSegundos = 0;
                    fim
            fim

        operação horaVálida( aHora, oMinuto, oSegundos, oCentesimosSegundos )
            início
                se ( (aHora >= 0) e (aHora <= 24) e (oMinuto >= 0) e (oMinuto <= 60) e (oSegundos >= 0 ) e (oSegundos <= 60) e (oCentesimosSegundos >= 0) e (oCentesimosSegundos <= 60) )
                    retorna verdadeiro;

                senão
                    retorna falso;
        
            fim
        
        operação mostraHora( aHora, oMinuto, oSegundos, oCentesimosSegundos )
            início
                imprime aHora;
                imprime ":";
                imprime oMinuto;
                imprime ":";
                imprime oSegundos;
                imprime ":";
                imprime oCentesimosSegundos;
                
            fim

    fim do modelo


## Questão 9 - 

    modelo Livro
    início do modelo
        dados autor, editora, paginas, quantidadeVendidos;

        operação setAutor( oAutor )
            início
                autor = oAutor;
                
            fim

        operação setEditora( aEditora )
            início
                editora = aEditora;
                
            fim

        operação setPaginas( aPaginas )
            início
                paginas = aPaginas;
                
            fim

        operação setQuantidadeVendidos( quantidade )
            início
                quantidadeVendidos = quantidade;
                
            fim

    fim do modelo

## Questão 10 - 

    modelo LivroDeLivraria
    início do modelo
        dados autor, editora, paginas, quantidadeVendidos, valor;

        operação venderLivro( valor, quantidade )
            início
                imprime "Total a pagar: " + valor * quantidade;
            fim

        operação divulgarLivro()
            início
                imprime "Venham, venham! Comprem os livros do" + autor;
                imprime "Aproveitem a promoção, por apenas R$" + valor;
            fim
        

        operação setAutor( oAutor )
            início
                autor = oAutor;
                
            fim

        operação setEditora( aEditora )
            início
                editora = aEditora;
                
            fim

        operação setPaginas( aPaginas )
            início
                paginas = aPaginas;
                
            fim

        operação setQuantidadeVendidos( quantidade )
            início
                quantidadeVendidos = quantidade;
                
            fim


    fim do modelo

## Questão 11 - 

//A diferença deste modelo é que agora existem novos dados no modelo e que alguns métodos deixaram de existir para o surgimento de outros.
    
    modelo LivroDeBiblioteca
    início do modelo
        dados autor, editora, paginas, quantidadeEmprestado, disponivel, destinatario, prazoEmprestimo;

        operação setAutor( oAutor )
            início
                autor = oAutor;
                
            fim

        operação setEditora( aEditora )
            início
                editora = aEditora;
                
            fim

        operação setPaginas( aPaginas )
            início
                paginas = aPaginas;
                
            fim

        operação quantidadeEmprestado()
            início
                quantidadeEmprestado = quantidadeEmprestado + 1;
                
            fim

        operação estáDisponivel()
		início
		    se disponivel == verdadeiro
			retorne verdadeiro;
		    senão
			retorne falso;
		fim
		
        operação emprestarLivro( oDestinatario, oPrazo )
            início
                se estáDisponivel()
                    destinatario = oDestinatario;
                    prazoEmprestimo = oPrazo;
                    imprime "Livro emprestado para " + oDestinatario + "com prazo de entrega até " + oPrazo;
                senão
                    imprime "Livro indisponível, tente em outro momento";
            fim

    fim do modelo
        
