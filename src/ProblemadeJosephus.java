

import java.util.Scanner;
  public class ProblemadeJosephus {

      //Metodo que recebe N (participantes) e K (passo de eliminação) e retorna um inteiro — a posição do sobrevivente.


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
              //Quando você escreve new No(1), está criando um objeto da classe No e passando o valor 1 para o construtor.
              No atual = cabeca;
              for (int i = 2; i <= n; i++) {
                  atual.proximo = new No(i);
                  atual = atual.proximo;
              }
              atual.proximo = cabeca;
              return cabeca;
          }

           static int validacaoJosephus(int N, int K) {

              //Verifica se N e K são válidos (≥ 1). Se algum for inválido, exibe erro e encerra o programa com System.exit(1).
              if (N < 1) {
                  System.out.println("Erro: N = numero ivalido");
              }
              if (K < 1) {
                  System.out.println("Erro: K = numero ivalido");
              } else {
                  System.out.println("Valido!");
              }

              No atual = criarLista(N);

              //repeticao para verificar proximo no
              while (atual.proximo != atual) {
                  No anterior = atual;
                  for (int i = 0; i < K - 1; i++) {
                      anterior = anterior.proximo;
                  }
                  No eliminado = anterior.proximo;
                  anterior.proximo = eliminado.proximo;
                  atual = anterior.proximo; //processo que atualiza o no
              }
              System.out.println("Casa eliminada: " + atual.proximo.valor);
              System.out.println("Sobrevivente: " + atual.valor);
              return atual.valor;
          }



          public static void main(String[] args) {
              Scanner ler = new Scanner(System.in);
              // cria repeticao (while)
              while (true) {
                  System.out.println("Informe N (número de participantes):");
                  int N = ler.nextInt();
                  if (N == 0) break;
                  System.out.println("Informe K (passo de eliminação)    :");
                  int K = ler.nextInt();

                  int resultado = validacaoJosephus(N, K);
                  if (resultado != -1) {
                      //Chama o metodo validar() com os valores lidos e imprime a posição do sobrevivente.
                      System.out.println("o numero da casa do Sobrevivente é: " + validacaoJosephus(N, K));
                  }
              }
              ler.close();
              //Libera o recurso de Scanner.

              //Usuário digita N e K
              //        ↓
              //Valida se N ≥ 1 e K ≥ 1
              //        ↓
              //Executa o loop iterativo
              //        ↓
              //Retorna posição do sobrevivente (base 1)
              //        ↓
              //Exibe o resultado
          }
      }

