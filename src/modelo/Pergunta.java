package modelo;

import java.util.List;

public abstract class Pergunta {
    protected int id;
    protected String texto;
    protected String respostaCorreta;
    protected Dificuldade dificuldade;
    protected PerTipo tipoPersonagem;
    protected String categoria;
    protected int estagioMinimo; // a partir de qual estágio essa pergunta pode aparecer

    public enum Dificuldade {
        FACIL("Fácil", 10, 1),    // estágios 1-3
        MEDIO("Médio", 20, 4),    // estágios 4-7
        DIFICIL("Difícil", 35, 8); // estágios 8-10

        private String nome;
        private int danoBase;
        private int estagioMinimo;

        Dificuldade(String nome, int danoBase, int estagioMinimo) {
            this.nome = nome;
            this.danoBase = danoBase;
            this.estagioMinimo = estagioMinimo;
        }

        public String getNome() { return nome; }
        public int getDanoBase() { return danoBase; }
        public int getEstagioMinimo() { return estagioMinimo; }
    }

    public Pergunta(int id, String texto, String respostaCorreta, Dificuldade dificuldade,
                    PerTipo tipoPersonagem, String categoria, int estagioMinimo) {
        this.id = id;
        this.texto = texto;
        this.respostaCorreta = respostaCorreta;
        this.dificuldade = dificuldade;
        this.tipoPersonagem = tipoPersonagem;
        this.categoria = categoria;
        this.estagioMinimo = estagioMinimo;
    }

    public int getId() { return id; }
    public String getTexto() { return texto; }
    public String getRespostaCorreta() { return respostaCorreta; }
    public Dificuldade getDificuldade() { return dificuldade; }
    public PerTipo getTipoPersonagem() { return tipoPersonagem; }
    public String getCategoria() { return categoria; }
    public int getEstagioMinimo() { return estagioMinimo; }

    public boolean isAdequadaParaEstagio(int estagioNumero) {
        return estagioNumero >= estagioMinimo;
    }

    public abstract void exibir();
    public abstract List<String> getOpcoes();
}