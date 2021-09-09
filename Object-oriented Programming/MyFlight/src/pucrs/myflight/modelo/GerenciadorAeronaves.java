package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {
	private ArrayList<Aeronave> aeronaves;
	
	public GerenciadorAeronaves() {
		aeronaves = new ArrayList<>();
	}
  
  public void adicionar(Aeronave aeronave) {
    aeronaves.add(aeronave);
  }

  public ArrayList<Aeronave> listarTodas() {
    return aeronaves;
  }

  public Aeronave buscarPorCodigo(String cod) {
    int index = 0;
    
    while (aeronaves.size() > index) {
      if (aeronaves.get(index).getCodigo().equals(cod)) {
        return aeronaves.get(index);
      }
      index++;
    }

    return null;
  }
}
