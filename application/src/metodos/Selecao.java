package metodos;

public class Selecao {

    public static long [] selectionSort(int[] dados) {
        long trocasTotais = 0;
        long comparacoesTotais = 0;

        //para cada posição de referência, do primeiro elemento ao penúltimo...
        for (int posReferencia = 0; posReferencia<dados.length-1 ; posReferencia++) {

            int menor = posReferencia;  //inicializar o menor: elemento da posição atual

            for (int i=posReferencia+1; i< dados.length; i++){  //procuramos o menor da referência para a frente

                if (dados[i] < dados[menor])    //se encontramos um menor, armazenamos a posição
                    menor = i;
                    comparacoesTotais++;
            }

            Utils.trocar(dados, posReferencia, menor); //trocamos o elemento da posição de referência com o menor encontrado
            trocasTotais++;
        }
        long[] vet={trocasTotais,comparacoesTotais};

        return vet;
    }

}
