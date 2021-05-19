/**
 * A classe ControladorTarefa é a camada de controle do programa, sendo a estrutura que contém os 
 * métodos referentes a todas as tarefas, tendo a responsabilidade de manipular os dados informados 
 * pelo usuário.
 */
public class ControladorTarefa extends ConsultasHospital {
    public ControladorTarefa() {
    }
    
    /**
     * Método referente a tarefa 01, que consiste em cadastrar um paciente.
     * 
     * @param nome String - Nome do paciente informado pelo usuário
     * @param cpf String - CPF do paciente informado pelo usuário ou gerado pela classe CPF
     * @param telefone String - Telefone do paciente informado pelo usuário
     * @param convenio String - Convênio do paciente informado pelo usuário
     * @param diagnostico String - Diagnóstico do paciente informado pelo usuário
     * @param numConsultasMes Integer - Número de consultas do mês informado pelo usuário
    */
    public void cadastrarPaciente(String nome, String cpf, String telefone, String convenio,
        String diagnostico, Integer numConsultaMes) {
        System.out.println("\nPaciente cadastrado:\n");
                
        // Variável para armazenar o paciente cadastrado como objeto
        Paciente paciente = new Paciente(nome, cpf, telefone, convenio, diagnostico, numConsultaMes);
        
        this.adicionarPaciente(paciente);
        
        System.out.printf("%s\n\n", paciente.toString());
    }
    
    /**
     * Método referente a tarefa 02, que consiste em listar os pacientes.
    */
    public void listarPacientes() {
        System.out.println("Pacientes cadastrados:\n");
         
        // Laço de repetição para percorrer todos os pacientes       
        for (Paciente paciente : this.getPacientes()) {
            System.out.printf("%s\n\n", paciente.toString());
        }
    }
    
    /**
     * Método referente a tarefa 06, que consiste em descobrir o nome do paciente com mais vogais.
    */
    public void descobrirNomeMaisVogais() {
        System.out.println("Nome do paciente com mais vogais:\n");
                
        Paciente pacienteEncontrado = this.encontrarNomeMaisVogais();
        
        System.out.printf("%s\n\n", pacienteEncontrado != null ? 
            pacienteEncontrado.toString() : "Nenhum paciente");
    }
}
