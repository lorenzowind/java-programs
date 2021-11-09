package pucrs.myflight.modelo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooVariasEscalas extends VooEscalas{
    private ArrayList <Rota> rotas = new ArrayList<>();
    public VooVariasEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
        super(rota, rotaFinal, datahora, duracao);
    }
    public void addRota(Rota rota){
        rotas.add(rota);
    }
    public void removeRota(Rota rota){
        rotas.remove(rota);
    }
    @Override
    public String toString() {
        
        return "Escalas: " + rotas + "\nVoo: [" + super.toString() + "]";
     }
}
