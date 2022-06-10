package metodos;

public class Heapsort {
    private static long trocasTotais = 0;
    private static long comparacoesTotais = 0;

    public static long [] heapSort(int[] dados) {
        
        buildMaxHeap(dados);
        int n = dados.length;

        for (int i = dados.length - 1; i > 0; i--) {
            Utils.trocar(dados, i, 0);
            trocasTotais++;
            maxHeapify(dados, 0, --n);
        }
        
        return new long[]{trocasTotais, comparacoesTotais};
    }

    private static void buildMaxHeap(int[] dados) {
        for (int i = dados.length / 2 - 1; i >= 0; i--) {
            maxHeapify(dados, i, dados.length);
        }
    }

    private static void maxHeapify(int[] dados, int pos, int tamanhoDoVetor) {

        int max = 2 * pos + 1, right = max + 1;
        if (max < tamanhoDoVetor) {

            if (right < tamanhoDoVetor && dados[max] < dados[right]) {
                max = right;
            }

            if (dados[max] > dados[pos]) {
                Utils.trocar(dados, max, pos);
                trocasTotais++;
                
                maxHeapify(dados, max, tamanhoDoVetor);
            }
        }
        comparacoesTotais++;
    }

}
