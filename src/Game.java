import modelo.*;
import dados.BancoPerguntas;
import controle.GerenciadorBatalha;
import controle.GerenciadorRodaCapoeira;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n🎮 BAQUARA : BATALHA DO SABER 🎮");
        System.out.println("=".repeat(60));

        System.out.print("\nDigite seu nome: ");
        String nomeJogador = scanner.nextLine().trim();
        if (nomeJogador.isEmpty()) nomeJogador = "Herói";

        Jogador jogador = new Jogador(nomeJogador);

        System.out.println("\n📋 ESCOLHA SEU PERSONAGEM:");
        System.out.println("=".repeat(50));
        System.out.println("1 🛡️ PALADINO - Rota: Caminho da Iluminação");
        System.out.println("2 🌿 CAÇADORA - Rota: Caminho da Predadora");
        System.out.println("3 ⚔️ GUERREIRO - Rota: Caminho da Glória");
        System.out.println("4 📚 SÁBIO - Rota: Caminho do Conhecimento");
        System.out.println("5 🔮 ARCANISTA - Rota: Caminho Místico");
        System.out.println("=".repeat(50));

        // ✅ Lê a escolha - QUALQUER COISA diferente de 1-5 ativa a rota secreta
        int escolha = lerEscolhaPersonagem(scanner);

        if (escolha == -1) {
            // 🔥 ROTA SECRETA DE CAPOEIRA ATIVADA!
            ativarRodaDeCapoeira(jogador, scanner);
        } else {
            // Rota normal
            Personagem personagem = criarPersonagemNormal(escolha);
            jogador.escolherPersonagem(personagem);
            System.out.println("\n📖 Tema: " + personagem.getTipo().getTema());
            personagem.mostrarStatus();

            System.out.print("\n🎯 Pressione ENTER para iniciar sua jornada...");
            scanner.nextLine();

            BancoPerguntas banco = new BancoPerguntas();
            GerenciadorBatalha batalha = new GerenciadorBatalha(jogador, banco);
            batalha.iniciarRota();
        }

        scanner.close();
    }

    /**
     * Lê a escolha do personagem
     * @return número de 1-5, ou -1 se ativou a rota secreta
     */
    private static int lerEscolhaPersonagem(Scanner scanner) {
        System.out.print("\n👉 Sua escolha (1-5): ");
        String entrada = scanner.nextLine().trim();

        // ✅ Tenta converter para número
        try {
            int escolha = Integer.parseInt(entrada);

            if (escolha >= 1 && escolha <= 5) {
                return escolha; // Escolha normal
            } else {
                // Qualquer número fora de 1-5 ativa a rota secreta
                return -1;
            }
        } catch (NumberFormatException e) {
            // Qualquer texto/letra ativa a rota secreta
            return -1;
        }
    }

    /**
     * Cria personagens normais
     */
    private static Personagem criarPersonagemNormal(int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("\n🛡️ Você escolheu: PALADINO");
                return new Paladino();
            case 2:
                System.out.println("\n🌿 Você escolheu: CAÇADORA");
                return new Cacadora();
            case 3:
                System.out.println("\n⚔️ Você escolheu: GUERREIRO");
                return new Guerreiro();
            case 4:
                System.out.println("\n📚 Você escolheu: SÁBIO");
                return new Sabio();
            case 5:
                System.out.println("\n🔮 Você escolheu: ARCANISTA");
                return new Arcanista();
            default:
                return new Arcanista();
        }
    }

    /**
     * 🔥 ATIVA A RODA PROIBIDA DE CAPOEIRA!
     */
    private static void ativarRodaDeCapoeira(Jogador jogador, Scanner scanner) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🥋 VOCÊ ENTROU NA RODA PROIBIDA! 🥋");
        System.out.println("=".repeat(60));

        // Animação de ativação
        String[] mensagens = {
                "🌑 O berimbau ecoa na escuridão...",
                "🥁 O atabaque começa a pulsar...",
                "👥 Espíritos ancestrais se aproximam...",
                "💫 A energia da capoeira ancestral desperta...",
                "🥋 A RODA PROIBIDA COMEÇA! 🥋"
        };

        for (String msg : mensagens) {
            System.out.println(msg);
            try {
                Thread.sleep(800); // Pausa dramática
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n🔥 VOCÊ FOI ESCOLHIDO PELO BERIMBAU SAGRADO! 🔥");
        System.out.println("   Derrote 9 mestres lendários");
        System.out.println("   Enfrente o lendário BESOURO MANGANGÁ");
        System.out.println("   Use seu conhecimento para ganhar força!");
        System.out.println("   ⏱️ Você tem apenas 10 segundos para responder!\n");

        System.out.print("Pressione ENTER para entrar na roda...");
        scanner.nextLine();

        Capoeirista capoeirista = new Capoeirista();
        jogador.escolherPersonagem(capoeirista);

        System.out.println("\n🥋 SEU PERSONAGEM:");
        capoeirista.mostrarStatus();

        System.out.print("\n🎵 Pressione ENTER para começar o jogo...");
        scanner.nextLine();

        GerenciadorRodaCapoeira rodaCapoeira = new GerenciadorRodaCapoeira(jogador);
        rodaCapoeira.iniciarRodaProibida();
    }
}