import constants.Constants;
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
        int[] dados = {58,9,42,23,29,33,1,44,47,14};

        trocasTotais = 0;
        comparacoesTotais = 0;

        Utils.askShouldPrint(Constants.QUESTION_DISORDERED_VETOR, dados);

        inicio = System.nanoTime();
        trocasTotais = Selecao.selectionSort(dados);
        //Insercao.insertionSort(dados);
        //Quicksort.quickSort(dados, 0, dados.length-1);
        fim = System.nanoTime();
        tempo = (fim-inicio) * Constants.NANO;

        Utils.askShouldPrint(Constants.QUESTION_ORDERED_VETOR, dados);

        System.out.printf("Tempo decorrido: %.8f segundos\n", tempo);
        System.out.println("Trocas: " + trocasTotais);
        System.out.println("Comparações: " + comparacoesTotais);
        System.out.println();
    }

}