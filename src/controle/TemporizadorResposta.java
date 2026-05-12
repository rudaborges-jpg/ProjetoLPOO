package controle;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TemporizadorResposta {
    private static final int TEMPO_MAXIMO = 10; // 10 segundos
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    /**
     * Lê uma resposta do usuário com tempo limite de 10 segundos
     * @param scanner O scanner para leitura
     * @param mensagem A mensagem para exibir
     * @return A resposta do usuário, ou "TEMPO_ESGOTADO" se o tempo acabar
     */
    public static String lerComTempo(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        System.out.println(" ⏱️ (10 segundos)");

        // Inicia contagem regressiva em thread separada
        Future<String> future = executor.submit(() -> {
            return scanner.nextLine().trim();
        });

        try {
            String resposta = future.get(TEMPO_MAXIMO, TimeUnit.SECONDS);
            return resposta;
        } catch (TimeoutException e) {
            System.out.println("\n⏰ TEMPO ESGOTADO! O inimigo vai atacar!");
            future.cancel(true);
            return "TEMPO_ESGOTADO";
        } catch (Exception e) {
            return "TEMPO_ESGOTADO";
        }
    }

    /**
     * Lê a escolha de ação (1-4) com tempo limite
     * @return O número escolhido, ou -1 se o tempo acabou
     */
    public static int lerEscolhaComTempo(Scanner scanner) {
        Future<String> future = executor.submit(() -> {
            return scanner.nextLine().trim();
        });

        try {
            String entrada = future.get(TEMPO_MAXIMO, TimeUnit.SECONDS);

            try {
                int escolha = Integer.parseInt(entrada);
                if (escolha >= 1 && escolha <= 4) {
                    return escolha;
                }
                return -1; // Número inválido
            } catch (NumberFormatException e) {
                return -2; // Não é número
            }
        } catch (TimeoutException e) {
            System.out.println("\n⏰ TEMPO ESGOTADO!");
            future.cancel(true);
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Mostra contagem regressiva em segundo plano
     */
    public static void iniciarContagemRegressiva() {
        System.out.print("⏱️ ");
        for (int i = TEMPO_MAXIMO; i > 0; i--) {
            if (i <= 3) {
                System.out.print("⚠️ ");
            }
        }
    }
}