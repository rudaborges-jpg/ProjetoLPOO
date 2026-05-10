import modelo.*;
import dados.BancoPerguntas;
import controle.GerenciadorBatalha;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n🎮 CODEARENA: BATALHA DO CONHECIMENTO 🎮");
        System.out.println("=".repeat(60));

        System.out.print("\nDigite seu nome: ");
        String nomeJogador = scanner.nextLine();
        Jogador jogador = new Jogador(nomeJogador);

        System.out.println("\n📋 ESCOLHA SEU PERSONAGEM (CADA UM TEM SUA PRÓPRIA ROTA DE 10 ESTÁGIOS):");
        System.out.println("=".repeat(50));
        System.out.println("1 🛡️ PALADINO - Rota: Caminho da Fé (perguntas de religião)");
        System.out.println("2 🌿 CAÇADORA - Rota: Caminho da Natureza (perguntas de animais/natureza)");
        System.out.println("3 ⚔️ GUERREIRO - Rota: Caminho da Glória (perguntas de combate)");
        System.out.println("4 📚 SÁBIO - Rota: Caminho do Conhecimento (perguntas de ciência/arte)");
        System.out.println("5 🔮 ARCANISTA - Rota: Caminho Arcano (perguntas de magia/mitologia)");
        System.out.println("=".repeat(50));

        System.out.print("\nSua escolha (1-5): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        Personagem personagem = null;
        switch (escolha) {
            case 1:
                personagem = new Paladino();
                break;
            case 2:
                personagem = new Cacadora();
                break;
            case 3:
                personagem = new Guerreiro();
                break;
            case 4:
                personagem = new Sabio();
                break;
            case 5:
                personagem = new Arcanista();
                break;
            default:
                System.out.println("Opção inválida! Escolhendo Guerreiro.");
                personagem = new Guerreiro();
        }

        jogador.escolherPersonagem(personagem);
        System.out.println("\n📖 Tema: " + personagem.getTipo().getTema());
        personagem.mostrarStatus();

        BancoPerguntas banco = new BancoPerguntas();
        GerenciadorBatalha batalha = new GerenciadorBatalha(jogador, banco);

        // Iniciar a rota específica do personagem escolhido
        batalha.iniciarRota();

        scanner.close();
    }
}