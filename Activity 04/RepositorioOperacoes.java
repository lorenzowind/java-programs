/**
 * A interface RepositorioOperacoes é a estrutura responsável pela especificação do comportamento
 * que as classes de modelo e controle devem implementar.
 */
public interface RepositorioOperacoes {
    public void listarPacientes();
    
    public void calcularMediaDiasInternacaoUTI();
    
    public void listarPacientesPorTempoInternacao();
    
    public void calcularPorcentagemConvenioPacientes();
    
    public Double calcularMediaDiasInternacao(Integer local);
    
    public Paciente[] ordenarPacientesPorTempoInternacao();
    
    public Double calcularPorcentagemConvenio(String convenio);
}
