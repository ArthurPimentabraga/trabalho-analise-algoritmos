package metodos;

import constants.Constants;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    static Random sorteio = new Random(42);
    static Scanner scanner = new Scanner(System.in);

    /**
     * Método auxiliar para trocar dois elementos de posição (necessário em todos os algoritmos de comparação)
     * @param dados O array com os dados
     * @param pos1  Posição 1 para troca
     * @param pos2  Posição 2 para troca
     */
    public static void trocar(int[] dados, int pos1, int pos2){
        int aux = dados[pos1];
        dados[pos1] = dados[pos2];
        dados[pos2] = aux;
        
    }

    public static void gerarDados() throws IOException {
        for (int quant : Constants.TAMANHOS) {
            float trocas = quant * 0.92f;  //quantidade de trocas para bagunçar os dados

            int[] vetAux = new int[quant];

            //Criaremos o array com dados crescentes, para evitar repetições
            int valorAtual = 1;
            vetAux[0] = 1;
            for(int i = 1; i < quant; i++){
                valorAtual += (sorteio.nextInt(11) + 1);
                vetAux[i] = valorAtual;
            }

            //Vamos bagunçar o vetor
            for (int i = 1; i < (int)trocas ; i++) {     //até o número de trocas calculado...
                int pos1 = sorteio.nextInt(quant);      //sorteamos duas posições e trocamos.
                int pos2 = sorteio.nextInt(quant);
                Utils.trocar(vetAux, pos1, pos2);
            }

            gravarDados(vetAux, "T" + quant);
        }
    }

    private static void gravarDados(int[] dados, String fileName) throws IOException {
        FileWriter arq = new FileWriter(fileName + ".txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        Arrays.stream(dados).forEach(gravarArq::println);
        arq.close();
    }

    public static void askShouldPrint(String question, int[] dados) {
        System.out.printf(question);
        String choose = scanner.next();
        if ("y".equals(choose)) Utils.printVector(dados);
    }

    public static int chooseTest() {
        System.out.println("Escolha um tamanho de vetor para executar:");
        System.out.println("1. 1000");
        System.out.println("2. 10_000");
        System.out.println("3. 100_000");
        System.out.println("4. 500_000");
        int choose = scanner.nextInt();
        return Constants.TAMANHOS[choose-1];
    }

    public static void printVector(int[] dados) {
        for (int i : dados) {
            System.out.print(i + " | ");
        }
        System.out.println("\n");
    }

    public static int[] carregarDados(int tamanho) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("T"+tamanho+".txt"));
        int[] dados = new int[tamanho];
        String linha;

        for (int i = 0; i < dados.length; i++) {
            linha = buffRead.readLine();
            if (linha != null) {
                dados[i] = Integer.parseInt(linha);
            }
        }

        buffRead.close();
        return dados;
    }

}
