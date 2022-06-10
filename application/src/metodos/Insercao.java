package metodos;

public class Insercao {

    private static long trocasTotais = 0;
    private static long comparacoesTotais = 0;

    public static long[] insertionSort(int[] dados) {

        for(int posRef = 1; posRef < dados.length; posRef++) {  //a partir do segundo elemento (posição 1)...
            int posComp = posRef - 1;                           //auxiliar para comparação com o elemento de referência
            int dadoRef = dados[posRef];                        //auxiliar para guardar o elemento de referência

            while (posComp >= 0 && dadoRef < dados[posComp]){  //enquanto o elemento de referência for menor e houver vetor, recua uma posição
                posComp--;
                comparacoesTotais++;
            }
            comparacoesTotais++;
            trocasTotais++;

            //posição encontrada. Copiar todos os elementos entre a posição de referência e o fim da comparação "para a frente"
            //note que não é uma troca: cópia é mais barato para o algoritmo (1 operação contra 3)
            for (int posCopia = posRef; posCopia > (posComp+1); posCopia--){
                dados[posCopia] = dados[posCopia - 1];
                trocasTotais++;
            }

            //inserimos o dado de referência em sua posição correta
            dados[posComp + 1] = dadoRef;
            trocasTotais++;
        }
        long [] vet = {trocasTotais,comparacoesTotais};

        return vet;
    }

}
