package metodos;

import java.util.Random;

public class Utils {

    //#region Metódos Utilitários
    /**
     * Método auxiliar para trocar dois elementos de posição (necessário em todos os algoritmos de comparação)
     * @param dados O array com os dados
     * @param pos1  Posição 1 para troca
     * @param pos2  Posição 2 para troca
     */
    public static long trocar(int[] dados, int pos1, int pos2, long trocasTotais){
        int aux = dados[pos1];
        dados[pos1] = dados[pos2];
        dados[pos2] = aux;
        return ++trocasTotais;
    }

    /**
     * Gerador de conjuntos de dados int (arrays) para teste
     * @param quant O tamanho do conjunto
     * @param ordenado  Conjunto ordenado (true) ou não (false)
     * @param proporcao Em caso de conjunto desordenadao, proporção dos elementos fora de lugar
     * @return Um array com as características acima
     */
    public static int[] gerarDados(int quant, boolean ordenado, float proporcao, Random sorteio, long trocasTotais){
        float trocas = quant * proporcao;  //quantidade de trocas para bagunçar os dados

        int[] vetAux = new int[quant];

        //Criaremos o array com dados crescentes, para evitar repetições
        int valorAtual = 1;
        vetAux[0] = 1;
        for(int i=1; i<quant; i++){
            valorAtual += (sorteio.nextInt(11)+1);
            vetAux[i] = valorAtual;
        }

        //Vamos bagunçar o vetor, se for pedido pelo usuário.
        if (!ordenado) {
            for (int i = 1; i < (int)trocas ; i++){     //até o número de trocas calculado...
                int pos1 = sorteio.nextInt(quant);      //sorteamos duas posições e trocamos.
                int pos2 = sorteio.nextInt(quant);

                Utils.trocar(vetAux, pos1, pos2, trocasTotais);
            }
        }
        return vetAux;
    }

}
