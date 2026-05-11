package controle;

import modelo.*;
import modelo.Pergunta.Dificuldade;
import dados.BancoPerguntas;
import habilidades.*;
import java.util.*;

public class GerenciadorBatalha {
    private Jogador jogador;
    private Inimigo inimigoAtual;
    private BancoPerguntas bancoPerguntas;
    private GerenciadorRotas gerenciadorRotas;
    private Rota rotaAtual;
    private int estagioIndex;
    private int rodadaAtual;
    private int pontuacaoTotal;
    private Scanner scanner;
    private Random random;

    // ⭐ Para controle de repetição de perguntas
    private Set<Integer> perguntasUsadas;
    private Map<Dificuldade, Integer> resetsPorDificuldade;

    public GerenciadorBatalha(Jogador jogador, BancoPerguntas bancoPerguntas) {
        this.jogador = jogador;
        this.bancoPerguntas = bancoPerguntas;
        this.gerenciadorRotas = new GerenciadorRotas();
        this.rodadaAtual = 0;
        this.pontuacaoTotal = 0;
        this.scanner = new Scanner(System.in);
        this.random = new Random();

        this.perguntasUsadas = new HashSet<>();
        this.resetsPorDificuldade = new HashMap<>();
        for (Dificuldade diff : Dificuldade.values()) {
            resetsPorDificuldade.put(diff, 0);
        }

        inicializarHabilidades();
    }

    private void inicializarHabilidades() {
        Personagem p = jogador.getPersonagem();

        if (p instanceof Paladino) {
            p.setHabilidade(new HabilidadeCura(p, 30, 8));
        } else if (p instanceof Guerreiro) {
            p.setHabilidade(new HabilidadeDanoExtra(p, 20, 8));
        } else if (p instanceof Cacadora) {
            p.setHabilidade(new HabilidadeCritico(p, 20, 8));
        } else if (p instanceof Sabio) {
            p.setHabilidade(new HabilidadePoderMagico(p, 30, 8));
        } else if (p instanceof Arcanista) {
            p.setHabilidade(new HabilidadeDestruicaoTotal(p, 35, 8));
        }

        if (p.getHabilidade() != null) {
            System.out.println("\n🌟 " + p.getNome() + " possui a habilidade: " +
                    p.getHabilidade().getNome());
            System.out.println("   " + p.getHabilidade().getDescricao());
            System.out.println("   ⏱️ Cooldown: " + p.getHabilidade().getCooldown() + " rodadas");
        }
    }

    public void iniciarRota() {
        PerTipo tipoPersonagem = jogador.getPersonagem().getTipo();
        rotaAtual = gerenciadorRotas.getRota(tipoPersonagem);
        gerenciadorRotas.setRotaAtual(rotaAtual);
        estagioIndex = 0;

        System.out.println("\n" + "=".repeat(60));
        System.out.println("🗺️ VOCÊ ESCOLHEU A ROTA: " + rotaAtual.getNomeRota());
        System.out.println("=".repeat(60));
        rotaAtual.mostrarInfo();

        System.out.print("\nPressione ENTER para começar sua jornada...");
        scanner.nextLine();

        iniciarJogo();
    }

    private void iniciarJogo() {
        while (estagioIndex < rotaAtual.getTotalEstagios() && jogador.vivo()) {
            Estagio estagio = rotaAtual.getEstagios().get(estagioIndex);
            estagio.mostrarInfo();


            if (estagio.ehChefao()) {
                inimigoAtual = estagio.getChefao();
                System.out.println("\n⚠️ UM CHEFÃO APARECEU! ⚠️");
                System.out.println("👑 " + inimigoAtual.getNome() + " - Vida: " + inimigoAtual.getVida());
            } else {
                criarInimigoParaEstagio(estagio);
            }

            boolean completo = realizarBatalha(estagio);

            if (!completo) {
                System.out.println("\n💀 GAME OVER! Pontuação final: " + pontuacaoTotal);
                return;
            }

            estagioIndex++;

            if (estagioIndex < rotaAtual.getTotalEstagios()) {
                jogador.getPersonagem().curar(30);
                System.out.println("\n✨ Você avança para o próximo estágio! +30 de vida! ✨");
                System.out.print("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }
        }

        if (estagioIndex >= rotaAtual.getTotalEstagios() && jogador.vivo()) {
            System.out.println("\n🏆 PARABÉNS! VOCÊ COMPLETOU A ROTA " + rotaAtual.getNomeRota() + "! 🏆");
            System.out.println("🏆 Pontuação final: " + pontuacaoTotal);

            System.out.println("\n📊 ESTATÍSTICAS DE PERGUNTAS:");
            System.out.println("   Total de perguntas únicas usadas: " + perguntasUsadas.size());
            for (Dificuldade diff : Dificuldade.values()) {
                System.out.println("   " + diff.getNome() + " - Resets: " + resetsPorDificuldade.get(diff));
            }
        }
    }

    private void resetarPerguntasPorDificuldade(Dificuldade dificuldade) {
        perguntasUsadas.clear();
        int totalResets = resetsPorDificuldade.get(dificuldade) + 1;
        resetsPorDificuldade.put(dificuldade, totalResets);
        System.out.println("🔄 Banco de perguntas reiniciado para dificuldade " +
                dificuldade.getNome() + " (reset #" + totalResets + ")");
    }

    private void criarInimigoParaEstagio(Estagio estagio) {
        int vidaBase = 60 + (estagio.getNumero() * 10);
        int ataqueBase = 15 + (estagio.getNumero() * 5);
        String nome = "🗡️ Guardião do " + estagio.getNome() + " 🗡️";
        this.inimigoAtual = new Inimigo(nome, vidaBase, ataqueBase, estagio.getNumero());
    }

    private Pergunta getPerguntaSemRepeticao(PerTipo tipo, Dificuldade dificuldade, int estagioNumero) {
        List<Pergunta> todasPerguntas = bancoPerguntas.getPerguntasPorDificuldade(tipo, dificuldade, estagioNumero);

        if (todasPerguntas == null || todasPerguntas.isEmpty()) {
            System.out.println("⚠️ Nenhuma pergunta disponível para " + dificuldade.getNome());
            return null;
        }

        List<Pergunta> perguntasNaoUsadas = new ArrayList<>();
        for (Pergunta p : todasPerguntas) {
            if (!perguntasUsadas.contains(p.getId())) {
                perguntasNaoUsadas.add(p);
            }
        }

        if (perguntasNaoUsadas.isEmpty()) {
            System.out.println("\n🔄 Todas as " + todasPerguntas.size() +
                    " perguntas de dificuldade " + dificuldade.getNome() +
                    " já foram usadas na jornada!");
            System.out.println("   Reiniciando ciclo para esta dificuldade...");
            resetarPerguntasPorDificuldade(dificuldade);

            perguntasNaoUsadas = todasPerguntas;
        }

        Pergunta escolhida = perguntasNaoUsadas.get(random.nextInt(perguntasNaoUsadas.size()));

        perguntasUsadas.add(escolhida.getId());

        int usadasNestaDificuldade = 0;
        for (Pergunta p : todasPerguntas) {
            if (perguntasUsadas.contains(p.getId())) {
                usadasNestaDificuldade++;
            }
        }
        int restantes = todasPerguntas.size() - usadasNestaDificuldade;
        System.out.println("📚 " + dificuldade.getNome() + ": " + usadasNestaDificuldade + "/" +
                todasPerguntas.size() + " usadas | Restantes: " + restantes);

        return escolhida;
    }

    private boolean realizarBatalha(Estagio estagio) {
        while (jogador.vivo() && inimigoAtual.vivo()) {
            rodadaAtual++;
            System.out.println("\n" + "=".repeat(60));
            System.out.println("⚔️ RODADA " + rodadaAtual);
            if (estagio.ehChefao()) {
                System.out.println("👑 BATALHA CONTRA O CHEFÃO! 👑");
            }
            System.out.println("=".repeat(60));

            jogador.mostrarStatus();
            inimigoAtual.mostrarStatus();

            Personagem personagem = jogador.getPersonagem();
            if (personagem.getHabilidade() != null) {
                if (personagem.isHabilidadePronta()) {
                    System.out.println("✨ HABILIDADE ESPECIAL PRONTA! ✨");
                } else {
                    System.out.println("⏳ Habilidade em cooldown: " +
                            personagem.getCooldownAtual() + " rodadas");
                }
            }

            int escolha = mostrarMenuAcao();

            switch (escolha) {
                case 1:
                    realizarRodadaPergunta(estagio);
                    break;
                case 2:
                    if (personagem.getHabilidade() != null && personagem.isHabilidadePronta()) {
                        realizarRodadaHabilidade(estagio);
                    } else if (personagem.getHabilidade() == null) {
                        System.out.println("\n❌ Seu personagem não possui habilidade especial!");
                        System.out.println("   Voltando ao ataque normal...");
                        realizarRodadaPergunta(estagio);
                    } else {
                        System.out.println("\n⏳ Habilidade ainda em cooldown! " +
                                "Aguarde " + personagem.getCooldownAtual() + " rodadas.");
                        System.out.println("   Voltando ao ataque normal...");
                        realizarRodadaPergunta(estagio);
                    }
                    break;
            }

            personagem.reduzirCooldownHabilidade();

            if (!inimigoAtual.vivo()) {
                System.out.println("\n🎉 VITÓRIA! Estágio " + estagio.getNumero() + " concluído! 🎉");

                int experienciaInimigo = calcularExperienciaPorInimigo(estagio);
                jogador.getPersonagem().addExperiencia(experienciaInimigo);
                System.out.println("📚 +" + experienciaInimigo + " EXP por derrotar o inimigo!");

                int bonus = estagio.getNumero() * 10;
                pontuacaoTotal += bonus;
                System.out.println("🏆 Bônus de estágio: +" + bonus + " pontos!");
                return true;
            }

            if (!jogador.vivo()) {
                System.out.println("\n💀 Você foi derrotado! 💀");
                return false;
            }
        }
        return false;
    }

    private int calcularExperienciaPorInimigo(Estagio estagio) {
        int experienciaBase = 50;
        int multiplicador = estagio.getNumero();

        if (estagio.ehChefao()) {
            multiplicador *= 2;
        }

        int experiencia = experienciaBase * multiplicador;

        Random random = new Random();
        double variacao = 0.9 + (random.nextDouble() * 0.2);
        experiencia = (int)(experiencia * variacao);

        return Math.max(20, experiencia);
    }

    private int mostrarMenuAcao() {
        Personagem personagem = jogador.getPersonagem();
        int escolha = -1;

        while (escolha != 1 && escolha != 2) {
            System.out.println("\n📋 O QUE VOCÊ DESEJA FAZER?");
            System.out.println("=".repeat(40));
            System.out.println("1 🗡️ Responder Pergunta (Ataque Normal)");

            if (personagem.getHabilidade() != null) {
                String status = personagem.isHabilidadePronta() ? "✅ PRONTA" : "⏳ COOLDOWN";
                System.out.println("2 🌟 Usar Habilidade Especial - " +
                        personagem.getHabilidade().getNome() + " [" + status + "]");
            } else {
                System.out.println("2 ❌ Sem habilidade especial");
            }
            System.out.println("=".repeat(40));
            System.out.print("Sua escolha (1 ou 2): ");

            try {
                escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha != 1 && escolha != 2) {
                    System.out.println("\n❌ Opção inválida! Digite 1 ou 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Entrada inválida! Digite um número (1 ou 2).");
                scanner.nextLine();
                escolha = -1;
            }
        }
        return escolha;
    }

    private void realizarRodadaPergunta(Estagio estagio) {
        Dificuldade dificuldade;
        if (estagio.getDificuldade() <= 3) {
            dificuldade = Dificuldade.FACIL;
        } else if (estagio.getDificuldade() <= 7) {
            dificuldade = Dificuldade.MEDIO;
        } else {
            dificuldade = Dificuldade.DIFICIL;
        }

        Pergunta pergunta = getPerguntaSemRepeticao(
                jogador.getPersonagem().getTipo(), dificuldade, estagio.getNumero());

        if (pergunta == null) {
            pergunta = bancoPerguntas.getPerguntaAleatoriaParaPersonagem(
                    jogador.getPersonagem().getTipo(), estagio.getNumero());
        }

        if (pergunta == null) {
            System.out.println("\n❌ ERRO: Nenhuma pergunta disponível!");
            return;
        }

        pergunta.exibir();

        String resposta;
        if (pergunta instanceof PerguntaCompletarLacuna) {
            System.out.print("\nDigite sua resposta: ");
            resposta = scanner.nextLine().trim();
        } else {
            System.out.print("\nSua resposta: ");
            resposta = scanner.nextLine().toUpperCase();
        }

        boolean correta = AvaliadorRespostas.avaliar(pergunta, resposta);
        int dano = calcularDano(pergunta.getDificuldade(), estagio);

        if (correta) {
            System.out.println("\n✅ CORRETO!");
            inimigoAtual.tomarDano(dano);

            int experienciaGanha = (estagio.getDificuldade() * 5);
            jogador.getPersonagem().addExperiencia(experienciaGanha);
            System.out.println("📚 +" + experienciaGanha + " de experiência!");

            int pontos = calcularPontos(pergunta.getDificuldade(), estagio);
            pontuacaoTotal += pontos;
            jogador.addPontuacao(pontos);
            System.out.println("🏆 +" + pontos + " pontos! Total: " + pontuacaoTotal);
        } else {
            System.out.println("\n❌ ERRADO!");
            System.out.println("Resposta correta: " + pergunta.getRespostaCorreta());

            int danoInimigo = calcularDanoInimigo();
            jogador.tomarDano(danoInimigo);
            System.out.println("⚠️ " + inimigoAtual.getNome() + " contra-ataca causando " + danoInimigo + " de dano!");
        }
    }

    private void realizarRodadaHabilidade(Estagio estagio) {
        Personagem personagem = jogador.getPersonagem();

        System.out.println("\n🌟 USANDO HABILIDADE ESPECIAL! 🌟");
        System.out.println("💪 " + personagem.getHabilidade().getNome());
        System.out.println("📖 " + personagem.getHabilidade().getDescricao());

        System.out.print("\nDeseja realmente usar a habilidade? (S/N): ");
        String confirmacao = scanner.nextLine().toUpperCase();

        if (!confirmacao.equals("S")) {
            System.out.println("\n❌ Uso cancelado! Voltando ao combate normal.");
            realizarRodadaPergunta(estagio);
            return;
        }

        int dano = personagem.usarHabilidade(inimigoAtual);

        if (dano > 0) {
            System.out.println("\n💥 " + personagem.getNome() + " causa " + dano + " de dano com sua habilidade especial!");
        }
    }

    private int calcularDanoInimigo() {
        int danoBase = inimigoAtual.getAtaque();

        int multiplicador = (estagioIndex + 1);

        if (rotaAtual.getEstagios().get(estagioIndex).ehChefao()) {
            multiplicador *= 2;
        }

        int dano = danoBase + (multiplicador * 2);

        double variacao = 0.8 + (random.nextDouble() * 0.4);
        dano = (int)(dano * variacao);

        return Math.max(5, dano);
    }

    private int calcularDano(Dificuldade diff, Estagio estagio) {
        Personagem personagem = jogador.getPersonagem();

        int danoBase = personagem.getAtaque();

        int multiplicadorDificuldade;
        switch (diff) {
            case FACIL:
                multiplicadorDificuldade = 1;
                break;
            case MEDIO:
                multiplicadorDificuldade = 2;
                break;
            case DIFICIL:
                multiplicadorDificuldade = 3;
                break;
            default:
                multiplicadorDificuldade = 1;
        }

        int multiplicadorEstagio = estagio.getDificuldade() / 2;

        int dano = danoBase * multiplicadorDificuldade * multiplicadorEstagio;

        double variacao = 0.85 + (random.nextDouble() * 0.3);
        dano = (int)(dano * variacao);

        return Math.max(5, dano);
    }

    private int calcularPontos(Dificuldade diff, Estagio estagio) {
        return diff.getDanoBase() * 5 * estagio.getDificuldade();
    }
}