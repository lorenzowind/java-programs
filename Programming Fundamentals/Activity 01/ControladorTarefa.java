/**
 * A classe ControladorTarefa é a camada de controle do programa, sendo a estrutura que contém os 
 * métodos referentes a tarefa 01 e tarefa 02, tendo a responsabilidade de manipular os dados 
 * informados pelo usuário.
 */
public class ControladorTarefa extends TempoUsoDispositivos {
    public ControladorTarefa() {
    }
    
    /**
     * Método referente a tarefa 01, que consiste em imprimir a porcentagem média por semana, mês e
     * ano que cada faixa etária escolar usa os dispositivos.
    */
    public void calcularPctgUsoFaixaEtariaEscolar() {
        // Laço para impressão das porcentagens de cada faixa etária escolar
        for(ItemFaixaEtariaEscolar itemFaixaEtariaEscolar : this.faixaEtariaEscolar) {    
            System.out.printf("Nível: %s\nSérie: %s\nIdade: %d anos\n", 
                itemFaixaEtariaEscolar.getNivel(),
                itemFaixaEtariaEscolar.getSerie(),
                itemFaixaEtariaEscolar.getIdade());
            
            // Variável para armazenar a porcentagem de utilização de uma pessoa de idade corrente
            // no contexto do sistema educacional brasileiro
            Double pctg = this.calcularPctgUso(itemFaixaEtariaEscolar.getIdade(), null);
            
            System.out.printf("- Porcentagem média por semana: %.2f%%\n", pctg);
            System.out.printf("-- Total correspondente: %s\n", this.gerarMensagem(pctg, 'S'));
            
            System.out.printf("- Porcentagem média por mês (30 dias): %.2f%%\n", pctg);
            System.out.printf("-- Total correspondente: %s\n", this.gerarMensagem(pctg, 'M'));
            
            System.out.printf("- Porcentagem média por ano (365 dias): %.2f%%\n", pctg);
            System.out.printf("-- Total correspondente: %s\n\n", this.gerarMensagem(pctg, 'A'));
        }
    }
    
    /**
     * Método referente a tarefa 02, que consiste em imprimir a porcentagem média por dia, semana, 
     * mês e ano que o usuário usa os dispositivos, também considerando a idade informada.
     * 
     * @param idade Integer - Idade informada pelo usuário
     * @param qtdHorasUso Double - Quantidade de horas que o usuário usa os dispositivos
    */
    public void calcularPctgUsoUsuario(Integer idade, Double qtdHorasUso) {
        System.out.println("\nResultado:\n");
        
        // Variável para armazenar a porcentagem de utilização do usuário
        Double pctg = this.calcularPctgUso(idade, qtdHorasUso);
        
        // Variável para armazenar a porcentagem de utilização de uma pessoa da mesma idade mas no 
        // contexto do sistema educacional brasileiro
        Double pctgRef = this.calcularPctgUso(idade, null);
        
        // Comparações para verificar se o usuário está ou não no padrão de utilização
        if (pctg > pctgRef) {
            System.out.println("Cuidado! Você está acima da média de uso de dispositivos.\n");
        } else if (pctg < pctgRef) {
            System.out.println("Parabéns! Você está abaixo da média de uso de dispositivos.\n");
        } else {
            System.out.println("Você está no padrão da média de uso de dispositivos.\n");
        }
        
        System.out.printf("- Porcentagem média por dia: %.2f%%\n", pctg);
        System.out.printf("-- Total correspondente: %s\n", this.gerarMensagem(pctg, 'D'));
        
        System.out.printf("- Porcentagem média por semana: %.2f%%\n", pctg);
        System.out.printf("-- Total correspondente: %s\n", this.gerarMensagem(pctg, 'S'));
        
        System.out.printf("- Porcentagem média por mês (30 dias): %.2f%%\n", pctg);
        System.out.printf("-- Total correspondente: %s\n", this.gerarMensagem(pctg, 'M'));
        
        System.out.printf("- Porcentagem média por ano (365 dias): %.2f%%\n", pctg);
        System.out.printf("-- Total correspondente: %s\n\n", this.gerarMensagem(pctg, 'A'));
    }
}
