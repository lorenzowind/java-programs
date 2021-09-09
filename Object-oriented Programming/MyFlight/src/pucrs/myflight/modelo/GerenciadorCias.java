package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}
  
  public void adicionar(CiaAerea empresa) {
    empresas.add(empresa);
  }

  public ArrayList<CiaAerea> listarTodas() {
    return empresas;
  }

  public CiaAerea buscarPorCodigo(String cod) {
    int index = 0;
    
    while (empresas.size() > index) {
      if (empresas.get(index).getCodigo().equals(cod)) {
        return empresas.get(index);
      }
      index++;
    }

    return null;
  }

  public CiaAerea buscarPorNome(String nome) {
    int index = 0;
    
    while (empresas.size() > index) {
      if (empresas.get(index).getNome().equals(nome)) {
        return empresas.get(index);
      }
      index++;
    }

    return null;
  }
}
