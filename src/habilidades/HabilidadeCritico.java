package habilidades;

import modelo.Inimigo;
import modelo.Personagem;
import java.util.Random;

public class HabilidadeCritico implements HabilidadeEspecial {
    private Personagem usuario;
    private int danoBase;
    private int cooldownMaximo;
    private int cooldownAtual;
    private String nome;
    private String descricao;
    private Random random;

    public HabilidadeCritico(Personagem usuario, int danoBase, int cooldown) {
        this.usuario = usuario;
        this.danoBase = danoBase;
        this.cooldownMaximo = cooldown;
        this.cooldownAtual = 0;
        this.random = new Random();
        this.nome = "Chuva de Flechas";
        this.descricao = "Causa " + danoBase + " de dano em área com chance de crítico";
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
    public boolean estaPronta() { return cooldownAtual == 0; }

    @Override
    public int executar(Inimigo alvo) {
        if (!estaPronta()) {
            System.out.println("⏳ Habilidade em cooldown!");
            return 0;
        }

        int dano = danoBase + usuario.getAtaque();

        // Chance de crítico (40%)
        if (random.nextDouble() < 0.4) {
            dano = (int)(dano * 1.5);
            System.out.print("🎯 GOLPE CRÍTICO! ");
        }

        alvo.tomarDano(dano);

        // Dano de sangramento adicional
        alvo.tomarDano(10);

        cooldownAtual = cooldownMaximo;
        return dano;
    }

    @Override
    public void reduzirCooldown() {
        if (cooldownAtual > 0) cooldownAtual--;
    }

    @Override
    public void resetarCooldown() { cooldownAtual = 0; }
}