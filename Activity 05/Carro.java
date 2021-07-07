/**
 * A classe Carro é a estrutura para descrever as características do carro, contendo os dados 
 * necessários para o cadastro.
 */
public class Carro {
    private String diaSemana; // seg | ter | qua | qui | sex | sab
    private String placa;
    private Integer categoria; // 1 - Idosos | 2 - PRF | 3 - Gestantes | 4 - Vaga simples
    
    public Carro(String diaSemana, String placa, Integer categoria) {
        this.diaSemana = diaSemana;
        this.placa = placa;
        this.categoria = categoria;
    }
    
    public String toString() {
        return "Dia da semana: " + this.diaSemana + "\n" +
            "Placa: " + this.placa + "\n" +
            "Categoria: " + this.categoria + "\n";
    }
    
    public String getDiaSemana() {
        return this.diaSemana;
    }
    
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public Integer getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
}
