package modelo;

public class Estagio {
    private int numero;
    private String nome;
    private int dificuldade; // 1 a 10
    private int perguntasParaPassar; // quantas perguntas acertar para avançar
    private Inimigo chefao; // chefão do estágio (opcional, null se não for chefão)

    public Estagio(int numero, String nome, int dificuldade, int perguntasParaPassar) {
        this.numero = numero;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.perguntasParaPassar = perguntasParaPassar;
        this.chefao = null;
    }

    public Estagio(int numero, String nome, int dificuldade, int perguntasParaPassar, Inimigo chefao) {
        this.numero = numero;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.perguntasParaPassar = perguntasParaPassar;
        this.chefao = chefao;
    }

    public int getNumero() { return numero; }
    public String getNome() { return nome; }
    public int getDificuldade() { return dificuldade; }
    public int getPerguntasParaPassar() { return perguntasParaPassar; }
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
        System.out.println("🎯 Acertos necessários: " + perguntasParaPassar);
        System.out.println("=".repeat(60));
    }
}
