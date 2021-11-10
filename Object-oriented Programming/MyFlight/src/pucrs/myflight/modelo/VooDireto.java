package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo{
    private Rota rota;
    public VooDireto(Rota rota, LocalDateTime datahora){
        super(datahora);
        this.rota = rota;
    }
    public Rota getRota(){
        return this.rota;
    }
    public Duration getDuracao(){
        double latDistance = Math.toRadians(rota.getOrigem().getLocal().getLatitude() - rota.getDestino().getLocal().getLatitude());
        double lngDistance = Math.toRadians(rota.getOrigem().getLocal().getLongitude() -  rota.getDestino().getLocal().getLongitude());
    
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
          + Math.cos(Math.toRadians(rota.getOrigem().getLocal().getLatitude())) * Math.cos(Math.toRadians(rota.getDestino().getLocal().getLatitude()))
          * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
    
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    
        return Duration.ofHours((long) (Math.round(6371 * c)/805 + 0.5));
    }
}

