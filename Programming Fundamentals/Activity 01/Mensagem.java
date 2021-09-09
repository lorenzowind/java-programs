/**
 * A classe Mensagem é a estrutura para descrever os métodos de geração de mensagens formatadas
 * considerando os diferentes períodos de tempo.
 */
public class Mensagem implements RepositorioConstantes {
    public Mensagem() {
    }
    
    /**
     * Método para geração de mensagem formatada referente a quantidade de uso diário dos 
     * dispositivos.
     * 
     * @param qtdHoras Double - Quantidade de horas de uso diário
     * @return String - Mensagem formatada contendo a quantidade de horas correspondentes
     */
    public String gerarMensagemDia(Double qtdHoras) {
        // Conversão da quantidade de horas para um valor inteiro
        Integer qtdIntHoras = (int) Math.floor(qtdHoras);
        
        // Retorno da mensagem formatada considerando a tratativa de número e quantidade
        return (qtdHoras % 1 != 0 ? "mais de " : "") + String.valueOf(qtdIntHoras) 
            + (qtdIntHoras == 1 ? " hora" : " horas") + " de uso!";
    }
     
    /**
     * Método para geração de mensagem formatada referente a quantidade de uso semanal dos 
     * dispositivos.
     * 
     * @param qtdHoras Double - Quantidade de horas de uso semanal
     * @return String - Mensagem formatada contendo a quantidade de horas correspondentes
     */
    public String gerarMensagemSemana(Double qtdHoras) {
        // Verificação da quantidade de horas para certificar o intervalo de tempo correto para
        // geração da mensagem
        if (qtdHoras < this.horasDia) {
            return this.gerarMensagemDia(qtdHoras);
        }
        
        // Variável para armazenar a quantidade relativa ao período de tempo diário
        Double qtdDias = qtdHoras / this.horasDia;
        // Conversão da quantidade de dias para um valor inteiro
        Integer qtdIntDias = (int) Math.floor(qtdDias);
        
        // Retorno da mensagem formatada considerando a tratativa de número e quantidade
        return (qtdDias % 1 != 0 ? "mais de " : "") + String.valueOf(qtdIntDias) 
            + (qtdIntDias == 1 ? " dia" : " dias") + " de uso!";
    }
    
    /**
     * Método para geração de mensagem formatada referente a quantidade de uso mensal dos 
     * dispositivos.
     * 
     * @param qtdHoras Double - Quantidade de horas de uso mensal
     * @return String - Mensagem formatada contendo a quantidade de horas correspondentes
     */
    public String gerarMensagemMes(Double qtdHoras) {
        // Verificação da quantidade de dias para certificar o intervalo de tempo correto para
        // geração da mensagem
        if (qtdHoras / this.horasDia < this.totalDiasSemana) {
            return this.gerarMensagemSemana(qtdHoras);
        }
        
        // Variável para armazenar a quantidade relativa ao período de tempo semanal
        Double qtdSemanas = qtdHoras / this.horasDia / this.totalDiasSemana;
        // Conversão da quantidade de semanas para um valor inteiro
        Integer qtdIntSemanas = (int) Math.floor(qtdSemanas);
        
        // Retorno da mensagem formatada considerando a tratativa de número e quantidade
        return (qtdSemanas % 1 != 0 ? "mais de " : "") + String.valueOf(qtdIntSemanas) 
            + (qtdIntSemanas == 1 ? " semana" : " semanas") + " de uso!";
    }
    
    /**
     * Método para geração de mensagem formatada referente a quantidade de uso anual dos 
     * dispositivos.
     * 
     * @param qtdHoras Double - Quantidade de horas de uso anual
     * @return String - Mensagem formatada contendo a quantidade de horas correspondentes
     */
    public String gerarMensagemAno(Double qtdHoras) {
        // Verificação da quantidade de dias para certificar o intervalo de tempo correto para
        // geração da mensagem
        if (qtdHoras / this.horasDia < this.totalDiasMes) {
            return this.gerarMensagemMes(qtdHoras);
        }
        
        // Variável para armazenar a quantidade relativa ao período de tempo mensal
        Double qtdMeses = qtdHoras / this.horasDia / this.totalDiasMes;
        // Conversão da quantidade de meses para um valor inteiro
        Integer qtdIntMeses = (int) Math.floor(qtdMeses);
        
        // Retorno da mensagem formatada considerando a tratativa de número e quantidade
        return (qtdMeses % 1 != 0 ? "mais de " : "") + String.valueOf(qtdIntMeses) 
            + (qtdIntMeses == 1 ? " mês" : " meses") + " de uso!";
    }
}
