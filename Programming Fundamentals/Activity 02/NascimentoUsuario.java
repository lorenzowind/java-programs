/**
 * A classe NascimentoUsuario é a camada de modelo do programa, sendo a estrutura que contém os 
 * métodos e atributos referentes a parte lógica do programa, gerenciando o comportamento dos dados.
 */
public abstract class NascimentoUsuario implements RepositorioOperacoes, RepositorioConstantes {
    /**
     * Método que busca o signo correspondente ao dia e mês repassados como argumento.
     * 
     * @param dia Integer - Dia qualquer entre 1 e 31
     * @param mes Integer - Mês qualquer entre 1 e 12
     */
    public String buscarSignoZodiaco(Integer dia, Integer mes) {
        for (SignoZodiaco signo : this.signosZodiaco) {
            if (signo.verificarSigno(dia, mes)) {
                return signo.getNome();
            }
        }
        
        return this.signosZodiaco[this.signosZodiaco.length - 1].getNome();
    }
    
    /**
     * Método que busca o dia da semana correspondente ao dia, mês e ano repassados como argumento.
     * 
     * @param dia Integer - Dia qualquer entre 1 e 31
     * @param mes Integer - Mês qualquer entre 1 e 12
     * @param ano Integer - Ano qualquer maior que 1899
     */
    public String buscarDiaSemana(Integer dia, Integer mes, Integer ano) {
        Integer auxMes = mes;
        
        if (mes == 1) {
            auxMes = 13;
        } else if (mes == 2) { 
            auxMes = 14;
        }
        
        Integer j = ano / 100;
        Integer k = ano % 100 ;
        double h = (dia + ((26 * (auxMes + 1)) / 10) + k + (k / 4) + (j / 4) - (2 * j)) % 7;
        
        Integer index = (int) h;
        
        return this.diasSemana[index];
    }
}
