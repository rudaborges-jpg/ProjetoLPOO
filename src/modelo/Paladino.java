package modelo;

public abstract class Paladino extends Personagem {

    public Paladino() {
        super(PerTipo.PALADINO, "Paladino", 150, 22, 18);
    }

    public void usarHabilidadeEspecial(Personagem  alvo) {
        System.out.println("\n🛡️ " + nome + " invoca o ESPÍRITO SAGRADO!");
        int cura = 40 + (nivel * 5);
        curar(cura);
        int dano = 25 + (nivel * 3);
        System.out.println("⚡ Luz divina atinge " + alvo.getNome() + " causando " + dano + " de dano!");
        alvo.tomarDano(dano);
    }

    public String getNomeHabilidade() {
        return "ESPÍRITO SAGRADO";
    }
    public String getDescricaoHabilidade() {
        return "Cura " + (40 + (nivel * 5)) + " de vida e causa " + (25 + (nivel * 3)) + " de dano ao inimigo.";
    }
}
