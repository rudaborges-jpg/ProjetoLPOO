package controle;

import modelo.*;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por avaliar as respostas do jogador.
 *
 * Características:
 * - Normalização avançada de texto para perguntas de lacuna
 * - Distância de Levenshtein para tolerância a erros de digitação
 * - Mapeamento de variações comuns (números, abreviações)
 * - Tratamento especial para múltipla escolha e V/F
 *
 * @author Grupo Baquara
 * @version 3.0
 */
public class AvaliadorRespostas {

    // Mapeamento de variações comuns
    private static final Map<String, String> VARIACOES_COMUNS = new HashMap<>();

    static {
        // Números por extenso
        VARIACOES_COMUNS.put("1", "um");
        VARIACOES_COMUNS.put("2", "dois");
        VARIACOES_COMUNS.put("3", "tres");
        VARIACOES_COMUNS.put("4", "quatro");
        VARIACOES_COMUNS.put("5", "cinco");
        VARIACOES_COMUNS.put("6", "seis");
        VARIACOES_COMUNS.put("7", "sete");
        VARIACOES_COMUNS.put("8", "oito");
        VARIACOES_COMUNS.put("9", "nove");
        VARIACOES_COMUNS.put("10", "dez");
        VARIACOES_COMUNS.put("12", "doze");
        VARIACOES_COMUNS.put("150", "cento e cinquenta");

        // Abreviações comuns da capoeira
        VARIACOES_COMUNS.put("sto", "sao");
        VARIACOES_COMUNS.put("s.", "sao");
        VARIACOES_COMUNS.put("v.", "vicente");
        VARIACOES_COMUNS.put("m.", "mestre");
        VARIACOES_COMUNS.put("mte", "mestre");
    }

    /**
     * Avalia se a resposta do jogador está correta
     *
     * @param pergunta Pergunta a ser avaliada
     * @param resposta Resposta fornecida pelo jogador
     * @return true se a resposta estiver correta
     */
    public static boolean avaliar(Pergunta pergunta, String resposta) {
        if (pergunta == null || resposta == null || resposta.trim().isEmpty()) {
            return false;
        }

        // Verifica se o tempo esgotou
        if (resposta.equals("TEMPO_ESGOTADO")) {
            return false;
        }

        // Tratamento específico para cada tipo de pergunta
        if (pergunta instanceof PerguntaCompletarLacuna) {
            return avaliarLacuna(pergunta, resposta);
        } else if (pergunta instanceof PerguntaMultiplaEscolha) {
            return avaliarMultiplaEscolha((PerguntaMultiplaEscolha) pergunta, resposta);
        } else if (pergunta instanceof PerguntaVerdadeiroFalso) {
            return avaliarVerdadeiroFalso(pergunta, resposta);
        }

        // Fallback - comparação direta
        return resposta.trim().equalsIgnoreCase(pergunta.getRespostaCorreta().trim());
    }

    /**
     * Avalia perguntas de completar lacuna com tolerância flexível
     */
    private static boolean avaliarLacuna(Pergunta pergunta, String respostaJogador) {
        String respostaNormalizada = normalizarTextoAvancado(respostaJogador);
        String corretaNormalizada = normalizarTextoAvancado(pergunta.getRespostaCorreta());

        // 1. Verificação exata após normalização
        if (respostaNormalizada.equals(corretaNormalizada)) {
            return true;
        }

        // 2. Verificação de "contém" (para respostas que incluem palavras extras)
        if (verificarContem(respostaNormalizada, corretaNormalizada)) {
            return true;
        }

        // 3. Distância de Levenshtein (tolerância a pequenos erros de digitação)
        if (verificarSimilaridade(respostaNormalizada, corretaNormalizada)) {
            return true;
        }

        // 4. Verificação com variações comuns
        if (verificarVariacoesComuns(respostaNormalizada, corretaNormalizada)) {
            return true;
        }

        return false;
    }

    /**
     * Avalia perguntas de múltipla escolha
     */
    private static boolean avaliarMultiplaEscolha(PerguntaMultiplaEscolha pergunta, String resposta) {
        String respostaUpper = resposta.trim().toUpperCase();

        // Aceita tanto a letra quanto o texto completo
        if (respostaUpper.matches("[A-D]")) {
            int index = respostaUpper.charAt(0) - 'A';
            if (index >= 0 && index < pergunta.getOpcoes().size()) {
                String opcaoSelecionada = pergunta.getOpcoes().get(index);
                return opcaoSelecionada.equals(pergunta.getRespostaCorreta());
            }
        }

        // Se digitou o texto completo, normaliza e compara
        String respostaNormalizada = normalizarTextoAvancado(resposta);
        String corretaNormalizada = normalizarTextoAvancado(pergunta.getRespostaCorreta());

        return respostaNormalizada.equals(corretaNormalizada) ||
                respostaNormalizada.contains(corretaNormalizada);
    }

    /**
     * Avalia perguntas de verdadeiro ou falso
     */
    private static boolean avaliarVerdadeiroFalso(Pergunta pergunta, String resposta) {
        String respostaUpper = resposta.trim().toUpperCase();

        // Aceita V/F, Verdadeiro/Falso, Sim/Não, Yes/No
        boolean respostaBool = respostaUpper.equals("V") ||
                respostaUpper.equals("VERDADEIRO") ||
                respostaUpper.equals("SIM") ||
                respostaUpper.equals("YES") ||
                respostaUpper.equals("TRUE");

        boolean corretaBool = pergunta.getRespostaCorreta().equals("V") ||
                pergunta.getRespostaCorreta().equals("VERDADEIRO");

        return respostaBool == corretaBool;
    }

    /**
     * Normalização avançada de texto para comparação flexível
     */
    private static String normalizarTextoAvancado(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "";
        }

        String normalizado = texto.trim().toLowerCase();

        // Remove acentos (normalização Unicode NFD + remoção de marcas)
        normalizado = Normalizer.normalize(normalizado, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        // Substitui diferentes tipos de separadores por espaço
        normalizado = normalizado.replace("-", " ")
                .replace("–", " ")
                .replace("—", " ")
                .replace("_", " ")
                .replace("'", " ")  // Trata apóstrofo como separador
                .replace("`", " ")
                .replace("´", " ");

        // Remove pontuação (mas mantém caracteres alfanuméricos)
        normalizado = normalizado.replaceAll("[.,;:!?\"'«»()\\[\\]{}@#$%&*=+\\/\\\\]", " ");

        // Remove artigos e preposições comuns no início
        normalizado = normalizado.replaceAll("^(o |a |os |as |um |uma |uns |umas |do |da |dos |das |no |na |nos |nas |pelo |pela )", "");

        // Substitui múltiplos espaços por um único espaço
        normalizado = normalizado.replaceAll("\\s+", " ");

        // Remove espaços no início e fim
        normalizado = normalizado.trim();

        return normalizado;
    }

    /**
     * Verifica se uma string contém a outra (considerando tamanhos similares)
     */
    private static boolean verificarContem(String resposta, String correta) {
        if (resposta.isEmpty() || correta.isEmpty()) {
            return false;
        }

        // Se a resposta contém a correta
        if (resposta.contains(correta)) {
            // Verifica se não é uma correspondência muito curta
            double proporcao = (double) correta.length() / resposta.length();
            return proporcao >= 0.5; // Pelo menos 50% da resposta é a correta
        }

        // Se a correta contém a resposta
        if (correta.contains(resposta)) {
            double proporcao = (double) resposta.length() / correta.length();
            return proporcao >= 0.6; // Pelo menos 60% da correta foi respondida
        }

        return false;
    }

    /**
     * Verifica similaridade usando distância de Levenshtein
     */
    private static boolean verificarSimilaridade(String resposta, String correta) {
        int distancia = calcularDistanciaLevenshtein(resposta, correta);
        int tamanhoMaximo = Math.max(resposta.length(), correta.length());

        if (tamanhoMaximo == 0) {
            return true;
        }

        // Calcula a similaridade como porcentagem
        double similaridade = 1.0 - ((double) distancia / tamanhoMaximo);

        // Aceita se a similaridade for maior que:
        // - 80% para respostas curtas (até 5 caracteres)
        // - 75% para respostas médias (6-15 caracteres)
        // - 70% para respostas longas (16+ caracteres)
        double limite;
        if (tamanhoMaximo <= 5) {
            limite = 0.80;
        } else if (tamanhoMaximo <= 15) {
            limite = 0.75;
        } else {
            limite = 0.70;
        }

        return similaridade >= limite;
    }

    /**
     * Verifica variações comuns mapeadas
     */
    private static boolean verificarVariacoesComuns(String resposta, String correta) {
        // Tenta expandir abreviações na resposta
        String respostaExpandida = expandirVariacoes(resposta);
        String corretaExpandida = expandirVariacoes(correta);

        return respostaExpandida.equals(corretaExpandida) ||
                respostaExpandida.contains(corretaExpandida) ||
                corretaExpandida.contains(respostaExpandida);
    }

    /**
     * Expande variações comuns no texto
     */
    private static String expandirVariacoes(String texto) {
        String[] palavras = texto.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            String expansao = VARIACOES_COMUNS.get(palavra);
            resultado.append(expansao != null ? expansao : palavra).append(" ");
        }

        return resultado.toString().trim();
    }

    /**
     * Calcula a distância de Levenshtein entre duas strings
     * (número mínimo de operações para transformar uma string na outra)
     */
    private static int calcularDistanciaLevenshtein(String s1, String s2) {
        if (s1.isEmpty()) return s2.length();
        if (s2.isEmpty()) return s1.length();

        int[][] matriz = new int[s1.length() + 1][s2.length() + 1];

        // Inicializa primeira linha e coluna
        for (int i = 0; i <= s1.length(); i++) {
            matriz[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            matriz[0][j] = j;
        }

        // Preenche a matriz
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int custo = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;

                matriz[i][j] = Math.min(
                        Math.min(
                                matriz[i - 1][j] + 1,      // Deleção
                                matriz[i][j - 1] + 1       // Inserção
                        ),
                        matriz[i - 1][j - 1] + custo    // Substituição
                );
            }
        }

        return matriz[s1.length()][s2.length()];
    }

    /**
     * Retorna a resposta correta formatada para exibição
     */
    public static String getRespostaCorretaFormatada(Pergunta pergunta) {
        if (pergunta instanceof PerguntaMultiplaEscolha) {
            PerguntaMultiplaEscolha multipla = (PerguntaMultiplaEscolha) pergunta;
            return multipla.getLetraCorreta() + ") " + pergunta.getRespostaCorreta();
        }
        return pergunta.getRespostaCorreta();
    }
}