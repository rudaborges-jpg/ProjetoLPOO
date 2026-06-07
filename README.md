# BAQUARA: Batalha do Saber 🎮

## Sobre o Projeto

**BAQUARA: Batalha do Saber** é um jogo educativo em Java que combina mecânicas de RPG com perguntas e respostas sobre diversos temas. O jogador escolhe um personagem com habilidades únicas e enfrenta inimigos respondendo perguntas de múltipla escolha, verdadeiro/falso e completar lacunas.

## Funcionalidades

- **5 personagens jogáveis** + **1 rota secreta** (Capoeirista)
- **10 estágios por rota** com dificuldade progressiva
- **Chefões** no final de cada rota
- **Sistema de habilidades especiais** com cooldown
- **Banco de perguntas** com mais de 1000 questões
- **Sistema de experiência e level up**
- **Rota secreta de Capoeira** com 9 mestres lendários + chefão especial
- **Temporizador de respostas** (varia por dificuldade)
- **Sistema de pontuação e estatísticas**

## Personagens

| Personagem | Tipo | Vida | Ataque | Defesa | Atributo Especial | Habilidade |
|------------|------|------|--------|--------|-------------------|------------|
| 🛡️ Paladino | Religião/Sagrado | 150 | 22 | 25 | Poder Divino | Espírito Sagrado (cura + dano) |
| 🌿 Caçadora | Natureza/Sobrevivência | 110 | 30 | 12 | Penetração | Chuva de Flechas (crítico + sangramento) |
| ⚔️ Guerreiro | Combate/História | 140 | 28 | 18 | Espírito de Luta | Fúria do Guerreiro (dano massivo) |
| 📚 Sábio | Conhecimento/Filosofia | 100 | 25 | 14 | Mana | Sabedoria Ancestral (dano + cura + mana) |
| 🔮 Arcanista | Magia/Mitologia | 95 | 32 | 8 | Poder Arcano | Cataclismo Arcano (dano + efeito elemental) |
| 🥋 Capoeirista | Rota Secreta | 120 | 25 | 15 | Energia da Ginga | Jogo de Capoeira (múltiplos ataques) |

## Rotas e Estágios

Cada personagem possui uma rota temática com 10 estágios:

| Personagem | Nome da Rota | Chefão Final |
|------------|--------------|--------------|
| Paladino | Caminho da Iluminação | Metatron - O Anjo Supremo |
| Caçadora | Caminho da Predadora | Fenrir - O Lobo Gigante |
| Guerreiro | Caminho da Glória | Odin - O Pai de Todos |
| Sábio | Caminho do Conhecimento | Athena - Deusa da Sabedoria |
| Arcanista | Caminho Místico | Loki - O Deus da Trapaça |

## Rota Secreta: Roda de Capoeira

Ativada ao **NÃO escolher um número de 1 a 5** na seleção de personagem.

### Mestres Lendários (9 estágios)

| Estágio | Mestre | Título |
|---------|--------|--------|
| 1 | Mestre Bimba | O Pai da Capoeira Regional |
| 2 | Mestre Pastinha | O Guardião da Capoeira Angola |
| 3 | Mestre João Grande | O Discípulo de Pastinha |
| 4 | Mestre João Pequeno | O Filósofo da Capoeira |
| 5 | Mestre Canjiquinha | O Gênio da Malícia |
| 6 | Mestre Caíçara | O Guardião da Tradição Oral |
| 7 | Mestre Suassuna | O Inovador da Capoeira |
| 8 | Mestre Nenel | O Herdeiro de Bimba |
| 9 | Mestre Moraes | O Filósofo da Capoeira Angola |

### Chefão Final: Besouro Mangangá 🦗

O lendário capoeirista baiano com **3 fases de batalha**:
- **Fase 1**: Ataques rápidos normais
- **Fase 2**: Corpo fechado (invulnerável a dano < 50)
- **Fase 3**: Fúria do Besouro (dano dobrado, defesa reduzida)

## Mecânicas de Jogo

### Sistema de Batalha

1. **Rodada de Pergunta** - Responda corretamente para causar dano
2. **Habilidade Especial** - Poder único com cooldown de 8 rodadas
3. **Contra-ataque** - Se errar, o inimigo revida

### Sistema de Perguntas

| Dificuldade | Pontos Base | Estágios | Tempo de Resposta |
|-------------|-------------|----------|-------------------|
| Fácil | 10 | 1-4 | 15 segundos |
| Médio | 10 | 4-7 | 12 segundos |
| Difícil | 10 | 8-10 | 10 segundos |

### Tipos de Pergunta

- **Múltipla Escolha** - Escolha a alternativa correta (A, B, C ou D)
- **Verdadeiro/Falso** - Responda V ou F
- **Completar Lacuna** - Digite a palavra que falta

### Sistema de Level Up

Cada nível concede:
- ❤️ +40 de Vida Máxima
- ⚔️ +5 de Ataque
- 🛡️ +3 de Defesa
- 🔋 Recarga completa do atributo especial

## Como Jogar

1. Execute o jogo: `java Game`
2. Digite seu nome
3. Escolha seu personagem (1-5)
4. **Para a rota secreta**: digite qualquer coisa diferente de 1-5
5. Responda as perguntas para derrotar os inimigos
6. Use sua habilidade especial quando disponível
7. Complete todos os 10 estágios para vencer!

## Justificativa de Design

O projeto original "CodeArena" propunha uma estrutura básica de jogo de quiz com batalhas por
turnos, porém o projeto final "BAQUARA: Batalha do Saber" incorporou diversas melhorias 
arquitetônicas e de experiência do jogador. Na hierarquia de personagens, foi criada a interface 
AtributoEspecial para gerenciar recursos únicos de cada personagem (como Poder Divino do
Paladino e Energia da Ginga do Capoeirista), permitindo tratamento polimórfico desses 
atributos. As habilidades especiais foram implementadas como classes separadas que seguem
a interface HabilidadeEspecial, aplicando o padrão Strategy e permitindo cooldown e troca 
dinâmica de habilidades entre personagens. O sistema de perguntas foi estendido com três 
tipos (múltipla escolha, verdadeiro/falso e completar lacuna), cada um implementando seu 
próprio método exibir() por polimorfismo. O banco de perguntas foi estruturado para filtrar
questões por tipo de personagem e dificuldade, com um sistema que evita repetição durante 
a partida. A lógica de batalha foi dividida entre GerenciadorBatalha (execução do combate) 
e GerenciadorRotas (definição dos estágios), enquanto a rota secreta de Capoeira foi adicionada
como elemento de surpresa, com mecânicas próprias como o contador de ataques básicos consecutivos
que força o inimigo a esquivar. Por fim, o TemporizadorResposta implementa uma contagem regressiva
visual via threads sem interferir na digitação do usuário, e o AvaliadorRespostas centraliza 
a validação com normalização de texto, aceitando variações como ausência de acentos e números
por extenso. Todas essas decisões visaram aplicar os conceitos fundamentais de POO (herança,
polimorfismo, encapsulamento e interfaces) enquanto entregam uma experiência de jogo mais rica
e tematicamente coesa, superando os requisitos mínimos da Entrega 1.
