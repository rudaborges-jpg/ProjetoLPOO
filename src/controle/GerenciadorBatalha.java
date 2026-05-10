package controle;

import modelo.*;
import modelo.Pergunta.Dificuldade;
import dados.BancoPerguntas;
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

    public GerenciadorBatalha(Jogador jogador, BancoPerguntas bancoPerguntas) {
        this.jogador = jogador;
        this.bancoPerguntas = bancoPerguntas;
        this.gerenciadorRotas = new GerenciadorRotas();
        this.rodadaAtual = 0;
        this.pontuacaoTotal = 0;
        this.scanner = new Scanner(System.in);
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

            // Criar inimigo do estágio ou chefão
            if (estagio.ehChefao()) {
                inimigoAtual = estagio.getChefao();
                System.out.println("\n⚠️ UM CHEFÃO APARECEU! ⚠️");
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
        }
    }

    private void criarInimigoParaEstagio(Estagio estagio) {
        int vidaBase = 60 + (estagio.getNumero() * 10);
        int ataqueBase = 10 + (estagio.getNumero() * 3);
        String nome = "🗡️ Guardião do " + estagio.getNome() + " 🗡️";
        this.inimigoAtual = new Inimigo(nome, vidaBase, ataqueBase, estagio.getNumero());
    }

    private boolean realizarBatalha(Estagio estagio) {
        int acertos = 0;
        int necessarios = estagio.getPerguntasParaPassar();

        while (jogador.vivo() && inimigoAtual.vivo() && acertos < necessarios) {
            rodadaAtual++;
            System.out.println("\n" + "=".repeat(50));
            System.out.println("⚔️ RODADA " + rodadaAtual + " | Acertos: " + acertos + "/" + necessarios);
            if (estagio.ehChefao()) {
                System.out.println("👑 BATALHA CONTRA O CHEFÃO! 👑");
            }
            System.out.println("=".repeat(50));

            jogador.mostrarStatus();
            inimigoAtual.mostrarStatus();

            // Determinar dificuldade baseada no estágio
            Dificuldade dificuldade;
            if (estagio.getDificuldade() <= 3) {
                dificuldade = Dificuldade.FACIL;
            } else if (estagio.getDificuldade() <= 7) {
                dificuldade = Dificuldade.MEDIO;
            } else {
                dificuldade = Dificuldade.DIFICIL;
            }

            Pergunta pergunta = bancoPerguntas.getPerguntaAleatoriaPorDificuldade(
                    jogador.getPersonagem().getTipo(), dificuldade, estagio.getNumero());

            if (pergunta == null) {
                pergunta = bancoPerguntas.getPerguntaAleatoriaParaPersonagem(
                        jogador.getPersonagem().getTipo(), estagio.getNumero());
            }

            pergunta.exibir();
            System.out.print("\nSua resposta: ");
            String resposta = scanner.nextLine().toUpperCase();

            boolean correta = AvaliadorRespostas.avaliar(pergunta, resposta);
            int dano = calcularDano(pergunta.getDificuldade(), estagio);

            if (correta) {
                acertos++;
                System.out.println("\n✅ CORRETO! (" + acertos + "/" + necessarios + ")");
                inimigoAtual.tomarDano(dano);

                int pontos = calcularPontos(pergunta.getDificuldade(), estagio);
                pontuacaoTotal += pontos;
                jogador.addPontuacao(pontos);
                System.out.println("🏆 +" + pontos + " pontos! Total: " + pontuacaoTotal);
            } else {
                System.out.println("\n❌ ERRADO! Resposta correta: " + pergunta.getRespostaCorreta());
                int penalidade = dano / 2;
                jogador.tomarDano(penalidade);
                System.out.println("⚠️ Você sofreu " + penalidade + " de dano!");
            }

            if (!inimigoAtual.vivo()) {
                System.out.println("\n🎉 VITÓRIA!");
                if (estagio.ehChefao()) {
                    int bonus = estagio.getNumero() * 100;
                    pontuacaoTotal += bonus;
                    System.out.println("👑 Bônus de chefão: +" + bonus + " pontos!");
                } else {
                    int bonus = estagio.getNumero() * 50;
                    pontuacaoTotal += bonus;
                    System.out.println("🏆 Bônus de estágio: +" + bonus + " pontos!");
                }
                return true;
            }
        }

        return acertos >= necessarios;
    }

    private int calcularDano(Dificuldade diff, Estagio estagio) {
        int dano = diff.getDanoBase();
        dano = dano * (estagio.getDificuldade() / 2);
        if (dano < 5) dano = 5;
        return dano;
    }

    private int calcularPontos(Dificuldade diff, Estagio estagio) {
        return diff.getDanoBase() * 5 * estagio.getDificuldade();
    }
}
