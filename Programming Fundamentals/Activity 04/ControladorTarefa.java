/**
 * A classe ControladorTarefa é a camada de controle do programa, sendo a estrutura que contém os 
 * métodos referentes a todas as tarefas, tendo a responsabilidade de manipular os dados informados 
 * pelo usuário.
 */
public class ControladorTarefa extends ConsultasHospital {
    public ControladorTarefa() {
    }
    
    /**
     * Método referente a tarefa 01, que consiste em listar os pacientes.
    */
    public void listarPacientes() {
        System.out.println("Pacientes cadastrados:\n");
         
        // Laço de repetição para percorrer todos os pacientes       
        for (Paciente paciente : this.getPacientes()) {
            System.out.printf("%s\n", paciente.toString());
        }
    }
    
    /**
     * Método referente a tarefa 02, que consiste em calcular a média de dias de internação dos
     * pacientes na UTI que já tiveram alta.
    */
    public void calcularMediaDiasInternacaoUTI() {
        System.out.printf("\nMédia de dias dos pacientes de UTI com alta: %.2f dia(s)\n\n",
            this.calcularMediaDiasInternacao(2));
    }
    
    /**
     * Método referente a tarefa 03, que consiste em listar os pacientes de forma ordenada por tempo
     * de internação.
    */
    public void listarPacientesPorTempoInternacao() {
        System.out.println("Pacientes por tempo de internação:\n");
         
        // Laço de repetição para percorrer todos os pacientes       
        for (Paciente paciente : this.ordenarPacientesPorTempoInternacao()) {
            System.out.printf("Tempo de internação: %d dia(s)\n%s\n\n", 
                paciente.getTempoInternacao(), paciente.toString());
        }
    }
    
    /**
     * Método referente a tarefa 04, que consiste em calcular a porcentagem de pacientes que são do
     * SUS ou de convênio particular.
    */
    public void calcularPorcentagemConvenioPacientes() {
        System.out.printf("\nPorcentagem de pacientes do SUS: %%%.2f\n",
            this.calcularPorcentagemConvenio("SUS"));
            
        System.out.printf("\nPorcentagem de pacientes de convênio particular: %%%.2f\n\n",
            this.calcularPorcentagemConvenio("Particular"));
    }
}
