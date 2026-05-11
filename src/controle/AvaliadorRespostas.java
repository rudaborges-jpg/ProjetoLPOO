package controle;

import modelo.*;
import java.text.Normalizer;

public class AvaliadorRespostas {

    public static boolean avaliar(Pergunta pergunta, String resposta) {
        if (pergunta == null || resposta == null) {
            return false;
        }

        if (pergunta instanceof PerguntaCompletarLacuna) {
            String respostaNormalizada = normalizarTexto(resposta);
            String corretaNormalizada = normalizarTexto(pergunta.getRespostaCorreta());
            return respostaNormalizada.equalsIgnoreCase(corretaNormalizada);
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

    private static String normalizarTexto(String texto) {
        if (texto == null) return "";

        String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        String minusculas = semAcentos.toLowerCase();

        String semHifen = minusculas.replace("-", " ")
                .replace("–", " ")
                .replace("—", " ")
                .replaceAll("\\s+", " ")
                .trim();

        return semHifen;
    }

    public static String getRespostaCorretaFormatada(Pergunta pergunta) {
        return pergunta.getRespostaCorreta();
    }
}