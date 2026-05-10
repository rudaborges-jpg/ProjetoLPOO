package modelo;

public class Estagio {
    private int numero;
    private String nome;
    private int dificuldade;
    private Inimigo chefao;
    public Estagio(int numero, String nome, int dificuldade ) {
        this.numero = numero;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.chefao = null;
    }

    public Estagio(int numero, String nome, int dificuldade, int i, Inimigo chefao) {
        this.numero = numero;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.chefao = chefao;
    }

    public Estagio(int numero, String tronoCelestial, int dificuldade, int i) {
    }

    public int getNumero() { return numero; }
    public String getNome() { return nome; }
    public int getDificuldade() { return dificuldade; }
    public Inimigo getChefao() { return chefao; }
    public boolean ehChefao() { return chefao != null; }

    public void mostrarInfo() {
        System.out.println("\n" + "=".repeat(60));
        if (ehChefao()) {
            System.out.println("👑 ESTÁGIO " + numero + ": " + nome + " - CHEFÃO! 👑");
        } else {
            System.out.println("🌟 ESTÁGIO " + numero + ": " + nome + " 🌟");
        }
        System.out.println("=".repeat(60));
        System.out.println("📊 Dificuldade: " + dificuldade + "/10");
        System.out.println("=".repeat(60));
    }
}
