package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo
{ 
    private ArrayList <Rota> rotas = new ArrayList<>();

    // Construtor
    public VooEscalas(LocalDateTime datahora) {
        super(datahora); // chama o construtor de Voo
     }

    public void adicionaRota(Rota rota){
        rotas.add(rota);
    }
    public Rota getRota(){
        return this.rotas.get(0);
    }
    public Duration getDuracao(){
        Duration duracao = Duration.ofHours(0);
        for(Rota rota: rotas){
            double latDistance = Math.toRadians(rota.getOrigem().getLocal().getLatitude() - rota.getDestino().getLocal().getLatitude());
            double lngDistance = Math.toRadians(rota.getOrigem().getLocal().getLongitude() -  rota.getDestino().getLocal().getLongitude());
        
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
              + Math.cos(Math.toRadians(rota.getOrigem().getLocal().getLatitude())) * Math.cos(Math.toRadians(rota.getDestino().getLocal().getLatitude()))
              * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
        
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
            duracao.plusHours((long) (Math.round(6371 * c)/805 + 0.5));
        }
        return duracao;
        
    }
    public ArrayList <Rota> getRotas(){
        return rotas;
    }
    @Override
    public String toString() {
        
        return "Escalas: " + rotas;
    }
}