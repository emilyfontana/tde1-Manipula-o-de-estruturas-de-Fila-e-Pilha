package src;
public class MergeLista {
    public static FilaLista merge(FilaLista A, FilaLista B) {
        FilaLista C = new FilaLista();
        
        // Cria cópias para não modificar as originais
        FilaLista copiaA = copiarFila(A);
        FilaLista copiaB = copiarFila(B);

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

    private static FilaLista copiarFila(FilaLista original) {
        FilaLista copia = new FilaLista();
        FilaLista temp = new FilaLista();

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