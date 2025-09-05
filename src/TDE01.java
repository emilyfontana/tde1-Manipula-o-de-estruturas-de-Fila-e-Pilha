package src;
import java.util.Scanner;

public class TDE01 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== TDE 01 - ESTRUTURAS DE DADOS ===");
            System.out.println("1. Testar Pilha (Lista Encadeada)");
            System.out.println("2. Testar Fila (Lista Encadeada)");
            System.out.println("3. Testar Merge (Lista Encadeada)");
            System.out.println("4. Testar Merge (Vetor)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = lerNumero();
            
            switch (opcao) {
                case 1: testarPilha(); break;
                case 2: testarFila(); break;
                case 3: testarMergeLista(); break;
                case 4: testarMergeVetor(); break;
                case 0: 
                    System.out.println("Encerrando o programa...");
                    return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    public static void testarPilha() {
        System.out.println("\n=== TESTE DA PILHA (LIFO) ==="); //remove do topo
        PilhaLista pilha = new PilhaLista();
        
        System.out.print("Quantos elementos deseja inserir? ");
        int qtd = lerNumero();
        
        for (int i = 0; i < qtd; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int valor = lerNumero();
            pilha.insere(valor);
        }

        System.out.println("\nPilha após inserção:");
        pilha.imprime();

        System.out.print("\nQuantos elementos deseja remover? ");
        int remover = lerNumero();
        
        for (int i = 0; i < remover; i++) {
            if (pilha.vazia()) {
                System.out.println("Pilha vazia!");
                break;
            }
            System.out.println("Removido: " + pilha.remove());
        }

        System.out.println("Pilha após remoção:");
        pilha.imprime();
    }

    public static void testarFila() {
        System.out.println("\n=== TESTE DA FILA (FIFO) ===");
        FilaLista fila = new FilaLista();
        
        System.out.print("Quantos elementos deseja inserir? ");
        int qtd = lerNumero();
        
        for (int i = 0; i < qtd; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int valor = lerNumero();
            fila.insere(valor);
        }

        System.out.println("\nFila após inserção:");
        fila.imprime();

        System.out.print("\nQuantos elementos deseja remover? ");
        int remover = lerNumero();
        
        for (int i = 0; i < remover; i++) {
            if (fila.vazia()) {
                System.out.println("Fila vazia!");
                break;
            }
            System.out.println("Removido: " + fila.remove());
        }

        System.out.println("Fila após remoção:");
        fila.imprime();
    }

    public static void testarMergeLista() {
        System.out.println("\n=== MERGE COM LISTA ENCADEADA(ordenadas) ===");

        FilaLista A = new FilaLista();
        FilaLista B = new FilaLista();

        System.out.println("\nFila A (ordem crescente):");
        inserirOrdenado(A);
        System.out.println("\nFila B (ordem crescente):");
        inserirOrdenado(B);

        FilaLista C = MergeLista.merge(A, B);

        System.out.println("\nFila A:"); A.imprime();
        System.out.println("Fila B:"); B.imprime();
        System.out.println("Fila C (merge):"); C.imprime();
    }

    public static void testarMergeVetor() {
        System.out.println("\n=== MERGE COM VETOR (ordenadas)===");

        FilaVetor A = new FilaVetor(20);
        FilaVetor B = new FilaVetor(20);

        System.out.println("\nFila A (ordem crescente):");
        inserirOrdenadoVetor(A);
        System.out.println("\nFila B (ordem crescente):");
        inserirOrdenadoVetor(B);

        FilaVetor C = MergeVetor.merge(A, B);

        System.out.println("\nFila A:"); A.imprime();
        System.out.println("Fila B:"); B.imprime();
        System.out.println("Fila C (merge):"); C.imprime();
    }

    private static void inserirOrdenado(FilaLista fila) {
        System.out.print("Quantos elementos? ");
        int qtd = lerNumero();
        int anterior = Integer.MIN_VALUE;

        for (int i = 0; i < qtd; i++) {
            System.out.print("Elemento " + (i + 1) + " : ");
            int valor = lerNumero();
            
            if (valor < anterior) {
                System.out.println("Os valores deve ser em ordem crescente! Tente novamente");
                i--;
                continue;
            }
            
            fila.insere(valor);
            anterior = valor;
        }
    }

    private static void inserirOrdenadoVetor(FilaVetor fila) {
        System.out.print("Quantos elementos? ");
        int qtd = lerNumero();
        int anterior = Integer.MIN_VALUE;

        for (int i = 0; i < qtd; i++) {
            System.out.print("Elemento " + (i + 1) + " : ");
            int valor = lerNumero();
            
            if (valor < anterior) {
                System.out.println("os números devem ser em ordem crescente! Tente novamente");
                i--; //verifica se esta em ordem crescente 
                continue;
            }
            
            fila.insere(valor);
            anterior = valor;
        }
    }

    private static int lerNumero() {
        while (true) {
            
            return Integer.parseInt(scanner.nextLine().trim()); //le corretamente os valores
            
        }
    }
}