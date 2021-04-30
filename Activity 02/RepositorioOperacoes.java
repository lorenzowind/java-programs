/**
 * A interface RepositorioOperacoes é a estrutura responsável pela especificação do comportamento
 * que as classes de modelo e controle devem implementar.
 */
public interface RepositorioOperacoes {
    public void descobrirSignoZodiaco(Integer dia, Integer mes);
    
    public void descobrirIdade(Integer dia, Integer mes, Integer ano);
    
    public void descobrirDiaSemana(Integer dia, Integer mes, Integer ano);
}
