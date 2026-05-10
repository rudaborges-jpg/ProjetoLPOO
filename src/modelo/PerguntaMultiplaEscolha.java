package modelo;

import java.util.List;

public class PerguntaMultiplaEscolha extends Pergunta {
    private List<String> opcoes;
    private String letraCorreta;

    public PerguntaMultiplaEscolha(int id, String texto, List<String> opcoes, String letraCorreta,
                                   Dificuldade dificuldade, PerTipo tipoPersonagem,
                                   String categoria, int estagioMinimo) {
        super(id, texto, getRespostaFromLetter(opcoes, letraCorreta), dificuldade,
                tipoPersonagem, categoria, estagioMinimo);
        this.opcoes = opcoes;
        this.letraCorreta = letraCorreta;
    }

    private static String getRespostaFromLetter(List<String> opcoes, String letra) {
        int index = letra.toUpperCase().charAt(0) - 'A';
        return opcoes.get(index);
    }

    public void exibir() {
        System.out.println("\n📖 " + getTexto());
        char letra = 'A';
        for (String opcao : opcoes) {
            System.out.println("   " + letra + ") " + opcao);
            letra++;
        }
        System.out.println("[Dificuldade: " + getDificuldade().getNome() + "]");
    }

    public List<String> getOpcoes() { return opcoes; }

    public String getLetraCorreta() { return letraCorreta; }
}
