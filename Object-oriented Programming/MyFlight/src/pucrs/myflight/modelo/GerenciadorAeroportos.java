package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {
	private ArrayList<Aeroporto> aeroportos;
	
	public GerenciadorAeroportos() {
		aeroportos = new ArrayList<>();
	}
  
  public void adicionar(Aeroporto aeroporto) {
    aeroportos.add(aeroporto);
  }

  public ArrayList<Aeroporto> listarTodos() {
    return aeroportos;
  }

  public Aeroporto buscarPorCodigo(String cod) {
    int index = 0;
    
    while (aeroportos.size() > index) {
      if (aeroportos.get(index).getCodigo().equals(cod)) {
        return aeroportos.get(index);
      }
      index++;
    }

    return null;
  }
}
