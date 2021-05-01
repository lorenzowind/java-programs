/**
 * A classe NascimentoUsuario é a camada de modelo do programa, sendo a estrutura que contém os 
 * métodos e atributos referentes a parte lógica do programa, gerenciando o comportamento dos dados.
 */
public abstract class NascimentoUsuario implements RepositorioOperacoes, RepositorioConstantes {
    
    /**
     * Método para que busca o signo correspondente ao dia e mês repassados como argumento.
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
}
