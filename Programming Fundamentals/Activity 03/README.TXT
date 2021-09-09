----- Trabalho 03 -----
    
Esse trabalho foi desenvolvido pelo aluno Lorenzo Windmoller Martins, matrícula 21104284-1;

O programa consiste em seis tarefas principais:

1. Cadastrar um paciente informando o nome, CPF (que pode ser gerado), telefone, diagnóstico,
convênio e o número de consultas por mês;

2. Listar os pacientes cadastrados;

3. Alterar o diagnóstico de um paciente, informando o nome e o novo diagnóstico;

4. Alterar o convênio de um paciente, informando o nome e o novo convênio;

5. Consultar o valor total que um paciente, ou todos, deve pagar pelas consultas, considerando que 
o valor de uma consulta é R$150,00;

6. Descobrir o nome do paciente com mais vogais;

O projeto é estruturado da seguinte forma:

* Camada de apresentação (View): a classe MenuPrograma é responsável pela tratativa e validação
dos dados informados, sendo o ponto de partida do programa;

* Camada de controle (Controller): a classe ControladorTarefa é responsável pela manipulação dos
dados informados, mediando a entrada e saída das informações;

* Camada de modelo (Model): a classe ConsultasHospital é responsável pelas operações lógicas,
gerenciando o comportamento e estrutura dos dados. Além disso, a classe Paciente e GeradorCPF são 
modelos que descrevem os objetos utilizados dentro do contexto operacional do programa;

* Repósitórios: a interface RepositorioOperacoes é responsável pela definição e especificação 
dos métodos que devem ser implementados na camada de controle e modelo, já a interface 
RepositorioConstantes contém atributos predefinidos com o intuito de reutilização;

O trabalho contribuiu para compreensão dos seguintes conceitos:

* Lógica de encapsulamento em classes: manipulação dos atributos de determinada classe utilizando
getters e setters, além da utilização de construtores para diferentes propósitos dentro do contexto
do programa;

As dificuldades encontradas durante o desenvolvimento do trabalho foram:

* Durante a implementação do programa, foi um tanto trabalhoso desenvolver o fluxo de validação dos
dados que são informados nas tarefas, principalmente quando eram relacionados a trativa de tipo;

As fontes consultadas foram:

* Dúvidas e questões pontuais no Stack OverFlow;

* Documentação do Java no W3Schools: classe Math;
