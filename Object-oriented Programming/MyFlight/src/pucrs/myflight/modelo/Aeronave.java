package pucrs.myflight.modelo;

public class Aeronave {
	private String codigo;
	private String descricao;
	private Integer capacidade;
	
	public Aeronave(String codigo, String descricao, Integer capacidade) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Integer getCapacidade() {
		return capacidade;
	}
}
