public class Mensagem implements RepositorioConstantes {
    public Mensagem() {
    }
    
    public String gerarMensagemDia(Double qtdHoras) {
        Integer qtdIntHoras = (int) Math.floor(qtdHoras);
        
        return (qtdHoras % 1 != 0 ? "mais de " : "") 
            + String.valueOf(qtdIntHoras) + (qtdIntHoras == 1 ? " hora!" : " horas!");
    }
    
    public String gerarMensagemSemana(Double qtdHoras) {
        if (qtdHoras < this.horasDia) {
            return this.gerarMensagemDia(qtdHoras);
        }
        
        Double qtdDias = qtdHoras / this.horasDia;
        Integer qtdIntDias = (int) Math.floor(qtdDias);
        
        return (qtdDias % 1 != 0 ? "mais de " : "")
            + String.valueOf(qtdIntDias) + (qtdIntDias == 1 ? " dia!" : " dias!");
    }
    
    public String gerarMensagemMes(Double qtdHoras) {
        if (qtdHoras / this.horasDia < this.totalDiasSemana) {
            return this.gerarMensagemSemana(qtdHoras);
        }
        
        Double qtdSemanas = qtdHoras / this.horasDia / this.totalDiasSemana;
        Integer qtdIntSemanas = (int) Math.floor(qtdSemanas);
        
        return (qtdSemanas % 1 != 0 ? "mais de " : "")
            + String.valueOf(qtdIntSemanas) + (qtdIntSemanas == 1 ? " semana!" : " semanas!");
    }
    
    public String gerarMensagemAno(Double qtdHoras) {
        if (qtdHoras / this.horasDia < this.totalDiasMes) {
            return this.gerarMensagemMes(qtdHoras);
        }
        
        Double qtdMeses = qtdHoras / this.horasDia / this.totalDiasMes;
        Integer qtdIntMeses = (int) Math.floor(qtdMeses);
        
        return (qtdMeses % 1 != 0 ? "mais de " : "")
            + String.valueOf(qtdIntMeses) + (qtdIntMeses == 1 ? " mês!" : " meses!");
    }
}
