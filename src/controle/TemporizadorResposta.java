package controle;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class TemporizadorResposta {
    private static final int TEMPO_MAXIMO = 10; // 10 segundos

    /**
     * Lê uma resposta do usuário com temporizador visível
     * @param scanner O scanner para leitura
     * @param mensagem A mensagem para exibir
     * @return A resposta do usuário, ou "TEMPO_ESGOTADO" se o tempo acabar
     */
    public static String lerComTempo(Scanner scanner, String mensagem) {
        System.out.print(mensagem);

        // Thread para capturar a resposta
        AtomicReference<String> resposta = new AtomicReference<>(null);
        AtomicBoolean respondido = new AtomicBoolean(false);

        // Thread para mostrar o timer
        Thread threadTimer = new Thread(() -> {
            try {
                for (int i = TEMPO_MAXIMO; i > 0; i--) {
                    if (respondido.get()) {
                        break; // Sai se já responderam
                    }

                    // Move o cursor para posição fixa e mostra o timer
                    String timerMsg;
                    if (i <= 3) {
                        timerMsg = String.format("\r⏱️  ⚠️  %d segundos restantes! ⚠️  ", i);
                    } else if (i <= 5) {
                        timerMsg = String.format("\r⏱️  ⏳ %d segundos restantes... ", i);
                    } else {
                        timerMsg = String.format("\r⏱️  🕐 %d segundos restantes    ", i);
                    }

                    System.out.print(timerMsg);
                    System.out.flush();

                    Thread.sleep(1000);
                }

                if (!respondido.get()) {
                    System.out.print("\r⏱️  ⏰ TEMPO ESGOTADO!                    \n");
                    System.out.flush();
                }
            } catch (InterruptedException e) {
                // Timer foi interrompido porque o usuário respondeu
            }
        });

        // Thread para capturar input
        Thread threadInput = new Thread(() -> {
            try {
                String input = scanner.nextLine().trim();
                resposta.set(input);
                respondido.set(true);
                threadTimer.interrupt(); // Para o timer
            } catch (Exception e) {
                resposta.set("TEMPO_ESGOTADO");
                respondido.set(true);
            }
        });

        // Inicia ambas as threads
        threadTimer.setDaemon(true);
        threadTimer.start();
        threadInput.start();

        // Espera o input ou timeout
        try {
            threadInput.join(TEMPO_MAXIMO * 1000); // Espera no máximo 10 segundos

            if (!respondido.get()) {
                // Timeout - usuário não respondeu
                respondido.set(true);
                threadTimer.interrupt();
                threadInput.interrupt();

                System.out.println("\n⏰ TEMPO ESGOTADO! O inimigo vai atacar!");
                return "TEMPO_ESGOTADO";
            }

            // Pequena pausa para limpar o console
            Thread.sleep(200);

            // Limpa a linha do timer
            System.out.print("\r" + " ".repeat(50) + "\r");

            return resposta.get() != null ? resposta.get() : "TEMPO_ESGOTADO";

        } catch (InterruptedException e) {
            return "TEMPO_ESGOTADO";
        }
    }

    /**
     * Mostra uma animação de contagem regressiva (apenas visual)
     */
    public static void mostrarContagemRegressiva() {
        System.out.print("\n⏱️  Preparando... ");
        for (int i = 3; i > 0; i--) {
            try {
                System.out.print(i + "... ");
                System.out.flush();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("JÁ!");
    }
}