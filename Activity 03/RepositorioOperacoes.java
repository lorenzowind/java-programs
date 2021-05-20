/**
 * A interface RepositorioOperacoes é a estrutura responsável pela especificação do comportamento
 * que as classes de modelo e controle devem implementar.
 */
public interface RepositorioOperacoes {
    public void cadastrarPaciente(String nome, String cpf, String telefone, String convenio,
        String diagnostico, Integer numConsultaMes);

    public void listarPacientes();
    
    public void descobrirNomeMaisVogais();
    
    public void consultarValorPagarTodosPacientes();
    
    public void adicionarPaciente(Paciente paciente);
    
    public Paciente encontrarNomeMaisVogais();
    
    public Double calcularValorPagarConsulta(Paciente paciente);
}
