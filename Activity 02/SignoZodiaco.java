/**
 * A classe SignoZodiaco é a estrutura para descrever as características do signo, contendo nome,
 * dia/mês mínimo e dia/mês máximo.
 */
public class SignoZodiaco {
    private final String nome;
    private final Integer diaMinimo, mesMinimo;
    private final Integer diaMaximo, mesMaximo;
    
    public SignoZodiaco(String nome, Integer diaMinimo, Integer mesMinimo, 
        Integer diaMaximo, Integer mesMaximo) {
        this.nome = nome;
        this.diaMinimo = diaMinimo;
        this.mesMinimo = mesMinimo;
        this.diaMaximo = diaMaximo;
        this.mesMaximo = mesMaximo;
    }

    public String getNome() {
        return this.nome;
    }

    public Integer getDiaMinimo() {
        return this.diaMinimo;
    }

    public Integer getMesMinimo() {
        return this.mesMinimo;
    }

    public Integer getDiaMaximo() {
        return this.diaMaximo;
    }

    public Integer getMesMaximo() {
        return this.mesMaximo;
    }
    
    /**
     * Método para verificação que compara se os argumentos repassados estão no intervalo da
     * data correspondete ao signo.
     * 
     * @param dia Integer - Dia qualquer entre 1 e 31
     * @param mes Integer - Mês qualquer entre 1 e 12
     */
    public boolean verificarSigno(Integer dia, Integer mes) {      
        if (mes == this.mesMinimo) {
            return dia >= this.diaMinimo;
        } else if (mes == this.mesMaximo) {
            return dia <= this.diaMaximo;
        }
        
        return false;
    }
}
