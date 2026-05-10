package modelo;

import habilidades.HabilidadeEspecial;

public abstract class Personagem {
    protected String nome;
    protected PerTipo tipo;
    protected int vida;
    protected int vidaMax;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected int experiencia;
    protected int spatkCooldown;
    protected int atualCooldown;

    // NOVO PARA ENTREGA 2
    protected HabilidadeEspecial habilidade;

    public Personagem(PerTipo tipo, String nome, int vida, int ataque, int defesa) {
        this.tipo = tipo;
        this.nome = nome;
        this.vida = vida;
        this.vidaMax = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = 1;
        this.experiencia = 0;
        this.spatkCooldown = 3;
        this.atualCooldown = 0;
    }

    // Getters
    public String getNome() { return nome; }
    public PerTipo getTipo() { return tipo; }
    public int getVida() { return vida; }
    public int getVidaMax() { return vidaMax; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
    public int getNivel() { return nivel; }
    public int getExperiencia() { return experiencia; }
    public boolean taProntaHabilidade() { return atualCooldown == 0; }

    // NOVOS GETTERS/SETTERS PARA HABILIDADE (Entrega 2)
    public void setHabilidade(HabilidadeEspecial habilidade) {
        this.habilidade = habilidade;
    }

    public HabilidadeEspecial getHabilidade() {
        return habilidade;
    }

    public boolean isHabilidadePronta() {
        return habilidade != null && habilidade.estaPronta();
    }

    public int getCooldownAtual() {
        return habilidade != null ? habilidade.getCooldownAtual() : 0;
    }

    public void reduzirCooldownHabilidade() {
        if (habilidade != null) {
            habilidade.reduzirCooldown();
        }
    }

    public void resetarCooldownHabilidade() {
        if (habilidade != null) {
            habilidade.resetarCooldown();
        }
    }

    public int usarHabilidade(Inimigo alvo) {
        if (habilidade != null && habilidade.estaPronta()) {
            return habilidade.executar(alvo);
        }
        System.out.println("❌ Habilidade não disponível!");
        return 0;
    }

    public void tomarDano(int dano) {
        int danoAtual = Math.max(1, dano - defesa);
        this.vida -= danoAtual;
        if (this.vida < 0) this.vida = 0;
        System.out.println("⚔️ " + nome + " sofreu " + danoAtual + " de dano! (❤️ " + vida + "/" + vidaMax + ")");
    }

    public void curar(int quanto) {
        this.vida += quanto;
        if (this.vida > vidaMax) this.vida = vidaMax;
        System.out.println("💚 " + nome + " recuperou " + quanto + " de vida! (❤️ " + vida + "/" + vidaMax + ")");
    }

    public int ataqueInimigo(Personagem inimigo) {
        int dano = ataque + (nivel * 2);
        System.out.println("🗡️ " + nome + " ataca " + inimigo.getNome() + " causando " + dano + " de dano!");
        inimigo.tomarDano(dano);
        return dano;
    }

    public boolean vivo() { return vida > 0; }

    // Métodos abstratos originais (da Entrega 1)
    public abstract void usarHabilidadeEspecial(Personagem alvo);
    public abstract String getNomeHabilididade();
    public abstract String getDescricaoHabilidade();

    public void reduzirCooldown() {
        if (atualCooldown > 0) atualCooldown--;
    }

    public void addExperiencia(int exp) {
        this.experiencia += exp;
        System.out.println("📚 " + nome + " ganhou " + exp + " de experiência!");
        int expNecessario = nivel * 100;
        if (experiencia >= expNecessario) {
            levelUp();
        }
    }

    protected void levelUp() {
        nivel++;
        experiencia = 0;
        vidaMax += 20;
        vida = vidaMax;
        ataque += 5;
        defesa += 3;
        System.out.println("\n🎉 " + nome + " subiu para o NÍVEL " + nivel + "!");
    }

    public void mostrarStatus() {
        System.out.println("\n👤 " + nome + " (Nv." + nivel + ") - ❤️ " + vida + "/" + vidaMax + " | ⚔️ " + ataque + " | 🛡️ " + defesa);
        if (atualCooldown > 0) {
            System.out.println("   ⏳ Cooldown: " + atualCooldown + " rodadas");
        }
        if (habilidade != null) {
            if (habilidade.estaPronta()) {
                System.out.println("   ✨ Habilidade: " + habilidade.getNome() + " [PRONTA]");
            } else {
                System.out.println("   ⏳ Habilidade: " + habilidade.getNome() + " [Cooldown: " + habilidade.getCooldownAtual() + "]");
            }
        }
    }

    @Override
    public String toString() {
        return nome + " (Nv." + nivel + " - " + tipo.getNome() + ")";
    }
}