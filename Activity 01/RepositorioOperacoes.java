/**
 * A interface RepositorioOperacoes é a estrutura responsável pela especificação do comportamento
 * que as classes de modelo e controle devem implementar.
 */
public interface RepositorioOperacoes {
    public Double buscarHorasUsoFaixaIdades(Integer idade);
    
    public Double calcularPctgUso(Integer idade, Character periodo, Double qtdHorasUso);
    
    public void calcularPctgUsoFaixaEtariaEscolar();
    
    public void calcularPctgUsoUsuario(Integer idade, Double qtdHoras);
}
