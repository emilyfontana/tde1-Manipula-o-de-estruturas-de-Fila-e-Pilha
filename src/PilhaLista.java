package src;
public class PilhaLista {
    private NodePilha topo;
    private int tamanho;

    private static class NodePilha {
        int info;
        NodePilha next;

        NodePilha(int info) {
            this.info = info;
            this.next = null;
        }
    }

    public PilhaLista() {
        topo = null;
        tamanho = 0;
    }

    public void insere(int valor) {
        NodePilha novo = new NodePilha(valor);
        novo.next = topo;
        topo = novo;
        tamanho++;
    }

    public int remove() {
        if (vazia()) {
            throw new IllegalStateException("Pilha vazia!");
        }
        int valor = topo.info;
        topo = topo.next;
        tamanho--;
        return valor;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Pilha vazia!");
            return;
        }
        System.out.print("Topo -> ");
        NodePilha atual = topo;
        while (atual != null) {
            System.out.print(atual.info + " ");
            atual = atual.next;
        }
        System.out.println("<- Base");
    }

    public boolean vazia() {
        return topo == null;
    }

    public int tamanho() {
        return tamanho;
    }
}

