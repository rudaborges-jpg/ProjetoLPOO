package controle;

import modelo.*;
import java.util.*;

public class GerenciadorRotas {
    private Map<PerTipo, Rota> rotas;
    private Rota rotaAtual;

    public GerenciadorRotas() {
        this.rotas = new HashMap<>();
        criarTodasRotas();
    }

    private void criarTodasRotas() {
        Rota rotaPaladino = new Rota(PerTipo.PALADINO, "Caminho da Iluminação");

        rotaPaladino.adicionarEstagio(new Estagio(1, "Iniciação da Fé", 1, 3));
        rotaPaladino.adicionarEstagio(new Estagio(2, "Prova da Devoção", 2, 3));
        rotaPaladino.adicionarEstagio(new Estagio(3, "Julgamento Divino", 3, 4));
        rotaPaladino.adicionarEstagio(new Estagio(4, "Catedral das Sombras", 4, 4));
        rotaPaladino.adicionarEstagio(new Estagio(5, "Valquírias", 5, 4));
        rotaPaladino.adicionarEstagio(new Estagio(6, "Purgatório", 6, 5));
        rotaPaladino.adicionarEstagio(new Estagio(7, "Anjos Caídos", 7, 5));
        rotaPaladino.adicionarEstagio(new Estagio(8, "Trono Celestial", 8, 5));
        rotaPaladino.adicionarEstagio(new Estagio(9, "Arcanjo Miguel", 9, 5));
        Inimigo chefaoPaladino = new Inimigo("👑 METATRON - O Anjo Supremo 👑", 300, 45, 10);
        rotaPaladino.adicionarEstagio(new Estagio(10, "METATRON", 10, 5, chefaoPaladino));

        rotas.put(PerTipo.PALADINO, rotaPaladino);

        Rota rotaCacadora = new Rota(PerTipo.CACADORA, "Caminho da Predadora");

        rotaCacadora.adicionarEstagio(new Estagio(1, "Floresta dos Sussurros", 1, 3));
        rotaCacadora.adicionarEstagio(new Estagio(2, "Lago das Fadas", 2, 3));
        rotaCacadora.adicionarEstagio(new Estagio(3, "Montanha Gelada", 3, 4));
        rotaCacadora.adicionarEstagio(new Estagio(4, "Vulcão Adormecido", 4, 4));
        rotaCacadora.adicionarEstagio(new Estagio(5, "Pântano Maldito", 5, 4));
        rotaCacadora.adicionarEstagio(new Estagio(6, "Caverna dos Ursos", 6, 5));
        rotaCacadora.adicionarEstagio(new Estagio(7, "Templo da Natureza", 7, 5));
        rotaCacadora.adicionarEstagio(new Estagio(8, "Espírito da Floresta", 8, 5));
        rotaCacadora.adicionarEstagio(new Estagio(9, "Guardião dos Animais", 9, 5));
        Inimigo chefaoCacadora = new Inimigo("👑 FENRIR - O Lobo Gigante 👑", 280, 50, 10);
        rotaCacadora.adicionarEstagio(new Estagio(10, "FENRIR", 10, 5, chefaoCacadora));

        rotas.put(PerTipo.CACADORA, rotaCacadora);

        Rota rotaGuerreiro = new Rota(PerTipo.GUERREIRO, "Caminho da Glória");

        rotaGuerreiro.adicionarEstagio(new Estagio(1, "Campo de Treinamento", 1, 3));
        rotaGuerreiro.adicionarEstagio(new Estagio(2, "Arena dos Gladiadores", 2, 3));
        rotaGuerreiro.adicionarEstagio(new Estagio(3, "Castelo Sombrio", 3, 4));
        rotaGuerreiro.adicionarEstagio(new Estagio(4, "Campo de Batalha", 4, 4));
        rotaGuerreiro.adicionarEstagio(new Estagio(5, "Fortaleza Invencível", 5, 4));
        rotaGuerreiro.adicionarEstagio(new Estagio(6, "Vale dos Reis", 6, 5));
        rotaGuerreiro.adicionarEstagio(new Estagio(7, "Portão do Inferno", 7, 5));
        rotaGuerreiro.adicionarEstagio(new Estagio(8, "Monte dos Gigantes", 8, 5));
        rotaGuerreiro.adicionarEstagio(new Estagio(9, "Exército das Trevas", 9, 5));

        Inimigo chefaoGuerreiro = new Inimigo("👑 ODIN - O Pai de Todos 👑", 350, 55, 10);
        rotaGuerreiro.adicionarEstagio(new Estagio(10, "ODIN", 10, 5, chefaoGuerreiro));

        rotas.put(PerTipo.GUERREIRO, rotaGuerreiro);

        Rota rotaSabio = new Rota(PerTipo.SABIO, "Caminho do Conhecimento");

        rotaSabio.adicionarEstagio(new Estagio(1, "Biblioteca Antiga", 1, 3));
        rotaSabio.adicionarEstagio(new Estagio(2, "Observatório Estelar", 2, 3));
        rotaSabio.adicionarEstagio(new Estagio(3, "Laboratório Alquímico", 3, 4));
        rotaSabio.adicionarEstagio(new Estagio(4, "Academia dos Sábios", 4, 4));
        rotaSabio.adicionarEstagio(new Estagio(5, "Torre do Saber", 5, 4));
        rotaSabio.adicionarEstagio(new Estagio(6, "Museu Histórico", 6, 5));
        rotaSabio.adicionarEstagio(new Estagio(7, "Planetário", 7, 5));
        rotaSabio.adicionarEstagio(new Estagio(8, "Teatro Grego", 8, 5));
        rotaSabio.adicionarEstagio(new Estagio(9, "Oráculo de Delfos", 9, 5));

        Inimigo chefaoSabio = new Inimigo("👑 ATHENA - Deusa da Sabedoria 👑", 260, 48, 10);
        rotaSabio.adicionarEstagio(new Estagio(10, "ATHENA", 10, 5, chefaoSabio));

        rotas.put(PerTipo.SABIO, rotaSabio);

        Rota rotaArcanista = new Rota(PerTipo.ARCANISTA, "Caminho Místico");

        rotaArcanista.adicionarEstagio(new Estagio(1, "Torre de Marfim", 1, 3));
        rotaArcanista.adicionarEstagio(new Estagio(2, "Círculo Mágico", 2, 3));
        rotaArcanista.adicionarEstagio(new Estagio(3, "Floresta Encantada", 3, 4));
        rotaArcanista.adicionarEstagio(new Estagio(4, "Labirinto Mítico", 4, 4));
        rotaArcanista.adicionarEstagio(new Estagio(5, "Castelo Flutuante", 5, 4));
        rotaArcanista.adicionarEstagio(new Estagio(6, "Plano Astral", 6, 5));
        rotaArcanista.adicionarEstagio(new Estagio(7, "Reino dos Deuses", 7, 5));
        rotaArcanista.adicionarEstagio(new Estagio(8, "Caverna da Magia", 8, 5));
        rotaArcanista.adicionarEstagio(new Estagio(9, "Portal Dimensional", 9, 5));

        Inimigo chefaoArcanista = new Inimigo("👑 LOKI - O Deus da Trapaça 👑", 290, 52, 10);
        rotaArcanista.adicionarEstagio(new Estagio(10, "LOKI", 10, 5, chefaoArcanista));

        rotas.put(PerTipo.ARCANISTA, rotaArcanista);
    }

    public Rota getRota(PerTipo tipo) {
        return rotas.get(tipo);
    }

    public void setRotaAtual(Rota rota) {
        this.rotaAtual = rota;
    }

    public Rota getRotaAtual() {
        return rotaAtual;
    }
}