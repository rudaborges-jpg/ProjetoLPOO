package habilidades;

import modelo.Inimigo;
import modelo.Personagem;
import java.util.Random;

public class HabilidadeDestruicaoTotal implements HabilidadeEspecial {
    private Personagem usuario;
    private int danoBase;
    private int cooldownMaximo;
    private int cooldownAtual;
    private String nome;
    private String descricao;
    private Random random;

    public HabilidadeDestruicaoTotal(Personagem usuario, int danoBase, int cooldown) {
        this.usuario = usuario;
        this.danoBase = danoBase;
        this.cooldownMaximo = cooldown;
        this.cooldownAtual = 0;
        this.random = new Random();
        this.nome = "Cataclismo Arcano";
        this.descricao = "Libera todo poder arcano causando dano massivo";
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

        int dano = danoBase + (usuario.getAtaque() / 2);

        // Multiplicador aleatório para mais imprevisibilidade
        double multiplicador = 0.9 + (random.nextDouble() * 0.2);
        dano = (int)(dano * multiplicador);

        alvo.tomarDano(dano);

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