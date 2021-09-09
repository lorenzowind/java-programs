/**
 * A classe ConsultasHospital é a camada de modelo do programa, sendo a estrutura que contém os 
 * métodos e atributos referentes a parte lógica do programa, gerenciando o comportamento dos dados.
 */
public abstract class ConsultasHospital implements RepositorioOperacoes {
    private GeradorCPF geradorCPF = new GeradorCPF();
    
    // Array para armazenar os pacientes cadastrados
    private Paciente[] pacientes = {
        new Paciente("Maria", geradorCPF.gerarCPF(), "SUS", "10/06/2021", "13/06/2021", false, 3),
        new Paciente("Joao", geradorCPF.gerarCPF(), "SUS", "02/06/2021", "08/06/2021", false, 2),
        new Paciente("Lucas", geradorCPF.gerarCPF(), "Particular", "02/06/2021", "", true, 3),
        new Paciente("Gui", geradorCPF.gerarCPF(), "SUS", "11/06/2021", "12/06/2021", false, 1),
        new Paciente("Isabela", geradorCPF.gerarCPF(), "Particular", "10/06/2021", "", true, 2),
        new Paciente("Natalia", geradorCPF.gerarCPF(), "SUS", "02/06/2021", "04/06/2021", false, 1),
    };
    
    public Paciente[] getPacientes() {
        return this.pacientes;
    }
    
    /**
     * Método para calcular média dos dias que pacientes ficaram internados em determinado local 
     * e já tiveram alta.
     * 
     * @param local Integer - Local de internação
     * 
     * @return Double - Quantidade de dias de internação
     */
    public Double calcularMediaDiasInternacao(Integer local) {
        Integer numDias = 0, numPacientes = 0;
        
        // Laço de repetição para percorrer todos os pacientes
        for (Paciente paciente : this.getPacientes()) {
            if (paciente.getLocal().equals(local) && !paciente.getStatus()) {
                numDias += paciente.getTempoInternacao();
                numPacientes++;
            }
        }
        
        return numPacientes != 0 ? (double) numDias / numPacientes : 0.0;
    }
    
    /**
     * Método para ordenar pacientes por maior tempo de internação. 
     * 
     * @return Paciente[] - Lista de pacientes ordenada em ordem decrescente
     */
    public Paciente[] ordenarPacientesPorTempoInternacao() {
        Paciente[] pacientesOrdenados = this.pacientes;
        Paciente pacienteAux;
        
        // Laço de repetição para percorrer todos os pacientes
        for (int i = 0; i < pacientesOrdenados.length; i++) {
            // Laço de repetição para percorrer todos os pacientes
            for (int j = 0; j < pacientesOrdenados.length - 1; j++) {
                if (pacientesOrdenados[j].getTempoInternacao() < 
                    pacientesOrdenados[j + 1].getTempoInternacao()) {
                    pacienteAux = pacientesOrdenados[j];
                    pacientesOrdenados[j] = pacientesOrdenados[j + 1];
                    pacientesOrdenados[j + 1] = pacienteAux;
                }
            }    
        }
        
        return pacientesOrdenados;
    }
    
    /**
     * Método para calcular porcentagem de pacientes de um determinado convênio.
     * 
     * @param convenio String - Convênio para realizar a busca
     * 
     * @return Double - Porcentagem de pacientes
     */
    public Double calcularPorcentagemConvenio(String convenio) {
        Integer numPacientes = 0;
        
        // Laço de repetição para percorrer todos os pacientes
        for (Paciente paciente : this.getPacientes()) {
            if (paciente.getConvenio().equals(convenio)) {
                numPacientes++;
            }
        }
        
        return (double)(numPacientes * 100) / this.pacientes.length;
    }
}
