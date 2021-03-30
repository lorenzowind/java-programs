public interface RepositorioOperacoes {
    public Double buscarHorasUsoFaixaIdades(Integer idade);
    
    public Double calcularPctgUso(Integer idade, Character periodo, Double qtdHorasUso);
    
    public void calcularPctgUsoFaixaEtariaEscolar();
    
    public void calcularPctgUsoUsuario(Integer idade, Double qtdHoras);
}
