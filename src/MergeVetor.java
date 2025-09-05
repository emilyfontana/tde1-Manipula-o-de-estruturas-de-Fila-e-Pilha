package src;
public class MergeVetor {
    public static FilaVetor merge(FilaVetor A, FilaVetor B) {
        int novaCapacidade = A.tamanho() + B.tamanho();
        FilaVetor C = new FilaVetor(novaCapacidade);

        // Cria cópias para não modificar as originais
        FilaVetor copiaA = copiarFila(A);
        FilaVetor copiaB = copiarFila(B);

        // Merge de duas filas ORDENADAS
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

        // Esvazia a original na temporária
        while (!original.vazia()) {
            int valor = original.remove();
            temp.insere(valor);
        }

        // Restaura a original e cria a cópia
        while (!temp.vazia()) {
            int valor = temp.remove();
            original.insere(valor);
            copia.insere(valor);
        }

        return copia;
    }
}