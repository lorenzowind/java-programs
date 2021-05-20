/**
 * A classe GeradorCPF é a estrutura para descrever as características do gerador de CPF, contendo
 * alguns métodos úteis.
 */
public class GeradorCPF {
    public GeradorCPF() {
    }

    /**
     * Método para geração de CPF a partir de números aleatórios com utilização do método random da
     * classe Math.
     * 
     * @return String - CPF gerado
     */
    public String gerarCPF() {
        String cpf = "";
        
        // Laço para geração de números randômicos conforme a quantidade de dígitos do CPF
        for (int i = 0; i < 11; i++) {
            cpf += Integer.toString((int)(Math.random() * 10));
        }
        
        // Retorno do CPF gerado inserindo os caracteres especiais
        return cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + 
            cpf.substring(6,9) + "-" + cpf.substring(9,11);
    }
}
