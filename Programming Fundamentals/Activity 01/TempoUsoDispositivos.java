/**
 * A classe TempoUsoDispositivos é a camada de modelo do programa, sendo a estrutura que contém os 
 * métodos e atributos referentes a parte lógica do programa, gerenciando o comportamento dos dados.
 */
public abstract class TempoUsoDispositivos implements RepositorioOperacoes, RepositorioConstantes {
    Mensagem mensagem = new Mensagem();
    
    // Array de objetos para armazenar as faixas de idade e o respectivo tempo médio de uso dos 
    // dispositivos
    private final ItemFaixaIdades[] faixaIdades = {
        new ItemFaixaIdades(2, 7, 3.0),
        new ItemFaixaIdades(8, 12, 4.75),
        new ItemFaixaIdades(13, 18, 6.0)
    };
    
    // Array de objetos para armazenar os níveis e séries do sistema educacional brasileiro, além 
    // das respectivas idades
    public final ItemFaixaEtariaEscolar[] faixaEtariaEscolar = {
        new ItemFaixaEtariaEscolar("Educação Infantil", "Berçário", 2),
        new ItemFaixaEtariaEscolar("Educação Infantil", "N1", 3),
        new ItemFaixaEtariaEscolar("Educação Infantil", "N2", 4),
        new ItemFaixaEtariaEscolar("Educação Infantil", "N3", 5),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries iniciais)", "1º ano", 6),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries iniciais)", "2º ano", 7),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries iniciais)", "3º ano", 8),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries iniciais)", "4º ano", 9),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries iniciais)", "5º ano", 10),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries finais)", "6º ano", 11),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries finais)", "7º ano", 13),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries finais)", "8º ano", 14),
        new ItemFaixaEtariaEscolar("Ensino Fundamental (séries finais)", "9º ano", 14),
        new ItemFaixaEtariaEscolar("Ensino Médio", "1º ano", 15),
        new ItemFaixaEtariaEscolar("Ensino Médio", "2º ano", 16),
        new ItemFaixaEtariaEscolar("Ensino Médio", "3º ano", 17)
    };
    
    /**
     * Método para buscar a quantidade de horas de uso dos dispositivos de acordo com as faixas de 
     * idade armazenadas anteriormente.
     * 
     * @param idade Integer - Idade para comparação no intervalo númerico das faixas de idade
     * @return Double - Quantidade de horas encontrada de acordo com a idade
     */
    public Double buscarHorasUsoFaixaIdades(Integer idade) {
        // Laço para verificação do intervalo da faixa de idades
        for (int i = 0; i < this.faixaIdades.length; i++) {
            if (idade >= this.faixaIdades[i].getIdadeMinima() && 
                idade <= this.faixaIdades[i].getIdadeMaxima()) {
                return this.faixaIdades[i].getTempoUso();
            }
        }
        
        // Retorno padrão do último registro caso a idade repassada como argumento não tenha sido
        // encontrada no array
        return this.faixaIdades[faixaIdades.length - 1].getTempoUso();
    }
    
    /**
     * Método para calcular a porcentagem de uso referente a determinada idade e opcionalmente a 
     * quantidade de horas de utilização diária dos dispositivos.
     * 
     * @param idade Integer - Idade para comparação no intervalo númerico das faixas de idade ou
     * para critério informativo
     * @param qtdHorasUso Double - Quantidade de horas de uso dos dispositivos
     * @return Double - Porcentagem média de uso dos dispositivos
     */
    public Double calcularPctgUso(Integer idade, Double qtdHorasUso) {
        // Variável para armazenar a quantidade de horas de uso, podendo receber o argumento
        // repassado no método ou o retorno da busca de acordo com as faixas de idade
        Double mediaUsoHorasDia = qtdHorasUso == null 
            ? this.buscarHorasUsoFaixaIdades(idade)
            : qtdHorasUso;
        
        // Retorno do cálculo referente a porcentagem de utilização diária dos dispositivos
        return (mediaUsoHorasDia * 100) / this.mediaHorasAcordadoDia;
    };
    
    
    /**
     * Método para gerar uma mensagem formatada contendo informações relativas ao tempo de utilização
     * dos dispostivos de acordo com a porcentagem média e o período requerido (diário, semanal, 
     * mensal ou anual).
     * 
     * @param pctg Double - Porcentagem média de uso dos dispositivos
     * @param periodo Character - Periodo de utilização, que pode ser D (diário), S (semanal), M 
     * (mensal) ou A (anual)
     * @return String - Porcentagem média de uso dos dispositivos
     */
    public String gerarMensagem(Double pctg, Character periodo) {
        // Verificação do período e tratativa da mensagem
        switch (periodo) {
            case 'D': {
                // Retorno da mensagem formatada repassando a quantidade de horas de uso diário 
                // a partir do cálculo inverso da porcentagem
                return this.mensagem.gerarMensagemDia((this.mediaHorasAcordadoDia * pctg) / 100);
            }
            case 'S': {
                // Retorno da mensagem formatada repassando a quantidade de horas de uso semanal 
                // a partir do cálculo inverso da porcentagem
                return this.mensagem.gerarMensagemSemana(
                    ((this.mediaHorasAcordadoDia * this.totalDiasSemana * pctg) / 100));
            }
            case 'M': {
                // Retorno da mensagem formatada repassando a quantidade de horas de uso mensal 
                // a partir do cálculo inverso da porcentagem
                return this.mensagem.gerarMensagemMes(
                    ((this.mediaHorasAcordadoDia * this.totalDiasMes * pctg) / 100));
            }
            case 'A':
            default: {
                // Retorno da mensagem formatada repassando a quantidade de horas de uso anual 
                // a partir do cálculo inverso da porcentagem
                return this.mensagem.gerarMensagemAno(
                    ((this.mediaHorasAcordadoDia * this.totalDiasAno * pctg) / 100));
            }
        }
    }
}
