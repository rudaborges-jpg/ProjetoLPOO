package modelo;

public class Sabio extends Personagem {
    private int mana;
    private int manaMaxima;

    public Sabio() {
        super(PerTipo.SABIO, "Sábio", 100, 25, 10);
        this.manaMaxima = 100;
        this.mana = 100;
    }

    public int getMana() { return mana; }
    public int getManaMaxima() { return manaMaxima; }

    private boolean usarMana(int quantidade) {
        if (mana >= quantidade) {
            mana -= quantidade;
            return true;
        }
        System.out.println("❌ Mana insuficiente! (Mana: " + mana + "/" + manaMaxima + ")");
        return false;
    }

    private void recuperarMana(int quantidade) {
        mana += quantidade;
        if (mana > manaMaxima) mana = manaMaxima;
        System.out.println("🔮 " + nome + " recuperou " + quantidade + " de mana! (Mana: " + mana + "/" + manaMaxima + ")");
    }


    public int ataqueInimigo(Personagem alvo) {
        if (usarMana(10)) {
            int dano = ataque + (nivel * 2) + 10;
            System.out.println("🔮 " + nome + " lança MISSIL MÁGICO causando " + dano + " de dano!");
            alvo.tomarDano(dano);
            return dano;
        } else {
            return super.ataqueInimigo(alvo);
        }
    }



    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println("\n📜 " + nome + " conjura SABEDORIA ANCESTRAL!");
        if (usarMana(30)) {
            int dano = 40 + (nivel * 3);
            System.out.println("💥 Explosão arcana causa " + dano + " de dano!");
            alvo.tomarDano(dano);
            int cura = 30 + (nivel * 2);
            curar(cura);
            recuperarMana(20);
        }
    }

    public String getNomeHabilididade() {
        return "SABEDORIA ANCESTRAL";
    }

    public String getDescricaoHabilidade() {
        return "Causa " + (40 + (nivel * 3)) + " de dano, cura " + (30 + (nivel * 2)) +
                " de vida e recupera 20 de mana. Custa 30 de mana.";
    }



    public void mostrarStatus() {
        super.mostrarStatus();
        System.out.println("   🔮 Mana: " + mana + "/" + manaMaxima);
    }
}