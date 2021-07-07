----- Trabalho 04 -----
    
Esse trabalho foi desenvolvido pelo aluno Lorenzo Windmoller Martins, matrícula 21104284-1;

O programa consiste em quatro tarefas principais:

1. Listar os pacientes cadastrados;

2. Calcular a média de dias de internação dos pacientes na UTI que já tiveram alta;

3. Listar os pacientes de forma ordenada e decrescente de acordo com o tempo de internação;

4. Calcular a porcentagem de pacientes que são do SUS ou de convênio particular;

O projeto é estruturado da seguinte forma:

* Camada de apresentação (View): a classe MenuPrograma é responsável pela tratativa e validação
dos dados informados, sendo o ponto de partida do programa;

* Camada de controle (Controller): a classe ControladorTarefa é responsável pela manipulação dos
dados informados, mediando a entrada e saída das informações;

* Camada de modelo (Model): a classe ConsultasHospital é responsável pelas operações lógicas,
gerenciando o comportamento e estrutura dos dados. Além disso, a classe Paciente, DataAtual e 
GeradorCPF são modelos que descrevem os objetos utilizados dentro do contexto operacional do programa;

* Repósitórios: a interface RepositorioOperacoes é responsável pela definição e especificação 
dos métodos que devem ser implementados na camada de controle e modelo, já a interface 
RepositorioConstantes contém atributos predefinidos com o intuito de reutilização;

O trabalho contribuiu para compreensão dos seguintes conceitos:

* Generalização de métodos: comportamento padronizado de determinada função com possibilidade para
acesso aos atributos partindo do argumento fornecido;

As dificuldades encontradas durante o desenvolvimento do trabalho foram:

* Durante a implementação da funcionalidade de ordenação, tive dificuldade para definir uma 
estratégia para armazenamento da informação relativa ao tempo de internação do paciente, porém
percebi que era mais eficiente criar um atributo na classe, sendo calculado apenas uma vez, no
momento da criação da instância;

As fontes consultadas foram:

* Trabalhos anteriores realizados na disciplina;

* Questões referentes a métodos de ordenação no Stack OverFlow;
