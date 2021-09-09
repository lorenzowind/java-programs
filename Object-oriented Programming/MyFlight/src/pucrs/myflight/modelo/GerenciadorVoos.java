package pucrs.myflight.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorVoos {
	private ArrayList<Voo> voos;
	
	public GerenciadorVoos() {
		voos = new ArrayList<>();
	}
  
  public void adicionar(Voo voo) {
    voos.add(voo);
  }

  public ArrayList<Voo> listarTodos() {
    return voos;
  }

  public ArrayList<Voo> buscarPorData(LocalDate data) {
    int index = 0;
  
	  ArrayList<Voo> voosdata = new ArrayList<>();
    
    while (voos.size() > index) {
      if (voos.get(index).getDatahora().toLocalDate().equals(data)) {
        voosdata.add(voos.get(index));
      }
      index++;
    }

    return voosdata;
  }
}
