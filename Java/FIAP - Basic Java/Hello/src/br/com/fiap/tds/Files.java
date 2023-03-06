package br.com.fiap.tds;

import java.io.*;

public class Files {

    public static void main(String[] args) {

//        try {
//            //Abre o arquivo
//            FileWriter stream = new FileWriter("arquivo.txt");
//            PrintWriter print = new PrintWriter(stream);
//
//            //Escreve no arquivo
//            print.println("Teste");
//            print.println("Escrevendo no arquivo");
//
//            //Fecha o objeto print
//            print.close();
//            //Fecha o arquivo
//            stream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//            try {
//                //Abre o arquivo
//                FileReader stream = new FileReader("arquivo.txt");
//                BufferedReader reader = new BufferedReader(stream);
//
//                //Lê uma linha do arquivo
//                String linha = reader.readLine();
//                while (linha != null){
//                    System.out.println(linha);
//                    //Lê a próxima linha do arquivo
//                    linha = reader.readLine();
//                }
//
//                reader.close();
//                //Fecha o arquivo
//                stream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            File arquivo = new File("arquivo.txt");

            // Verifica se o arquivo existe
            if (arquivo.exists()) {

                System.out.println("O arquivo existe!\n" + "Pode ser lido: " + arquivo.canRead() + "\nPode ser gravado: " + arquivo.canWrite() +
                "\nTamanho: " + arquivo.length() +
                "\nCaminho: " + arquivo.getPath());

            } else {

                // Cria o arquivo
                try {
                    if (arquivo.createNewFile())
                        System.out.println("Arquivo criado!");
                    else
                        System.out.println("Arquivo não criado!");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }




    }

}
