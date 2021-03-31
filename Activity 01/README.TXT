----- Trabalho 01 -----
    
Esse trabalho foi desenvolvido pelo aluno Lorenzo Windmoller Martins, matrícula 21104284-1;

O programa consiste em duas tarefas principais:

1. Imprimir a porcentagem média por semana, mês e ano que cada faixa etária escolar (série) usa 
dispositivos móveis, considerando uma pesquisa realizada pela OCDR que consta o tempo de utilização
por determinadas faixas de idade;

2. Calcular a porcentagem média por dia, semana, mês e ano que o usuário utiliza os dispositivos 
móveis de acordo com a idade e quantidade de horas de uso informadas, e também verificar se está ou 
não nos padrões da pesquisa da OCDR;

O projeto é estruturado da seguinte forma:

* Camada de apresentação (View): a classe MenuPrograma é responsável pela tratativa e validação
dos dados informados, sendo o ponto de partida do programa;

* Camada de controle (Controller): a classe ControladorTarefa é responsável pela manipulação dos
dados informados, mediando a entrada e saída das informações;

* Camada de modelo (Model): a classe TempoUsoDispositivos é responsável pelas operações lógicas,
gerenciando o comportamento e estrutura dos dados. Além disso, a classe ItemFaixaIdades e
ItemFaixaEtariaEscolar são modelos que descrevem os objetos utilizados dentro do contexto
operacional do programa;

* Repósitório de operações: a interface RepositorioOperacoes é responsável pela definição e
especificação dos métodos que devem ser implementados na camada de controle e modelo;

O trabalho contribuiu para compreensão dos seguintes conceitos:

* Comportamento da classe: exercício do processo de criação de classes, verificando as regras de 
formação e algumas práticas de orientação a objetos, ou seja, tendo em vista o encapsulamento dos 
métodos de acesso e o comportamento herdado das estruturas;

* JavaDoc: prática da produção de documentação e comentários a respeito de comandos, métodos e
estruturas - como classes e interfaces - descrevendo o comportamento de determinado trecho do código
e especificando os parâmetros, valor de retorno, tipagem, etc;

* Arquitetura MVC (Model-View-Controller): organização da estrutura do programa seguindo princípios
de isolamento de regras operacionais da lógica de apresentação (interatividade com o usuário), 
trazendo flexibilidade na implementação;

As dificuldades encontradas durante o desenvolvimento do trabalho foram:

* Inicialmente, foi difícil visualizar uma solução em que as responsabilidades do programa ficassem
isoladas e implementadas em diferentes estruturas com finalidades específicas, para uma lógica
reutilizável nas diferentes tarefas. Então, elaborei um esboço mental seguindo uma organização 
baseada na arquitetura MVC, e a partir disso, comecei o desenvolvimento de uma alternativa de 
implementação possível, com camadas sendo representadas por classes que se interligavam;

As fontes consultadas foram:

* Artigos do DevMedia: Introdução ao Padrão MVC, JavaDoc – Implementando documentação através do 
NetBeans, Os 4 pilares da Programação Orientada a Objetos; 

* Documentação do Java no W3Schools; 

* Dúvidas e questões pontuais no Stack OverFlow;
