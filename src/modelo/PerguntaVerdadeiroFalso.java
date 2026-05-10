package modelo;

import java.util.Arrays;
import java.util.List;

public class PerguntaVerdadeiroFalso extends Pergunta {

    public PerguntaVerdadeiroFalso(int id, String texto, boolean respostaCorreta,
                                   Dificuldade dificuldade, PerTipo tipoPersonagem,
                                   String categoria, int estagioMinimo) {
        super(id, texto, respostaCorreta ? "V" : "F", dificuldade, tipoPersonagem, categoria, estagioMinimo);
    }

    public void exibir() {
        System.out.println("\n📖 " + getTexto());
        System.out.println("   V) Verdadeiro");
        System.out.println("   F) Falso");
        System.out.println("[Dificuldade: " + getDificuldade().getNome() + "]");
    }

    public List<String> getOpcoes() {
        return Arrays.asList("Verdadeiro", "Falso");
    }
}
