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
            
            System.out.printf("- Porcentagem média por semana: %.2f%%\n", 
                this.calcularPctgUso(itemFaixaEtariaEscolar.getIdade(), 'S', null));
                
            System.out.printf("- Porcentagem média por mês (30 dias): %.2f%%\n", 
                this.calcularPctgUso(itemFaixaEtariaEscolar.getIdade(), 'M', null));
                
            System.out.printf("- Porcentagem média por ano (365 dias): %.2f%%\n\n", 
                this.calcularPctgUso(itemFaixaEtariaEscolar.getIdade(), 'A', null));
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
        
        // Variável para armazenar a porcentagem diária de utilização do usuário
        Double pctgDia = this.calcularPctgUso(idade, 'D', qtdHorasUso);
        
        // Variável para armazenar a porcentagem diária de utilização de uma pessoa da mesma idade
        // mas no contexto do sistema educacional brasileiro
        Double pctgDiaRef = this.calcularPctgUso(idade, 'D', null);
        
        // Comparações para verificar se o usuário está ou não no padrão de utilização
        if (pctgDia > pctgDiaRef) {
            System.out.println("Cuidado! Você está acima da média de uso de dispositivos.\n");
        } else if (pctgDia < pctgDiaRef) {
            System.out.println("Parabéns! Você está abaixo da média de uso de dispositivos.\n");
        } else {
            System.out.println("Você está no padrão da média de uso de dispositivos.\n");
        }
        
        System.out.printf("- Porcentagem média por dia: %.2f%%\n", pctgDia);
                
        System.out.printf("- Porcentagem média por semana: %.2f%%\n", 
            this.calcularPctgUso(idade, 'S', qtdHorasUso));
            
        System.out.printf("- Porcentagem média por mês (30 dias): %.2f%%\n", 
            this.calcularPctgUso(idade, 'M', qtdHorasUso));
            
        System.out.printf("- Porcentagem média por ano (365 dias): %.2f%%\n\n", 
            this.calcularPctgUso(idade, 'A', qtdHorasUso));
    }
}
