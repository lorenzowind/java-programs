/**
 * A classe ItemFaixaIdades é a estrutura para descrever as características da faixa de idades,
 * contendo idade mínima e máxima, além do tempo de uso dos dispositivos.
 */
public class ItemFaixaIdades {
    private final Integer idadeMinima;
    private final Integer idadeMaxima;
    private final Double tempoUso;
    
    public ItemFaixaIdades(Integer idadeMinima, Integer idadeMaxima, Double tempoUso) {
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
        this.tempoUso = tempoUso;
    }

    public Integer getIdadeMinima() {
        return this.idadeMinima;
    }

    public Integer getIdadeMaxima() {
        return this.idadeMaxima;
    }

    public Double getTempoUso() {
        return this.tempoUso;
    }
}
