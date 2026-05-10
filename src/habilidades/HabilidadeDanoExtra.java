package habilidades;

import modelo.Inimigo;
import modelo.Personagem;

public class HabilidadeDanoExtra implements HabilidadeEspecial {
    private Personagem usuario;
    private int danoBase;
    private int cooldownMaximo;
    private int cooldownAtual;
    private String nome;
    private String descricao;

    public HabilidadeDanoExtra(Personagem usuario, int danoBase, int cooldown) {
        this.usuario = usuario;
        this.danoBase = danoBase;
        this.cooldownMaximo = cooldown;
        this.cooldownAtual = 0;
        this.nome = "Fúria do Guerreiro";
        this.descricao = "Causa " + danoBase + " de dano extra e reduz defesa do inimigo";
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public String getDescricao() { return descricao; }

    @Override
    public int getCooldown() { return cooldownMaximo; }

    @Override
    public int getCooldownAtual() { return cooldownAtual; }

    @Override
    public boolean estaPronta() {
        return cooldownAtual == 0;
    }

    @Override
    public int executar(Inimigo alvo) {
        if (!estaPronta()) {
            System.out.println("⏳ Habilidade em cooldown!");
            return 0;
        }

        int danoTotal = danoBase + usuario.getAtaque();
        System.out.println("💥 " + usuario.getNome() + " usa " + nome + " causando " + danoTotal + " de dano!");
        alvo.tomarDano(danoTotal);

        cooldownAtual = cooldownMaximo;
        return danoTotal;
    }

    @Override
    public void reduzirCooldown() {
        if (cooldownAtual > 0) {
            cooldownAtual--;
        }
    }

    @Override
    public void resetarCooldown() {
        cooldownAtual = 0;
    }
}
