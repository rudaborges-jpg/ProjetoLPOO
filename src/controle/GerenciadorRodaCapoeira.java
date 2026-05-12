package controle;

import modelo.*;
import dados.BancoPerguntasCapoeira;
import modelo.Pergunta.Dificuldade;
import java.util.*;

public class GerenciadorRodaCapoeira {
    private Jogador jogador;
    private Inimigo[] inimigos;
    private BesouroManganga besouro;
    private int estagioAtual;
    private int pontuacaoTotal;
    private Scanner scanner;
    private Random random;
    private BancoPerguntasCapoeira bancoCapoeira;

    private int perguntasCertas;
    private int perguntasErradas;
    private int vitorias;

    // Dados dos mestres para cada estágio
    private String[] nomesMestres = {
            "MESTRE BIMBA",
            "MESTRE PASTINHA",
            "MESTRE JOÃO GRANDE",
            "MESTRE JOÃO PEQUENO",
            "MESTRE CANJIQUINHA",
            "MESTRE CAIÇARA",
            "MESTRE SUASSUNA",
            "MESTRE NENEL",
            "MESTRE MORAES"
    };

    private String[] titulosMestres = {
            "O Pai da Capoeira Regional",
            "O Guardião da Capoeira Angola",
            "O Discípulo de Pastinha",
            "O Filósofo da Capoeira",
            "O Gênio da Malícia",
            "O Guardião da Tradição Oral",
            "O Inovador da Capoeira",
            "O Herdeiro de Bimba",
            "O Filósofo da Capoeira Angola"
    };

    private String[] historiasMestres = {
            "Manoel dos Reis Machado (1900-1974). Criou a Capoeira Regional em 1928.\n" +
                    "Primeiro a tirar a capoeira da marginalidade e transformá-la em arte marcial\n" +
                    "respeitada. Criou a 'sequência de Bimba' com 8 movimentos básicos.",

            "Vicente Ferreira Pastinha (1889-1981). Grande defensor da Capoeira Angola,\n" +
                    "a forma mais tradicional. Ensinou que capoeira é dança, luta, filosofia e\n" +
                    "resistência cultural. 'Capoeira é tudo que a boca come.'",

            "João Oliveira dos Santos (1933-2022). Discípulo de Mestre Pastinha, levou a\n" +
                    "Capoeira Angola para o mundo. Ensinou nos EUA e formou gerações de\n" +
                    "capoeiristas. Foi Doutor Honoris Causa.",

            "João Pereira dos Santos (1917-2011). Também discípulo de Pastinha, era\n" +
                    "conhecido por sua técnica impecável e movimentos precisos. 'Na capoeira,\n" +
                    "o importante não é o golpe, é a intenção.'",

            "José Anastácio dos Santos (1937-2003). Discípulo de Bimba, era mestre da\n" +
                    "malícia e da mandinga. Suas rodas eram famosas pela imprevisibilidade e\n" +
                    "criatividade. 'Malandro não briga, malandro ginga.'",

            "Antônio Carlos Moraes (1938-2008). Guardião das tradições orais da capoeira.\n" +
                    "Preservou ladainhas, corridos e histórias ancestrais. Sua memória guardava\n" +
                    "séculos de sabedoria da capoeira.",

            "Reinaldo Ramos Suassuna (1938-). Fundador do Grupo Cordão de Ouro, criou um\n" +
                    "estilo próprio que mistura tradição e inovação. Suas rodas são espetáculos\n" +
                    "de técnica e beleza.",

            "Manoel Nascimento Machado (1956-). Filho de Mestre Bimba, é o guardião do\n" +
                    "legado da Capoeira Regional. Mantém viva a sequência de ensino criada por\n" +
                    "seu pai.",

            "Pedro Moraes Trindade (1950-). Fundador do GCAP, um dos maiores pensadores\n" +
                    "da capoeira. Sua filosofia une ancestralidade africana, resistência cultural\n" +
                    "e transformação social. 'Capoeira é revolução.'"
    };

    private String[] frasesDerrota = {
            "A capoeira nunca morrerá... Ela vive em cada ginga...",
            "Capoeira é tudo que a boca come e o coração sente...",
            "A capoeira é minha vida... Minha filosofia...",
            "Na capoeira, o importante não é o golpe, é a intenção...",
            "Malandro não briga, malandro ginga...",
            "Quem não sabe ler a história, está condenado a repeti-la...",
            "Capoeira é identidade, é raiz, é resistência...",
            "A capoeira regional é a arte de meu pai... Minha herança...",
            "Capoeira é revolução... É a arte de transformar dor em dança..."
    };

    private int[] vidasMestres = {100, 130, 160, 190, 220, 250, 280, 320, 380};
    private int[] ataquesMestres = {15, 18, 22, 26, 30, 34, 38, 42, 46};

    public GerenciadorRodaCapoeira(Jogador jogador) {
        this.jogador = jogador;
        this.inimigos = new Inimigo[9];
        this.besouro = new BesouroManganga();
        this.estagioAtual = 0;
        this.pontuacaoTotal = 0;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.bancoCapoeira = new BancoPerguntasCapoeira(); // ✅ Banco específico de capoeira

        this.perguntasCertas = 0;
        this.perguntasErradas = 0;
        this.vitorias = 0;

        // Cria os inimigos baseados nos mestres
        for (int i = 0; i < 9; i++) {
            inimigos[i] = new Inimigo(
                    nomesMestres[i],
                    vidasMestres[i],
                    ataquesMestres[i],
                    i + 1
            );
        }
    }

    public void iniciarRodaProibida() {
        System.out.println("\n🥋 A RODA PROIBIDA COMEÇA! 🥋");
        System.out.println("   Derrote 9 mestres lendários e enfrente o BESOURO MANGANGÁ!");
        System.out.println("   ⏱️ Você tem 10 segundos para responder cada pergunta!");
        System.out.println("   📚 Responda certo para poder atacar!");

        System.out.print("\n🎵 Pressione ENTER para o berimbau tocar...");
        scanner.nextLine();

        // Enfrenta os 9 mestres
        for (int i = 0; i < inimigos.length; i++) {
            estagioAtual = i + 1;
            boolean venceu = enfrentarMestre(inimigos[i], i);

            if (!venceu) {
                derrotaNaRoda();
                return;
            }

            vitorias++;

            // Evolui o capoeirista após cada vitória
            Capoeirista cap = (Capoeirista) jogador.getPersonagem();
            cap.evoluirTitulo(estagioAtual + 1);

            if (i < inimigos.length - 1) {
                System.out.println("\n🎵 O berimbau chama o próximo desafiante...");
                System.out.println("   Prepare-se para o próximo mestre!");
                System.out.print("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }

        // CHEFÃO FINAL
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🦗 O BESOURO MANGANGÁ ENTRA NA RODA! 🦗");
        System.out.println("=".repeat(60));
        System.out.println("\n📜 A LENDA DO BESOURO:");
        System.out.println("Manoel Henrique Pereira (1895-1924), o lendário Besouro Mangangá.");
        System.out.println("Nascido em Santo Amaro da Purificação, Bahia.");
        System.out.println("Diziam que tinha o 'corpo fechado' - balas e facas não o feriam.");
        System.out.println("Filho de Ogum, protegido de Exu, seu nome correu o mundo.");
        System.out.println("Considerado por muitos o maior capoeirista de todos os tempos.");
        System.out.println("\n🦗 'FECHADO! NINGUÉM ME SEGURA!'\n");

        System.out.print("Pressione ENTER para o confronto final...");
        scanner.nextLine();

        boolean venceuBesouro = batalhaDeCapoeira(besouro, true);

        if (venceuBesouro) {
            vitoriaFinal();
        } else {
            derrotaFinal();
        }
    }

    private boolean enfrentarMestre(Inimigo mestre, int index) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🥋 ESTÁGIO " + (index + 1) + "/10");
        System.out.println("=".repeat(60));

        System.out.println("\n📜 HISTÓRIA DO MESTRE:");
        System.out.println(historiasMestres[index]);

        System.out.println("\n👥 DESAFIANTE: " + nomesMestres[index]);
        System.out.println("   🏅 " + titulosMestres[index]);
        System.out.println("   ❤️ Vida: " + vidasMestres[index] + " | ⚔️ Ataque: " + ataquesMestres[index]);

        System.out.print("\nPressione ENTER para começar o jogo...");
        scanner.nextLine();

        return batalhaDeCapoeira(mestre, false);
    }

    private boolean batalhaDeCapoeira(Inimigo inimigo, boolean ehChefao) {
        Capoeirista capoeirista = (Capoeirista) jogador.getPersonagem();
        int rodada = 0;

        while (jogador.vivo() && inimigo.vivo()) {
            rodada++;

            System.out.println("\n" + "=".repeat(60));
            System.out.println("🔄 RODADA " + rodada);

            if (ehChefao) {
                System.out.println("🦗 CONFRONTO FINAL CONTRA O BESOURO!");
            }
            System.out.println("=".repeat(60));

            // Status
            capoeirista.mostrarStatus();
            System.out.println();

            if (ehChefao) {
                besouro.mostrarStatus();
            } else {
                System.out.println("👥 " + inimigo.getNome());
                inimigo.mostrarStatus();
            }

            // Determina dificuldade baseada no estágio
            Dificuldade dificuldade = getDificuldadeEstagio();

            // Obtém pergunta de capoeira
            Pergunta pergunta = bancoCapoeira.getPerguntaAleatoria(dificuldade);

            if (pergunta == null) {
                System.out.println("❌ Erro ao carregar pergunta!");
                return false;
            }

            // Exibe pergunta
            System.out.println("\n📚 PERGUNTA DE CAPOEIRA:");
            pergunta.exibir();

            System.out.println("\n⏱️ VOCÊ TEM 10 SEGUNDOS PARA RESPONDER!");

            String resposta;
            if (pergunta instanceof PerguntaCompletarLacuna) {
                resposta = TemporizadorResposta.lerComTempo(scanner, "\nDigite sua resposta: ");
            } else {
                resposta = TemporizadorResposta.lerComTempo(scanner, "\nSua resposta: ");
            }

            boolean acertou = false;
            if (!resposta.equals("TEMPO_ESGOTADO")) {
                acertou = AvaliadorRespostas.avaliar(pergunta, resposta);
            }

            if (acertou) {
                perguntasCertas++;
                System.out.println("\n✅ CORRETO! Você ganha o direito de atacar!");

                // Recupera ginga
                Capoeirista cap = (Capoeirista) jogador.getPersonagem();
                System.out.println("🌀 +20 de Ginga recuperada!");

                // Menu de ataques
                int escolha = mostrarMenuAtaque();
                executarAtaque(escolha, capoeirista, inimigo);

            } else {
                perguntasErradas++;
                System.out.println("\n❌ ERRADO OU TEMPO ESGOTADO!");
                if (!resposta.equals("TEMPO_ESGOTADO")) {
                    System.out.println("Resposta correta: " + pergunta.getRespostaCorreta());
                } else {
                    System.out.println("⏰ O tempo acabou!");
                }

                // Inimigo ataca
                int danoInimigo = calcularDanoInimigo(inimigo, ehChefao);
                System.out.println("💢 " + inimigo.getNome() + " ataca causando " + danoInimigo + " de dano!");
                jogador.tomarDano(danoInimigo);
            }

            // Verifica mortes
            if (!inimigo.vivo()) {
                System.out.println("\n💀 " + inimigo.getNome() + " FOI DERROTADO!");

                if (!ehChefao) {
                    int index = estagioAtual - 1;
                    System.out.println("   Últimas palavras: \"" + frasesDerrota[index] + "\"");
                } else {
                    System.out.println("   🦗 O BESOURO CAIU! IMPOSSÍVEL!");
                }

                int bonus = estagioAtual * 35;
                pontuacaoTotal += bonus;
                System.out.println("🏆 +" + bonus + " pontos! Total: " + pontuacaoTotal);

                return true;
            }

            if (!jogador.vivo()) {
                return false;
            }

            // Pequena pausa entre rodadas
            System.out.print("\n⏭️ Pressione ENTER para próxima rodada...");
            scanner.nextLine();
        }

        return jogador.vivo();
    }

    /**
     * Determina a dificuldade das perguntas baseada no estágio
     */
    private Dificuldade getDificuldadeEstagio() {
        if (estagioAtual <= 3) {
            return Dificuldade.FACIL;
        } else if (estagioAtual <= 7) {
            return Dificuldade.MEDIO;
        } else {
            return Dificuldade.DIFICIL;
        }
    }

    private int mostrarMenuAtaque() {
        Capoeirista cap = (Capoeirista) jogador.getPersonagem();

        System.out.println("\n📋 ESCOLHA SEU ATAQUE:");
        System.out.println("=".repeat(50));
        System.out.println("1 🔄 GINGA BÁSICA (Ataque Normal)");
        System.out.println("   📊 Dano: " + cap.getAtaque() + " + bônus | Custo: 0 de Ginga");
        System.out.println();
        System.out.println("2 💫 ATAQUE DIFÍCIL (Movimentos Acrobáticos)");
        System.out.println("   📊 Dano: " + (cap.getAtaque() + 15) + " + bônus | Custo: 20 de Ginga");
        System.out.println();
        System.out.println("3 🔥 COMBINAÇÃO MORTAL (Sequência de Golpes)");
        System.out.println("   📊 Dano: Múltiplos golpes | Custo: 40 de Ginga");
        System.out.println();
        System.out.println("4 🌀 ESQUIVA (" + cap.getEsquivasRestantes() + " restantes)");
        System.out.println("   📊 Desvia do próximo ataque | 40% chance de contra-ataque");
        System.out.println("=".repeat(50));

        System.out.println("\n⏱️ VOCÊ TEM 10 SEGUNDOS PARA ESCOLHER!");

        return TemporizadorResposta.lerEscolhaComTempo(scanner);
    }

    private void executarAtaque(int escolha, Capoeirista cap, Inimigo inimigo) {
        switch (escolha) {
            case 1:
                System.out.println("\n🔄 GINGA BÁSICA!");
                cap.ataqueNormal(inimigo);
                break;

            case 2:
                System.out.println("\n💫 ATAQUE DIFÍCIL!");
                cap.ataqueDificil(inimigo);
                break;

            case 3:
                System.out.println("\n🔥 COMBINAÇÃO MORTAL!");
                cap.ataqueCombinado(inimigo);
                break;

            case 4:
                System.out.println("\n🌀 ESQUIVA!");
                cap.executarEsquiva(inimigo);
                break;

            default:
                System.out.println("\n⏰ TEMPO ESGOTADO! Perdeu a vez!");
                int dano = inimigo.getAtaque() + random.nextInt(10);
                System.out.println("💢 " + inimigo.getNome() + " ataca causando " + dano + "!");
                jogador.tomarDano(dano);
                break;
        }
    }

    private int calcularDanoInimigo(Inimigo inimigo, boolean ehChefao) {
        int danoBase = inimigo.getAtaque();

        if (ehChefao && besouro.getFaseAtual() == 3) {
            danoBase *= 2;
            System.out.println("⚡ FÚRIA DO BESOURO! Dano dobrado!");
        }

        int variacao = random.nextInt(15) - 7;
        return Math.max(5, danoBase + variacao);
    }

    private void derrotaNaRoda() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("💀 VOCÊ CAIU NA RODA! 💀");
        System.out.println("=".repeat(60));
        System.out.println("   O berimbau silenciou...");
        System.out.println("   Sua ginga foi interrompida...");
        System.out.println("   Mas a capoeira continua viva!\n");
        exibirResultados();
    }

    private void derrotaFinal() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🦗 O BESOURO VENCEU! 🦗");
        System.out.println("=".repeat(60));
        System.out.println("   'FECHADO, NINGUÉM ME SEGURA!'");
        System.out.println("   Você lutou bravamente contra a lenda...");
        System.out.println("   O corpo fechado do Besouro prevaleceu...\n");
        exibirResultados();
    }

    private void vitoriaFinal() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("👑 VOCÊ SE TORNOU O NOVO BESOURO! 👑");
        System.out.println("=".repeat(60));
        System.out.println("   🦗 O corpo fechado agora é seu!");
        System.out.println("   🌎 Sua fama correrá o mundo!");
        System.out.println("   📜 Você é a nova lenda da capoeira!");
        System.out.println("   🎵 Seu nome será cantado nas rodas para sempre!\n");
        exibirResultados();
    }

    private void exibirResultados() {
        System.out.println("\n📊 RESULTADOS DA RODA PROIBIDA");
        System.out.println("=".repeat(50));
        System.out.println("🏆 Pontuação Total: " + pontuacaoTotal);
        System.out.println("📊 Rodadas Jogadas: " + (perguntasCertas + perguntasErradas));
        System.out.println("✅ Perguntas Certas: " + perguntasCertas);
        System.out.println("❌ Perguntas Erradas: " + perguntasErradas);

        if (perguntasCertas + perguntasErradas > 0) {
            double aproveitamento = (double) perguntasCertas / (perguntasCertas + perguntasErradas) * 100;
            System.out.println("📈 Aproveitamento: " + String.format("%.1f", aproveitamento) + "%");
        }

        System.out.println("🥋 Mestres Derrotados: " + vitorias + "/9");

        Capoeirista c = (Capoeirista) jogador.getPersonagem();
        System.out.println("\n👤 SEU CAPOEIRISTA:");
        System.out.println("   🏅 Título: " + c.getNome());
        System.out.println("   ❤️ Vida Final: " + c.getVida() + "/" + c.getVidaMax());
        System.out.println("   ⚔️ Ataque: " + c.getAtaque());
        System.out.println("   🛡️ Defesa: " + c.getDefesa());

        System.out.println("   🦗 Enfrentou o Besouro: " + (estagioAtual >= 10 ? "SIM" : "NÃO"));

        System.out.println("\n🎵 O berimbau continuará tocando...");
        System.out.println("   A capoeira nunca morrerá!\n");
    }
}