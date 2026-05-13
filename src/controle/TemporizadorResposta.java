package controle;

import java.util.Scanner;


public class TemporizadorResposta {

    public static final int TEMPO_FACIL = 15;
    public static final int TEMPO_MEDIO = 12;
    public static final int TEMPO_DIFICIL = 10;
    public static final int TEMPO_CHEFAO = 8;
    public static final int TEMPO_PADRAO = 10;


    public static String lerComTempo(Scanner scanner, String mensagem, int tempoMaximo) {
        // ===== VALIDAÇÃO DO TEMPO =====
        if (tempoMaximo <= 0) {
            System.err.println("⚠️  AVISO: tempoMaximo inválido (" + tempoMaximo + "). Usando padrão: " + TEMPO_PADRAO + "s");
            tempoMaximo = TEMPO_PADRAO;
        }

        if (tempoMaximo > 60) {
            System.err.println("⚠️  AVISO: tempoMaximo muito alto (" + tempoMaximo + "). Limitando a 60s");
            tempoMaximo = 60;
        }

        // ===== EXIBIÇÃO INICIAL =====
        System.out.print(mensagem);
        System.out.flush();

        // ===== CONFIGURAÇÃO DO TEMPORIZADOR =====
        long tempoInicio = System.currentTimeMillis();
        long tempoLimiteMs = tempoMaximo * 1000L; // Converte para milissegundos
        long tempoLimite = tempoInicio + tempoLimiteMs;

        String resposta = null;
        int ultimoSegundoExibido = tempoMaximo;

        // ===== LOOP PRINCIPAL =====
        while (System.currentTimeMillis() < tempoLimite) {
            try {
                long agora = System.currentTimeMillis();
                long tempoRestanteMs = tempoLimite - agora;
                int segundosRestantes = (int) Math.ceil(tempoRestanteMs / 1000.0);

                // Exibe o timer apenas quando o segundo muda
                if (segundosRestantes != ultimoSegundoExibido && segundosRestantes >= 0) {
                    ultimoSegundoExibido = segundosRestantes;
                    exibirTimer(segundosRestantes, tempoMaximo);
                }

                // Tenta ler do Scanner sem bloquear
                if (System.in.available() > 0) {
                    if (scanner.hasNextLine()) {
                        resposta = scanner.nextLine().trim();

                        // Só aceita se não estiver vazia
                        if (!resposta.isEmpty()) {
                            break;
                        }
                    }
                }

                // Pequena pausa para não consumir 100% da CPU
                Thread.sleep(100);

            } catch (InterruptedException e) {
                // Interrompido, sai do loop
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                // Erro inesperado na leitura
                System.err.println("Erro na leitura: " + e.getMessage());
                break;
            }
        }

        // ===== LIMPEZA DO CONSOLE =====
        limparLinhaTimer();

        // ===== VERIFICAÇÃO DO RESULTADO =====
        if (resposta == null || resposta.isEmpty()) {
            System.out.println("\n⏰ TEMPO ESGOTADO! (" + tempoMaximo + " segundos)");
            return "TEMPO_ESGOTADO";
        }

        long tempoGasto = (System.currentTimeMillis() - tempoInicio) / 1000;
        System.out.println("✓ Resposta recebida em " + tempoGasto + " segundos");

        return resposta;
    }


    private static void exibirTimer(int segundosRestantes, int tempoTotal) {
        // Não mostra timer se já passou do tempo
        if (segundosRestantes < 0) return;

        StringBuilder sb = new StringBuilder();
        sb.append("\r⏱️  ");

        // Ícone baseado na urgência
        if (segundosRestantes <= 3) {
            sb.append("🔴⚠️  ");
        } else if (segundosRestantes <= 5) {
            sb.append("🟡⏳ ");
        } else {
            sb.append("🟢🕐 ");
        }

        // Barra de progresso
        int barraLargura = 20;
        double proporcao = (double) segundosRestantes / tempoTotal;
        int preenchido = (int) (proporcao * barraLargura);

        sb.append("[");
        for (int i = 0; i < barraLargura; i++) {
            sb.append(i < preenchido ? "█" : "░");
        }
        sb.append("] ");

        // Tempo restante
        sb.append(segundosRestantes).append("s restantes");

        System.out.print(sb.toString());
        System.out.flush();
    }


    private static void limparLinhaTimer() {
        System.out.print("\r" + " ".repeat(60) + "\r");
        System.out.flush();
    }


    public static String lerComTempo(Scanner scanner, String mensagem) {
        return lerComTempo(scanner, mensagem, TEMPO_PADRAO);
    }


    public static void mostrarContagemRegressiva() {
        System.out.print("\n⏱️  Preparando... ");
        for (int i = 3; i > 0; i--) {
            try {
                System.out.print(i + "... ");
                System.out.flush();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("JÁ! 🎯");
    }


    public static int getTempoPorDificuldade(String dificuldade) {
        switch (dificuldade.toUpperCase()) {
            case "FACIL":   return TEMPO_FACIL;
            case "MEDIO":   return TEMPO_MEDIO;
            case "DIFICIL": return TEMPO_DIFICIL;
            case "CHEFAO":  return TEMPO_CHEFAO;
            default:        return TEMPO_PADRAO;
        }
    }
}