/**
 * A classe ItemFaixaEtariaEscolar é a estrutura para descrever as características da faixa etária
 * escolar, contendo nível, série e idade correspondente.
 */
public class ItemFaixaEtariaEscolar {
    private final String nivel;
    private final String serie;
    private final Integer idade;
    
    public ItemFaixaEtariaEscolar(String nivel, String serie, Integer idade) {
        this.nivel = nivel;
        this.serie = serie;
        this.idade = idade;
    }

    public String getNivel() {
        return this.nivel;
    }

    public String getSerie() {
        return this.serie;
    }

    public Integer getIdade() {
        return this.idade;
    }
}
