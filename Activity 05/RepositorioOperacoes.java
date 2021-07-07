/**
 * A interface RepositorioOperacoes é a estrutura responsável pela especificação do comportamento
 * que as classes de modelo e controle devem implementar.
 */
public interface RepositorioOperacoes {
    public void adicionarCarro(Integer linha, Integer coluna, Carro carro);
    
    public Integer buscarQuantidadeCategoriaPorDia(Integer categoria, String diaSemana);
    
    public Carro[] buscarVeiculosCategoriaPorDia(Integer categoria, String diaSemana);
    
    public Integer[] buscarCategoriaEspecial();
    
    public Carro[] buscarClientesIdosos();
    
    public void preencherPlanilha(String diaSemana, Integer categoria, Integer linha, Integer coluna, 
        String placa);
        
    public void gerarRelatorio(String diaSemana);
    
    public void calcularCategoria();
    
    public void descobrirClienteIdoso();
}
