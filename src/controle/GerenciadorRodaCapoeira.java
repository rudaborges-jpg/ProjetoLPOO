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
    private int vezesSemTempo;

    // Dados dos mestres
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
        this.bancoCapoeira = new BancoPerguntasCapoeira();

        this.perguntasCertas = 0;
        this.perguntasErradas = 0;
        this.vitorias = 0;
        this.vezesSemTempo = 0;

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

    // ============ INÍCIO DA RODA ============

    public void iniciarRodaProibida() {
        System.out.println("\n🥋 A RODA PROIBIDA COMEÇA! 🥋");
        System.out.println("=".repeat(60));
        System.out.println("📋 REGRAS DA RODA:");
        System.out.println("   🎯 Escolha seu tipo de ataque (SEM pressa)");
        System.out.println("   📚 Ataque Básico     → Pergunta FÁCIL");
        System.out.println("   💫 Ataque Difícil    → Pergunta MÉDIA");
        System.out.println("   🔥 Combinação Mortal → Pergunta DIFÍCIL");
        System.out.println("   🌀 Esquiva           → SEM pergunta (desvia do ataque)");
        System.out.println("   ⏱️  10 segundos para responder cada pergunta!");
        System.out.println("   ❌ Se o tempo acabar, o inimigo ataca!");
        System.out.println("=".repeat(60));

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

            // Recupera recursos após vitória
            cap.recarregarTotalmente();

            if (i < inimigos.length - 1) {
                System.out.println("\n🎵 O berimbau chama o próximo desafiante...");
                System.out.println("   Prepare-se para o próximo mestre!");
                System.out.print("\nPressione ENTER para continuar...");
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

    // ============ ENFRENTAR MESTRE ============

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

    // ============ LOOP DE BATALHA (CORRIGIDO) ============

    private boolean batalhaDeCapoeira(Inimigo inimigo, boolean ehChefao) {
        Capoeirista capoeirista = (Capoeirista) jogador.getPersonagem();
        int rodada = 0;

        while (jogador.vivo() && inimigo.vivo()) {
            rodada++;

            // ===== MOSTRA STATUS =====
            System.out.println("\n" + "=".repeat(60));
            System.out.println("🔄 RODADA " + rodada);
            if (ehChefao) {
                System.out.println("🦗 CONFRONTO FINAL CONTRA O BESOURO!");
            }
            System.out.println("=".repeat(60));

            capoeirista.mostrarStatus();
            System.out.println();

            if (ehChefao) {
                besouro.mostrarStatus();
            } else {
                System.out.println("👥 " + inimigo.getNome());
                inimigo.mostrarStatus();
            }

            // ===== MENU DE ATAQUE =====
            int escolhaAtaque = mostrarMenuAtaqueSemTempo();

            // ===== CORREÇÃO: ESQUIVA NÃO TEM PERGUNTA =====
            if (escolhaAtaque == 4) {
                // Esquiva é executada diretamente, sem pergunta
                System.out.println("\n🌀 ESQUIVA DE CAPOEIRA!");
                boolean esquivou = capoeirista.executarEsquiva(inimigo);

                if (esquivou) {
                    System.out.println("   ✨ Você desviou com elegância!");
                    // Recupera um pouco de ginga
                    capoeirista.consumirEnergiaGinga(-5);
                    System.out.println("   🌀 +5 de Ginga recuperada!");
                }

                // Pula o resto da rodada (sem pergunta, sem ataque inimigo)
                if (!inimigo.vivo()) {
                    // Se a esquiva matou o inimigo (contra-ataque)
                    System.out.println("\n💀 " + inimigo.getNome() + " FOI DERROTADO!");
                    int bonus = estagioAtual * 35;
                    pontuacaoTotal += bonus;
                    jogador.addPontuacao(bonus);
                    System.out.println("🏆 +" + bonus + " pontos! Total: " + pontuacaoTotal);
                    return true;
                }

                // Pequena pausa
                if (inimigo.vivo() && jogador.vivo()) {
                    System.out.print("\n⏭️  Pressione ENTER para próxima rodada...");
                    scanner.nextLine();
                }
                continue; // Pula o resto do loop
            }

            // Para ataques 1, 2 e 3: determina dificuldade
            Dificuldade dificuldade = getDificuldadePorAtaque(escolhaAtaque);

            // Obtém pergunta de capoeira
            Pergunta pergunta = bancoCapoeira.getPerguntaAleatoria(dificuldade);

            if (pergunta == null) {
                System.out.println("❌ Erro ao carregar pergunta!");
                return false;
            }

            // ===== EXIBE PERGUNTA COM TEMPORIZADOR =====
            System.out.println("\n📚 PERGUNTA DE CAPOEIRA:");
            System.out.println("   Dificuldade: " + getNomeDificuldade(dificuldade));
            pergunta.exibir();

            String resposta;
            if (pergunta instanceof PerguntaCompletarLacuna) {
                System.out.print("\n✏️  Digite sua resposta: ");
                resposta = scanner.nextLine().trim();
            } else {
                System.out.print("\n✏️  Sua resposta: ");
                resposta = scanner.nextLine().trim().toUpperCase();
            }

            // ===== CORREÇÃO: AVALIAÇÃO DE RESPOSTA =====
            boolean acertou = AvaliadorRespostas.avaliar(pergunta, resposta);

            // ===== PROCESSAR RESULTADO =====
            if (acertou) {
                perguntasCertas++;
                System.out.println("\n✅ CORRETO! Execute seu golpe!");

                // Executa o ataque escolhido
                executarAtaque(escolhaAtaque, capoeirista, inimigo);

                // Bônus de ginga por acertar
                capoeirista.consumirEnergiaGinga(-10);
                System.out.println("🌀 +10 de Ginga recuperada!");

            } else {
                perguntasErradas++;
                System.out.println("\n❌ ERRADO!");

                // Mostra a resposta correta para feedback
                if (pergunta instanceof PerguntaMultiplaEscolha) {
                    PerguntaMultiplaEscolha multipla = (PerguntaMultiplaEscolha) pergunta;
                    System.out.println("   Resposta correta: " + multipla.getLetraCorreta() + ") " +
                            pergunta.getRespostaCorreta());
                } else if (pergunta instanceof PerguntaVerdadeiroFalso) {
                    System.out.println("   Resposta correta: " + pergunta.getRespostaCorreta());
                } else {
                    System.out.println("   Resposta correta: " + pergunta.getRespostaCorreta());
                }

                // Inimigo contra-ataca
                int danoInimigo = calcularDanoInimigo(inimigo, ehChefao);
                System.out.println("💢 " + inimigo.getNome() + " contra-ataca causando " + danoInimigo + " de dano!");
                jogador.tomarDano(danoInimigo);

                // Chance do inimigo usar habilidade especial (20%)
                if (random.nextDouble() < 0.2) {
                    int danoExtra = (int)(danoInimigo * 0.5);
                    System.out.println("⚡ " + inimigo.getNome() + " usa GOLPE ESPECIAL! +" + danoExtra + " de dano!");
                    jogador.tomarDano(danoExtra);
                }
            }

            // ===== VERIFICA MORTES =====
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
                jogador.addPontuacao(bonus);
                System.out.println("🏆 +" + bonus + " pontos! Total: " + pontuacaoTotal);

                return true;
            }

            if (!jogador.vivo()) {
                return false;
            }

            // Pequena pausa entre rodadas
            if (inimigo.vivo() && jogador.vivo()) {
                System.out.print("\n⏭️  Pressione ENTER para próxima rodada...");
                scanner.nextLine();
            }
        }

        return jogador.vivo();
    }

    // ============ MENU DE ATAQUE (SEM TEMPO) ============

    private int mostrarMenuAtaqueSemTempo() {
        Capoeirista cap = (Capoeirista) jogador.getPersonagem();
        int escolha = -1;

        while (escolha < 1 || escolha > 4) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("📋 ESCOLHA SEU TIPO DE ATAQUE:");
            System.out.println("=".repeat(60));

            System.out.println("\n1 🔄 GINGA BÁSICA (Ataque Normal)");
            System.out.println("   📚 Pergunta FÁCIL");
            System.out.println("   ⚔️  Dano: " + cap.getAtaque() + " + bônus");
            System.out.println("   🌀 Custo: 0 de Ginga");
            System.out.println("   💚 Recupera: +5 de Ginga");

            System.out.println("\n2 💫 ATAQUE DIFÍCIL (Movimentos Acrobáticos)");
            System.out.println("   📚 Pergunta MÉDIA");
            System.out.println("   ⚔️  Dano: " + (cap.getAtaque() + 15) + " + bônus");
            System.out.println("   🌀 Custo: 20 de Ginga");
            System.out.println("   🎯 30% de chance de bônus extra");

            System.out.println("\n3 🔥 COMBINAÇÃO MORTAL (Sequência de Golpes)");
            System.out.println("   📚 Pergunta DIFÍCIL");
            System.out.println("   ⚔️  Dano: 3-4 golpes consecutivos");
            System.out.println("   🌀 Custo: 40 de Ginga");
            System.out.println("   💥 Dano máximo possível!");

            System.out.println("\n4 🌀 ESQUIVA DE CAPOEIRA");
            System.out.println("   📚 SEM pergunta (uso livre)");
            System.out.println("   🛡️  Desvia do próximo ataque");
            System.out.println("   ⚡ 40% de chance de contra-ataque");
            System.out.println("   🔄 Esquivas restantes: " + cap.getEsquivasRestantes() + "/" + cap.getEsquivasMaximas());

            System.out.println("\n" + "=".repeat(60));
            System.out.println("🌀 Ginga disponível: " + cap.getEnergiaGinga() + "/" + cap.getEnergiaMaxima());
            System.out.println("=".repeat(60));

            System.out.print("\n🎯 Sua escolha (1-4): ");

            try {
                String entrada = scanner.nextLine().trim();
                escolha = Integer.parseInt(entrada);

                // Validações específicas
                if (escolha == 2 && cap.getEnergiaGinga() < 20) {
                    System.out.println("\n❌ GINGA INSUFICIENTE! Você precisa de 20 de Ginga.");
                    System.out.println("   Ginga atual: " + cap.getEnergiaGinga());
                    System.out.println("   Escolha outra opção.");
                    escolha = -1;
                    continue;
                }

                if (escolha == 3 && cap.getEnergiaGinga() < 40) {
                    System.out.println("\n❌ GINGA INSUFICIENTE! Você precisa de 40 de Ginga.");
                    System.out.println("   Ginga atual: " + cap.getEnergiaGinga());
                    System.out.println("   Escolha outra opção.");
                    escolha = -1;
                    continue;
                }

                if (escolha == 4 && cap.getEsquivasRestantes() <= 0) {
                    System.out.println("\n❌ SEM ESQUIVAS! Você já usou todas.");
                    System.out.println("   Esquivas serão recuperadas no próximo estágio.");
                    System.out.println("   Escolha outra opção.");
                    escolha = -1;
                    continue;
                }

                if (escolha < 1 || escolha > 4) {
                    System.out.println("\n❌ Opção inválida! Escolha entre 1 e 4.");
                    escolha = -1;
                }

            } catch (NumberFormatException e) {
                System.out.println("\n❌ Entrada inválida! Digite um número de 1 a 4.");
                escolha = -1;
            }
        }

        return escolha;
    }

    // ============ DIFICULDADE POR ATAQUE ============

    private Dificuldade getDificuldadePorAtaque(int escolhaAtaque) {
        switch (escolhaAtaque) {
            case 1: return Dificuldade.FACIL;
            case 2: return Dificuldade.MEDIO;
            case 3: return Dificuldade.DIFICIL;
            default: return Dificuldade.FACIL;
        }
    }

    private String getNomeDificuldade(Dificuldade dificuldade) {
        switch (dificuldade) {
            case FACIL: return "⭐ FÁCIL";
            case MEDIO: return "⭐⭐ MÉDIO";
            case DIFICIL: return "⭐⭐⭐ DIFÍCIL";
            default: return "⭐ FÁCIL";
        }
    }

    // ============ EXECUTAR ATAQUE ============

    private void executarAtaque(int escolha, Capoeirista cap, Inimigo inimigo) {
        System.out.print("\n💨 Preparando golpe");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(300);
                System.out.print(".");
                System.out.flush();
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println();

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
        }
    }

    // ============ CÁLCULO DE DANO ============

    private int calcularDanoInimigo(Inimigo inimigo, boolean ehChefao) {
        int danoBase = inimigo.getAtaque();

        if (ehChefao && besouro.getFaseAtual() == 3) {
            danoBase *= 2;
            System.out.println("⚡ FÚRIA DO BESOURO! Dano dobrado!");
        }

        int variacao = random.nextInt((int)(danoBase * 0.6)) - (int)(danoBase * 0.3);
        int danoFinal = danoBase + variacao;

        return Math.max(5, danoFinal);
    }

    // ============ TELAS DE RESULTADO ============

    private void derrotaNaRoda() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("💀 VOCÊ CAIU NA RODA! 💀");
        System.out.println("=".repeat(60));
        System.out.println("   😢 O berimbau silenciou...");
        System.out.println("   💔 Sua ginga foi interrompida...");
        System.out.println("   🌟 Mas a capoeira continua viva!");
        System.out.println("   💪 Treine mais e volte mais forte!\n");
        exibirResultados();
    }

    private void derrotaFinal() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🦗 O BESOURO VENCEU! 🦗");
        System.out.println("=".repeat(60));
        System.out.println("   'FECHADO, NINGUÉM ME SEGURA!'");
        System.out.println("   Você lutou bravamente contra a lenda...");
        System.out.println("   O corpo fechado do Besouro prevaleceu...");
        System.out.println("   Mas sua jornada foi lendária!\n");
        exibirResultados();
    }

    private void vitoriaFinal() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("👑 VOCÊ SE TORNOU O NOVO BESOURO! 👑");
        System.out.println("=".repeat(60));
        System.out.println("   🦗 O corpo fechado agora é seu!");
        System.out.println("   🌎 Sua fama correrá o mundo!");
        System.out.println("   📜 Você é a nova lenda da capoeira!");
        System.out.println("   🎵 Seu nome será cantado nas rodas para sempre!");
        System.out.println("   👑 VOCÊ É O HERDEIRO DO BERIMBAU SAGRADO!\n");
        exibirResultados();
    }

    private void exibirResultados() {
        System.out.println("\n📊 RESULTADOS DA RODA PROIBIDA");
        System.out.println("=".repeat(50));
        System.out.println("🏆 Pontuação Total: " + pontuacaoTotal);
        System.out.println("📊 Perguntas Respondidas: " + (perguntasCertas + perguntasErradas));
        System.out.println("✅ Acertos: " + perguntasCertas);
        System.out.println("❌ Erros: " + perguntasErradas);

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
        System.out.println("   🌀 Ginga Máxima: " + c.getEnergiaMaxima());
        System.out.println("   🦗 Enfrentou o Besouro: " + (estagioAtual >= 10 ? "SIM 👑" : "NÃO"));

        System.out.println("\n🎵 O berimbau continuará tocando...");
        System.out.println("   A capoeira nunca morrerá!");
        System.out.println("   Axé! 🙏\n");
    }
}