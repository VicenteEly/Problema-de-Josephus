
import java.util.Scanner;

public class ProblemadeJosephus {

    // LLR03: Estrutura do no da lista encadeada circular
    static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
    
    
    static No criarLista(int n) {
        No cabeca = new No(1);
        No atual = cabeca;
        for (int i = 2; i <= n; i++) {
            atual.proximo = new No(i);
            atual = atual.proximo;
        }
        atual.proximo = cabeca;
        return cabeca;
    }

    // HLR02/HLR03: Valida entradas e executa o algoritmo de Josephus via lista circular
    static int validacaoJosephus(int N, int K) {

        // LLR01: Rejeita N < 1
        if (N < 1) {
            System.out.println("Erro: N invalido");
            return -1;
        }
        // LLR02: Rejeita K < 1
        if (K < 1) {
            System.out.println("Erro: K invalido");
            return -1;
        }

        No atual = criarLista(N);

        // LLR07: Repete eliminacao ate restar exatamente um no
        while (atual.proximo != atual) {
            // LLR04: Avanca K-1 nos para identificar o proximo a ser eliminado
            No anterior = atual;
            for (int i = 0; i < K - 2; i++) {
                anterior = anterior.proximo;
            }
            // LLR05: Remove o no e ajusta ponteiros preservando a circularidade
            No eliminado = anterior.proximo;
            anterior.proximo = eliminado.proximo;
            // LLR09: Libera referencia do no eliminado para o coletor de lixo
            eliminado.proximo = null;
            // LLR06: Define no corrente como o imediatamente seguinte ao removido
            atual = anterior.proximo;
        }
        // LLR08: Retorna o identificador do no sobrevivente (base 1)
        return atual.valor;
    }

    // HLR01/HLR05: Le N e K repetidamente; encerra quando N = 0
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        while (true) {
            System.out.println("Informe N (número de participantes):");
            int N = ler.nextInt();
            if (N == 0) break;
            System.out.println("Informe K (passo de eliminação)    :");
            int K = ler.nextInt();

            int resultado = validacaoJosephus(N, K);
            // HLR04: Apresenta a posicao do sobrevivente (base 1)
            if (resultado != -1) {
                System.out.println("Sobrevivente: " + resultado);
            }
        }
        // LLR09: Libera recurso de leitura
        ler.close();
    }
}