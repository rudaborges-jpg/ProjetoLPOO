package modelo;

import java.util.Random;

public abstract class Arcanista extends Personagem {
    private int poderArcano;
    private int poderMaximo;
    private Random random;
    private String[] elementos;

    public Arcanista() {
        super(PerTipo.ARCANISTA, "Arcanista", 95, 32, 8);
        this.poderArcano = 0;
        this.poderMaximo = 5;
        this.random = new Random();
        this.elementos = new String[]{"🔥 Fogo", "❄️ Gelo", "⚡ Raio", "🌑 Sombra", "✨ Luz"};
    }

    private void acumularPoder() {
        if (poderArcano < poderMaximo) {
            poderArcano++;
        }
        System.out.println("✨ Poder Arcano acumulado: " + poderArcano + "/" + poderMaximo);
    }

    private void resetarPoder() {
        poderArcano = 0;
        System.out.println("🌀 Poder Arcano foi resetado!");
    }

    public void atacar(Personagem alvo) {

        String elemento = elementos[random.nextInt(elementos.length)];

        int dano = ataque + (nivel * 2) + (poderArcano * 3);

        System.out.println("🔮 " + nome + " conjura " + elemento + " causando " + dano + " de dano!");
        alvo.tomarDano(dano);

        acumularPoder();
    }
}