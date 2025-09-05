package src;
public class MergeVetor {
    public static FilaVetor merge(FilaVetor A, FilaVetor B) {
        int novaCapacidade = A.tamanho() + B.tamanho();
        FilaVetor C = new FilaVetor(novaCapacidade);

        //aqui tambem cria copia 
        FilaVetor copiaA = copiarFila(A);
        FilaVetor copiaB = copiarFila(B);

        // ORDENADAS
        while (!copiaA.vazia() && !copiaB.vazia()) {
            if (copiaA.primeiro() <= copiaB.primeiro()) {
                C.insere(copiaA.remove());
            } else {
                C.insere(copiaB.remove());
            }
        }

        // Adiciona elementos restantes de A (se houver)
        while (!copiaA.vazia()) {
            C.insere(copiaA.remove());
        }

        // Adiciona elementos restantes de B (se houver)
        while (!copiaB.vazia()) {
            C.insere(copiaB.remove());
        }

        return C;
    }

    private static FilaVetor copiarFila(FilaVetor original) {
        int tamanhoOriginal = original.tamanho();
        FilaVetor copia = new FilaVetor(tamanhoOriginal);
        FilaVetor temp = new FilaVetor(tamanhoOriginal);

        
        while (!original.vazia()) {
            int valor = original.remove();
            temp.insere(valor);
        }

        
        while (!temp.vazia()) {
            int valor = temp.remove();
            original.insere(valor);
            copia.insere(valor);
        }

        return copia;
    }
}