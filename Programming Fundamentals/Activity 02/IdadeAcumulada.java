/**
 * A classe IdadeAcumulada é a estrutura para descrever a idade correspondente em anos e dias 
 * em relação à data atual.
 */
public class IdadeAcumulada {
    private final Integer diaNascimento, mesNacimento, anoNascimento;
    private Integer anosAcumulados, diasAcumulados;
    private Integer mesesDifAniv, diasDifAniv;
    private final DataAtual dataAtual;
    
    public IdadeAcumulada(Integer diaNascimento, Integer mesNacimento, Integer anoNascimento) {
        this.diaNascimento = diaNascimento;
        this.mesNacimento = mesNacimento;
        this.anoNascimento = anoNascimento;
        
        this.dataAtual = new DataAtual();
        
        this.calcularAcumulo();
    }
    
    public Integer getDiaNascimento() {
        return this.diaNascimento;
    }

    public Integer getMesNacimento() {
        return this.mesNacimento;
    }

    public Integer getAnoNascimento() {
        return this.anoNascimento;
    }

    public Integer getAnosAcumulados() {
        return this.anosAcumulados;
    }

    public Integer getDiasAcumulados() {
        return this.diasAcumulados;
    }

    public Integer getMesesDifAniv() {
        return this.mesesDifAniv;
    }

    public Integer getDiasDifAniv() {
        return this.diasDifAniv;
    }
    
    /**
     * Método para cálculo do acúmulo de anos e dias desde o nascimento até a data atual.
     */
    private void calcularAcumulo() {
        if (this.dataAtual.getDia() == this.diaNascimento &&
            this.dataAtual.getMes() == this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - this.anoNascimento;
            this.diasAcumulados = 0;
            this.mesesDifAniv = 0;
            this.diasDifAniv = 0;
        } else if (this.dataAtual.getDia() < this.diaNascimento &&
            this.dataAtual.getMes() == this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - 1 - this.anoNascimento;
            this.diasAcumulados = this.dataAtual.getDia() + (11 * 30);
            this.mesesDifAniv = 0;
            this.diasDifAniv = this.diaNascimento - this.dataAtual.getDia();
        } else if (this.dataAtual.getDia() > this.diaNascimento &&
            this.dataAtual.getMes() == this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - 1 - this.anoNascimento;
            this.diasAcumulados = this.dataAtual.getDia() - this.diaNascimento;
            this.mesesDifAniv = 0;
            this.diasDifAniv = 30 - this.dataAtual.getDia() + this.diaNascimento;
        } else if (this.dataAtual.getDia() < this.diaNascimento &&
            this.dataAtual.getMes() < this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - 1 - this.anoNascimento;
            this.diasAcumulados = this.dataAtual.getDia() + 
                ((this.mesNacimento - this.dataAtual.getMes()) * 30);
            this.mesesDifAniv = this.mesNacimento - this.dataAtual.getMes();
            this.diasDifAniv = this.diaNascimento - this.dataAtual.getDia();
        } else if (this.dataAtual.getDia() < this.diaNascimento &&
            this.dataAtual.getMes() > this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - this.anoNascimento;
            this.diasAcumulados = ((this.dataAtual.getMes() - this.mesNacimento) * 30) - 
                this.dataAtual.getDia();
            this.mesesDifAniv = 12 - this.dataAtual.getMes() + this.mesNacimento;
            this.diasDifAniv = this.diaNascimento - this.dataAtual.getDia();
        } else if (this.dataAtual.getDia() > this.diaNascimento &&
            this.dataAtual.getMes() < this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - 1 - this.anoNascimento;
            this.diasAcumulados = ((this.mesNacimento - this.dataAtual.getMes()) * 30) - 
                this.dataAtual.getDia();
            this.mesesDifAniv = this.mesNacimento - 1 - this.dataAtual.getMes();
            this.diasDifAniv = 30 - this.dataAtual.getDia() + this.diaNascimento;
        } else if (this.dataAtual.getDia() > this.diaNascimento &&
            this.dataAtual.getMes() > this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - this.anoNascimento;
            this.diasAcumulados = this.dataAtual.getDia() + 
                ((this.dataAtual.getMes() - 1 - this.mesNacimento) * 30);
            this.mesesDifAniv = 12 - this.dataAtual.getMes() + this.mesNacimento;
            this.diasDifAniv = this.dataAtual.getDia() - this.diaNascimento;
        } else if (this.dataAtual.getDia() == this.diaNascimento &&
            this.dataAtual.getMes() < this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - this.anoNascimento;
            this.diasAcumulados = ((this.mesNacimento - this.dataAtual.getMes()) * 30);
            this.mesesDifAniv = this.mesNacimento - this.dataAtual.getMes();
            this.diasDifAniv = 0;
        } else if (this.dataAtual.getDia() == this.diaNascimento &&
            this.dataAtual.getMes() > this.mesNacimento) {
            this.anosAcumulados = this.dataAtual.getAno() - this.anoNascimento;
            this.diasAcumulados = ((this.dataAtual.getMes() - this.mesNacimento) * 30);
            this.mesesDifAniv = 12 - this.dataAtual.getMes() + this.mesNacimento;
            this.diasDifAniv = 0;
        }
    }
}
