package src;
public class FilaVetor {
    private int[] vetor;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public FilaVetor(int capacidade) {
        this.capacidade = capacidade;
        vetor = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public void insere(int valor) {
        if (tamanho == capacidade) {
            throw new IllegalStateException("Fila cheia!");
        }
        fim = (fim + 1) % capacidade;
        vetor[fim] = valor;
        tamanho++;
    }

    public int remove() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia!");
        }
        int valor = vetor[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return valor;
    }

    public int primeiro() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia!");
        }
        return vetor[inicio];
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % capacidade;
            System.out.print(vetor[index] + " ");
        }
        System.out.println();
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }
}

