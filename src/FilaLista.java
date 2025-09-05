package src;
public class FilaLista {
    private NodeFila inicio;
    private NodeFila fim;
    private int tamanho;

    private static class NodeFila {
        int info;
        NodeFila next;

        NodeFila(int info) {
            this.info = info;
            this.next = null;
        }
    }

    public FilaLista() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void insere(int valor) {
        NodeFila novo = new NodeFila(valor);
        if (vazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.next = novo;
            fim = novo;
        }
        tamanho++;
    }

    public int remove() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia!");
        }
        int valor = inicio.info;
        inicio = inicio.next;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return valor;
    }

    public int primeiro() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia!");
        }
        return inicio.info;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.print("Início -> ");
        NodeFila atual = inicio;
        while (atual != null) {
            System.out.print(atual.info + " ");
            atual = atual.next;
        }
        System.out.println("<- Fim");
    }

    public boolean vazia() {
        return inicio == null;
    }

    public int tamanho() {
        return tamanho;
    }
}
