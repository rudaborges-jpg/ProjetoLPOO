package habilidades;

import modelo.Inimigo;
import modelo.Personagem;

public class HabilidadeCura implements HabilidadeEspecial {
    private Personagem usuario;
    private int curaBase;
    private int cooldownMaximo;
    private int cooldownAtual;
    private String nome;
    private String descricao;

    public HabilidadeCura(Personagem usuario, int curaBase, int cooldown) {
        this.usuario = usuario;
        this.curaBase = curaBase;
        this.cooldownMaximo = cooldown;
        this.cooldownAtual = 0;
        this.nome = "Espírito Sagrado";
        this.descricao = "Cura " + curaBase + " de vida e causa dano ao inimigo";
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

        // Cura o usuário
        usuario.curar(curaBase);

        // Causa dano ao alvo
        int dano = curaBase / 2;
        System.out.println("💚 " + usuario.getNome() + " usa " + nome + " curando " + curaBase + " e causando " + dano + " de dano!");
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