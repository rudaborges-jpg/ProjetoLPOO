package controle;

import modelo.Pergunta;
import modelo.PerguntaMultiplaEscolha;

public class AvaliadorRespostas {
    public static boolean avaliar(Pergunta pergunta, String resposta) {
        if (pergunta == null || resposta == null) {
            return false;
        }

        String respostaNormalizada = resposta.trim().toUpperCase();

        if (pergunta instanceof PerguntaMultiplaEscolha) {
            PerguntaMultiplaEscolha multipla = (PerguntaMultiplaEscolha) pergunta;

            if (respostaNormalizada.matches("[A-D]")) {
                int index = respostaNormalizada.charAt(0) - 'A';
                if (index >= 0 && index < multipla.getOpcoes().size()) {
                    String textoOpcao = multipla.getOpcoes().get(index);
                    return textoOpcao.equals(pergunta.getRespostaCorreta());
                }
            }
        }

        return respostaNormalizada.equals(pergunta.getRespostaCorreta().toUpperCase());
    }

    public static String getLetraRespostaCorreta(Pergunta pergunta) {
        if (pergunta instanceof PerguntaMultiplaEscolha) {
            PerguntaMultiplaEscolha multipla = (PerguntaMultiplaEscolha) pergunta;
            String correta = pergunta.getRespostaCorreta();

            for (int i = 0; i < multipla.getOpcoes().size(); i++) {
                if (multipla.getOpcoes().get(i).equals(correta)) {
                    return String.valueOf((char) ('A' + i));
                }
            }
        }
        return pergunta.getRespostaCorreta();
    }

    public static String getRespostaCorretaFormatada(Pergunta pergunta) {
        if (pergunta instanceof PerguntaMultiplaEscolha) {
            String letra = getLetraRespostaCorreta(pergunta);
            String texto = pergunta.getRespostaCorreta();
            return letra + ") " + texto;
        }
        return pergunta.getRespostaCorreta();
    }
}
