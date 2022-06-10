package metodos;

public class Quicksort {

    private static long trocasTotais = 0;

    public static long quickSort(int[] dados, int inicio, int fim) {
        if (inicio < fim) {                                      //array de tamanho 2 ou maior (inicio é antes do fim)
            int particao = particionar(dados, inicio, fim);     //chamada da partição para os dados
            quickSort(dados, inicio, particao - 1);             //recursividade: metade inicial (esquerda)
            quickSort(dados, particao + 1, fim);                //recursividade: metade final (direita)
        }

        return trocasTotais;
    }

    /**
     * Partição do Quicksort. Recebe início e fim (inclusivos) da área a ser particionada
     * @param dados Array a ser ordenado
     * @param inicio Posição inicial (inclusiva) do particionamento
     * @param fim Posição final (inclusiva) do particionamento
     * @return Posição do particionamento
     */
    public static int particionar(int[] dados, int inicio, int fim) {
        int pivot = dados[fim];         //pivô é o elemento do final do vetor (Seguindo Cormen et al)
        int particao = inicio - 1;      //partição marca onde estão os menores que o pivô (inicialmente, antes dos dados)

        for(int i=inicio ; i<fim; i++){ //verificação de quem são os menores que o pivô
            if (dados[i] < pivot){          //sempre que é menor, aumentamos a partição e jogamos o elemento menor dentro da partição
                particao++;
                trocasTotais = Utils.trocar(dados, i, particao, trocasTotais);
            }
        }

        particao++;     //ao final, incrementamos a partição para posicionar o pivô no local correto
        trocasTotais = Utils.trocar(dados, fim, particao, trocasTotais);
        return particao;
    }

}
