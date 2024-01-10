Este jogo foi implementado como trabalho final de Programação 1 do Curso de Ciência da Computação na UFFS (Universidade Federal da Fronteira Sul), foi implementado de forma individual com foco nos ensinamentos da programação em objetos.

Regras e componentes do jogo de cartas a ser implementado:
1) O jogo possui 109 cartas numeradas de 1 a 109.
2) Cada carta vale 1 ponto com as seguintes exceções:
a. Cartas terminadas com o dígito 5 valem 1 ponto extra;
b. Cartas múltiplas de 10 valem 2 pontos extras;
c. Cartas com dois dígitos repetidos valem 4 pontos extras;
d. Exemplo: a carta de número 2 vale 1 ponto, a de número 5 vale 2 pontos, a de numero 20
vale 3 pontos, a de número 33 vale 5 pontos e a de número 55 vale 6 pontos (1 base + 1 por
terminar em 5 + 4 por ter dois dígitos repetidos).
3) O jogo tem de 3 a 6 jogadores.
4) O jogo tem um tabuleiro em forma tabular com 5 linhas e 5 colunas.
5) A sequência de jogo acontece da seguinte forma:
a. Forma-se um baralho (pilha) com as 109 cartas organizadas de forma aleatória
(embaralhadas);
b. Distribui-se 12 cartas fechadas para cada um dos jogadores a partir do baralho;
c. Distribui-se 5 cartas abertas posicionando-as no início de cada linha do tabuleiro;
d. Cada jogador escolhe secretamente uma carta de sua mão para jogar na rodada atual;
e. Após cada jogador ter selecionado sua carta, as cartas são reveladas e a ordem dos jogadores
será determinada pela ordem crescente de valor numérico da carta selecionada por cada um;
f. Começando a partir do primeiro jogador, posiciona-se a carta selecionada à direita de uma
carta já posicionada em uma das fileiras seguindo 4 regras:
i. A nova carta deve manter a ordem crescente de valor na linha onde for posicionada;
ii. A carta é sempre posicionada na linha onde a diferença entre a última carta à direita
e a nova carta for a menor;
iii. Caso o jogador tiver que posicionar sua carta em uma linha cheia (que já possui 5
cartas), ele é obrigado a primeiro coletar todas as cartas daquela linha para então
posicionar sua carta no início dessa linha (agora vazia com exceção da carta recém
posicionada pelo jogador);
iv. Caso a carta do jogador não puder ser colocada em nenhuma linha por conta da regra
f.i., ou seja, a sua carta é menor que todas as cartas posicionadas no final de cada
linha, ele deverá coletar todas as cartas da linha cujo último número seja o maior
dentre todas as linhas e posicionar sua carta no início dessa linha.OBS: as cartas coletadas nos casos iii e iv não voltam para a mão dos jogadores. Elas
serão contabilizadas na pontuação de fim de jogo.
g. O passo f é repetido até que todo jogador tenha posicionado sua carta no tabuleiro;
h. Inicia-se uma nova rodada a partir do passo d;
i. O jogo termina em 12 rodadas quando os jogadores tiverem posicionados todas as cartas de
sua mão.
j. Soma-se os pontos das cartas coletadas por cada jogador. O jogador com a menor pontuação,
ou zero pontos) é o vencedor. Em caso de empate, os jogadores empatados com a menor
pontuação compartilham a vitória.
O trabalho deve possuir as seguintes características:
1) O jogo deve ser desenvolvido na linguagem Java, mas não é necessário desenvolver interface gráfica.
A interação com o usuário pode ser via terminal/console.
2) O número de jogadores da partida, assim como o nome de cada jogador, deve ser informado pelo
usuário ao iniciar o jogo.
3) A seleção da carta a ser jogada por cada jogador em uma rodada deve ser solicitada ao usuário. Não
é necessário esconder as mãos do jogador do usuário (não teria como sem usar elementos de rede
para criar um jogo multijogador com múltiplos usuários). Para isso sugere-se imprimir a mão de cada
um dos jogadores (cartas que ele possui) e solicitar ao usuário a carta que deverá ser jogada na rodada
atual por cada jogador.
4) No início do jogo (após passo c) e ao final de cada rodada (após seleção e posicionamento das cartas
dos jogadores, ou seja, ao finalizar o passo f) deverá ser impresso o estado atual do tabuleiro e a
pontuação atual de cada jogador (contabilizadas a partir das cartas coletadas até então).
5) Ao final do jogo deve-se anunciar/imprimir a pontuação individual de cada jogador, as cartas
coletadas por cada jogador e, por fim, o/os jogadores vencedores.
