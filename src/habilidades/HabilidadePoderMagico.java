package habilidades;

import modelo.Inimigo;
import modelo.Personagem;
import modelo.Sabio;

public class HabilidadePoderMagico implements HabilidadeEspecial {
    private Personagem usuario;
    private int danoBase;
    private int cooldownMaximo;
    private int cooldownAtual;
    private String nome;
    private String descricao;

    public HabilidadePoderMagico(Personagem usuario, int danoBase, int cooldown) {
        this.usuario = usuario;
        this.danoBase = danoBase;
        this.cooldownMaximo = cooldown;
        this.cooldownAtual = 0;
        this.nome = "Sabedoria Ancestral";
        this.descricao = "Causa dano, cura e recupera mana";
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
        alvo.tomarDano(dano);

        usuario.curar(30);

        if (usuario instanceof Sabio) {
            Sabio sabio = (Sabio) usuario;
            System.out.println("🔮 Mana recuperada!");
        }

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