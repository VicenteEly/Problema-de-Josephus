import java.util.Scanner;


  public class ProblemadeJosephus {

      //Metodo que recebe N (participantes) e K (passo de eliminação) e retorna um inteiro — a posição do sobrevivente.
        public static int validacao(int N, int K) {
            int sobrevivente = 0;


            //Verifica se N e K são válidos (≥ 1). Se algum for inválido, exibe erro e encerra o programa com System.exit(1).
            if (N >= 1 && K >= 1) {

                System.out.println("valido, só numeros naturais");

            } else {
                System.out.println("ERRO");
                System.out.println("N ou K invalido");
                System.exit(1);
            }
            for (int i = 2; i <= N; i++) {
                sobrevivente = (sobrevivente + K) % i;
            }
            //Converte o resultado de base 0 para base 1 (posições começam em 1, não em 0).
            return sobrevivente + 1;
        }

        public static void main(String[] args) {
            Scanner ler = new Scanner(System.in);
            System.out.println("Informe N (número de participantes):");
            int N = ler.nextInt();
            System.out.println("Informe K (passo de eliminação)    :");
            int K = ler.nextInt();

            //Chama o metodo validar() com os valores lidos e imprime a posição do sobrevivente.
            System.out.println("o numero da casa do Sobrevivente é: " + validacao(N, K));

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
