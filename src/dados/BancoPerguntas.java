package dados;

import modelo.*;
import modelo.Pergunta.Dificuldade;
import java.util.*;

public class BancoPerguntas {
    private Map<PerTipo, List<Pergunta>> perguntasPorPersonagem;
    private Map<PerTipo, Map<Dificuldade, List<Pergunta>>> perguntasPorDificuldade;
    private Random random;
    private int proximoId;

    public BancoPerguntas() {
        this.perguntasPorPersonagem = new HashMap<>();
        this.perguntasPorDificuldade = new HashMap<>();
        this.random = new Random();
        this.proximoId = 1;

        // Inicializar estruturas
        for (PerTipo tipo : PerTipo.values()) {
            perguntasPorPersonagem.put(tipo, new ArrayList<>());
            perguntasPorDificuldade.put(tipo, new HashMap<>());
            for (Dificuldade diff : Dificuldade.values()) {
                perguntasPorDificuldade.get(tipo).put(diff, new ArrayList<>());
            }
        }

        // CARREGAR PERGUNTAS DO PALADINO
        carregarPerguntasPaladino();
        carregarPerguntasCacadora();
        carregarPerguntasGuerreiro();
        carregarPerguntasSabio();
        carregarPerguntasArcanista();

        System.out.println("✅ Banco carregado com " + getTotalPerguntas() + " perguntas!");
        mostrarEstatisticas();
    }
    private void carregarPerguntasPaladino() {
        carregarPaladinoFacilMultiplaEscolha();
        carregarPaladinoFacilVerdadeiroFalso();
        carregarPaladinoFacilLacuna();

        carregarPaladinoMedioMultiplaEscolha();
        carregarPaladinoMedioVerdadeiroFalso();
        carregarPaladinoMedioLacuna();

        carregarPaladinoDificilMultiplaEscolha();
        carregarPaladinoDificilVerdadeiroFalso();
        carregarPaladinoDificilLacuna();
    }


    private void carregarPaladinoFacilMultiplaEscolha() {
        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual é o livro sagrado do Cristianismo?",
                Arrays.asList("Torá", "Alcorão", "Bíblia", "Vedas"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem os cristãos acreditam ser o Filho de Deus?",
                Arrays.asList("Maomé", "Buda", "Jesus Cristo", "Moisés"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quantos apóstolos Jesus escolheu?",
                Arrays.asList("10", "12", "14", "7"), "B", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual o nome da mãe de Jesus?",
                Arrays.asList("Marta", "Madalena", "Maria", "Ana"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Onde Jesus nasceu?",
                Arrays.asList("Jerusalém", "Nazaré", "Belém", "Cafarnaum"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual cidade é sede do Papa?",
                Arrays.asList("Roma", "Jerusalém", "Vaticano", "Milão"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual o primeiro livro da Bíblia?",
                Arrays.asList("Êxodo", "Levítico", "Gênesis", "Números"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem escreveu a maior parte dos Salmos?",
                Arrays.asList("Salomão", "Moisés", "Davi", "Abraão"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que significa a palavra 'Cristo'?",
                Arrays.asList("Salvador", "Ungido", "Rei", "Profeta"), "B", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual o nome do anjo que anunciou o nascimento de Jesus?",
                Arrays.asList("Miguel", "Rafael", "Gabriel", "Uriel"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Onde Jesus foi crucificado?",
                Arrays.asList("Jardim do Getsêmani", "Monte das Oliveiras", "Calvário", "Monte Sinai"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem negou Jesus três vezes?",
                Arrays.asList("Judas", "João", "Pedro", "Tiago"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que aconteceu no terceiro dia após a morte de Jesus?",
                Arrays.asList("Ascensão", "Transfiguração", "Ressurreição", "Pentecostes"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual sacramento é considerado o 'pão da vida'?",
                Arrays.asList("Batismo", "Crisma", "Eucaristia", "Penitência"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem escreveu a maioria das cartas do Novo Testamento?",
                Arrays.asList("Pedro", "João", "Paulo", "Tiago"), "C", "Cristianismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual é a principal religião de matriz africana no Brasil?",
                Arrays.asList("Quimbanda", "Candomblé", "Catimbó", "Xangô"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que são os Orixás?",
                Arrays.asList("Espíritos malignos", "Deuses ou divindades", "Sacerdotes", "Rituais"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual Orixá é conhecido como a 'Mãe das Águas'?",
                Arrays.asList("Iansã", "Iemanjá", "Oxum", "Nanã"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual Orixá é associado aos raios, trovões e à justiça?",
                Arrays.asList("Ogum", "Xangô", "Oxóssi", "Omulu"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "No sincretismo brasileiro, qual Orixá foi associado a São Jorge?",
                Arrays.asList("Oxalá", "Xangô", "Ogum", "Oxóssi"), "C", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que é a Umbanda?",
                Arrays.asList("Seita africana", "Religião sincrética brasileira", "Ritual indígena", "Dança religiosa"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual Orixá é o rei de Ketu e considerado o Orixá da paz e da criação?",
                Arrays.asList("Oxalá", "Xangô", "Ogum", "Ifá"), "A", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual Orixá é o caçador e senhor das matas?",
                Arrays.asList("Oxóssi", "Ogum", "Omulu", "Xangô"), "A", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Iansã é Orixá de qual elemento?",
                Arrays.asList("Fogo", "Ventos e tempestades", "Água doce", "Terra"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual entidade da Umbanda é conhecida como 'povo da rua' ou 'povo de rua'?",
                Arrays.asList("Orixás", "Caboclos", "Exus", "Pretos-velhos"), "C", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem são os Pretos-Velhos na Umbanda?",
                Arrays.asList("Orixás antigos", "Espíritos de escravizados idosos", "Guerreiros africanos", "Crianças espíritas"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que é o 'Axé' no Candomblé?",
                Arrays.asList("Dança sagrada", "Energia vital / força divina", "Ritual de iniciação", "Oferenda"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual Orixá é o senhor da cura e das doenças (associado à terra e à morte)?",
                Arrays.asList("Obaluaiê/Omulu", "Oxumarê", "Logunedê", "Ossain"), "A", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual Orixá é o senhor das folhas e da sabedoria vegetal?",
                Arrays.asList("Oxalá", "Ossain", "Xangô", "Oxum"), "B", "Afro-Brasileira", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "No Candomblé, o que é um 'Barracão' ou 'Ilê'?",
                Arrays.asList("Oferenda", "Terreiro / Casa de culto", "Toque de atabaque", "Vestimenta sagrada"), "B", "Afro-Brasileira", 1);

        // BUDISMO (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem é o fundador do Budismo?",
                Arrays.asList("Confúcio", "Lao Tsé", "Sidarta Gautama", "Dalai Lama"), "C", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que representa o Nirvana no Budismo?",
                Arrays.asList("Paraíso", "Iluminação / Libertação", "Reencarnação", "Sofrimento"), "B", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quantas são as Nobres Verdades do Budismo?",
                Arrays.asList("4", "6", "8", "10"), "A", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual é a oitava parte do Caminho Óctuplo?",
                Arrays.asList("Fala correta", "Concentração correta", "Ação correta", "Intenção correta"), "B", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que significa a palavra 'Budha' (Buda)?",
                Arrays.asList("O iluminado", "O sofredor", "O mestre", "O meditador"), "A", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que é o Dharma no Budismo?",
                Arrays.asList("Roda da vida", "Ensinamentos do Buda", "Templo sagrado", "Monge itinerante"), "B", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O símbolo da 'Roda do Dharma' (Dharmachakra) tem quantos raios normalmente?",
                Arrays.asList("4", "6", "8", "10"), "C", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual conceito budista significa 'ações têm consequências'?",
                Arrays.asList("Samsara", "Nirvana", "Karma", "Dukkha"), "C", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que significa 'Dukkha' no Budismo?",
                Arrays.asList("Sofrimento / insatisfação", "Alegria suprema", "Compaixão", "Vazio"), "A", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Praticar meditação sentado é chamado de:",
                Arrays.asList("Vipassana", "Zazen (ou meditação sentada)", "Mantra", "Yoga"), "B", "Budismo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual é a Trindade principal do Hinduísmo (Trimurti)?",
                Arrays.asList("Shiva, Vishnu, Brahma", "Rama, Krishna, Ganesha", "Indra, Agni, Surya", "Lakshmi, Parvati, Sarasvati"), "A", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual o conceito de ciclo de renascimento no Hinduísmo?",
                Arrays.asList("Karma", "Samsara", "Moksha", "Dharma"), "B", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem é o deus com cabeça de elefante?",
                Arrays.asList("Shiva", "Vishnu", "Ganesha", "Hanuman"), "C", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que o conceito de 'Karma' representa?",
                Arrays.asList("Destino", "Ação e consequência", "Dever", "Libertação"), "B", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual é o livro sagrado mais antigo do Hinduísmo?",
                Arrays.asList("Bagavad Gita", "Ramayana", "Vedas", "Upanishads"), "C", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem é o deus preservador e protetor do universo?",
                Arrays.asList("Brahma", "Shiva", "Vishnu", "Indra"), "C", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Quem é o deus da destruição e transformação?",
                Arrays.asList("Brahma", "Shiva", "Vishnu", "Krishna"), "B", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual é a deusa do conhecimento, música e artes?",
                Arrays.asList("Lakshmi", "Parvati", "Durga", "Sarasvati"), "D", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "O que significa 'Moksha'?",
                Arrays.asList("Dever religioso", "Libertação do ciclo de renascimento", "Yoga", "Meditação"), "B", "Hinduísmo", 1);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.FACIL,
                "Qual é o famoso poema épico que conta a história do príncipe Rama?",
                Arrays.asList("Mahabharata", "Ramayana", "Puranas", "Vedas"), "B", "Hinduísmo", 1);
    }


    private void carregarPaladinoFacilVerdadeiroFalso() {

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Natal celebra o nascimento de Jesus Cristo.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "A Sexta-Feira Santa celebra a ressurreição de Jesus.", false, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O domingo de Páscoa celebra a ressurreição de Jesus.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Pedro era pescador antes de seguir Jesus.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Jesus nasceu na cidade de Jerusalém.", false, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "João Batista batizou Jesus no rio Jordão.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Judas Iscariotes foi o apóstolo que negou Jesus três vezes.", false, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "A Bíblia é composta apenas pelo Novo Testamento.", false, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Moisés recebeu os 10 Mandamentos no Monte Sinai.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O livro de Apocalipse é o último livro da Bíblia.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Maria Madalena foi a primeira pessoa a ver Jesus ressuscitado.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Jesus andou sobre as águas de acordo com a Bíblia.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Espírito Santo descendeu sobre os apóstolos no Natal.", false, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O batismo é um dos sacramentos do Cristianismo.", true, "Cristianismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "A cidade de Belém fica na região da Judeia.", true, "Cristianismo", 1);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Candomblé é uma religião de matriz africana.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Iemanjá é o Orixá dos raios e trovões.", false, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Na Umbanda, os Caboclos representam espíritos de indígenas brasileiros.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Oxalá é considerado o Orixá da paz e da criação no Candomblé.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Ogum é o Orixá da guerra, tecnologia e ferreiro.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "A Umbanda é uma religião puramente africana sem influências.", false, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Orixás são considerados deuses únicos e não se comunicam com humanos.", false, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O 'atabaque' é um instrumento musical usado nos terreiros.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Exu é o Orixá mensageiro, guardião dos caminhos.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Oxum é Orixá das águas doces, fertilidade e amor.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Nanã é Orixá das águas salgadas.", false, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "No sincretismo, Iemanjá é associada à Nossa Senhora dos Navegantes.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Acarajé é tradicionalmente oferecido a Iansã.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Os 'Pretos-Velhos' na Umbanda são espíritos que transmitem sabedoria e humildade.", true, "Afro-Brasileira", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Exu é sempre visto como uma entidade maligna e demoníaca.", false, "Afro-Brasileira", 1);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Budismo surgiu na Índia.", true, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Sidarta Gautama era um príncipe antes de se tornar Buda.", true, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Budismo acredita em um deus criador supremo.", false, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Dalai Lama é o líder máximo de todas as tradições budistas.", false, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "A meditação é uma prática central no Budismo.", true, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Budismo não acredita em reencarnação.", false, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O conceito de 'Karma' no Budismo significa que ações têm consequências.", true, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Buda é considerado um deus no Budismo.", false, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Caminho Óctuplo é composto por 8 práticas para a iluminação.", true, "Budismo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Nirvana significa a cessação do sofrimento.", true, "Budismo", 1);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Hinduísmo é uma religião politeísta ou henoteísta.", true, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Brahma é o deus destruidor no Hinduísmo.", false, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Os Vedas são os textos sagrados mais antigos do Hinduísmo.", true, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Rio Ganges é considerado sagrado pelos hindus.", true, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Krishna é uma das encarnações (avatar) de Vishnu.", true, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "Ganesha é filho de Shiva e Parvati.", true, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Hinduísmo não acredita em reencarnação.", false, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "A vaca é considerada um animal sagrado no Hinduísmo.", true, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "O Mahabharata é um dos principais épicos do Hinduísmo.", true, "Hinduísmo", 1);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.FACIL, "A deusa Lakshmi é a consorte de Brahma.", false, "Hinduísmo", 1);
    }
    private void carregarPaladinoFacilLacuna() {
        // CRISTIANISMO (15 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O livro sagrado do Cristianismo é a __________.",
                "Bíblia", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O filho de Deus para os cristãos é __________.",
                "Jesus Cristo", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "Jesus escolheu __________ apóstolos.",
                "12", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O nome da mãe de Jesus é __________.",
                "Maria", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "Jesus nasceu na cidade de __________.",
                "Belém", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O primeiro livro da Bíblia é __________.",
                "Gênesis", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O anjo que anunciou o nascimento de Jesus a Maria chamava-se __________.",
                "Gabriel", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "Jesus foi crucificado no lugar chamado __________.",
                "Calvário", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O apóstolo que negou Jesus três vezes foi __________.",
                "Pedro", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O apóstolo que traiu Jesus por 30 moedas de prata foi __________.",
                "Judas Iscariotes", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O rio onde Jesus foi batizado por João Batista é o rio __________.",
                "Jordão", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O dia da semana em que os cristãos celebram a ressurreição de Jesus é o __________.",
                "Domingo", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O livro da Bíblia que fala da criação do mundo é __________.",
                "Gênesis", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O imperador romano que governava quando Jesus nasceu era __________.",
                "Augusto", "Cristianismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O primeiro milagre de Jesus foi transformar água em __________ na cidade de Caná.",
                "vinho", "Cristianismo", 1);

        // RELIGIÕES AFRO-BRASILEIRAS (15 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A principal religião de matriz africana no Brasil é o __________.",
                "Candomblé", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "As divindades do Candomblé são chamadas de __________.",
                "Orixás", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A 'Mãe das Águas' é a Orixá chamada __________.",
                "Iemanjá", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O Orixá associado aos raios, trovões e à justiça é __________.",
                "Xangô", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "No sincretismo brasileiro, o Orixá Ogum é associado a São __________.",
                "Jorge", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A religião sincrética brasileira que mistura elementos africanos, indígenas e espíritas é a __________.",
                "Umbanda", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O Orixá da paz e da criação é __________.",
                "Oxalá", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O Orixá caçador e senhor das matas é __________.",
                "Oxóssi", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A Orixá dos ventos e tempestades é __________.",
                "Iansã", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "Na Umbanda, os espíritos de escravizados idosos que transmitem sabedoria são chamados de __________.",
                "Pretos-Velhos", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O instrumento musical de percussão usado nos terreiros é o __________.",
                "atabaque", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A energia vital ou força divina no Candomblé é chamada de __________.",
                "Axé", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O Orixá senhor das folhas e da sabedoria vegetal é __________.",
                "Ossain", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O Orixá mensageiro, guardião dos caminhos, é __________.",
                "Exu", "Afro-Brasileira", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A Orixá das águas doces, fertilidade e amor é __________.",
                "Oxum", "Afro-Brasileira", 1);

        // BUDISMO (10 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O fundador do Budismo é __________.",
                "Sidarta Gautama", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O estado de iluminação e libertação no Budismo é chamado de __________.",
                "Nirvana", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O Budismo possui __________ Nobres Verdades.",
                "4", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O caminho para a iluminação no Budismo é chamado de Caminho __________.",
                "Óctuplo", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O princípio de que ações têm consequências no Budismo é o __________.",
                "Karma", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A Roda do __________ é um símbolo importante do Budismo.",
                "Dharma", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A prática de meditação sentada é chamada de __________.",
                "Zazen", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O sofrimento ou insatisfação existencial no Budismo é chamado de __________.",
                "Dukkha", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O ciclo de renascimentos no Budismo é chamado de __________.",
                "Samsara", "Budismo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O líder espiritual do Budismo Tibetano é o __________.",
                "Dalai Lama", "Budismo", 1);

        // HINDUÍSMO (10 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A Trindade principal do Hinduísmo (Trimurti) é composta por Brahma, Vishnu e __________.",
                "Shiva", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O ciclo de renascimento no Hinduísmo é chamado de __________.",
                "Samsara", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O deus com cabeça de elefante é __________.",
                "Ganesha", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O princípio de causa e efeito no Hinduísmo é o __________.",
                "Karma", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O livro sagrado mais antigo do Hinduísmo são os __________.",
                "Vedas", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O deus preservador e protetor do universo é __________.",
                "Vishnu", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O deus da destruição e transformação é __________.",
                "Shiva", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A deusa do conhecimento, música e artes é __________.",
                "Sarasvati", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "A libertação do ciclo de renascimento é chamada de __________.",
                "Moksha", "Hinduísmo", 1);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.FACIL,
                "O famoso poema épico que conta a história do príncipe Rama é o __________.",
                "Ramayana", "Hinduísmo", 1);
    }

    private void carregarPaladinoMedioMultiplaEscolha() {
        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O Concílio de Niceia (325 d.C.) definiu principalmente:",
                Arrays.asList("Os livros da Bíblia", "A divindade de Cristo", "O batismo", "Páscoa"), "B", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Qual heresia negava a humanidade de Jesus?",
                Arrays.asList("Arianismo", "Docetismo", "Gnosticismo", "Nestorianismo"), "B", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que significa 'transubstanciação' na Eucaristia?",
                Arrays.asList("Simbolismo do pão", "Transformação real em corpo e sangue", "Bênção", "Comunhão espiritual"), "B", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Quem foi o primeiro Papa da Igreja Católica?",
                Arrays.asList("Paulo", "Pedro", "Lino", "Clemente"), "B", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O Cisma do Oriente (1054) dividiu a Igreja em:",
                Arrays.asList("Católica e Protestante", "Católica e Ortodoxa", "Ortodoxa e Copta", "Romana e Anglicana"), "B", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Qual livro da Bíblia fala sobre a saída do povo hebreu do Egito?",
                Arrays.asList("Gênesis", "Levítico", "Êxodo", "Deuteronômio"), "C", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que foram as Cruzadas?",
                Arrays.asList("Peregrinações a Roma", "Expedições militares à Terra Santa", "Concílios eclesiásticos", "Ordens monásticas"), "B", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Quem escreveu 'A Cidade de Deus'?",
                Arrays.asList("Tomás de Aquino", "Agostinho de Hipona", "Jerônimo", "Ambrósio"), "B", "Cristianismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que é o 'Odu' no Candomblé?",
                Arrays.asList("Ritual de iniciação", "Signo ou caminho do destino", "Oferenda", "Dança sagrada"), "B", "Afro-Brasileira", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Qual a diferença entre Candomblé Ketu, Jeje e Angola?",
                Arrays.asList("Dias da semana", "Nações de origem (iorubá, fon, banto)", "Nomes dos Orixás", "Cores de roupa"), "B", "Afro-Brasileira", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que significa 'cambono' ou 'cambono de santo'?",
                Arrays.asList("Sacerdote principal", "Ajudante de santo / auxiliar", "Objeto ritual", "Toque de atabaque"), "B", "Afro-Brasileira", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Quem é o Orixá 'senhor da terra dos mortos' (associado à calunga)?",
                Arrays.asList("Obaluaiê", "Oxalá", "Iemanjá", "Oxum"), "A", "Afro-Brasileira", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que é 'raspar a cabeça' no Candomblé?",
                Arrays.asList("Luto", "Ritual de iniciação (feitura de santo)", "Penitência", "Enfeite"), "B", "Afro-Brasileira", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Na Umbanda, o que significa a 'gira'?",
                Arrays.asList("Oferenda", "Sessão ou trabalho espiritual", "Ponto cantado", "Defumação"), "B", "Afro-Brasileira", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Quem é Pai Francisco na Umbanda?",
                Arrays.asList("Orixá", "Caboclo", "Pretos-velho famoso", "Exu"), "C", "Afro-Brasileira", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que é a escola Mahayana?",
                Arrays.asList("Veículo antigo", "Grande veículo", "Veículo diamante", "Veículo dos deuses"), "B", "Budismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que é a escola Theravada?",
                Arrays.asList("Grande veículo", "Veículo dos anciãos", "Veículo tântrico", "Budismo tibetano"), "B", "Budismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Qual é o princípio de 'não violência' e 'compaixão' chamado?",
                Arrays.asList("Metta (ou Maitri)", "Dukkha", "Anatta", "Samsara"), "A", "Budismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que é o 'Sangha' no Budismo?",
                Arrays.asList("Texto sagrado", "Comunidade de monges", "Templo", "Meditação"), "B", "Budismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que representa a Estátua do Buda deitado?",
                Arrays.asList("Sono", "Parinirvana (morte/libertação final)", "Meditação profunda", "Ensino"), "B", "Budismo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que são os Upanishads?",
                Arrays.asList("Rituais védicos", "Textos filosóficos e místicos", "Cânticos", "Leis"), "B", "Hinduísmo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Quem é o avatar de Vishnu que ensina Arjuna na batalha?",
                Arrays.asList("Rama", "Krishna", "Buda", "Kalki"), "B", "Hinduísmo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que significa 'Yoga' originalmente no Hinduísmo?",
                Arrays.asList("Exercício físico", "União com o divino", "Meditação", "Respiração"), "B", "Hinduísmo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Durga é uma forma de qual deusa principal?",
                Arrays.asList("Lakshmi", "Parvati", "Sarasvati", "Kali"), "B", "Hinduísmo", 4);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O que são os 'Ashramas'?",
                Arrays.asList("Templos", "Estágios da vida", "Livros sagrados", "Rituais"), "B", "Hinduísmo", 4);
    }

    private void carregarPaladinoMedioVerdadeiroFalso() {
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O Arianismo negava a divindade de Cristo.", true, "Cristianismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O Concílio Vaticano II aconteceu no século XX.", true, "Cristianismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "A Igreja Ortodoxa reconhece a supremacia do Papa.", false, "Cristianismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O batismo por imersão era comum nos primeiros séculos.", true, "Cristianismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "Martinho Lutero foi um líder da Contrarreforma.", false, "Cristianismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O termo 'Cristo' significa 'Salvador' em grego.", false, "Cristianismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "A Páscoa judaica (Pessach) celebra a libertação da escravidão no Egito.", true, "Cristianismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O livro de Jó trata do problema do sofrimento do justo.", true, "Cristianismo", 4);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "No Candomblé, o 'jogo de búzios' é usado para adivinhação.", true, "Afro-Brasileira", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "A Umbanda foi fundada oficialmente no século XIX no Rio de Janeiro.", false, "Afro-Brasileira", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "Oxum é Orixá das águas salgadas.", false, "Afro-Brasileira", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O 'abebé' é um leque ritual de Oxum.", true, "Afro-Brasileira", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "'Caboclo' na Umbanda representa espírito de guerreiro indígena.", true, "Afro-Brasileira", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O 'ponto riscado' é um símbolo energético usado nos terreiros.", true, "Afro-Brasileira", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "Na Umbanda, não se usa atabaques.", false, "Afro-Brasileira", 4);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O Budismo Tibetano incorpora práticas tântricas.", true, "Budismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "Anatta significa 'alma eterna' em Pali.", false, "Budismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O Dalai Lama é sempre reencarnado.", true, "Budismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "Budismo Zen originou-se no Japão a partir do Budismo Chan chinês.", true, "Budismo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "'Mantra' no Budismo é apenas uma canção.", false, "Budismo", 4);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O sistema de castas (varnas) tem origem religiosa nos textos hindus.", true, "Hinduísmo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "Shiva é representado por um tridente (trishula).", true, "Hinduísmo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "Kali é uma forma pacífica de Parvati.", false, "Hinduísmo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "A vaca é sagrada porque representa a generosidade da terra.", true, "Hinduísmo", 4);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.MEDIO, "O Ganges é considerado um rio comum sem significado especial.", false, "Hinduísmo", 4);
    }
    private void carregarPaladinoMedioLacuna() {
        // CRISTIANISMO (7 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O Concílio de __________ (325 d.C.) definiu a divindade de Cristo.",
                "Niceia", "Cristianismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "A heresia que negava a divindade de Cristo era o __________.",
                "Arianismo", "Cristianismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O Cisma do Oriente (1054) dividiu a Igreja em Católica e __________.",
                "Ortodoxa", "Cristianismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O livro da Bíblia que narra a saída do povo hebreu do Egito é o __________.",
                "Êxodo", "Cristianismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O teólogo que escreveu 'A Cidade de Deus' foi Santo __________.",
                "Agostinho", "Cristianismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O termo 'Cristo' significa __________ em grego.",
                "Ungido", "Cristianismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O sacramento que significa 'ação de graças' e celebra o corpo e sangue de Cristo é a __________.",
                "Eucaristia", "Cristianismo", 4);

        // RELIGIÕES AFRO-BRASILEIRAS (8 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "No Candomblé, o rito de iniciação que envolve raspar a cabeça é chamado de __________.",
                "feitura de santo", "Afro-Brasileira", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O 'jogo de __________' é usado no Candomblé para adivinhação.",
                "búzios", "Afro-Brasileira", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "A Umbanda foi fundada oficialmente no início do século XX por __________.",
                "Zélio Fernandino de Moraes", "Afro-Brasileira", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "A Orixá das lagoas, lama e morte (associada à velhice) é __________.",
                "Nanã", "Afro-Brasileira", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O ritual de fortalecimento da cabeça no Candomblé é chamado de __________.",
                "Bori", "Afro-Brasileira", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "A oferenda ou ritual funerário no Candomblé é chamado de __________.",
                "Axexê", "Afro-Brasileira", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "No Candomblé Jeje, as divindades de origem fon (Daomé) são chamadas de __________.",
                "Voduns", "Afro-Brasileira", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Na Umbanda, os espíritos infantis são chamados de __________.",
                "Erês", "Afro-Brasileira", 4);

        // BUDISMO (6 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O 'Grande Veículo' do Budismo é a escola __________.",
                "Mahayana", "Budismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O 'Veículo dos Anciãos' é a escola __________.",
                "Theravada", "Budismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O princípio budista de compaixão amorosa é chamado de __________ (em páli).",
                "Metta", "Budismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "A comunidade de monges budistas é chamada de __________.",
                "Sangha", "Budismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "A tradição do 'Veículo do Diamante' é o __________.",
                "Vajrayana", "Budismo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O conceito de 'vazio' ou vacuidade no Budismo Mahayana é chamado de __________.",
                "Sunyata", "Budismo", 4);

        // HINDUÍSMO (4 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "Os textos filosóficos e místicos do Hinduísmo que complementam os Vedas são os __________.",
                "Upanishads", "Hinduísmo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O avatar de Vishnu que ensina Arjuna no campo de batalha no Bhagavad Gita é __________.",
                "Krishna", "Hinduísmo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O deus guerreiro filho de Shiva e Parvati é __________.",
                "Karttikeya", "Hinduísmo", 4);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.MEDIO,
                "O sistema de estágios da vida no Hinduísmo (estudante, chefe de família, eremita, renunciante) é chamado de __________.",
                "Ashramas", "Hinduísmo", 4);
    }


    private void carregarPaladinoDificilMultiplaEscolha() {
        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que foi o 'Docetismo'?",
                Arrays.asList("Jesus só parecia humano", "Jesus só parecia divino", "Duas naturezas", "Um só Deus"), "A", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Qual teólogo cunhou o termo 'Trindade' (Trinitas) em latim?",
                Arrays.asList("Atanásio", "Tertuliano", "Orígenes", "Irineu"), "B", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que é a 'Patrística'?",
                Arrays.asList("Período dos apóstolos", "Filosofia dos Padres da Igreja", "Concílio", "Cisma"), "B", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que significam as siglas INRI na cruz de Cristo?",
                Arrays.asList("Rei dos Judeus", "Jesus de Nazaré", "Filho de Davi", "Salvador do mundo"), "A", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O Credo Niceno-Constantinopolitano foi definido em quais anos?",
                Arrays.asList("325 e 381", "313 e 325", "381 e 431", "431 e 451"), "A", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que é a 'apokatástasis'?",
                Arrays.asList("Inferno eterno", "Restauração universal de todos", "Purgatório", "Juízo final"), "B", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Qual dos seguintes é um 'Pai Capadócio'?",
                Arrays.asList("Atanásio", "Basílio Magno", "Ambrósio", "Jerônimo"), "B", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que o Filioque ('e do Filho') causou na Igreja?",
                Arrays.asList("Missa em latim", "Grande Cisma (1054)", "Reforma", "Inquisição"), "B", "Cristianismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que é o 'Bori' no Candomblé?",
                Arrays.asList("Morte do iniciado", "Ritual de fortalecimento da cabeça", "Casamento", "Festa"), "B", "Afro-Brasileira", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Quem é 'Nanã Buruquê'?",
                Arrays.asList("Orixá das lagoas, lama e morte", "Orixá do mar", "Orixá do fogo", "Orixá da caça"), "A", "Afro-Brasileira", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que significa 'axexê'?",
                Arrays.asList("Nascimento", "Ritual funerário do Candomblé", "Iniciação", "Colheita"), "B", "Afro-Brasileira", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que é o 'Padê de Exu'?",
                Arrays.asList("Oferenda a Exu antes dos rituais", "Dança", "Canto", "Vestimenta"), "A", "Afro-Brasileira", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "No Candomblé Jeje, os voduns correspondem a quê?",
                Arrays.asList("Orixás", "Divindades da nação Fon (Daomé)", "Caboclos", "Encantados"), "B", "Afro-Brasileira", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que são os 'Erês' na Umbanda?",
                Arrays.asList("Orixás", "Espíritos infantis", "Exus", "Pretos-velhos"), "B", "Afro-Brasileira", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que a 'Quimbanda' representa dentro da Umbanda?",
                Arrays.asList("Linha direita", "Linha de esquerda (trabalhos com Exus)", "Cura", "Batismo"), "B", "Afro-Brasileira", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que é o conceito de 'Sunyata' no Budismo Mahayana?",
                Arrays.asList("Compaixão", "Vazio / vacuidade", "Sofrimento", "Alegria"), "B", "Budismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que é a tradição Vajrayana?",
                Arrays.asList("Veículo antigo", "Veículo do diamante", "Grande veículo", "Pequeno veículo"), "B", "Budismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Quem foi Nagarjuna?",
                Arrays.asList("Rei budista", "Filósofo da escola Madhyamaka", "Discípulo de Buda", "Tradutor"), "B", "Budismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que significa 'Bodhisattva'?",
                Arrays.asList("Ser iluminado", "Ser que adia o nirvana para salvar outros", "Monge errante", "Deusa"), "B", "Budismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Qual tradição budista pratica 'Tonglen' (dar e receber)?",
                Arrays.asList("Theravada", "Tibetana", "Zen", "Chan"), "B", "Budismo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que são os 'Puranas'?",
                Arrays.asList("Leis", "Textos mitológicos e históricos", "Rituais", "Hinos"), "B", "Hinduísmo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que significa 'Advaita Vedanta'?",
                Arrays.asList("Deus pessoal", "Não dualidade", "Dualidade", "Devocional"), "B", "Hinduísmo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Quem foi Shankara (Adi Shankaracharya)?",
                Arrays.asList("Rei", "Filósofo da não dualidade", "Poeta", "Guerreiro"), "B", "Hinduísmo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que é a 'Bhakti'?",
                Arrays.asList("Yoga físico", "Devoção amorosa a Deus", "Conhecimento", "Ação"), "B", "Hinduísmo", 8);

        adicionarPerguntaMultipla(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O que são os 'Yoguis' (ou Yogins)?",
                Arrays.asList("Praticantes de yoga", "Deuses", "Textos", "Rituais"), "A", "Hinduísmo", 8);
    }

    private void carregarPaladinoDificilVerdadeiroFalso() {
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Monofisismo afirmava que Cristo tinha uma única natureza divina.", true, "Cristianismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Concílio de Calcedônia (451) definiu as duas naturezas de Cristo.", true, "Cristianismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Nestorianismo foi condenado por negar Maria como Theotokos (Mãe de Deus).", true, "Cristianismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "A Igreja Copta aceitou o Concílio de Calcedônia.", false, "Cristianismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "Pelágio defendia o pecado original hereditário.", false, "Cristianismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "Agostinho de Hipona escreveu 'Confissões' e 'A Trindade'.", true, "Cristianismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Quarto Concílio de Latrão (1215) definiu transubstanciação.", true, "Cristianismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Antigo Testamento foi escrito inteiramente em hebraico, sem exceções.", false, "Cristianismo", 8);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "No Candomblé Bantu (Angola), os Orixás são chamados de 'Inquices' ou 'Minkisi'.", true, "Afro-Brasileira", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "Oxumarê é Orixá do arco-íris e movimento cíclico", true, "Afro-Brasileira", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O 'batismo de santo' é a entrega da cabeça ao Orixá.", true, "Afro-Brasileira", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "Na Umbanda, 'Pombagira' é uma entidade sempre negativa e maligna.", false, "Afro-Brasileira", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O 'ponto de demanda' na Umbanda é para trabalhos específicos de magia.", true, "Afro-Brasileira", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "A Jurema Sagrada é uma tradição indígena incorporada a algumas vertentes umbandistas.", true, "Afro-Brasileira", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O 'corte de água' na Umbanda é oferecido a Ogum.", false, "Afro-Brasileira", 8);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Buddhacarita é uma biografia de Buda em versos sânscritos", true, "Budismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "As Quatro Nobres Verdades começam com 'O sofrimento existe'.", true, "Budismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Caminho Óctuplo inclui 'fé cega' como uma das práticas.", false, "Budismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "A escola Yogacara fala sobre 'consciência-armazenamento' (alaya-vijnana).", true, "Budismo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Budismo não tem escrituras sagradas.", false, "Budismo", 8);

        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "Os Aranyakas são textos 'da floresta' para eremitas.", true, "Hinduísmo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "A Gita ensina três yogas: jnana, bhakti e karma.", true, "Hinduísmo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O 'Shiva Nataraja' representa Shiva como dançarino cósmico.", true, "Hinduísmo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "A deusa Kali é consorte de Vishnu.", false, "Hinduísmo", 8);
        adicionarPerguntaVF(PerTipo.PALADINO, Dificuldade.DIFICIL, "O Manusmriti é um famoso código legal hindu.", true, "Hinduísmo", 8);
    }
    private void carregarPaladinoDificilLacuna() {
        // CRISTIANISMO (7 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A heresia que afirmava que Jesus só parecia humano, mas não era, chamava-se __________.",
                "Docetismo", "Cristianismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O teólogo que cunhou o termo 'Trindade' (Trinitas) em latim foi __________.",
                "Tertuliano", "Cristianismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O período da filosofia dos Padres da Igreja é chamado de __________.",
                "Patrística", "Cristianismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A doutrina da restauração universal de todos os seres é chamada de __________.",
                "Apokatástasis", "Cristianismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O termo 'Filioque' (que significa 'e do Filho') causou o Grande Cisma entre a Igreja do Ocidente e a Igreja do __________.",
                "Oriente", "Cristianismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O Concílio que definiu as duas naturezas de Cristo (humana e divina) foi o de __________.",
                "Calcedônia", "Cristianismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O autor de 'Confissões' e 'A Trindade' foi Santo __________.",
                "Agostinho", "Cristianismo", 8);

        // RELIGIÕES AFRO-BRASILEIRAS (8 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "No Candomblé Bantu (Angola), os Orixás são chamados de __________ ou Minkisi.",
                "Inquices", "Afro-Brasileira", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O Orixá do arco-íris e do movimento cíclico é __________.",
                "Oxumarê", "Afro-Brasileira", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O 'batismo de santo' no Candomblé refere-se à entrega da cabeça ao __________.",
                "Orixá", "Afro-Brasileira", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A entidade feminina da Umbanda que trabalha com Exu nas demandas amorosas é a __________.",
                "Pombagira", "Afro-Brasileira", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O ritual conhecido como 'Padê de __________' é uma oferenda feita antes dos rituais para abrir os caminhos.",
                "Exu", "Afro-Brasileira", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A tradição da Jurema Sagrada é uma prática espiritual __________ incorporada à Umbanda.",
                "indígena", "Afro-Brasileira", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O 'ponto __________' na Umbanda é um símbolo energético desenhado no chão.",
                "riscado", "Afro-Brasileira", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Na Quimbanda (linha de esquerda da Umbanda), os trabalhos são realizados com __________.",
                "Exus", "Afro-Brasileira", 8);

        // BUDISMO (5 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O filósofo budista fundador da escola Madhyamaka (caminho do meio) foi __________.",
                "Nagarjuna", "Budismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O ser que adia a própria iluminação para salvar todos os seres é o __________.",
                "Bodhisattva", "Budismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A prática de 'dar e receber' (Tonglen) é característica do Budismo __________.",
                "Tibetano", "Budismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O texto biográfico de Buda em versos sânscritos é o __________.",
                "Buddhacarita", "Budismo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A escola budista que enfatiza a 'consciência-armazenamento' (alaya-vijnana) é a __________.",
                "Yogacara", "Budismo", 8);

        // HINDUÍSMO (5 perguntas)
        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "Os textos 'da floresta' destinados a eremitas são chamados de __________.",
                "Aranyakas", "Hinduísmo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O Bhagavad Gita ensina três yogas: jnana (conhecimento), bhakti (devoção) e __________ (ação).",
                "karma", "Hinduísmo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A representação de Shiva como o dançarino cósmico é chamada de Shiva __________.",
                "Nataraja", "Hinduísmo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "O famoso código legal hindu escrito por um sábio lendário é o __________.",
                "Manusmriti", "Hinduísmo", 8);

        adicionarPerguntaLacuna(PerTipo.PALADINO, Dificuldade.DIFICIL,
                "A escola filosófica hindu que prega a não dualidade (Advaita) foi sistematizada por __________.",
                "Shankara", "Hinduísmo", 8);
    }

    // ==================== CAÇADORA - 200 PERGUNTAS ====================
    private void carregarPerguntasCacadora() {
        carregarCacadoraFacilMultiplaEscolha();  // 50 questões
        carregarCacadoraFacilVerdadeiroFalso();  // 50 questões
        carregarCacadoraMedioMultiplaEscolha();  // 25 questões
        carregarCacadoraMedioVerdadeiroFalso();  // 25 questões
        carregarCacadoraDificilMultiplaEscolha(); // 25 questões
        carregarCacadoraDificilVerdadeiroFalso(); // 25 questões
    }

    // ==================== PERGUNTAS FÁCEIS (100) ====================

    // 50 questões de MÚLTIPLA ESCOLHA - FÁCIL
    private void carregarCacadoraFacilMultiplaEscolha() {
        // ANIMAIS (15 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é o animal mais rápido do mundo?",
                Arrays.asList("Leão", "Guepardo", "Falcão-peregrino", "Cavalo"), "C", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal é conhecido como o 'Rei da Selva'?",
                Arrays.asList("Elefante", "Leão", "Tigre", "Gorila"), "B", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é o maior animal do mundo?",
                Arrays.asList("Elefante africano", "Tubarão-baleia", "Baleia-azul", "Girafa"), "C", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal vive na Austrália e carrega seus filhotes numa bolsa?",
                Arrays.asList("Coala", "Canguru", "Diabo-da-tasmânia", "Wombat"), "B", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual ave é símbolo da paz?",
                Arrays.asList("Águia", "Corvo", "Pomba", "Gaivota"), "C", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal é famoso por seu pescoço longo?",
                Arrays.asList("Elefante", "Girafa", "Zebra", "Rinoceronte"), "B", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Onde vivem os pingüins?",
                Arrays.asList("Polo Norte", "Polo Sul (Antártida)", "Amazônia", "Deserto do Saara"), "B", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual felino é conhecido por ter listras?",
                Arrays.asList("Leão", "Onça", "Tigre", "Leopardo"), "C", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal marinho é conhecido como 'cavalo-marinho'?",
                Arrays.asList("Peixe-palhaço", "Hipocampo", "Polvo", "Lula"), "B", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal é o melhor amigo do homem?",
                Arrays.asList("Gato", "Cavalo", "Cachorro", "Pássaro"), "C", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal tem uma tromba?",
                Arrays.asList("Rinoceronte", "Hipopótamo", "Elefante", "Morsa"), "C", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual inseto produz mel?",
                Arrays.asList("Vespa", "Abelha", "Formiga", "Mosquito"), "B", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal é conhecido por 'mudar de cor' para se camuflar?",
                Arrays.asList("Polvo", "Camaleão", "Lagarto", "Sapo"), "B", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual ave não voa mas nada muito bem?",
                Arrays.asList("Avestruz", "Emu", "Pinguim", "Kiwi"), "C", "Animais", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual animal é conhecido por sua memória excelente?",
                Arrays.asList("Gato", "Cachorro", "Elefante", "Rato"), "C", "Animais", 1);

        // NATUREZA (15 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "O que é fotossíntese?",
                Arrays.asList("Respiração das plantas", "Produção de alimento pela planta usando luz", "Crescimento da raiz", "Florescimento"), "B", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é o maior bioma brasileiro?",
                Arrays.asList("Mata Atlântica", "Pantanal", "Amazônia", "Cerrado"), "C", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é o menor oceano do mundo?",
                Arrays.asList("Pacífico", "Atlântico", "Índico", "Ártico"), "D", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual gás as plantas liberam durante a fotossíntese?",
                Arrays.asList("Gás carbônico", "Nitrogênio", "Oxigênio", "Hidrogênio"), "C", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é a camada da Terra onde vivemos?",
                Arrays.asList("Manto", "Núcleo", "Crosta terrestre", "Atmosfera"), "C", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "O que é um 'ecossistema'?",
                Arrays.asList("Um tipo de animal", "Comunidade de seres vivos + ambiente", "Apenas plantas", "Apenas animais"), "B", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual fenômeno natural é uma grande onda causada por terremoto no mar?",
                Arrays.asList("Furacão", "Tornado", "Tsunami", "Tufão"), "C", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é o rio mais extenso do mundo?",
                Arrays.asList("Amazonas", "Nilo", "Yang-Tsé", "Mississipi"), "A", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é a maior floresta tropical do mundo?",
                Arrays.asList("Congo", "Amazônia", "Bornéu", "Daintree"), "B", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "O que causa as estações do ano?",
                Arrays.asList("Distância da Terra ao Sol", "Inclinação do eixo da Terra", "Rotação da Terra", "Ventos solares"), "B", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual fenômeno destrói a camada de ozônio?",
                Arrays.asList("Efeito estufa", "CFCs (clorofluorcarbonetos)", "Poluição dos rios", "Desmatamento"), "B", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "O que é biodiversidade?",
                Arrays.asList("Quantidade de água", "Variedade de espécies", "Altitude", "Temperatura média"), "B", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é o maior deserto do mundo?",
                Arrays.asList("Saara", "Gobi", "Atacama", "Antártida"), "D", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "As plantas carnívoras capturam insetos para obter:",
                Arrays.asList("Energia do sol", "Nutrientes (nitrogênio)", "Água", "Sombra"), "B", "Natureza", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é o processo de transformação de água em vapor?",
                Arrays.asList("Condensação", "Precipitação", "Evaporação", "Sublimação"), "C", "Natureza", 1);

        // SOBREVIVÊNCIA (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Em caso de emergência na floresta, qual a cor mais visível para sinalização?",
                Arrays.asList("Verde", "Marrom", "Vermelho ou laranja", "Preto"), "C", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual a primeira coisa que você deve fazer ao se perder na mata?",
                Arrays.asList("Correr", "Gritar", "Parar, respirar e pensar (S.T.O.P.)", "Acender fogo"), "C", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Para purificar água sem equipamento, o método mais seguro é:",
                Arrays.asList("Coar com pano", "Ferver", "Deixar no sol", "Adicionar areia"), "B", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Em situação de sobrevivência, o que NÃO se deve fazer?",
                Arrays.asList("Construir abrigo", "Sinalizar", "Entrar em pânico", "Racionar água"), "C", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual direção o sol nasce?",
                Arrays.asList("Oeste", "Norte", "Sul", "Leste"), "D", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Como encontrar o Norte à noite no hemisfério sul?",
                Arrays.asList("Estrela Polar", "Cruzeiro do Sul (Crux)", "Lua cheia", "Vento"), "B", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "O que NÃO se deve beber em sobrevivência?",
                Arrays.asList("Água de chuva", "Água de rio fervida", "Água salgada do mar", "Água de nascente"), "C", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual é a regra de três em sobrevivência?",
                Arrays.asList("3 minutos sem ar, 3 horas sem abrigo, 3 dias sem água, 3 semanas sem comida",
                        "3 horas sem ar", "3 dias sem comida é pior", "Só vale para água"), "A", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual material é melhor para acender fogo por atrito?",
                Arrays.asList("Madeira mole seca", "Madeira úmida", "Pedra", "Folha verde"), "A", "Sobrevivência", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "No frio extremo, o que cobre mais rápido o corpo?",
                Arrays.asList("Agasalho", "Barraca", "Isolamento do chão", "Fogueira"), "C", "Sobrevivência", 1);

        // RASTREAMENTO (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Uma pegada com unhas visíveis provavelmente é de:",
                Arrays.asList("Felino", "Canídeo", "Urso", "Ave"), "B", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Pegada arredondada sem marcas de unha é característica de:",
                Arrays.asList("Cachorro", "Gato (felino)", "Cavalo", "Boi"), "B", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Fezes com sementes e fibras indicam animal:",
                Arrays.asList("Carnívoro", "Herbívoro", "Onívoro", "Insetívoro"), "B", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "O que são 'tocas'?",
                Arrays.asList("Ninho de pássaro", "Buracos no chão usados por animais", "Marcas de unha", "Pegadas"), "B", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Qual sinal indica que um animal passou recentemente?",
                Arrays.asList("Pegada coberta de folhas", "Fezes secas", "Pegada nítida com bordas frescas", "Teia de aranha"), "C", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Restos de presas parcialmente comidas indicam:",
                Arrays.asList("Animal saudável", "Predador", "Doença", "Migração"), "B", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "O que são 'arranhões' em árvores?",
                Arrays.asList("Doença", "Marcação de território", "Erosão", "Fogo"), "B", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Rastros arrastados no chão (como de cobra) são chamados:",
                Arrays.asList("Pegadas", "Trilhas", "Rastros de deslocamento", "Sulcos"), "C", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Pelos presos em galhos ou cercas indicam:",
                Arrays.asList("Ave", "Mamífero de passagem", "Inseto", "Peixe"), "B", "Rastreamento", 1);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.FACIL,
                "Pegada humana em solo macio: o que observar?",
                Arrays.asList("Tamanho e direção", "Cor da pele", "Idade", "Peso aproximado"), "A", "Rastreamento", 1);
    }

    // 50 questões de VERDADEIRO OU FALSO - FÁCIL
    private void carregarCacadoraFacilVerdadeiroFalso() {
        // ANIMAIS (15 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O urso panda é nativo da Austrália.", false, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A baleia é um mamífero, não um peixe.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O morcego é uma ave.", false, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O camelo armazena água em sua corcova.", false, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O golfinho é um peixe de água salgada.", false, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A aranha é um inseto.", false, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O beija-flor consegue voar para trás.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O crocodilo chora enquanto come.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A lula tem 8 braços e 2 tentáculos.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O coelho é um roedor.", false, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A fêmea do cavalo é chamada de égua.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O avestruz é a maior ave do mundo.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O pinguim é uma ave que nada mas não voa.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O elefante tem a gestação mais longa entre os mamíferos terrestres.", true, "Animais", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O tigre é nativo da África.", false, "Animais", 1);

        // NATUREZA (15 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A água ferve a 100°C ao nível do mar.", true, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O solo é composto apenas de areia.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O efeito estufa é sempre prejudicial.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O desmatamento ajuda no equilíbrio climático.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A Amazônia produz cerca de 20% do oxigênio do mundo.", true, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "As árvores respiram.", true, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O ar é composto principalmente de oxigênio.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A chuva ácida é causada pela poluição.", true, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "As plantas não precisam de luz para viver.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O lixo plástico leva mais de 400 anos para se decompor.", true, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O Rio Amazonas deságua no Oceano Pacífico.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O Pantanal é o maior bioma brasileiro.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "As erupções vulcânicas podem afetar o clima global.", true, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O bambu é um tipo de árvore.", false, "Natureza", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "As algas marinhas produzem oxigênio.", true, "Natureza", 1);

        // SOBREVIVÊNCIA (10 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Você deve correr sempre que estiver perdido na floresta.", false, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "É seguro beber água do mar se estiver com sede.", false, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Ferver a água por 1 minuto mata os microorganismos.", true, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Moscas e mosquitos são indicadores de água por perto.", true, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Em um naufrágio, você deve beber água salgada.", false, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O líquen cresce sempre no lado sul das árvores no hemisfério sul.", false, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O fogo afasta animais selvagens perigosos.", true, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Construir um abrigo deve ser a primeira prioridade após segurança.", true, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Comer neve hidrata sem riscos.", false, "Sobrevivência", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A regra do 'três' ajuda a priorizar ações em sobrevivência.", true, "Sobrevivência", 1);

        // RASTREAMENTO (10 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Pegadas frescas têm bordas nítidas e fundo limpo.", true, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Fezes de herbívoros geralmente têm pelos e ossos.", false, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Rastros de cobra parecem uma linha ondulada.", true, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "A direção da pegada indica o lado para onde o animal vai.", true, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "O tamanho da pegada pode indicar o porte do animal.", true, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Ramos quebrados baixos indicam passagem de aves grandes.", false, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Tocas no chão podem ser de tatu ou coelho.", true, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Animais noturnos não deixam rastros.", false, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Pelos enroscados indicam passagem recente de mamífero.", true, "Rastreamento", 1);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.FACIL, "Todo rastro de pegada humana é fácil de seguir.", false, "Rastreamento", 1);
    }

    // ==================== PERGUNTAS MÉDIAS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - MÉDIO
    private void carregarCacadoraMedioMultiplaEscolha() {
        // ANIMAIS (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual animal pode regenerar seu próprio cérebro?",
                Arrays.asList("Lagarto", "Salamandra", "Planária", "Estrela-do-mar"), "C", "Animais", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual ave é incapaz de voar mas corre muito rápido?",
                Arrays.asList("Pinguim", "Kiwi", "Avestruz", "Emu"), "C", "Animais", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual é o animal com o maior coração entre os seres vivos?",
                Arrays.asList("Elefante", "Baleia-azul", "Girafa", "Tubarão-baleia"), "B", "Animais", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual animal hiberna por mais tempo?",
                Arrays.asList("Esquilo", "Urso pardo", "Ouriço", "Morcego"), "A", "Animais", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual animal tem três corações?",
                Arrays.asList("Polvo", "Sanguessuga", "Minhoca", "Barata"), "A", "Animais", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual destes não é um mamífero monotremado (bota ovos)?",
                Arrays.asList("Ornitorrinco", "Equidna", "Canguru", "Tachyglossus"), "C", "Animais", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual é a serpente mais venenosa do mundo?",
                Arrays.asList("Cascavel", "Naja", "Mamba-negra", "Taipan-do-interior"), "D", "Animais", 4);

        // NATUREZA (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que é um 'bioma'?",
                Arrays.asList("Uma espécie rara", "Comunidade de plantas e animais com clima similar", "Oceano", "Montanha"), "B", "Natureza", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual fenômeno é responsável pela dispersão de sementes?",
                Arrays.asList("Fotossíntese", "Polinização e dispersão (zoocoria, anemocoria)", "Germinação", "Respiração"), "B", "Natureza", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que é 'sucessão ecológica'?",
                Arrays.asList("Extinção", "Mudança gradual na comunidade de espécies ao longo do tempo", "Migração", "Caça"), "B", "Natureza", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual é o pH da chuva normal?",
                Arrays.asList("5,6", "7,0", "4,0", "8,5"), "A", "Natureza", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que causa o fenômeno 'El Niño'?",
                Arrays.asList("Aquecimento do Pacífico equatorial", "Resfriamento do Atlântico", "Derretimento glacial", "Erupção vulcânica"), "A", "Natureza", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual o maior produtor de oxigênio do planeta?",
                Arrays.asList("Floresta amazônica", "Fitoplâncton oceânico", "Algas marinhas", "Plâncton"), "B", "Natureza", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que é 'decomposição'?",
                Arrays.asList("Construção de matéria orgânica", "Quebra de matéria morta por fungos e bactérias", "Crescimento", "Fotosíntese"), "B", "Natureza", 4);

        // SOBREVIVÊNCIA (6 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual nó é mais seguro para amarrar uma corda em uma árvore?",
                Arrays.asList("Nó simples", "Nó de correr", "Volta do fiador ou nó de escota", "Nó direito"), "C", "Sobrevivência", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Num ambiente desértico, o melhor horário para caminhar é:",
                Arrays.asList("Meio-dia", "Início da manhã/tarde", "Madrugada (mais frio)", "Anoitecer"), "C", "Sobrevivência", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que significa a sigla 'S.T.O.P.' em sobrevivência?",
                Arrays.asList("Sentar, Tomar água, Orar, Partir", "Sentar, Pensar, Observar, Planejar", "Sinalizar, Tentar, Orar, Partir", "Sair, Tomar, Ousar, Parar"), "B", "Sobrevivência", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual dessas plantas NÃO é comestível?",
                Arrays.asList("Dente-de-leão", "Trevo vermelho", "Comigo-ninguém-pode", "Beldroega"), "C", "Sobrevivência", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual a melhor forma de purificar água na natureza sem ferver?",
                Arrays.asList("Filtro solar SODIS (garrafa PET ao sol 6h)", "Adicionar terra", "Coar com camisa", "Misturar com suco"), "A", "Sobrevivência", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que NÃO fazer ao encontrar um animal selvagem grande?",
                Arrays.asList("Correr", "Recuar devagar", "Fazer barulho", "Ficar imóvel"), "A", "Sobrevivência", 4);

        // RASTREAMENTO (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual característica da pegada indica pressa do animal?",
                Arrays.asList("Pegadas afastadas", "Pegadas sobrepostas", "Pegadas rasas", "Pegadas fundas"), "A", "Rastreamento", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que são 'fezes de contato' em rastreamento?",
                Arrays.asList("Fezes antigas", "Fezes deixadas em locais estratégicos para demarcar território", "Fezes líquidas", "Fezes sem forma"), "B", "Rastreamento", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "'Cama' de animal se refere a:",
                Arrays.asList("Área de descanso", "Ninho", "Toca subterrânea", "Área de alimentação"), "A", "Rastreamento", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "Qual destes é sinal de passagem de javali?",
                Arrays.asList("Trilha estreita", "Pegada com dois cascos e arrasto", "Pegada de garra", "Poeira"), "B", "Rastreamento", 4);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.MEDIO,
                "O que indica uma 'trilha de uso' na mata?",
                Arrays.asList("Animal de passagem única", "Passagem frequente de animais", "Corrida", "Queda de árvore"), "B", "Rastreamento", 4);
    }

    // 25 questões de VERDADEIRO OU FALSO - MÉDIO
    private void carregarCacadoraMedioVerdadeiroFalso() {
        // ANIMAIS (7 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O lobo-guará é um canídeo sul-americano de patas longas.", true, "Animais", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "A capivara é o maior roedor do mundo.", true, "Animais", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O ornitorrinco é mamífero, mas não tem glândulas mamárias.", false, "Animais", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "A arara-azul é uma ave nativa da África.", false, "Animais", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "A tartaruga-de-couro é a maior tartaruga marinha.", true, "Animais", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O mico-leão-dourado é encontrado apenas na Mata Atlântica.", true, "Animais", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O tamanduá-bandeira come formigas usando sua língua longa e pegajosa.", true, "Animais", 4);

        // NATUREZA (7 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O Cerrado brasileiro é considerado um hotspot de biodiversidade.", true, "Natureza", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "A Mata de Araucárias é um bioma exclusivo do sul do Brasil e Argentina.", true, "Natureza", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O fenômeno 'florescimento de algas' (maré vermelha) é inofensivo.", false, "Natureza", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O solo de terra preta na Amazônia é pobre em nutrientes.", false, "Natureza", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O processo de desertificação é irreversível na maioria dos casos.", true, "Natureza", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "As epífitas são plantas que parasitam outras plantas.", false, "Natureza", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O carvão vegetal é produzido pela queima incompleta de madeira.", true, "Natureza", 4);

        // SOBREVIVÊNCIA (6 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "A urina humana é segura para beber em emergência.", false, "Sobrevivência", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Se seu abrigo improvisado tiver entrada na direção do vento, o vento vai entrar.", true, "Sobrevivência", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "O musgo em árvores cresce preferencialmente no lado norte (Hemisfério Norte).", true, "Sobrevivência", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Comer neve hidrata sem perda de energia.", false, "Sobrevivência", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Quanto mais fina a madeira, mais rápido queima.", true, "Sobrevivência", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Em uma picada de cobra, deve-se sugar o veneno com a boca.", false, "Sobrevivência", 4);

        // RASTREAMENTO (5 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Pelos com pontas brancas e base escura indicam animal velho.", false, "Rastreamento", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "A posição da lua pode ajudar a encontrar direção noturna.", true, "Rastreamento", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Marcas de dentes em galhos indicam passagem de herbívoro.", true, "Rastreamento", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Rastros em zigue-zague indicam animal fugindo.", true, "Rastreamento", 4);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.MEDIO, "Pegadas humanas apontam calcanhar mais profundo em descida.", true, "Rastreamento", 4);
    }

    // ==================== PERGUNTAS DIFÍCEIS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - DIFÍCIL
    private void carregarCacadoraDificilMultiplaEscolha() {
        // ANIMAIS (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual animal tem o maior cérebro em relação ao corpo?",
                Arrays.asList("Humano", "Golfinho", "Formiga (proporcionalmente tem grande)", "Rato"), "C", "Animais", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que é 'inquilinismo' entre animais?",
                Arrays.asList("Predação", "Um animal vive dentro do outro sem prejudicar", "Competição", "Cooperação"), "B", "Animais", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual é a única ave que voa para trás?",
                Arrays.asList("Andorinhão", "Beija-flor", "Pardal", "Águia"), "B", "Animais", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Quantos corações tem uma minhoca?",
                Arrays.asList("1", "2", "5 pares", "Nenhum"), "C", "Animais", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual mamífero pode viver mais de 200 anos?",
                Arrays.asList("Tartaruga-gigante", "Baleia-da-groenlândia", "Elefante", "Humano"), "B", "Animais", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que é 'mimetismo batesiano'?",
                Arrays.asList("Animal inofensivo imita um perigoso", "Perigoso imita inofensivo", "Camuflagem", "Coloração de aviso"), "A", "Animais", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual animal tem sangue azul?",
                Arrays.asList("Lagosta", "Aranha", "Polvo", "Todos os acima"), "D", "Animais", 8);

        // NATUREZA (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que é 'biogeoquímica'?",
                Arrays.asList("Estudo de fósseis", "Ciclo de elementos químicos entre seres vivos e ambiente", "Classificação de solos", "Meteorologia"), "B", "Natureza", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual é o fenômeno de 'eutrofização'?",
                Arrays.asList("Enriquecimento excessivo de nutrientes em água", "Poluição do ar", "Derretimento de gelo", "Erosão"), "A", "Natureza", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que é a 'zona pelágica' no oceano?",
                Arrays.asList("Fundo do mar", "Coluna d'água aberta", "Zona costeira", "Região abissal"), "B", "Natureza", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual a diferença entre tempo e clima?",
                Arrays.asList("Tempo é curto prazo, clima é longo prazo", "São sinônimos", "Clima é só temperatura", "Tempo é pressão"), "A", "Natureza", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que são 'espécies exóticas invasoras'?",
                Arrays.asList("Nativa em risco", "Introduzidas que prejudicam ecossistema", "Animais migratórios", "Plantas medicinais"), "B", "Natureza", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que é a 'zona de ressurgência' oceânica?",
                Arrays.asList("Subida de águas profundas, ricas em nutrientes", "Águas mornas", "Ondas gigantes", "Corrente quente"), "A", "Natureza", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual gás do efeito estufa é mais potente que o CO2?",
                Arrays.asList("Metano", "Óxido nitroso", "Vapor d'água", "CFCs"), "A", "Natureza", 8);

        // SOBREVIVÊNCIA (6 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual técnica de fricção de madeira é mais eficiente para fazer fogo?",
                Arrays.asList("Arco de fogo", "Arado de fogo", "Bomba de fogo", "Perfurante manual"), "A", "Sobrevivência", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Em que direção deve-se construir a abertura do abrigo contra vento?",
                Arrays.asList("Contra o vento", "A favor do vento", "Perpendicular", "Tanto faz"), "A", "Sobrevivência", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual planta é conhecida por acumular água em suas folhas-reservatório?",
                Arrays.asList("Bromélia", "Cacto", "Samambaia", "Orquídea"), "A", "Sobrevivência", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual método de purificação de água NÃO mata vírus?",
                Arrays.asList("Ferver", "Filtro de barro", "Pastilhas de prata coloidal", "Luz UV"), "B", "Sobrevivência", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que significa 'hipotermia'?",
                Arrays.asList("Perda de calor corporal perigosa", "Excesso de calor", "Desidratação", "Fome"), "A", "Sobrevivência", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual é a dose letal de água do mar ingerida?",
                Arrays.asList("1 litro", "2-3 litros em pouco tempo pode matar", "Beber à vontade", "10 litros"), "B", "Sobrevivência", 8);

        // RASTREAMENTO (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que é 'linea alba' em pegadas de animais?",
                Arrays.asList("Sulco central na pegada", "Marca de unha", "Borda externa", "Parte mais funda"), "A", "Rastreamento", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que indica a presença de 'fezes de marcação' em posição elevada?",
                Arrays.asList("Alimentação", "Demarcação de território", "Doença", "Fuga"), "B", "Rastreamento", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "A técnica de 'rastreamento por pressão' se baseia em:",
                Arrays.asList("Som", "Cheiro", "Alteração do ambiente (galhos quebrados, folhas viradas)", "Pegadas"), "C", "Rastreamento", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "Qual é a maior pegada de mamífero terrestre?",
                Arrays.asList("Elefante", "Rinoceronte", "Hipopótamo", "Urso"), "A", "Rastreamento", 8);

        adicionarPerguntaMultipla(PerTipo.CACADORA, Dificuldade.DIFICIL,
                "O que é um 'rastro de arrasto'?",
                Arrays.asList("Animal rastejando", "Animal carregando presa", "Animal voando", "Animal nadando"), "B", "Rastreamento", 8);
    }

    // 25 questões de VERDADEIRO OU FALSO - DIFÍCIL
    private void carregarCacadoraDificilVerdadeiroFalso() {
        // ANIMAIS (7 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O axolote (ambystoma mexicanum) mantém características larvais na fase adulta (neotenia).", true, "Animais", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O dragão-de-komodo mata por envenenamento e bactérias.", true, "Animais", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O coala dorme cerca de 20 horas por dia por causa de sua dieta.", true, "Animais", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O ornitorrinco macho tem esporão venenoso.", true, "Animais", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "A hiena é mais aparentada dos felinos que dos canídeos.", true, "Animais", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O peixe-pedra é o peixe mais venenoso do mundo.", true, "Animais", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O tatu-bola é encontrado apenas na Austrália.", false, "Animais", 8);

        // NATUREZA (7 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O 'aprumo' das árvores cresce sempre para o norte.", false, "Natureza", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O solo laterítico é rico em alumínio e ferro.", true, "Natureza", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O Cerrado tem árvores de casca grossa e raízes profundas por causa do fogo natural.", true, "Natureza", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "A Caatinga é o único bioma exclusivamente brasileiro.", true, "Natureza", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O aquífero Guarani é o maior aquífero do mundo.", false, "Natureza", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O efeito estufa é um fenômeno natural indispensável para a vida.", true, "Natureza", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O aquecimento global causa o aumento do nível do mar por derretimento de geleiras e expansão térmica.", true, "Natureza", 8);

        // SOBREVIVÊNCIA (6 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "A técnica de 'destilação solar' pode produzir água potável a partir de água salgada.", true, "Sobrevivência", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O 'ponto de garfo' em gravetos pode ser usado para fazer fogo.", true, "Sobrevivência", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "Em caso de avalanche, deve-se nadar contra a neve.", true, "Sobrevivência", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "Método 'caminhar em zigue-zague' ajuda a não se perder em neblina.", true, "Sobrevivência", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O fungo 'pão-de-índio' (Polyporus) não é comestível.", false, "Sobrevivência", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O bambu pode conter cianeto quando cru.", true, "Sobrevivência", 8);

        // RASTREAMENTO (5 perguntas)
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O 'passo quebrado' em pegadas indica animal mancando.", true, "Rastreamento", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "Fezes de raposa geralmente têm forma de corda torcida.", true, "Rastreamento", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "Pelos de guarda mais grossos protegem a pelagem da água.", true, "Rastreamento", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "O 'teste da folha' pode ajudar a encontrar direção do vento.", true, "Rastreamento", 8);
        adicionarPerguntaVF(PerTipo.CACADORA, Dificuldade.DIFICIL, "Rastros sobrepostos de felino indicam que ele estava caçando.", true, "Rastreamento", 8);
    }
    // ==================== GUERREIRO - 200 PERGUNTAS ====================
    private void carregarPerguntasGuerreiro() {
        carregarGuerreiroFacilMultiplaEscolha();  // 50 questões
        carregarGuerreiroFacilVerdadeiroFalso();  // 50 questões
        carregarGuerreiroMedioMultiplaEscolha();  // 25 questões
        carregarGuerreiroMedioVerdadeiroFalso();  // 25 questões
        carregarGuerreiroDificilMultiplaEscolha(); // 25 questões
        carregarGuerreiroDificilVerdadeiroFalso(); // 25 questões
    }

    // ==================== PERGUNTAS FÁCEIS (100) ====================

    // 50 questões de MÚLTIPLA ESCOLHA - FÁCIL
    private void carregarGuerreiroFacilMultiplaEscolha() {
        // COMBATE E ARTES MARCIAIS (15 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual dessas é uma arte marcial japonesa?",
                Arrays.asList("Kung Fu", "Taekwondo", "Judô", "Muay Thai"), "C", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual arma é tradicionalmente usada por samurais?",
                Arrays.asList("Espada longa", "Katana", "Machado", "Lança"), "B", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual é o objetivo principal do Judô?",
                Arrays.asList("Nocautear", "Imobilizar e derrubar", "Chutar", "Uso de armas"), "B", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual país é o berço do Taekwondo?",
                Arrays.asList("China", "Japão", "Coreia do Sul", "Tailândia"), "C", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual luta é conhecida como 'a arte suave'?",
                Arrays.asList("Caratê", "Judô", "Aikidô", "Jiu-Jitsu"), "C", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "No Boxe, qual golpe é permitido abaixo da cintura?",
                Arrays.asList("Jab", "Cruzado", "Nenhum", "Upper"), "C", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual dessas armas é considerada 'arma branca'?",
                Arrays.asList("Pistola", "Espada", "Granada", "Bazuca"), "B", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que é um 'soco direto' no Boxe?",
                Arrays.asList("Golpe com mão traseira", "Golpe com mão da frente em linha reta", "Golpe circular", "Golpe de cima"), "B", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual equipamento NÃO é usado no MMA profissional?",
                Arrays.asList("Luvas abertas", "Protetor bucal", "Capacetes", "Protetor genital"), "C", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O Caratê se originou em qual ilha japonesa?",
                Arrays.asList("Hokkaido", "Honshu", "Okinawa", "Shikoku"), "C", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual golpe do Muay Thai é característico?",
                Arrays.asList("Cotovelada", "Joelhada", "Chute circular", "Todas as alternativas"), "D", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que é uma 'chave de braço' no Jiu-Jitsu?",
                Arrays.asList("Golpe de sorte", "Técnica de finalização", "Posição defensiva", "Aquecimento"), "B", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual é a arma principal de um cavaleiro medieval?",
                Arrays.asList("Arco", "Espada longa e escudo", "Besta", "Alabarda"), "B", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que é uma 'rasteira'?",
                Arrays.asList("Golpe no rosto", "Técnica para derrubar usando as pernas", "Defesa contra chute", "Salto"), "B", "Combate", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual luta é considerada esporte olímpico desde 2000?",
                Arrays.asList("Caratê", "Taekwondo", "Kung Fu", "Muay Thai"), "B", "Combate", 1);

        // ESTRATÉGIA MILITAR (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual é a manobra militar de 'cerco'?",
                Arrays.asList("Atacar de frente", "Cercar o inimigo por todos os lados", "Recuar", "Atacar de longe"), "B", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que significa 'flanquear' o inimigo?",
                Arrays.asList("Atacar pela retaguarda", "Atacar pelos lados", "Atacar de frente", "Bombardear"), "B", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que é 'guerra de trincheiras'?",
                Arrays.asList("Combate naval", "Combate com cavalaria", "Combate em valas escavadas", "Guerra aérea"), "C", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que significa 'emboscada'?",
                Arrays.asList("Ataque surpresa", "Recuo tático", "Cerco", "Bombardeio"), "A", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual exército inventou o 'blitzkrieg' (guerra relâmpago)?",
                Arrays.asList("Russo", "Francês", "Alemão", "Britânico"), "C", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que é um 'pelotão' no exército?",
                Arrays.asList("Pequena unidade de ~30-40 soldados", "General", "Arma", "Veículo"), "A", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que é 'logística militar'?",
                Arrays.asList("Combate corpo a corpo", "Planejamento de suprimentos e movimentação", "Espionagem", "Treinamento"), "B", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que significa 'retirada estratégica'?",
                Arrays.asList("Rendição", "Recuo planejado para vantagem futura", "Ataque final", "Deserção"), "B", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Para que serve um 'batedor' (scout) no campo de batalha?",
                Arrays.asList("Atacar", "Coletar informações sobre o inimigo", "Curar soldados", "Liderar carga"), "B", "Estratégia", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que é 'artilharia'?",
                Arrays.asList("Infantaria", "Cavalaria", "Armas de longo alcance (canhões, obuses)", "Aviação"), "C", "Estratégia", 1);

        // HISTÓRIA DE GUERRAS - Guerras Antigas (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual foi a guerra entre Esparta e Atenas?",
                Arrays.asList("Guerra do Peloponeso", "Guerras Púnicas", "Guerras Médicas", "Guerra de Troia"), "A", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Quem venceu as Guerras Púnicas?",
                Arrays.asList("Cartago", "Grécia", "Roma", "Egito"), "C", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual general cruzou os Alpes com elefantes?",
                Arrays.asList("César", "Aníbal", "Alexandre", "Pompeu"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual foi a maior batalha de Alexandre, o Grande?",
                Arrays.asList("Termópilas", "Gaugamela", "Maratona", "Plateias"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual império foi derrotado na Batalha de Actium (31 a.C.)?",
                Arrays.asList("Romano", "Egípcio", "Persa", "Grego"), "B", "História", 1);

        // Guerras Medievais (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Quem liderou os ingleses na Batalha de Hastings (1066)?",
                Arrays.asList("Ricardo Coração de Leão", "Guilherme, o Conquistador", "Henrique V", "Eduardo III"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "As Cruzadas foram guerras entre cristãos e:",
                Arrays.asList("Vikings", "Mongóis", "Muçulmanos", "Bizantinos"), "C", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual heroína francesa liderou exércitos na Guerra dos Cem Anos?",
                Arrays.asList("Maria Antonieta", "Joana d'Arc", "Catarina de Médici", "Ana Bolena"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que foi a Guerra das Rosas?",
                Arrays.asList("Guerra religiosa", "Guerra civil inglesa entre York e Lancaster", "Guerra com a França", "Guerra com a Espanha"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual imperador mongol criou um dos maiores impérios da história?",
                Arrays.asList("Átila", "Gengis Khan", "Kublai Khan", "Batu Khan"), "B", "História", 1);

        // Guerras Modernas (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual foi a causa imediata da Primeira Guerra Mundial?",
                Arrays.asList("Ataque a Pearl Harbor", "Assassinato de Francisco Ferdinando", "Invasão da Polônia", "Guerra Fria"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Em que ano terminou a Segunda Guerra Mundial?",
                Arrays.asList("1943", "1944", "1945", "1946"), "C", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual país foi o principal inimigo dos Aliados na Segunda Guerra?",
                Arrays.asList("Itália", "Japão", "Alemanha", "Todos os acima"), "D", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que foi o 'Dia D' (6 de junho de 1944)?",
                Arrays.asList("Ataque a Pearl Harbor", "Desembarque na Normandia", "Rendição da Alemanha", "Lançamento da bomba atômica"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual cidade recebeu a primeira bomba atômica?",
                Arrays.asList("Tóquio", "Nagasaki", "Hiroshima", "Kyoto"), "C", "História", 1);

        // Guerras Contemporâneas (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual guerra durou de 1955 a 1975 e envolveu EUA e Vietnã?",
                Arrays.asList("Guerra da Coreia", "Guerra do Vietnã", "Guerra Fria", "Guerra do Afeganistão"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "O que foi a Guerra Fria?",
                Arrays.asList("Guerra com gelo", "Conflito ideológico EUA x URSS sem confronto direto", "Guerra na Sibéria", "Guerra civil russa"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual guerra teve o conflito entre Argentina e Reino Unido em 1982?",
                Arrays.asList("Guerra do Golfo", "Guerra das Malvinas", "Guerra dos Seis Dias", "Guerra Civil Espanhola"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "A Guerra do Golfo (1991) foi contra a invasão de qual país?",
                Arrays.asList("Irã", "Kuwait", "Iraque", "Afeganistão"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual conflito começou em 2003 com a invasão do Iraque?",
                Arrays.asList("Guerra do Afeganistão", "Guerra do Iraque", "Primavera Árabe", "Guerra da Síria"), "B", "História", 1);

        // Heróis e Líderes Militares (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Quem foi Napoleão Bonaparte?",
                Arrays.asList("Rei francês", "Imperador e general francês", "Presidente dos EUA", "Papa"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual general americano comandou as forças aliadas na Segunda Guerra?",
                Arrays.asList("Patton", "MacArthur", "Eisenhower", "Bradley"), "C", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Quem foi Sun Tzu?",
                Arrays.asList("Imperador chinês", "Filósofo e estrategista militar", "General japonês", "Inventor da pólvora"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Qual líder brasileiro lutou na Guerra do Paraguai?",
                Arrays.asList("Dom Pedro I", "Duque de Caxias", "Tiradentes", "Getúlio Vargas"), "B", "História", 1);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.FACIL,
                "Quem foi a 'Dama de Ferro' que liderou a Inglaterra na Guerra das Malvinas?",
                Arrays.asList("Rainha Elizabeth", "Margaret Thatcher", "Theresa May", "Winston Churchill"), "B", "História", 1);
    }

    // 50 questões de VERDADEIRO OU FALSO - FÁCIL
    private void carregarGuerreiroFacilVerdadeiroFalso() {
        // COMBATE E ARTES MARCIAIS (15 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A espada é considerada uma arma branca.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Boxe permite golpes com os pés.", false, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Judô foi criado por Jigoro Kano.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Caratê significa 'mãos vazias'.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Muay Thai é conhecido como a 'arte das oito armas'.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A luta livre olímpica é disputada no tatame.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "No MMA, cabeçadas são permitidas.", false, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Jiu-Jitsu brasileiro foca em quedas e finalizações no chão.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Kung Fu é originário do Japão.", false, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A katana é uma espada curva de uma lâmina.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O escudo era usado apenas por cavaleiros.", false, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A armadura de placas surgiu na Idade Média.", true, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O arco e flecha foi inventado no século XX.", false, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A besta tem maior velocidade de tiro que o arco longo.", false, "Combate", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O capacete é equipamento de proteção obrigatório no Boxe olímpico.", true, "Combate", 1);

        // ESTRATÉGIA MILITAR (10 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A 'tática de terra arrasada' destrói recursos para o inimigo.", true, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O 'cerco' é uma estratégia defensiva apenas.", false, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Flanquear significa atacar pela frente.", false, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A 'guerra psicológica' usa medo e propaganda.", true, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "'Inteligência militar' coleta informações sobre o inimigo.", true, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O 'batalhão' é maior que um 'pelotão'.", true, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "'Blitzkrieg' significa guerra de trincheiras.", false, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A logística é irrelevante para vencer batalhas.", false, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Uma 'retirada tática' é sinal de covardia.", false, "Estratégia", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "'Camuflagem' ajuda a evitar detecção.", true, "Estratégia", 1);

        // HISTÓRIA DE GUERRAS (25 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Primeira Guerra Mundial começou em 1914.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Segunda Guerra Mundial terminou em 1945.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Hitler invadiu a Polônia em 1939.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Pearl Harbor foi atacado pelos alemães.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Os Estados Unidos lançaram duas bombas atômicas no Japão.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Guerra do Vietnã foi vencida pelos Estados Unidos.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Guerra Fria foi um conflito militar direto entre EUA e URSS.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Muro de Berlim caiu em 1989.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Napoleão foi derrotado na Batalha de Waterloo.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Alexandre, o Grande, conquistou a Pérsia.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Júlio César foi assassinado no Senado Romano.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Guerra dos Cem Anos durou exatamente 100 anos.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Joana d'Arc foi queimada na fogueira.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "As Cruzadas ocorreram na Idade Média.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Batalha de Stalingrado foi uma vitória alemã.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Brasil lutou na Segunda Guerra Mundial com a FEB.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Guerra do Paraguai foi entre Paraguai e Tríplice Aliança (Brasil, Argentina, Uruguai).", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Revolução Francesa teve influência militar em toda a Europa.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Guerra Civil Americana foi entre Norte e Sul dos EUA.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A bomba atômica foi usada pela primeira vez em 1945.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A 'Linha Maginot' foi construída pelos alemães.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O general Patton comandou as forças soviéticas.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "A Batalha de Austerlitz foi vencida por Napoleão.", true, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "O Império Romano foi derrotado pelos hunos.", false, "História", 1);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.FACIL, "Sun Tzu escreveu 'A Arte da Guerra'.", true, "História", 1);
    }

    // ==================== PERGUNTAS MÉDIAS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - MÉDIO
    private void carregarGuerreiroMedioMultiplaEscolha() {
        // COMBATE E ARTES MARCIAIS (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual golpe do Boxe é desferido com a mão traseira em movimento semicircular?",
                Arrays.asList("Jab", "Cruzado", "Hook (gancho)", "Upper"), "C", "Combate", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que é 'kata' no Caratê?",
                Arrays.asList("Luta livre", "Sequência de movimentos simulando combate", "Alongamento", "Saudação"), "B", "Combate", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual arte marcial é conhecida por usar a força do oponente contra ele mesmo?",
                Arrays.asList("Boxe", "Muay Thai", "Aikidô", "Taekwondo"), "C", "Combate", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que significa 'ippon' no Judô?",
                Arrays.asList("Penalidade", "Ponto máximo (vitória)", "Meio ponto", "Desqualificação"), "B", "Combate", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "No Jiu-Jitsu brasileiro, o que é 'montada'?",
                Arrays.asList("Posição superior sentado no peito do oponente", "Posição de guarda", "Chave de perna", "Estrangulamento"), "A", "Combate", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual arma medieval era usada para perfurar armaduras?",
                Arrays.asList("Espada larga", "Estrela da manhã", "Estoque (ou estocada)", "Manga de machado"), "C", "Combate", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que significa 'K.O.' no Boxe?",
                Arrays.asList("Ponto", "Nocaute (knockout)", "Empate", "Desqualificação"), "B", "Combate", 4);

        // ESTRATÉGIA MILITAR (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que é 'guerra assimétrica'?",
                Arrays.asList("Guerra com forças iguais", "Conflito entre forças de capacidades muito diferentes", "Guerra nuclear", "Guerra naval"), "B", "Estratégia", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que significa 'poder aéreo' em estratégia militar?",
                Arrays.asList("Forças terrestres", "Uso de aviões e helicópteros", "Marinha", "Infantaria"), "B", "Estratégia", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que é uma 'cabeça de ponte'?",
                Arrays.asList("Posição defensiva", "Área capturada em território inimigo para avançar", "Quartel-general", "Depósito de armas"), "B", "Estratégia", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que significa 'exército de reserva'?",
                Arrays.asList("Soldados inativos", "Forças mantidas para uso posterior", "Guarda costeira", "Polícia militar"), "B", "Estratégia", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que é 'guerra de movimento'?",
                Arrays.asList("Guerra estática", "Manobras rápidas para obter vantagem", "Guerra naval", "Bombardeio"), "B", "Estratégia", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Para que serve um 'combate de reconhecimento'?",
                Arrays.asList("Atacar o inimigo", "Avaliar força e posição inimiga", "Defender território", "Recuar"), "B", "Estratégia", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que é uma 'linha de suprimentos'?",
                Arrays.asList("Rota de combate", "Caminho para entregar mantimentos e munição", "Trincheira", "Aeroporto"), "B", "Estratégia", 4);

        // HISTÓRIA DE GUERRAS (11 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual foi a principal causa da Primeira Guerra Mundial?",
                Arrays.asList("Nacionalismo, alianças, imperialismo e assassinato", "Guerra nuclear", "Crise econômica", "Revolução comunista"), "A", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O Tratado de Versalhes (1919) impôs duras condições a qual país?",
                Arrays.asList("França", "Inglaterra", "Alemanha", "Áustria"), "C", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual foi a maior batalha da Segunda Guerra Mundial em número de baixas?",
                Arrays.asList("Normandia", "Stalingrado", "Berlim", "Midway"), "B", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que foi a 'Operação Barbarossa'?",
                Arrays.asList("Invasão alemã da URSS", "Desembarque na Normandia", "Batalha da Inglaterra", "Ataque a Pearl Harbor"), "A", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Quem comandou a FEB (Força Expedicionária Brasileira) na Segunda Guerra?",
                Arrays.asList("Duque de Caxias", "Getúlio Vargas", "Marechal Mascarenhas de Morais", "Monte Castelo"), "C", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual foi a batalha conhecida como 'Pracinhas brasileiros' na Itália?",
                Arrays.asList("Monte Cassino", "Monte Castelo", "Anzio", "Salerno"), "B", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que foi a 'Guerra dos Seis Dias' (1967)?",
                Arrays.asList("Guerra entre Índia e Paquistão", "Conflito entre Israel e países árabes", "Guerra civil na Nigéria", "Guerra do Vietnã"), "B", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual tratado encerrou oficialmente a Primeira Guerra Mundial?",
                Arrays.asList("Tratado de Paris", "Tratado de Versalhes", "Tratado de Tordesilhas", "Tratado de Roma"), "B", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Quem escreveu o livro 'A Arte da Guerra'?",
                Arrays.asList("Clausewitz", "Sun Tzu", "Maquiavel", "Jomini"), "B", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "O que foi a 'Batalha do Bulge' (1944)?",
                Arrays.asList("Última grande ofensiva alemã na Segunda Guerra", "Batalha naval", "Batalha no Pacífico", "Cerco de Leningrado"), "A", "História", 4);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.MEDIO,
                "Qual imperador romano construiu uma muralha na Bretanha?",
                Arrays.asList("Augusto", "Trajano", "Adriano", "Constantino"), "C", "História", 4);
    }

    // 25 questões de VERDADEIRO OU FALSO - MÉDIO
    private void carregarGuerreiroMedioVerdadeiroFalso() {
        // COMBATE (7 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "No Boxe, o 'jab' é geralmente o golpe mais rápido.", true, "Combate", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "O 'guarda baixa' no Boxe protege melhor o rosto.", false, "Combate", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "O Jiu-Jitsu foi adaptado pelos Gracies no Brasil.", true, "Combate", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "'Kumite' no Caratê significa luta ou combate.", true, "Combate", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "No Muay Thai, os golpes de cotovelo são permitidos.", true, "Combate", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A 'chave de calcanhar' é permitida em todas as faixas do Jiu-Jitsu.", false, "Combate", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "O 'cinturão preto' é o mais alto grau em todas as artes marciais.", false, "Combate", 4);

        // ESTRATÉGIA (6 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A 'guerra anfíbia' envolve ataque do mar para a terra.", true, "Estratégia", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "'Poder de fogo' refere-se exclusivamente à artilharia.", false, "Estratégia", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "Uma 'guerra de atrito' busca desgastar o inimigo.", true, "Estratégia", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "'Carga de cavalaria' ainda é usada em exércitos modernos.", false, "Estratégia", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "O princípio da 'surpresa' é fundamental na estratégia militar.", true, "Estratégia", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "'Defesa em profundidade' usa múltiplas linhas defensivas.", true, "Estratégia", 4);

        // HISTÓRIA (12 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A Batalha de Maratona ocorreu entre gregos e persas.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "Aníbal foi derrotado na Batalha de Zama.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A população judaica sofreu o Holocausto durante a Segunda Guerra.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "O Japão se rendeu após a primeira bomba atômica.", false, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A Guerra do Vietnã começou oficialmente em 1955.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "O Brasil declarou guerra à Alemanha em 1942.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A 'Guerra dos Farrapos' foi no Rio Grande do Sul.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A Revolução Russa de 1917 tirou a Rússia da Primeira Guerra.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A 'Linha Siegfried' era alemã.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A Batalha de Trafalgar foi naval.", true, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A 'Campanha da Rússia' de Napoleão foi bem-sucedida.", false, "História", 4);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.MEDIO, "A 'Tríplice Aliança' na Primeira Guerra era Alemanha, Áustria-Hungria e Itália.", true, "História", 4);
    }

    // ==================== PERGUNTAS DIFÍCEIS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - DIFÍCIL
    private void carregarGuerreiroDificilMultiplaEscolha() {
        // COMBATE (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que é 'kyusho' (arte dos pontos de pressão)?",
                Arrays.asList("Golpe psicológico", "Técnica de ataque a pontos vitais", "Defesa contra arma", "Meditação"), "B", "Combate", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "No Boxe, o que é 'southpaw'?",
                Arrays.asList("Lutador destro", "Lutador canhoto", "Golpe proibido", "Posição defensiva"), "B", "Combate", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Qual é a origem do 'Krav Maga'?",
                Arrays.asList("Japão", "Israel", "China", "Rússia"), "B", "Combate", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que significa 'Osoto Gari' no Judô?",
                Arrays.asList("Projeção de perna", "Grande ceifa externa", "Chave de braço", "Estrangulamento"), "B", "Combate", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que é 'armlock' (chave de braço) no MMA?",
                Arrays.asList("Golpe no rosto", "Finalização que hiperextende o cotovelo", "Chave de perna", "Posição de guarda"), "B", "Combate", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "No Caratê, o que é 'mawashi geri'?",
                Arrays.asList("Chute frontal", "Chute circular (roundhouse)", "Chute lateral", "Chute descendente"), "B", "Combate", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Qual é a arte marcial nacional do Brasil?",
                Arrays.asList("Jiu-Jitsu", "Capoeira", "Judô", "Caratê"), "B", "Combate", 8);

        // ESTRATÉGIA MILITAR (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que é 'doutrina de guerra híbrida'?",
                Arrays.asList("Guerra nuclear", "Combinação de guerra convencional, irregular e cibernética", "Guerra naval", "Guerra psicológica"), "B", "Estratégia", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que significa 'MAD' (Mutual Assured Destruction)?",
                Arrays.asList("Estratégia de paz", "Destruição Mútua Assegurada na Guerra Fria", "Tratado de desarmamento", "Arma secreta"), "B", "Estratégia", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que é 'guerra cibernética'?",
                Arrays.asList("Guerra com robôs", "Ataques a sistemas de computador e redes", "Guerra espacial", "Guerra eletrônica"), "B", "Estratégia", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que é 'centro de gravidade' na estratégia de Clausewitz?",
                Arrays.asList("Ponto mais fraco", "Fonte de força do inimigo", "Quartel-general", "Arma principal"), "B", "Estratégia", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que significa 'OODA loop' (Observe, Orient, Decide, Act)?",
                Arrays.asList("Tática de recuo", "Ciclo de tomada de decisão em combate", "Treinamento físico", "Protocolo de rendição"), "B", "Estratégia", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que é 'guerra de informação'?",
                Arrays.asList("Batalha com dados", "Uso de informações para vantagem tática e psicológica", "Espionagem", "Propaganda"), "B", "Estratégia", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que é uma 'operação de bandeira falsa'?",
                Arrays.asList("Operação verdadeira", "Ataque atribuído falsamente a outro grupo", "Retirada", "Cerco"), "B", "Estratégia", 8);

        // HISTÓRIA DE GUERRAS (11 perguntas)
        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Qual batalha marcou o fim do domínio naval de Napoleão?",
                Arrays.asList("Austerlitz", "Trafalgar", "Waterloo", "Jena"), "B", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que foi a 'Batalha de Cannae' (216 a.C.)?",
                Arrays.asList("Vitória romana", "Vitória de Aníbal cercando exército romano", "Tratado de paz", "Cerco de Cartago"), "B", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Quem escreveu 'Da Guerra' (Vom Kriege)?",
                Arrays.asList("Sun Tzu", "Clausewitz", "Jomini", "Maquiavel"), "B", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Qual foi a mais longa guerra da história?",
                Arrays.asList("Guerra dos Cem Anos", "Guerra do Peloponeso", "Guerra dos Trinta Anos", "Reconquista Espanhola (~781 anos)"), "D", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que foi a 'Batalha de Alesia' (52 a.C.)?",
                Arrays.asList("Derrota de César", "Cerco de Júlio César a Vercingetórix", "Batalha naval", "Tratado de paz"), "B", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Qual foi a maior invasão anfíbia da história?",
                Arrays.asList("Dia D (Normandia)", "Desembarque na Sicília", "Invasão de Okinawa", "Invasão da Coreia"), "A", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que aconteceu na 'Batalha de Stalingrado'?",
                Arrays.asList("Derrota alemã e captura do 6º Exército", "Vitória alemã", "Empate", "Retirada russa"), "A", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que foi o 'Plano Schlieffen'?",
                Arrays.asList("Plano de defesa francês", "Estratégia alemã para guerra em duas frentes", "Plano naval inglês", "Aliança secreta"), "B", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Quem comandou a 'Operação Overlord'?",
                Arrays.asList("Patton", "Montgomery", "Eisenhower", "Bradley"), "C", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "O que foi a 'Guerra do Peloponeso'?",
                Arrays.asList("Guerra entre Atenas e Esparta", "Guerra Persa", "Guerra macedônica", "Guerra civil romana"), "A", "História", 8);

        adicionarPerguntaMultipla(PerTipo.GUERREIRO, Dificuldade.DIFICIL,
                "Qual foi o grande estrategista cartaginês?",
                Arrays.asList("Asdrúbal", "Magão", "Aníbal", "Amílcar"), "C", "História", 8);
    }

    // 25 questões de VERDADEIRO OU FALSO - DIFÍCIL
    private void carregarGuerreiroDificilVerdadeiroFalso() {
        // COMBATE (7 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'kimura' é uma chave de ombro no Jiu-Jitsu.", true, "Combate", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "No Muay Thai, o 'roundhouse kick' tradicional é desferido com a canela.", true, "Combate", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'rear-naked choke' estrangula sem comprimir a traqueia.", true, "Combate", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'guarda fechada' no Jiu-Jitsu é uma posição inferior.", true, "Combate", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'foot sweep' (varredura) no Judô é ilegal.", false, "Combate", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "No Caratê Shotokan, o 'kiai' é o grito de energia.", true, "Combate", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'armadura de placas' pesava mais de 50 kg.", false, "Combate", 8);

        // ESTRATÉGIA (6 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "'Ataque de flanco' é frequentemente mais eficaz que ataque frontal.", true, "Estratégia", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "'Bait and switch' no combate é uma tática de distração.", true, "Estratégia", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "'Guerra de posição' prefere movimento constante.", false, "Estratégia", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "'Forças especiais' geralmente operam em grandes batalhões.", false, "Estratégia", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'princípio da segurança' em estratégia evita surpresas inimigas.", true, "Estratégia", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "'Manobra indireta' de Liddell Hart busca atacar pontos fortes.", false, "Estratégia", 8);

        // HISTÓRIA (12 perguntas)
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Batalha de Salamina' foi uma vitória naval grega sobre os persas.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'Code Talkers' foram indígenas que usaram sua língua para códigos na Segunda Guerra.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Batalha de Kursk' foi a maior batalha de tanques da história.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'Tratado de Tordesilhas' dividiu o mundo entre Portugal e Espanha com influência militar.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Guerra dos Farrapos' foi vencida pelos farroupilhas.", false, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Conferência de Ialta' (1945) dividiu a Europa pós-guerra.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Cavalaria' ainda existe em alguns exércitos modernos.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Legião Estrangeira Francesa' foi criada por Napoleão.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Batalha do Riachuelo' foi na Guerra do Paraguai.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'Canadá' queimou a Casa Branca em 1812.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "A 'Páscoa Sangrenta' (1916) foi uma revolta na Irlanda.", true, "História", 8);
        adicionarPerguntaVF(PerTipo.GUERREIRO, Dificuldade.DIFICIL, "O 'Japão' ainda mantém um exército proibido pela constituição.", true, "História", 8);
    }

    // ==================== SÁBIO - 200 PERGUNTAS ====================
    private void carregarPerguntasSabio() {
        carregarSabioFacilMultiplaEscolha();  // 50 questões
        carregarSabioFacilVerdadeiroFalso();  // 50 questões
        carregarSabioMedioMultiplaEscolha();  // 25 questões
        carregarSabioMedioVerdadeiroFalso();  // 25 questões
        carregarSabioDificilMultiplaEscolha(); // 25 questões
        carregarSabioDificilVerdadeiroFalso(); // 25 questões
    }

    // ==================== PERGUNTAS FÁCEIS (100) ====================

    // 50 questões de MÚLTIPLA ESCOLHA - FÁCIL
    private void carregarSabioFacilMultiplaEscolha() {
        // FILOSOFIA (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quem disse 'Penso, logo existo'?",
                Arrays.asList("Platão", "Aristóteles", "Descartes", "Sócrates"), "C", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual filósofo grego foi mestre de Alexandre, o Grande?",
                Arrays.asList("Platão", "Aristóteles", "Sócrates", "Pitágoras"), "B", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que significa a palavra 'Filosofia'?",
                Arrays.asList("Amor ao conhecimento", "Amor à sabedoria", "Estudo da vida", "Ciência exata"), "B", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual filósofo escreveu 'A República'?",
                Arrays.asList("Aristóteles", "Sócrates", "Platão", "Epicuro"), "C", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quem é conhecido como o 'pai da filosofia ocidental'?",
                Arrays.asList("Platão", "Aristóteles", "Sócrates", "Tales de Mileto"), "C", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual corrente filosófica acredita que o conhecimento vem da experiência?",
                Arrays.asList("Racionalismo", "Idealismo", "Empirismo", "Ceticismo"), "C", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quem escreveu 'O Príncipe', sobre política e poder?",
                Arrays.asList("Thomas Hobbes", "Maquiavel", "John Locke", "Rousseau"), "B", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual filósofo alemão criticou a religião e disse 'Deus está morto'?",
                Arrays.asList("Kant", "Hegel", "Nietzsche", "Schopenhauer"), "C", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que é a 'dialética' para Platão?",
                Arrays.asList("Método de debate e busca da verdade", "Poema", "Ciência exata", "Religião"), "A", "Filosofia", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual escola filosófica pregava a indiferença à dor e ao prazer?",
                Arrays.asList("Epicurismo", "Estoicismo", "Ceticismo", "Hedonismo"), "B", "Filosofia", 1);

        // CIÊNCIA (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é o planeta conhecido como 'Estrela D'Alva'?",
                Arrays.asList("Marte", "Júpiter", "Vênus", "Saturno"), "C", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual cientista propôs a teoria da evolução por seleção natural?",
                Arrays.asList("Lamarck", "Darwin", "Mendel", "Wallace"), "B", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que é a célula?",
                Arrays.asList("Unidade básica da vida", "Molécula", "Tecido", "Órgão"), "A", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual órgão é responsável por bombear o sangue?",
                Arrays.asList("Pulmão", "Fígado", "Coração", "Rim"), "C", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que é DNA?",
                Arrays.asList("Proteína", "Material genético", "Carboidrato", "Vitamina"), "B", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual vírus causou a pandemia de 2020?",
                Arrays.asList("H1N1", "Ebola", "COVID-19 (SARS-CoV-2)", "Zika"), "C", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é o maior osso do corpo humano?",
                Arrays.asList("Fêmur", "Tíbia", "Rádio", "Úmero"), "A", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual parte da planta realiza a fotossíntese?",
                Arrays.asList("Raiz", "Caule", "Folha", "Flor"), "C", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é o órgão responsável pela visão?",
                Arrays.asList("Ouvido", "Olho", "Nariz", "Língua"), "B", "Ciência", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual cientista desenvolveu a teoria da relatividade?",
                Arrays.asList("Newton", "Galileu", "Einstein", "Bohr"), "C", "Ciência", 1);

        // ARTE (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quem pintou o teto da Capela Sistina?",
                Arrays.asList("Da Vinci", "Michelangelo", "Rafael", "Donatello"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual artista cortou a própria orelha?",
                Arrays.asList("Monet", "Van Gogh", "Picasso", "Rembrandt"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que é a Mona Lisa?",
                Arrays.asList("Escultura", "Pintura", "Música", "Livro"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual movimento artístico inclui Salvador Dalí?",
                Arrays.asList("Impressionismo", "Cubismo", "Surrealismo", "Barroco"), "C", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quem pintou 'Os Girassóis'?",
                Arrays.asList("Monet", "Van Gogh", "Gauguin", "Cézanne"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual desses é um famoso compositor de música clássica?",
                Arrays.asList("Beatles", "Beethoven", "Elvis", "Michael Jackson"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que é o 'Renascimento' cultural?",
                Arrays.asList("Período medieval", "Movimento de redescoberta da arte e ciência greco-romana", "Guerra", "Revolução industrial"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quem esculpiu o 'David'?",
                Arrays.asList("Leonardo", "Michelangelo", "Donatello", "Bernini"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual pintor é conhecido por suas obras abstratas como 'Composição VIII'?",
                Arrays.asList("Mondrian", "Kandinsky", "Pollock", "Miró"), "B", "Arte", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual estilo artístico é caracterizado por pequenas pinceladas de cor?",
                Arrays.asList("Cubismo", "Impressionismo", "Expressionismo", "Realismo"), "B", "Arte", 1);

        // MATEMÁTICA (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quanto é 7 x 8?",
                Arrays.asList("48", "54", "56", "63"), "C", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é a raiz quadrada de 81?",
                Arrays.asList("7", "8", "9", "10"), "C", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quanto é 15% de 200?",
                Arrays.asList("20", "25", "30", "35"), "C", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é o valor de π (pi) aproximado?",
                Arrays.asList("2,14", "3,14", "4,14", "5,14"), "B", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Um triângulo com todos os lados iguais é chamado:",
                Arrays.asList("Isósceles", "Escaleno", "Equilátero", "Retângulo"), "C", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quanto é 2³ (dois ao cubo)?",
                Arrays.asList("4", "6", "8", "10"), "C", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é a soma dos ângulos internos de um triângulo?",
                Arrays.asList("90°", "180°", "270°", "360°"), "B", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual número é primo?",
                Arrays.asList("4", "6", "7", "9"), "C", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quanto é 144 ÷ 12?",
                Arrays.asList("10", "11", "12", "13"), "C", "Matemática", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Uma dúzia representa quantas unidades?",
                Arrays.asList("10", "11", "12", "13"), "C", "Matemática", 1);

        // FÍSICA (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é a unidade de medida de força?",
                Arrays.asList("Watt", "Joule", "Newton", "Pascal"), "C", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que acontece quando aquecemos um metal?",
                Arrays.asList("Contrai", "Dilata", "Derrete imediatamente", "Não muda"), "B", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é a velocidade aproximada da luz no vácuo?",
                Arrays.asList("300 mil km/s", "150 mil km/s", "1 milhão km/s", "30 mil km/s"), "A", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Quem descobriu a gravidade com a história da maçã?",
                Arrays.asList("Einstein", "Newton", "Galileu", "Kepler"), "B", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que mede um voltímetro?",
                Arrays.asList("Corrente elétrica", "Resistência", "Tensão elétrica", "Potência"), "C", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual lei diz que 'ação e reação são iguais e opostas'?",
                Arrays.asList("1ª Lei", "2ª Lei", "3ª Lei de Newton", "Lei da Gravitação"), "C", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O som se propaga mais rápido em:",
                Arrays.asList("Ar", "Água", "Aço", "Vácuo"), "C", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual é a unidade de potência?",
                Arrays.asList("Volt", "Ampere", "Watt", "Ohm"), "C", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "O que é inércia?",
                Arrays.asList("Tendência de um corpo permanecer em seu estado", "Força da gravidade", "Aceleração", "Velocidade constante"), "A", "Física", 1);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.FACIL,
                "Qual fenômeno explica um lápis parecendo quebrado dentro da água?",
                Arrays.asList("Reflexão", "Refração", "Difração", "Dispersão"), "B", "Física", 1);
    }

    // 50 questões de VERDADEIRO OU FALSO - FÁCIL
    private void carregarSabioFacilVerdadeiroFalso() {
        // FILOSOFIA (10 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Sócrates foi condenado à morte bebendo veneno.", true, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Platão foi discípulo de Aristóteles.", false, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "'Conhece-te a ti mesmo' é uma frase atribuída a Sócrates.", true, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O Existencialismo teve como expoente Jean-Paul Sartre.", true, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Karl Marx escreveu 'O Contrato Social'.", false, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A 'Caverna de Platão' é uma alegoria sobre o conhecimento.", true, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O Utilitarismo defende a maior felicidade para o maior número.", true, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Nietzsche era um filósofo alemão do século XIX.", true, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Immanuel Kant escreveu 'Crítica da Razão Pura'.", true, "Filosofia", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O Hedonismo prega que o prazer é o único bem.", true, "Filosofia", 1);

        // CIÊNCIA (10 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A água ferve a 100°C ao nível do mar.", true, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O coração humano tem 4 câmaras.", true, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A Terra é o centro do universo.", false, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O sangue venoso é vermelho escuro, não azul.", true, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "As plantas respiram durante a noite.", true, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A vacina contra a COVID-19 foi desenvolvida em 1 mês.", false, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O vírus da gripe é uma bactéria.", false, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O osso do fêmur fica no braço.", false, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O cérebro humano tem cerca de 86 bilhões de neurônios.", true, "Ciência", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Darwin viajou no navio Beagle.", true, "Ciência", 1);

        // ARTE (10 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Michelangelo foi pintor, escultor e arquiteto.", true, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A obra 'Guernica' é de Pablo Picasso.", true, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Van Gogh vendeu muitas obras em vida.", false, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Beethoven era surdo no final da vida.", true, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O 'Ballet' é um estilo de dança clássica.", true, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A 'Sinfonia nº 5' é de Mozart.", false, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O Museu do Louvre fica em Paris.", true, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A Capela Sistina está no Vaticano.", true, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Claude Monet foi um pintor impressionista.", true, "Arte", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A escultura 'O Pensador' é de Rodin.", true, "Arte", 1);

        // MATEMÁTICA (10 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "1 km equivale a 1000 metros.", true, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "0,5 é maior que 1/3.", true, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Todo número par é divisível por 4.", false, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "2 + 2 x 2 = 8.", false, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O quadrado tem 4 lados iguais.", true, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "10% de 100 é 10.", true, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "1 litro equivale a 1000 ml.", true, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A raiz quadrada de 64 é 9.", false, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "7 x 6 = 42.", true, "Matemática", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O círculo tem 360 graus.", true, "Matemática", 1);

        // FÍSICA (10 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A energia não se cria nem se destrói, apenas se transforma.", true, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Quanto maior a massa, maior a inércia.", true, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O gelo é mais denso que a água líquida.", false, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Um imã atrai apenas ferro.", false, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A luz é uma onda eletromagnética.", true, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O som não se propaga no vácuo.", true, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A gravidade na Lua é maior que na Terra.", false, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "O fusível queima para proteger o circuito.", true, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "Quanto maior a altura, maior a pressão atmosférica.", false, "Física", 1);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.FACIL, "A eletricidade pode ser gerada por energia solar.", true, "Física", 1);
    }

    // ==================== PERGUNTAS MÉDIAS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - MÉDIO
    private void carregarSabioMedioMultiplaEscolha() {
        // FILOSOFIA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual conceito de Nietzsche representa o 'super-homem'?",
                Arrays.asList("Übermensch", "Vontade de potência", "Eterno retorno", "Niilismo"), "A", "Filosofia", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "O 'imperativo categórico' é um conceito de qual filósofo?",
                Arrays.asList("Hegel", "Kant", "Hume", "Locke"), "B", "Filosofia", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Quem escreveu 'A Ética a Nicômaco'?",
                Arrays.asList("Platão", "Sócrates", "Aristóteles", "Epicuro"), "C", "Filosofia", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "O que é o 'materialismo histórico' de Marx?",
                Arrays.asList("História baseada em ideias", "História baseada em condições materiais e economia", "História religiosa", "História dos reis"), "B", "Filosofia", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual filósofo escreveu 'O Existencialismo é um Humanismo'?",
                Arrays.asList("Heidegger", "Camus", "Sartre", "Kierkegaard"), "C", "Filosofia", 4);

        // CIÊNCIA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual é o processo de divisão celular que produz gametas?",
                Arrays.asList("Mitose", "Meiose", "Fissão", "Gemulação"), "B", "Ciência", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual é o principal gás de efeito estufa emitido por humanos?",
                Arrays.asList("Metano", "Óxido nitroso", "Dióxido de carbono", "CFC"), "C", "Ciência", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "O que é a 'seleção natural'?",
                Arrays.asList("Escolha humana de animais", "Sobrevivência do mais adaptado", "Mutação aleatória", "Criação divina"), "B", "Ciência", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual tipo de célula não possui núcleo definido?",
                Arrays.asList("Eucarionte", "Procarionte", "Animal", "Vegetal"), "B", "Ciência", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "O que mede a escala Richter?",
                Arrays.asList("Furacões", "Terremotos", "Vulcões", "Tsunamis"), "B", "Ciência", 4);

        // ARTE (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual movimento artístico é conhecido por formas geométricas e fragmentação?",
                Arrays.asList("Impressionismo", "Cubismo", "Surrealismo", "Pop Art"), "B", "Arte", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Quem pintou 'A Noite Estrelada'?",
                Arrays.asList("Van Gogh", "Monet", "Gauguin", "Cézanne"), "A", "Arte", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual escola de samba é um movimento artístico e musical brasileiro?",
                Arrays.asList("Frevo", "Maracatu", "Samba", "Baião"), "C", "Arte", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Quem é considerado o 'pai da música clássica'?",
                Arrays.asList("Mozart", "Beethoven", "Bach", "Vivaldi"), "C", "Arte", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "O que é 'ready-made' na arte?",
                Arrays.asList("Obra pronta", "Objeto comum elevado a arte", "Escultura", "Instalação"), "B", "Arte", 4);

        // MATEMÁTICA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual é o valor de x em 2x + 5 = 15?",
                Arrays.asList("3", "4", "5", "6"), "C", "Matemática", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual é a fração equivalente a 0,75?",
                Arrays.asList("1/2", "2/3", "3/4", "4/5"), "C", "Matemática", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual é a raiz quadrada de 144?",
                Arrays.asList("10", "11", "12", "13"), "C", "Matemática", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Quantos graus tem um ângulo reto?",
                Arrays.asList("45°", "90°", "180°", "360°"), "B", "Matemática", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual é a fórmula da área do círculo?",
                Arrays.asList("πr²", "2πr", "πd", "πr"), "A", "Matemática", 4);

        // FÍSICA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual lei da termodinâmica diz que a entropia sempre aumenta?",
                Arrays.asList("Primeira", "Segunda", "Terceira", "Zero"), "B", "Física", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "O que é um 'elétron'?",
                Arrays.asList("Partícula com carga positiva", "Partícula com carga negativa", "Partícula neutra", "Próton"), "B", "Física", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual é a unidade de frequência?",
                Arrays.asList("Hertz", "Metro", "Segundo", "Watt"), "A", "Física", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "Qual cientista formulou as leis do movimento planetário?",
                Arrays.asList("Galileu", "Kepler", "Copérnico", "Ptolomeu"), "B", "Física", 4);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.MEDIO,
                "O que é a 'relatividade geral' de Einstein?",
                Arrays.asList("Absoluta do tempo", "Gravidade como curvatura do espaço-tempo", "Velocidade da luz variável", "Tempo absoluto"), "B", "Física", 4);
    }

    // 25 questões de VERDADEIRO OU FALSO - MÉDIO
    private void carregarSabioMedioVerdadeiroFalso() {
        // FILOSOFIA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O 'cogito ergo sum' é de René Descartes.", true, "Filosofia", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O 'Mito da Caverna' é uma alegoria de Aristóteles.", false, "Filosofia", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O Estoicismo foi fundado por Zenão de Cítio.", true, "Filosofia", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "'O Ser e o Nada' foi escrito por Sartre.", true, "Filosofia", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "Epicuro defendia o prazer moderado e ausência de dor.", true, "Filosofia", 4);

        // CIÊNCIA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O ozônio (O₃) na estratosfera protege contra raios UV.", true, "Ciência", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O pH neutro é 7.", true, "Ciência", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O oxigênio é o elemento mais abundante na crosta terrestre.", true, "Ciência", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "As mitocôndrias são responsáveis pela digestão celular.", false, "Ciência", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O buraco negro tem gravidade tão forte que nem a luz escapa.", true, "Ciência", 4);

        // ARTE (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O 'Barroco' foi um movimento artístico do século XVII.", true, "Arte", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "A 'Mona Lisa' está no Museu Britânico.", false, "Arte", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "Salvador Dalí foi um pintor surrealista espanhol.", true, "Arte", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O 'Samba' é patrimônio cultural imaterial do Brasil.", true, "Arte", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "'Tarsila do Amaral' pintou 'Abaporu'.", true, "Arte", 4);

        // MATEMÁTICA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "Todo número primo é ímpar.", false, "Matemática", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "A raiz quadrada de 25 é 5.", true, "Matemática", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "0,999... é igual a 1.", true, "Matemática", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O número π é racional.", false, "Matemática", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "Um hexágono tem 5 lados.", false, "Matemática", 4);

        // FÍSICA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "A energia cinética depende da massa e da velocidade.", true, "Física", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O som viaja mais rápido no ar do que na água.", false, "Física", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "A primeira lei de Newton é a lei da inércia.", true, "Física", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "A luz branca é composta por várias cores.", true, "Física", 4);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.MEDIO, "O trabalho é força vezes distância.", true, "Física", 4);
    }

    // ==================== PERGUNTAS DIFÍCEIS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - DIFÍCIL
    private void carregarSabioDificilMultiplaEscolha() {
        // FILOSOFIA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Quem escreveu 'Ser e Tempo' (Sein und Zeit)?",
                Arrays.asList("Sartre", "Heidegger", "Husserl", "Merleau-Ponty"), "B", "Filosofia", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é a 'Má vontade' (mauvaise foi) para Sartre?",
                Arrays.asList("Mentira a si mesmo", "Vontade de poder", "Pecado original", "Covardia"), "A", "Filosofia", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual filósofo desenvolveu o 'Utilitarismo' como sistema ético?",
                Arrays.asList("John Stuart Mill", "Jeremy Bentham", "Kant", "Hume"), "B", "Filosofia", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é a 'Razão Instrumental' na Escola de Frankfurt?",
                Arrays.asList("Racionalidade que busca só meios eficientes", "Racionalidade crítica", "Filosofia pura", "Lógica formal"), "A", "Filosofia", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Quem escreveu 'A Fenomenologia do Espírito'?",
                Arrays.asList("Kant", "Hegel", "Schopenhauer", "Nietzsche"), "B", "Filosofia", 8);

        // CIÊNCIA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual é o princípio da 'seleção natural' de Darwin?",
                Arrays.asList("Uso e desuso", "Sobrevivência do mais forte", "Variação hereditária + adaptação", "Herança de características adquiridas"), "C", "Ciência", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é epigenética?",
                Arrays.asList("Estudo de genes", "Alterações na expressão genética sem mudar o DNA", "Mutação genética", "Engenharia genética"), "B", "Ciência", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual vírus causa a AIDS?",
                Arrays.asList("HIV", "HPV", "HSV", "H1N1"), "A", "Ciência", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é um 'bioma'?",
                Arrays.asList("Comunidade de seres vivos", "Conjunto de ecossistemas com clima similar", "Espécie", "Habitat"), "B", "Ciência", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual é o processo de 'fermentação'?",
                Arrays.asList("Respiração aeróbica", "Produção de energia sem oxigênio", "Fotossíntese", "Digestão"), "B", "Ciência", 8);

        // ARTE (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Quem pintou 'As Meninas'?",
                Arrays.asList("El Greco", "Goya", "Velázquez", "Zurbarán"), "C", "Arte", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual movimento artístico foi liderado por Andy Warhol?",
                Arrays.asList("Dadaísmo", "Pop Art", "Minimalismo", "Op Art"), "B", "Arte", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é 'trompe-l'œil' na arte?",
                Arrays.asList("Pintura realista que engana o olho", "Escultura abstrata", "Colagem", "Instalação"), "A", "Arte", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Quem compôs 'As Quatro Estações'?",
                Arrays.asList("Bach", "Vivaldi", "Mozart", "Handel"), "B", "Arte", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual pintor criou o movimento 'Pintura Rupestre' moderna?",
                Arrays.asList("Picasso", "Matisse", "Miró", "Ninguém, é pré-histórica"), "D", "Arte", 8);

        // MATEMÁTICA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual é o valor do número de Euler (e) aproximado?",
                Arrays.asList("2,718", "3,141", "1,618", "1,414"), "A", "Matemática", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é um 'número transcendental'?",
                Arrays.asList("Número irracional", "Número que não é raiz de polinômio com coeficientes inteiros", "Número racional", "Número complexo"), "B", "Matemática", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual é o conjunto dos números reais?",
                Arrays.asList("Apenas inteiros", "Racionais e irracionais", "Apenas decimais", "Apenas frações"), "B", "Matemática", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é um 'espaço vetorial'?",
                Arrays.asList("Conjunto de vetores com operações", "Plano cartesiano", "Geometria", "Álgebra"), "A", "Matemática", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual é a derivada de sen(x)?",
                Arrays.asList("cos(x)", "-sen(x)", "-cos(x)", "tan(x)"), "A", "Matemática", 8);

        // FÍSICA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que diz a lei de Coulomb?",
                Arrays.asList("Força entre cargas elétricas", "Força gravitacional", "Indução eletromagnética", "Resistência elétrica"), "A", "Física", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é 'entropia'?",
                Arrays.asList("Energia interna", "Medida de desordem", "Calor específico", "Pressão"), "B", "Física", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é o 'Princípio da Incerteza' de Heisenberg?",
                Arrays.asList("Não se pode medir posição e momento com precisão", "Tudo é incerto", "Luz é partícula", "Ondas são partículas"), "A", "Física", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "O que é o 'Efeito Doppler'?",
                Arrays.asList("Mudança de frequência por movimento relativo", "Expansão do universo", "Desvio para o vermelho", "Relatividade"), "A", "Física", 8);

        adicionarPerguntaMultipla(PerTipo.SABIO, Dificuldade.DIFICIL,
                "Qual é a equação de Schrödinger?",
                Arrays.asList("Equação fundamental da mecânica quântica", "Relatividade", "Termodinâmica", "Eletromagnetismo"), "A", "Física", 8);
    }

    // 25 questões de VERDADEIRO OU FALSO - DIFÍCIL
    private void carregarSabioDificilVerdadeiroFalso() {
        // FILOSOFIA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O 'Niilismo' para Nietzsche é a desvalorização dos valores superiores.", true, "Filosofia", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "Hannah Arendt escreveu 'As Origens do Totalitarismo'.", true, "Filosofia", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A 'Máquina de guerra' é um conceito de Gilles Deleuze.", true, "Filosofia", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O 'Contrato Social' foi escrito por John Locke.", false, "Filosofia", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "Thomas Hobbes acreditava que o homem é naturalmente bom.", false, "Filosofia", 8);

        // CIÊNCIA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A gripe espanhola (1918) matou mais pessoas que a Primeira Guerra Mundial.", true, "Ciência", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "As mitocôndrias têm seu próprio DNA.", true, "Ciência", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O CRISPR é uma técnica de edição genética.", true, "Ciência", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A febre amarela é transmitida por bactérias.", false, "Ciência", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A vida na Terra surgiu há cerca de 3,5 bilhões de anos.", true, "Ciência", 8);

        // ARTE (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "Marcel Duchamp foi um artista dadaísta.", true, "Arte", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A 'Escola de Atenas' é uma pintura de Michelangelo.", false, "Arte", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O 'Expressionismo' alemão surgiu no início do século XX.", true, "Arte", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "Frida Kahlo era mexicana.", true, "Arte", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A 'Sinfonia Inacabada' é de Schubert.", true, "Arte", 8);

        // MATEMÁTICA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O número φ (phi, proporção áurea) é aproximadamente 1,618.", true, "Matemática", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O conjunto dos números complexos contém os reais.", true, "Matemática", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "Zero pertence ao conjunto dos números naturais.", false, "Matemática", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A soma dos ângulos internos de um pentágono regular é 540°.", true, "Matemática", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "10! (10 fatorial) = 3.628.800.", true, "Matemática", 8);

        // FÍSICA (5 perguntas)
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A luz tem massa.", false, "Física", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O 'Gato de Schrödinger' é um experimento sobre superposição quântica.", true, "Física", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "Buracos negros evaporam pela radiação de Hawking.", true, "Física", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "A velocidade da luz é constante em todos os referenciais inerciais.", true, "Física", 8);
        adicionarPerguntaVF(PerTipo.SABIO, Dificuldade.DIFICIL, "O elétron é uma partícula elementar.", true, "Física", 8);
    }
    // ==================== ARCANISTA - 200 PERGUNTAS ====================
    private void carregarPerguntasArcanista() {
        carregarArcanistaFacilMultiplaEscolha();  // 50 questões
        carregarArcanistaFacilVerdadeiroFalso();  // 50 questões
        carregarArcanistaMedioMultiplaEscolha();  // 25 questões
        carregarArcanistaMedioVerdadeiroFalso();  // 25 questões
        carregarArcanistaDificilMultiplaEscolha(); // 25 questões
        carregarArcanistaDificilVerdadeiroFalso(); // 25 questões
    }

    // ==================== PERGUNTAS FÁCEIS (100) ====================

    // 50 questões de MÚLTIPLA ESCOLHA - FÁCIL
    private void carregarArcanistaFacilMultiplaEscolha() {
        // MITOLOGIA (15 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na mitologia grega, quem é o rei dos deuses?",
                Arrays.asList("Poseidon", "Hades", "Zeus", "Ares"), "C", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é o deus do mar na mitologia grega?",
                Arrays.asList("Zeus", "Hades", "Poseidon", "Apolo"), "C", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na mitologia nórdica, quem empunha o martelo Mjolnir?",
                Arrays.asList("Odin", "Loki", "Thor", "Tyr"), "C", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é a deusa do amor e da beleza na mitologia romana?",
                Arrays.asList("Atena", "Afrodite (Vênus)", "Hera", "Artemisa"), "B", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Quem é o deus do submundo na mitologia grega?",
                Arrays.asList("Zeus", "Poseidon", "Hades", "Hermes"), "C", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na mitologia egípcia, quem é o deus do sol?",
                Arrays.asList("Osíris", "Ísis", "Rá", "Anúbis"), "C", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual herói grego matou a Medusa?",
                Arrays.asList("Hércules", "Perseu", "Teseu", "Aquiles"), "B", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na mitologia nórdica, onde vivem os heróis mortos em batalha?",
                Arrays.asList("Helheim", "Valhala", "Asgard", "Midgard"), "B", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Quem é a deusa da sabedoria na mitologia grega?",
                Arrays.asList("Afrodite", "Hera", "Atena", "Artemisa"), "C", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual criatura mitológica tem torso de homem e corpo de cavalo?",
                Arrays.asList("Minotauro", "Centauro", "Sátiro", "Górgona"), "B", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na mitologia grega, quem voou perto demais do sol?",
                Arrays.asList("Prometeu", "Ícaro", "Dédalo", "Perseu"), "B", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é o deus do trovão na mitologia nórdica?",
                Arrays.asList("Odin", "Thor", "Balder", "Freyr"), "B", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Quem é a deusa da caça na mitologia grega?",
                Arrays.asList("Atena", "Hera", "Artemisa", "Afrodite"), "C", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na mitologia egípcia, quem é o deus dos mortos?",
                Arrays.asList("Rá", "Osíris", "Anúbis", "Hórus"), "B", "Mitologia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual monstro grego tem cabeça de touro e corpo de homem?",
                Arrays.asList("Ciclope", "Centauro", "Minotauro", "Hidra"), "C", "Mitologia", 1);

        // MAGIA (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é um 'grimório'?",
                Arrays.asList("Poção mágica", "Livro de magia", "Varinha", "Cristal"), "B", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual varinha de Harry Potter tem a pena da cauda da Fênix?",
                Arrays.asList("Varinha de Voldemort", "Varinha de Harry", "Varinha de Dumbledore", "Todas"), "D", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O 'círculo mágico' serve para:",
                Arrays.asList("Decorar", "Proteção e concentração de energia", "Guardar poções", "Dançar"), "B", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é 'alquimia'?",
                Arrays.asList("Transformar metais em ouro", "Cura mágica", "Adivinhação", "Invocação"), "A", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é o nome da pedra lendária que transforma metais em ouro?",
                Arrays.asList("Pedra da Lua", "Pedra Filosofal", "Diamante", "Rubi"), "B", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que significa 'encantamento' na magia?",
                Arrays.asList("Poção", "Feitiço lançado em objetos", "Varinha", "Livro"), "B", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Quem é a lendária feiticeira da Ilha de Eéia, que transformou homens em porcos?",
                Arrays.asList("Medeia", "Circe", "Hécate", "Morgana"), "B", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é 'divinação'?",
                Arrays.asList("Curar", "Prever o futuro", "Invocar demônios", "Voar"), "B", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é a proteção contra energia negativa em muitas tradições?",
                Arrays.asList("Quartzo rosa", "Sal grosso", "Vela branca", "Todos acima"), "D", "Magia", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que representa o pentagrama na magia?",
                Arrays.asList("Maldade", "Proteção e os quatro elementos + espírito", "Demônio", "Lua"), "B", "Magia", 1);

        // ELEMENTOS (10 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Quais são os quatro elementos clássicos da natureza?",
                Arrays.asList("Fogo, água, terra, madeira", "Fogo, água, terra, ar", "Terra, ar, metal, madeira", "Água, fogo, metal, ar"), "B", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual elemento é associado ao calor e à transformação?",
                Arrays.asList("Água", "Terra", "Fogo", "Ar"), "C", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual elemento é associado às emoções e à intuição?",
                Arrays.asList("Fogo", "Terra", "Ar", "Água"), "D", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual elemento é associado à razão e à comunicação?",
                Arrays.asList("Água", "Fogo", "Terra", "Ar"), "D", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual elemento é associado à estabilidade e ao físico?",
                Arrays.asList("Ar", "Fogo", "Terra", "Água"), "C", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é o 'quinto elemento' em algumas tradições?",
                Arrays.asList("Madeira", "Metal", "Éter/Espírito", "Gelo"), "C", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na alquimia, o enxofre representa qual princípio?",
                Arrays.asList("Mercurial", "Salino", "Combustível/ativo (alma)", "Fixo"), "C", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O mercúrio na alquimia representa:",
                Arrays.asList("Metal", "Espírito volátil", "Água", "Fogo"), "B", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Na tradição wicca, o athame representa qual elemento?",
                Arrays.asList("Água", "Fogo", "Ar", "Terra"), "B", "Elementos", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O cálice (taça) na wicca representa qual elemento?",
                Arrays.asList("Terra", "Ar", "Fogo", "Água"), "D", "Elementos", 1);

        // OCULTISMO (15 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é o 'Tarô'?",
                Arrays.asList("Jogo de cartas comum", "Sistema de adivinhação e autoconhecimento", "Livro sagrado", "Amuleto"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Quantos arcanos maiores tem o Tarô tradicional?",
                Arrays.asList("22", "56", "78", "10"), "A", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que significa 'karma'?",
                Arrays.asList("Destino", "Sorte", "Lei de causa e efeito", "Azar"), "C", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é 'astrologia'?",
                Arrays.asList("Estudo das estrelas", "Estudo da influência dos astros nos humanos", "Astronomia", "Adivinhação"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Quantos são os signos do zodíaco?",
                Arrays.asList("10", "11", "12", "13"), "C", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é um 'talismã'?",
                Arrays.asList("Objeto de azar", "Objeto carregado com energia para um fim específico", "Amuleto comum", "Feitiço"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é a pedra associada ao chakra coronário?",
                Arrays.asList("Quartzo rosa", "Ametista", "Jaspe", "Ônix"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que significa 'umbanda' no contexto esotérico brasileiro?",
                Arrays.asList("Religião", "Magia negra", "Seita africana", "Ritual indígena"), "A", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é 'quiromancia'?",
                Arrays.asList("Leitura de borra de café", "Leitura das mãos", "Leitura de búzios", "Leitura de cartas"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é o símbolo do infinito associado à magia do amor?",
                Arrays.asList("Cruz", "Pentagrama", "Nó de Salomão", "Oito deitado (∞)"), "D", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é 'wicca'?",
                Arrays.asList("Religião pagã moderna", "Feitiço", "Livro", "Varinha"), "A", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que significa 'samhain' no calendário pagão?",
                Arrays.asList("Natal", "Ano novo celta", "Verão", "Primavera"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "Qual é o nome do oráculo chinês baseado em 64 hexagramas?",
                Arrays.asList("Tarô", "I Ching", "Runas", "Astrologia"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que é 'cristalomancia'?",
                Arrays.asList("Leitura com cristais", "Leitura com bola de cristal", "Magia com cristais", "Cristal terapia"), "B", "Ocultismo", 1);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.FACIL,
                "O que significa 'aura'?",
                Arrays.asList("Campo energético ao redor dos seres vivos", "Barulho", "Luz física", "Cor"), "A", "Ocultismo", 1);
    }

    // 50 questões de VERDADEIRO OU FALSO - FÁCIL
    private void carregarArcanistaFacilVerdadeiroFalso() {
        // MITOLOGIA (15 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Zeus é o deus do trovão na mitologia grega.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Thor é filho de Odin na mitologia nórdica.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Hades é o deus do mar.", false, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A Medusa tinha cobras no lugar do cabelo.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O cavalo de Tróia foi um presente dos gregos.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Hércules é conhecido por seus 12 trabalhos.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Afrodite nasceu da espuma do mar.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Loki é um deus nórdico sempre bondoso.", false, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O Minotauro vivia no labirinto de Creta.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Aquiles era invulnerável exceto no calcanhar.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Atena é a deusa da beleza.", false, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Odin perdeu um olho em busca de sabedoria.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A Fênix renasce das cinzas.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O Ciclope tem um olho só.", true, "Mitologia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Prometeu roubou o fogo dos deuses para dar aos humanos.", true, "Mitologia", 1);

        // MAGIA (10 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Merlin é um mago lendário das lendas arturianas.", true, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Harry Potter é um personagem real histórico.", false, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Poções mágicas existem na vida real.", false, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "'Abracadabra' é uma palavra usada em magia.", true, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O caldeirão é usado para preparar poções.", true, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A varinha mágica é usada apenas por bruxas más.", false, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O 'feitiço' é um encantamento mágico.", true, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Alquimistas tentavam transformar chumbo em ouro.", true, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O 'Oculus Reparo' é um feitiço de Harry Potter.", true, "Magia", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Toda magia é demoníaca.", false, "Magia", 1);

        // ELEMENTOS (10 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Existem apenas 4 elementos na natureza.", false, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O fogo é um elemento transformador.", true, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A água pode existir em 3 estados: sólido, líquido, gasoso.", true, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O ar é composto apenas de oxigênio.", false, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A terra é o elemento mais pesado.", true, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O éter é considerado o quinto elemento.", true, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Na alquimia, o sal representa o corpo físico.", true, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Os quatro elementos são: terra, água, ar e fogo.", true, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O elemento água é associado ao leste.", false, "Elementos", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Cada elemento tem direções e símbolos específicos.", true, "Elementos", 1);

        // OCULTISMO (15 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O Tarô tem 78 cartas.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A astrologia é uma ciência exata.", false, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O signo de Áries é o primeiro do zodíaco.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Karma significa que ações têm consequências.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A quiromancia lê as linhas da mão.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O I Ching é um oráculo chinês.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O pentagrama é sempre um símbolo do mal.", false, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O chakra é um centro de energia no corpo.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A Umbanda é uma religião brasileira.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A pedra da lua é associada à intuição.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O 'olho grego' é um amuleto contra o mau-olhado.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "Runas são letras de alfabeto germânico usadas em magia.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O número 13 é considerado azar por algumas tradições.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "A sexta-feira 13 é mito de azar.", true, "Ocultismo", 1);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.FACIL, "O 'triplo deus' na wicca representa o sol.", false, "Ocultismo", 1);
    }

    // ==================== PERGUNTAS MÉDIAS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - MÉDIO
    private void carregarArcanistaMedioMultiplaEscolha() {
        // MITOLOGIA (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Quem é o deus nórdico da guerra e da poesia?",
                Arrays.asList("Thor", "Tyr", "Odin", "Balder"), "C", "Mitologia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Na mitologia grega, quem foi punido a rolar uma pedra montanha acima eternamente?",
                Arrays.asList("Prometeu", "Sísifo", "Tântalo", "Midas"), "B", "Mitologia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Qual é a criatura com corpo de leão, cabeça de mulher e asas de águia?",
                Arrays.asList("Quimera", "Esfinge", "Harpia", "Górgona"), "B", "Mitologia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Na mitologia egípcia, Anúbis tem cabeça de qual animal?",
                Arrays.asList("Falcão", "Cachorro (chacal)", "Gato", "Crocodilo"), "B", "Mitologia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Qual herói grego participou da expedição dos Argonautas?",
                Arrays.asList("Jasão", "Perseu", "Teseu", "Hércules"), "A", "Mitologia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Na mitologia nórdica, o que é o Ragnarök?",
                Arrays.asList("Fim do mundo", "Nascimento de Thor", "Festa em Valhala", "Arma mágica"), "A", "Mitologia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Quem é a deusa do amor na mitologia nórdica?",
                Arrays.asList("Frigga", "Freya", "Hel", "Sif"), "B", "Mitologia", 4);

        // MAGIA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O que é 'magia simpática'?",
                Arrays.asList("Magia amigável", "Magia por semelhança ou contato", "Magia branca", "Magia negra"), "B", "Magia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Quem foi John Dee?",
                Arrays.asList("Caçador de bruxas", "Mago e conselheiro da rainha Elizabeth I", "Rei da Inglaterra", "Padre"), "B", "Magia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O que significa 'evocação' na magia?",
                Arrays.asList("Chamar um espírito para fora de si", "Chamar um espírito para dentro de si", "Banir", "Consagrar"), "A", "Magia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O 'Triplo Deusa' na wicca representa:",
                Arrays.asList("Donzela, Mãe, Anciã", "Nascimento, vida, morte", "Sol, lua, estrelas", "Terra, água, fogo"), "A", "Magia", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O 'Livro das Sombras' é:",
                Arrays.asList("Grimório de magia negra", "Diário e livro de feitiços de um bruxo/wiccano", "Profecia", "Mito"), "B", "Magia", 4);

        // ELEMENTOS (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Qual elemento não corresponde à emoção tradicional?",
                Arrays.asList("Água = emoção", "Terra = razão", "Fogo = vontade", "Ar = mente"), "B", "Elementos", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Na tradição ocidental, o ponto cardeal do fogo é:",
                Arrays.asList("Norte", "Leste", "Sul", "Oeste"), "C", "Elementos", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O elemento água corresponde a qual estação?",
                Arrays.asList("Primavera", "Verão", "Outono", "Inverno"), "C", "Elementos", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O que é 'alquimia interna'?",
                Arrays.asList("Magia", "Transformação espiritual do praticante", "Química", "Metalurgia"), "B", "Elementos", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Qual símbolo alquímico representa o enxofre?",
                Arrays.asList("Triângulo com traço", "Círculo com ponto", "Triângulo", "Cruz"), "A", "Elementos", 4);

        // OCULTISMO (8 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Quantas runas tem o Elder Futhark (alfabeto rúnico antigo)?",
                Arrays.asList("16", "24", "18", "32"), "B", "Ocultismo", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O que é 'sincretismo religioso'?",
                Arrays.asList("Pureza religiosa", "Mistura de diferentes crenças", "Guerra santa", "Conversão"), "B", "Ocultismo", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Qual é a cor do chakra raiz (Muladhara)?",
                Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde"), "A", "Ocultismo", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O que significa 'necromancia'?",
                Arrays.asList("Magia com plantas", "Comunicação com os mortos", "Adivinhação", "Cura"), "B", "Ocultismo", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "Qual planta é associada à proteção contra energia negativa?",
                Arrays.asList("Rosa", "Arruda", "Margarida", "Girassol"), "B", "Ocultismo", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O que significa 'banimento' em magia?",
                Arrays.asList("Chamar energia", "Remover energia negativa", "Curar", "Prever"), "B", "Ocultismo", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O 'Olho da Providência' no dólar americano é símbolo de?",
                Arrays.asList("Maçonaria/Iluminismo", "Demônio", "Magia negra", "Astrologia"), "A", "Ocultismo", 4);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.MEDIO,
                "O que é 'antroposofia'?",
                Arrays.asList("Estudo do homem", "Filosofia esotérica de Rudolf Steiner", "Magia natural", "Astrologia"), "B", "Ocultismo", 4);
    }

    // 25 questões de VERDADEIRO OU FALSO - MÉDIO
    private void carregarArcanistaMedioVerdadeiroFalso() {
        // MITOLOGIA (7 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Pandora abriu a caixa e liberou todos os males.", true, "Mitologia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Eco era uma ninfa que repetia sons.", true, "Mitologia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Narciso se apaixonou pela própria imagem.", true, "Mitologia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Teseu matou o Minotauro no labirinto.", true, "Mitologia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A Hidra de Lerna tinha 3 cabeças.", false, "Mitologia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Atlas sustenta o céu nos ombros.", true, "Mitologia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A deusa grega Hera era esposa de Zeus.", true, "Mitologia", 4);

        // MAGIA (5 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A 'Lei do Retorno' (Três vezes) é um princípio wiccano.", true, "Magia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Magia cerimonial usa poucos rituais.", false, "Magia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "O 'selo de Salomão' é um símbolo mágico.", true, "Magia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Aleister Crowley foi um mago influente.", true, "Magia", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "O 'círculo mágico' é aberto no sentido anti-horário.", false, "Magia", 4);

        // ELEMENTOS (5 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "O elemento ar é associado ao leste.", true, "Elementos", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A terra é associada ao elemento norte.", true, "Elementos", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "O fogo é associado ao oeste.", false, "Elementos", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Os 4 elementos são encontrados em todas as tradições mágicas.", false, "Elementos", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A pentáculo representa os 4 elementos + espírito.", true, "Elementos", 4);

        // OCULTISMO (8 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A cabala é um sistema místico judaico.", true, "Ocultismo", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A 'Árvore da Vida' tem 10 esferas (sefirot).", true, "Ocultismo", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "O horóscopo chinês tem 12 animais.", true, "Ocultismo", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "O 'número da besta' é 666 no Apocalipse.", true, "Ocultismo", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A Pedra Filosofal existe fisicamente.", false, "Ocultismo", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "O 'Mestre Kuthumi' é um mestre ascensionista.", true, "Ocultismo", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "A 'Quarta Dimensão' é espírito no ocultismo.", true, "Ocultismo", 4);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.MEDIO, "Oráculo de Delfos era um local de adivinhação grego.", true, "Ocultismo", 4);
    }

    // ==================== PERGUNTAS DIFÍCEIS (50) ====================

    // 25 questões de MÚLTIPLA ESCOLHA - DIFÍCIL
    private void carregarArcanistaDificilMultiplaEscolha() {
        // MITOLOGIA (7 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Quem é o deus egípcio do caos e da noite?",
                Arrays.asList("Rá", "Apófis (Apep)", "Set", "Toth"), "B", "Mitologia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Na mitologia grega, quem foi o criador dos humanos?",
                Arrays.asList("Zeus", "Prometeu", "Atena", "Hefesto"), "B", "Mitologia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Qual é o nome do deus nórdico cego que matou Balder com visco?",
                Arrays.asList("Vidar", "Vali", "Hödr", "Hermodr"), "C", "Mitologia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Na mitologia hindu, qual é o veículo (vahana) de Ganesha?",
                Arrays.asList("Rato", "Pavão", "Touro", "Leão"), "A", "Mitologia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Quem é a deusa nórdica do submundo (Helheim)?",
                Arrays.asList("Hel", "Freya", "Frigga", "Sif"), "A", "Mitologia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Qual monstro grego tem cabelos de serpente e olhar petrificante?",
                Arrays.asList("Górgona (Medusa)", "Harpia", "Quimera", "Hidra"), "A", "Mitologia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Na mitologia japonesa, qual é a deusa do sol?",
                Arrays.asList("Tsukuyomi", "Amaterasu", "Susanoo", "Izanami"), "B", "Mitologia", 8);

        // MAGIA (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O que é 'goécia'?",
                Arrays.asList("Magia branca", "Evocação de demônios", "Magia natural", "Alquimia"), "B", "Magia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Quem escreveu 'A Chave de Salomão' (Clavicula Salomonis)?",
                Arrays.asList("Salomão", "Pseudoepígrafe medieval", "Crowley", "Agripa"), "B", "Magia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O que significa 'theurgia'?",
                Arrays.asList("Magia divina/evocação de deuses", "Magia demoníaca", "Adivinhação", "Cura"), "A", "Magia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Na magia enoquiana, os 'Tablets' foram recebidos por quem?",
                Arrays.asList("Aleister Crowley", "John Dee e Edward Kelley", "Eliphas Levi", "S. L. MacGregor Mathers"), "B", "Magia", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O que é a 'Cábala Hermética'?",
                Arrays.asList("Cabala judaica pura", "Sistema ocidental de magia baseado na Árvore da Vida", "Alquimia", "Astrologia"), "B", "Magia", 8);

        // ELEMENTOS (5 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Na visão aristotélica, os elementos são movidos por quais qualidades?",
                Arrays.asList("Quente/frio, seco/úmido", "Amor/ódio", "Luz/escuro", "Atração/repulsão"), "A", "Elementos", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O 'homúnculo' na alquimia é:",
                Arrays.asList("Filósofo", "Ser humano criado artificialmente", "Pedra filosofal", "Metal"), "B", "Elementos", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Qual elemento é associado ao 'Mago' no Tarô?",
                Arrays.asList("Fogo", "Água", "Ar", "Terra"), "C", "Elementos", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "A 'Quinta Essência' (quintessência) é:",
                Arrays.asList("Água", "Éter", "Fogo", "Terra"), "B", "Elementos", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "No sistema dos 5 elementos chinês (Wu Xing), qual a ordem de geração?",
                Arrays.asList("Madeira→Fogo→Terra→Metal→Água", "Terra→Metal→Água→Madeira→Fogo", "Todas acima"), "A", "Elementos", 8);

        // OCULTISMO (8 perguntas)
        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O que é a 'Gnose' no Gnosticismo?",
                Arrays.asList("Fé cega", "Conhecimento espiritual direto", "Rito secreto", "Profecia"), "B", "Ocultismo", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Qual é o nome do demônio da goécia nº 1 (rei do oriente)?",
                Arrays.asList("Baal", "Paimon", "Lúcifer", "Belzebu"), "A", "Ocultismo", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O que significa 'Ayin' no caminho espiritual?",
                Arrays.asList("Nada/Vazio", "Luz", "Escuridão", "Sabedoria"), "A", "Ocultismo", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "A 'Ordem Hermética da Aurora Dourada' (Golden Dawn) foi fundada em:",
                Arrays.asList("1789", "1888", "1904", "1920"), "B", "Ocultismo", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Quem escreveu 'O Livro da Lei' (Liber AL vel Legis)?",
                Arrays.asList("John Dee", "Aleister Crowley", "Helena Blavatsky", "Israel Regardie"), "B", "Ocultismo", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O que é 'Thelema'?",
                Arrays.asList("Filosofia de Crowley ('Faze o que tu queres')", "Religião wicca", "Seita", "Magia negra"), "A", "Ocultismo", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "Qual mantra é associado ao chakra do coração (Anahata)?",
                Arrays.asList("Om", "Yam", "Ham", "Vam"), "B", "Ocultismo", 8);

        adicionarPerguntaMultipla(PerTipo.ARCANISTA, Dificuldade.DIFICIL,
                "O que são os 'Archivos Akashicos'?",
                Arrays.asList("Biblioteca espiritual/registro de todas as almas", "Livros sagrados", "Grimórios", "Textos budistas"), "A", "Ocultismo", 8);
    }

    // 25 questões de VERDADEIRO OU FALSO - DIFÍCIL
    private void carregarArcanistaDificilVerdadeiroFalso() {
        // MITOLOGIA (7 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "Hermes era o mensageiro dos deuses gregos.", true, "Mitologia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "Morfeu é o deus do sono e dos sonhos.", true, "Mitologia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "A Quimera foi morta por Belerofonte.", true, "Mitologia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O Cérbero tem 3 cabeças e guarda o submundo.", true, "Mitologia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "A deusa egípcia Ísis é esposa de Osíris.", true, "Mitologia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O 'Trovão' na mitologia nórdica é causado pelo carro de Thor.", true, "Mitologia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "Loki é filho de Odin.", false, "Mitologia", 8);

        // MAGIA (5 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "A 'Lei da Similaridade' diz que semelhante causa semelhante.", true, "Magia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O 'Wiccan Rede' diz 'não prejudiques, mas faça o que quiseres'.", true, "Magia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "A 'magia de contágio' usa partes do corpo.", true, "Magia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "Francesco Maria Guazzo escreveu sobre caça às bruxas.", true, "Magia", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "'Magia natural' usa forças da natureza, sem espíritos.", true, "Magia", 8);

        // ELEMENTOS (5 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "No Feng Shui, os 5 elementos são água, madeira, fogo, terra e metal.", true, "Elementos", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O símbolo do enxofre alquímico é um triângulo com traço.", true, "Elementos", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O mercúrio alquímico representa o princípio volátil feminino.", true, "Elementos", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O sal alquímico representa o espírito.", false, "Elementos", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "A Pedra Filosofal é capaz de transmutação.", true, "Elementos", 8);

        // OCULTISMO (8 perguntas)
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "A palavra 'Cábala' vem do hebraico 'receber'.", true, "Ocultismo", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O 'Olho de Hórus' é um símbolo de proteção egípcio.", true, "Ocultismo", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "'Tiphareth' na Árvore da Vida representa o Sol.", true, "Ocultismo", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O 'Abismo' (Daath) na Cabala é uma sefira invisível.", true, "Ocultismo", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "'Heka' é a palavra egípcia antiga para magia.", true, "Ocultismo", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "O 'Zohar' é o livro central da Cabala.", true, "Ocultismo", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "A 'Academia Platônica' de Florença estudava hermetismo.", true, "Ocultismo", 8);
        adicionarPerguntaVF(PerTipo.ARCANISTA, Dificuldade.DIFICIL, "Eliphas Levi escreveu 'Dogma e Ritual da Alta Magia'.", true, "Ocultismo", 8);
    }

    // ==================== MÉTODOS AUXILIARES ====================

    private void adicionarPerguntaMultipla(PerTipo tipo, Dificuldade diff, String texto,
                                           List<String> opcoes, String letraCorreta,
                                           String categoria, int estagioMinimo) {
        Pergunta p = new PerguntaMultiplaEscolha(proximoId++, texto, opcoes, letraCorreta,
                diff, tipo, categoria, estagioMinimo);
        perguntasPorPersonagem.get(tipo).add(p);
        perguntasPorDificuldade.get(tipo).get(diff).add(p);
    }

    private void adicionarPerguntaVF(PerTipo tipo, Dificuldade diff, String texto,
                                     boolean resposta, String categoria, int estagioMinimo) {
        Pergunta p = new PerguntaVerdadeiroFalso(proximoId++, texto, resposta,
                diff, tipo, categoria, estagioMinimo);
        perguntasPorPersonagem.get(tipo).add(p);
        perguntasPorDificuldade.get(tipo).get(diff).add(p);
    }
    private void adicionarPerguntaLacuna(PerTipo tipo, Dificuldade diff, String texto,
                                         String respostaCorreta, String categoria, int estagioMinimo) {
        Pergunta p = new PerguntaCompletarLacuna(proximoId++, texto, respostaCorreta,
                diff, tipo, categoria, estagioMinimo);
        perguntasPorPersonagem.get(tipo).add(p);
        perguntasPorDificuldade.get(tipo).get(diff).add(p);
    }

    public List<Pergunta> getPerguntasParaPersonagem(PerTipo tipo) {
        return new ArrayList<>(perguntasPorPersonagem.get(tipo));
    }

    public Pergunta getPerguntaAleatoriaParaPersonagem(PerTipo tipo, int estagioNumero) {
        List<Pergunta> perguntas = perguntasPorPersonagem.get(tipo);
        List<Pergunta> adequadas = perguntas.stream()
                .filter(p -> p.getEstagioMinimo() <= estagioNumero)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        if (adequadas.isEmpty()) return null;
        return adequadas.get(random.nextInt(adequadas.size()));
    }

    public Pergunta getPerguntaAleatoriaPorDificuldade(PerTipo tipo, Dificuldade dificuldade, int estagioNumero) {
        List<Pergunta> perguntas = perguntasPorDificuldade.get(tipo).get(dificuldade);
        List<Pergunta> adequadas = perguntas.stream()
                .filter(p -> p.getEstagioMinimo() <= estagioNumero)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        if (adequadas.isEmpty()) return null;
        return adequadas.get(random.nextInt(adequadas.size()));
    }

    public int getTotalPerguntas() {
        return perguntasPorPersonagem.values().stream().mapToInt(List::size).sum();
    }

    public void mostrarEstatisticas() {
        System.out.println("\n📊 ESTATÍSTICAS DO BANCO DE PERGUNTAS");
        System.out.println("=".repeat(60));
        for (PerTipo tipo : PerTipo.values()) {
            int total = perguntasPorPersonagem.get(tipo).size();
            System.out.println("👤 " + tipo.getNome() + ": " + total + " perguntas");
            for (Dificuldade diff : Dificuldade.values()) {
                int count = perguntasPorDificuldade.get(tipo).get(diff).size();
                System.out.println("   ├─ " + diff.getNome() + ": " + count);
            }
        }
        System.out.println("=".repeat(60));
        System.out.println("🎯 TOTAL GERAL: " + getTotalPerguntas() + " perguntas");
    }
}