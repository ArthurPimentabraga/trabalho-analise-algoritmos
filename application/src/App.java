import constants.Constants;
import metodos.Heapsort;
import metodos.Insercao;
import metodos.Quicksort;
import metodos.Selecao;
import metodos.Utils;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        long inicio, fim;
        double tempo;

        Utils.gerarDados();

        int test = Utils.chooseTest();

        int[] dados = Utils.carregarDados(test);
        long[] totais;

        System.out.println("####################################################################");

        System.out.println("HeapSort");
        Utils.askShouldPrint(Constants.QUESTION_DISORDERED_VETOR, dados);
        inicio = System.nanoTime();
        totais = Heapsort.heapSort(dados);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();
        Utils.askShouldPrint(Constants.QUESTION_ORDERED_VETOR, dados);

        System.out.println("####################################################################");

        System.out.println("QuickSort");
        dados = Utils.carregarDados(test);
        Utils.askShouldPrint(Constants.QUESTION_DISORDERED_VETOR, dados);
        inicio = System.nanoTime();
        totais = Quicksort.quickSort(dados, 0, dados.length-1);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();
        Utils.askShouldPrint(Constants.QUESTION_ORDERED_VETOR, dados);

        System.out.println("####################################################################");

        System.out.println("Selection");
        dados = Utils.carregarDados(test);
        Utils.askShouldPrint(Constants.QUESTION_DISORDERED_VETOR, dados);
        inicio = System.nanoTime();
        totais = Selecao.selectionSort(dados);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();
        Utils.askShouldPrint(Constants.QUESTION_ORDERED_VETOR, dados);

        System.out.println("####################################################################");

        System.out.println("Insertion");
        dados = Utils.carregarDados(test);
        Utils.askShouldPrint(Constants.QUESTION_DISORDERED_VETOR, dados);
        inicio = System.nanoTime();
        totais = Insercao.insertionSort(dados);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();
        Utils.askShouldPrint(Constants.QUESTION_ORDERED_VETOR, dados);

        System.out.println("####################################################################");
    }

}