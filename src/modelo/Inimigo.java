package modelo;

public class Inimigo {
    private String nome;
    private int vida;
    private int vidaMax;
    private int ataque;
    private int nivel;

    public Inimigo(String nome, int vida, int ataque, int nivel) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMax = vida;
        this.ataque = ataque;
        this.nivel = nivel;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getVidaMax() { return vidaMax; }
    public int getAtaque() { return ataque; }
    public int getNivel() { return nivel; }

    public void tomarDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
        System.out.println("💀 " + nome + " perdeu " + dano + " de vida! (❤️ " + vida + "/" + vidaMax + ")");
    }

    public boolean vivo() { return vida > 0; }

    public void mostrarStatus() {
        System.out.println("👾 " + nome + " | ❤️ " + vida + "/" + vidaMax + " | ⚔️ " + ataque);
    }
}
