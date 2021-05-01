----- Trabalho 02 -----
    
Esse trabalho foi desenvolvido pelo aluno Lorenzo Windmoller Martins, matrícula 21104284-1;

O programa consiste em três tarefas principais:

1. Descobrir qual o seu signo do zodíaco informando dia e mês do nascimento do usuário;

2. Dizer qual é a idade do usuário (anos completos, meses e dias) considerando a data da consulta;

3. Descobrir o dia da semana que o usuário nasceu usando o algoritmo de Zeller;

O projeto é estruturado da seguinte forma:

* Camada de apresentação (View): a classe MenuPrograma é responsável pela tratativa e validação
dos dados informados, sendo o ponto de partida do programa;

* Camada de controle (Controller): a classe ControladorTarefa é responsável pela manipulação dos
dados informados, mediando a entrada e saída das informações;

* Camada de modelo (Model): a classe NascimentoUsuario é responsável pelas operações lógicas,
gerenciando o comportamento e estrutura dos dados. Além disso, a classe SignoZodiaco, IdadeAcumulada
e DataAtual são modelos que descrevem os objetos utilizados dentro do contexto operacional do 
programa;

* Repósitórios: a interface RepositorioOperacoes é responsável pela definição e especificação 
dos métodos que devem ser implementados na camada de controle e modelo, já a interface 
RepositorioConstantes contém atributos predefinidos com o intuito de reutilização;

O trabalho contribuiu para compreensão dos seguintes conceitos:

* Comportamento lógico de datas: manipulação de dados relacionados com datas, como dia, mês e ano,
enfatizando o cálculo para encontrar a diferença entre determinados intervalos de tempo;

As dificuldades encontradas durante o desenvolvimento do trabalho foram:

* Durante a implementação do programa, foi difícil encontrar uma solução automatizada e que
assegurasse o compartilhamento de código dentro das funções, especificamente o método para calcular 
a idade com base na data atual;

As fontes consultadas foram:

* Site do Wikipédia: algoritmo de Zeller; 

* Documentação do Java no W3Schools: classe Date;
