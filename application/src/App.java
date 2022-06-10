import metodos.Insercao;
import metodos.Quicksort;
import metodos.Selecao;
import metodos.Utils;

import java.util.Random;

public class App {
    static Random sorteio;
    static long trocasTotais;
    static long comparacoesTotais;

    public static void main(String[] args) {
        final double NANO = (1.0f/1_000_000_000); // Nanossegundo: 1/10^9 segundos (para marcação de tempo)
        final int TAMANHO = 10;                   // 100; 1000; 10_000; 100_000;
        final int INITALEATORIO = 42;             // Semente do gerador aleatório (fixa para os testes)

        long inicio, fim;
        double tempo;

        sorteio = new Random(INITALEATORIO);
        int[] dadosTesteAleat = Utils.gerarDados(TAMANHO, false, 0.92f, sorteio, trocasTotais);

        trocasTotais = 0;
        comparacoesTotais = 0;

        // Comentar para testes!
        System.out.println("Array desordenado:");
        for(int i : dadosTesteAleat){
            System.out.print(String.format("%3d", i) + " ");
        }

        inicio = System.nanoTime();
        //trocasTotais = Selecao.selectionSort(dadosTesteAleat);
        //Insercao.insertionSort(dadosTesteAleat);
        Quicksort.quickSort(dadosTesteAleat, 0, dadosTesteAleat.length-1);
        fim = System.nanoTime();
        tempo = (fim-inicio)*NANO;

        // Comentar para testes!
        System.out.println("\nArray ordenado:");
        for(int i : dadosTesteAleat){
            System.out.print(String.format("%3d", i) + " ");
        }

        System.out.println();
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + trocasTotais);
        System.out.println("Comparações: " + comparacoesTotais);

    }

}