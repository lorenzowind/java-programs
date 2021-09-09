package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {
	private ArrayList<Rota> rotas;
	
	public GerenciadorRotas() {
		rotas = new ArrayList<>();
	}
  
  public void adicionar(Rota rota) {
    rotas.add(rota);
  }

  public ArrayList<Rota> listarTodas() {
    return rotas;
  }

  public ArrayList<Rota> buscarPorOrigem(Aeroporto orig) {
    int index = 0;
    
	  ArrayList<Rota> rotasorig = new ArrayList<>();

    while (rotas.size() > index) {
      if (rotas.get(index).getOrigem().equals(orig)) {
        rotasorig.add(rotas.get(index));
      }
      index++;
    }

    return rotasorig;
  }
}
