package controle;

import modelo.*;

public class AvaliadorRespostas {

    public static boolean avaliar(Pergunta pergunta, String resposta) {
        if (pergunta == null || resposta == null) {
            return false;
        }

        if (pergunta instanceof PerguntaCompletarLacuna) {
            String respostaNormalizada = resposta.trim().toLowerCase();
            String corretaNormalizada = pergunta.getRespostaCorreta().trim().toLowerCase();

            return respostaNormalizada.equals(corretaNormalizada);
        }


        String respostaUpper = resposta.trim().toUpperCase();

        if (pergunta instanceof PerguntaMultiplaEscolha) {
            if (respostaUpper.matches("[A-D]")) {
                PerguntaMultiplaEscolha multipla = (PerguntaMultiplaEscolha) pergunta;
                int index = respostaUpper.charAt(0) - 'A';
                if (index >= 0 && index < multipla.getOpcoes().size()) {
                    return multipla.getOpcoes().get(index).equals(pergunta.getRespostaCorreta());
                }
            }
        }

        return respostaUpper.equals(pergunta.getRespostaCorreta().toUpperCase());
    }

    public static String getRespostaCorretaFormatada(Pergunta pergunta) {
        return pergunta.getRespostaCorreta();
    }
}