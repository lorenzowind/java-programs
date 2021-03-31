import java.util.Scanner;

/**
 * A classe MenuPrograma é a camada de apresentação do programa, sendo a estrutura que contém o 
 * método main, e além disso um fluxo de entrada a fim de controlar as opções do úsuario, 
 * encaminhando-o para a tarefa 01, tarefa 02 ou saindo do programa. Essa classe também é 
 * responsável pela tratativa e validação das informações recebidas.
 * 
 * @author (Lorenzo Windmoller Martins | 21104284-1) 
 * @version (v.01 | 30/03/21)
 */
public class MenuPrograma {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        // Objeto para permitir a execução dos métodos referentes a tarefa 01 e tarefa 02
        ControladorTarefa controladorTarefa = new ControladorTarefa();
        
        Integer opcao;
        
        do {
            // Comando para limpar a tela
            System.out.print("\f");
            
            System.out.println("----- Trabalho 01 -----\n");

            System.out.println("0 - Sair");            
            System.out.println("1 - Tarefa 01");
            System.out.println("2 - Tarefa 02\n");
            
            System.out.print("Escolha uma opção: ");
            
            // Comando para leitura de opção e limpeza do buffer do teclado
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1: {
                    System.out.print("\f");
                    
                    // Método referente a tarefa 01
                    controladorTarefa.calcularPctgUsoFaixaEtariaEscolar();
                    
                    // Comandos para aguardar a visualização do usuário
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                case 2: {
                    System.out.print("\f");
                    
                    System.out.print("Informe sua idade: ");
                    
                    Integer idade = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("\nInforme a quantidade média de horas que você" + 
                        " usa seus dispositivos por dia");
                    
                    System.out.print("* formato (hh:mm): ");
                    
                    // Variável para armazenar quantidade de horas informada pelo usuário
                    String[] qtdHorasUsoStr = scanner.next().split(":");
                    scanner.nextLine();
                    
                    // Variável para armazenar quantidade de horas formatada com tipagem numérica
                    Double qtdHorasUso = Double.parseDouble(qtdHorasUsoStr[0]) 
                        + Double.parseDouble(qtdHorasUsoStr[1]) / 60;
                    
                    // Método referente a tarefa 02
                    controladorTarefa.calcularPctgUsoUsuario(idade, qtdHorasUso);
                    
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}
