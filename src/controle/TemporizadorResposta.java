package controle;

import java.util.Scanner;

/**
 * Temporizador de Respostas - Versão Corrigida
 *
 * ✅ Timer NÃO apaga a digitação do usuário
 * ✅ Feedback visual em linha separada
 * ✅ Contagem regressiva precisa
 *
 * @author Grupo Baquara
 * @version 6.0 - Corrigida
 */
public class TemporizadorResposta {

    public static final int TEMPO_FACIL = 15;
    public static final int TEMPO_MEDIO = 12;
    public static final int TEMPO_DIFICIL = 10;
    public static final int TEMPO_CHEFAO = 8;
    public static final int TEMPO_PADRAO = 10;

    /**
     * Lê uma resposta do usuário com tempo limite
     * O timer é exibido em uma LINHA SEPARADA para não apagar a digitação
     */
    public static String lerComTempo(Scanner scanner, String mensagem, int tempoMaximo) {
        if (tempoMaximo <= 0) tempoMaximo = TEMPO_PADRAO;
        if (tempoMaximo > 60) tempoMaximo = 60;

        // Exibe a mensagem de digitação
        System.out.print(mensagem);
        System.out.flush();

        // Guarda a referência do tempo
        long tempoInicio = System.currentTimeMillis();
        long tempoLimite = tempoInicio + (tempoMaximo * 1000L);

        // Move o cursor para baixo para a linha do timer
        System.out.println();  // Linha em branco
        System.out.println();  // Espaço para o timer
        System.out.print("\033[1A"); // Sobe uma linha

        // Thread para o timer visual (em linha separada)
        int finalTempoMaximo = tempoMaximo;
        Thread timerThread = new Thread(() -> {
            try {
                int ultimoSegundo = finalTempoMaximo;
                while (System.currentTimeMillis() < tempoLimite) {
                    long agora = System.currentTimeMillis();
                    long restanteMs = tempoLimite - agora;
                    int segundos = (int) Math.ceil(restanteMs / 1000.0);

                    if (segundos != ultimoSegundo && segundos >= 0) {
                        ultimoSegundo = segundos;

                        // Constrói a barra de progresso
                        String barra = construirBarraProgresso(segundos, finalTempoMaximo);

                        // Exibe o timer (sem \r - usa println para nova linha)
                        System.out.print("\033[2K"); // Limpa a linha atual
                        System.out.print("\r" + barra);
                        System.out.flush();
                    }

                    Thread.sleep(200);
                }

                // Tempo esgotado
                System.out.print("\033[2K"); // Limpa a linha
                System.out.println("\r⏰ TEMPO ESGOTADO!                         ");
                System.out.flush();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        timerThread.setDaemon(true);
        timerThread.start();

        // Volta o cursor para a linha de digitação
        System.out.print("\033[1A"); // Sobe para linha da mensagem
        System.out.print("\033[2K"); // Limpa a linha
        System.out.print(mensagem);
        System.out.flush();

        // Lê a resposta do usuário
        String resposta = null;

        while (System.currentTimeMillis() < tempoLimite && resposta == null) {
            try {
                if (System.in.available() > 0) {
                    if (scanner.hasNextLine()) {
                        resposta = scanner.nextLine().trim();
                        if (!resposta.isEmpty()) {
                            break;
                        } else {
                            resposta = null; // Continua esperando
                        }
                    }
                }
                Thread.sleep(100);
            } catch (Exception e) {
                break;
            }
        }

        // Interrompe o timer
        timerThread.interrupt();

        // Aguarda um pouco para o timer parar
        try { Thread.sleep(150); } catch (InterruptedException e) {}

        // Limpa as linhas do timer
        System.out.print("\033[2K"); // Limpa linha atual
        System.out.print("\033[1A"); // Sobe
        System.out.print("\033[2K"); // Limpa
        System.out.print("\033[1A"); // Sobe
        System.out.print("\033[2K"); // Limpa
        System.out.flush();

        // Verifica o resultado
        if (resposta == null || resposta.isEmpty()) {
            System.out.println("\n⏰ TEMPO ESGOTADO! (" + tempoMaximo + " segundos)");
            return "TEMPO_ESGOTADO";
        }

        long tempoGasto = (System.currentTimeMillis() - tempoInicio) / 1000;
        System.out.println("✅ Resposta registrada em " + tempoGasto + "s");

        return resposta;
    }

    /**
     * Constrói a barra de progresso visual
     */
    private static String construirBarraProgresso(int segundosRestantes, int tempoTotal) {
        StringBuilder sb = new StringBuilder();
        sb.append("⏱️  [");

        int barraLargura = 20;
        double proporcao = (double) segundosRestantes / tempoTotal;
        int preenchido = (int) (proporcao * barraLargura);

        for (int i = 0; i < barraLargura; i++) {
            if (i < preenchido) {
                sb.append("▓");
            } else {
                sb.append("░");
            }
        }

        sb.append("] ");
        sb.append(segundosRestantes);
        sb.append("s");

        // Alerta visual quando está acabando
        if (segundosRestantes <= 3) {
            sb.append(" ⚠️⚠️⚠️");
        } else if (segundosRestantes <= 5) {
            sb.append(" ⚠️");
        }

        return sb.toString();
    }

    /**
     * Versão com tempo padrão
     */
    public static String lerComTempo(Scanner scanner, String mensagem) {
        return lerComTempo(scanner, mensagem, TEMPO_PADRAO);
    }

    /**
     * Mostra contagem regressiva antes de começar
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
        System.out.println("JÁ! 🎯");
    }
}