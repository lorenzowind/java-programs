/**
 * A classe ControladorTarefa é a camada de controle do programa, sendo a estrutura que contém os 
 * métodos referentes a tarefa 01, tarefa 02 e tarefa 03, tendo a responsabilidade de manipular 
 * os dados informados pelo usuário.
 */
public class ControladorTarefa extends NascimentoUsuario {
    public ControladorTarefa() {
    }
    
    /**
     * Método referente a tarefa 01, que consiste em descobrir o signo de zodíaco do usuário.
     * 
     * @param dia Integer - Dia de nascimento informado pelo usuário
     * @param mes Integer - Mês de nascimento informado pelo usuário
    */
    public void descobrirSignoZodiaco(Integer dia, Integer mes) {
        System.out.println("\nResultado:\n");
                
        // Variável para armazenar o signo do zodíaco do usuário
        String signo = this.buscarSignoZodiaco(dia, mes);
        
        System.out.printf("O seu signo é: %s.\n\n", signo);
    }
    
    /**
     * Método referente a tarefa 02, que consiste em descobrir a idade do usuário a partir da
     * data informada.
     * 
     * @param dia Integer - Dia de nascimento informado pelo usuário
     * @param mes Integer - Mês de nascimento informado pelo usuário
     * @param ano Integer - Ano de nascimento informado pelo usuário
    */
    public void descobrirIdade(Integer dia, Integer mes, Integer ano) {
        System.out.println("\nResultado:\n");
                
        // Variável para armazenar o signo do zodíaco do usuário
        IdadeAcumulada idadeAcumulada = new IdadeAcumulada(dia, mes, ano);
        
        System.out.printf("A sua idade é: %d anos e %d dias.\n\n", 
            idadeAcumulada.getAnosAcumulados(),
            idadeAcumulada.getDiasAcumulados());
      
        if (idadeAcumulada.getMesesDifAniv() == 0 && idadeAcumulada.getDiasDifAniv() == 0) {
            System.out.println("Parabéns! Hoje é o seu aniversário.\n");
        } else {
            System.out.printf("O seu aniversário será daqui: %d meses e %d dias.\n\n", 
                idadeAcumulada.getMesesDifAniv(),
                idadeAcumulada.getDiasDifAniv());
        }
    }
    
    /**
     * Método referente a tarefa 03, que consiste em descobrir o dia da semana de nascimento do 
     * usuário a partir da data informada.
     * 
     * @param dia Integer - Dia de nascimento informado pelo usuário
     * @param mes Integer - Mês de nascimento informado pelo usuário
     * @param ano Integer - Ano de nascimento informado pelo usuário
    */
    public void descobrirDiaSemana(Integer dia, Integer mes, Integer ano) {
        System.out.println("\nResultado:\n");
                
        // Variável para armazenar o dia da semana do nascimento do usuário
        String diaSemana = this.buscarDiaSemana(dia, mes, ano);
        
        System.out.printf("O dia semana do seu nascimento é: %s.\n\n", diaSemana);
    }
}
