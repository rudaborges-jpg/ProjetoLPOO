package modelo;

import java.util.Random;

public abstract class Cacadora extends Personagem {
    private Random random;
    private double chanceCritico;

    public Cacadora() {
        super(PerTipo.CACADORA, "Caçadora", 110, 30, 12);
        this.random = new Random();
        this.chanceCritico = 0.30;
    }
    public void atacar(Personagem alvo) {
        int dano = ataque + (nivel * 2);
        boolean critico = false;

        if (random.nextDouble() < chanceCritico) {
            dano = (int)(dano * 1.5);
            critico = true;
            System.out.print("🎯 GOLPE CRÍTICO! ");
        }

        System.out.println("🏹 " + nome + " dispara uma flecha em " + alvo.getNome() + " causando " + dano + " de dano!");
        alvo.tomarDano(dano);
    }
    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println("\n🌿 " + nome + " usa CHUVA DE FLECHAS!");

        int dano = 45 + (nivel * 4);
        System.out.println("💥 Rajada de flechas causa " + dano + " de dano!");
        alvo.tomarDano(dano);

        System.out.println("🩸 O inimigo está sangrando!");
        alvo.tomarDano(10);
    }

    public String getNomeHabilidade() {
        return "CHUVA DE FLECHAS";
    }

    public String getDescricaoHabilidade() {
        return "Causa " + (45 + (nivel * 4)) + " de dano imediato + 10 de dano de sangramento. " +
                "Os ataques normais têm " + (int)(chanceCritico * 100) + "% de chance de causar dano crítico.";
    }
}
