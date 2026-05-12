package modelo;

public  class Paladino extends Personagem {
    private int poderDivino;
    private int poderDivinoMaximo;
    private int feAbencoada;

    public Paladino() {
        super(PerTipo.PALADINO, "Paladino", 150, 22, 18);
        this.poderDivinoMaximo = 100;
        this.poderDivino = 100;
        this.feAbencoada = 0;

    }

    public int getPoderDivino() { return poderDivino; }
    public int getPoderDivinoMaximo() { return poderDivinoMaximo; }
    public int getFeAbencoada() { return feAbencoada; }

    public boolean consumirPoderDivino(int quantidade) {
        if (poderDivino >= quantidade) {
            poderDivino -= quantidade;
            feAbencoada++;
            System.out.println("✨ Poder Divino consumido: " + quantidade +
                    " (Restante: " + poderDivino + "/" + poderDivinoMaximo + ")");
            return true;
        }
        System.out.println("❌ Poder Divino insuficiente! (" + poderDivino + "/" + poderDivinoMaximo + ")");
        return false;
    }

    public void recarregarPorEstagio(int estagioNumero) {
        int recarga = estagioNumero * 10;
        poderDivino = Math.min(poderDivinoMaximo, poderDivino + recarga);
        System.out.println("🙏 Poder Divino recarregado em +" + recarga +
                " (Agora: " + poderDivino + ")");
    }

    public void recarregarPorNivel(int novoNivel) {
        poderDivinoMaximo += 10;  // Aumenta o máximo a cada nível
        poderDivino = poderDivinoMaximo;  // Recarrega completamente
        System.out.println("🌟 Poder Divino máximo aumentou para " + poderDivinoMaximo +
                " e foi completamente restaurado!");
    }

    public void usarHabilidadeEspecial(Personagem  alvo) {
        System.out.println("\n🛡️ " + nome + " invoca o ESPÍRITO SAGRADO!");
        int cura = 40 + (nivel * 5);
        curar(cura);
        int dano = 25 + (nivel * 3);
        System.out.println("⚡ Luz divina atinge " + alvo.getNome() + " causando " + dano + " de dano!");
        alvo.tomarDano(dano);
    }

    @Override
    public String getNomeHabilididade() {
        return "";
    }

    public String getNomeHabilidade() {
        return "ESPÍRITO SAGRADO";
    }
    public String getDescricaoHabilidade() {
        return "Cura " + (40 + (nivel * 5)) + " de vida e causa " + (25 + (nivel * 3)) + " de dano ao inimigo.";
    }
}
