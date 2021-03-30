public class ControladorTarefa extends TempoUsoDispositivos {
    public ControladorTarefa() {
    }
    
    public void calcularPctgUsoFaixaEtariaEscolar() {
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
    
    public void calcularPctgUsoUsuario(Integer idade, Double qtdHorasUso) {
        System.out.println("\nResultado:\n");
        
        Double pctgDia = this.calcularPctgUso(idade, 'D', qtdHorasUso);
        Double pctgDiaRef = this.calcularPctgUso(idade, 'D', null);
        
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
