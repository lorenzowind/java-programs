import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * A classe DataAtual é a estrutura para descrever o dia, mês e ano correspondente a data atual.
 */
public class DataAtual {
    private final Integer dia, mes, ano;
    
    public DataAtual() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        String dataAtual[] = formatter.format(date).split("-");
        
        this.dia = Integer.parseInt(dataAtual[0]);
        this.mes = Integer.parseInt(dataAtual[1]);
        this.ano = Integer.parseInt(dataAtual[2]);
    }

    public Integer getDia() {
        return this.dia;
    }

    public Integer getMes() {
        return this.mes;
    }

    public Integer getAno() {
        return this.ano;
    }
}
