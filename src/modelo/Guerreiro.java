package modelo;

public abstract class Guerreiro extends Personagem {

    public Guerreiro() {
        super(PerTipo.GUERREIRO, "Guerreiro", 140, 28, 14);
    }
    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println("\n💪 " + nome + " usa FÚRIA DO GUERREIRO!");

        int dano = ataque + 15 + (nivel * 2);
        System.out.println("⚡ Ataque poderoso causa " + dano + " de dano!");
        alvo.tomarDano(dano);

        int reducaoDefesa = 3;
        alvo.defesa = Math.max(0, alvo.defesa - reducaoDefesa);
        System.out.println("🗣️ Grito de guerra! A defesa de " + alvo.getNome() + " foi reduzida em " + reducaoDefesa + "!");
    }

    public String getNomeHabilidade() {
        return "FÚRIA DO GUERREIRO";
    }


    public String getDescricaoHabilidade() {
        return "Causa dano massivo e reduz a defesa do inimigo em 3 pontos.";
    }
}
