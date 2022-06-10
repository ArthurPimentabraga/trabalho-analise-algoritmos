import constants.Constants;
import metodos.Heapsort;
import metodos.Insercao;
import metodos.Quicksort;
import metodos.Selecao;
import metodos.Utils;

import java.io.IOException;

public class App {

    // TODO do projeto
    // 1. Verificar porque os métodos não estão contabilizando as comparações
    // 2. Executar todos os métodos de forma automatica
    //  2.1. Ler dados dos arquivos gerados

    static long trocasTotais;
    static long comparacoesTotais;

    public static void main(String[] args) throws IOException {
        long inicio, fim;
        double tempo;

        Utils.gerarDados();

        // TEMPORÁRIO
        int[] dados = {58,9,42,23,29,33,1,44,47,14,53,25,2,98};

        trocasTotais = 0;
        comparacoesTotais = 0;
        long []totais={trocasTotais,comparacoesTotais};

        Utils.askShouldPrint(Constants.QUESTION_DISORDERED_VETOR, dados);

        inicio = System.nanoTime();
        totais = Heapsort.heapSort(dados);
        //Insercao.insertionSort(dados);
        //Quicksort.quickSort(dados, 0, dados.length-1);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.println("HeapSort");
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();

        trocasTotais = 0;
        comparacoesTotais=0;
        inicio = System.nanoTime();
        totais = Quicksort.quickSort(dados, 0, dados.length-1);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.println("QuickSort");
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();
    

        trocasTotais = 0;
        comparacoesTotais=0;
        inicio = System.nanoTime();
        totais = Selecao.selectionSort(dados);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.println("Selection");
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();

        trocasTotais = 0;
        comparacoesTotais=0;
        inicio = System.nanoTime();
        totais = Insercao.insertionSort(dados);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;
        System.out.println("Insertion");
        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + totais[0]);
        System.out.println("Comparações: " + totais[1]);
        System.out.println();

        
    }

    

}