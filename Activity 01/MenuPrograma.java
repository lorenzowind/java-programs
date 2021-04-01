import java.util.Scanner;
import java.util.InputMismatchException;

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
        
        // Variável para controle da opção do usuário
        Integer opcao = -1;
            
        do {  
            // Comando para limpar a tela
            System.out.print("\f");
            
            System.out.println("----- Trabalho 01 -----\n");

            System.out.println("0 - Sair");            
            System.out.println("1 - Tarefa 01");
            System.out.println("2 - Tarefa 02");
            
            // Atribuição para certificar a redefinição da opção
            opcao = -1;
            
            do {
                System.out.print("\nEscolha uma opção: ");
            
                try {
                    // Comando para leitura da opção desejada
                    opcao = scanner.nextInt();
                    
                    // Validação da opção informada
                    if (opcao < 0 || opcao > 2) {
                        System.out.println("\nAtenção, informe apenas 0, 1 ou 2!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nAtenção, informe apenas 0, 1 ou 2!");
            
                    // Comando para limpeza do buffer do teclado
                    scanner.nextLine();
                }
            } while (opcao < 0 || opcao > 2);
            
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
                    
                    // Variável para armazenar a idade do usuário
                    Integer idade = -1;
                    
                    do {
                        System.out.print("Informe sua idade: ");
                    
                        try {
                            idade = scanner.nextInt();
                            
                            // Validação da idade informada
                            if (idade < 0) {
                                System.out.println("\nAtenção, informe uma idade válida!\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\nAtenção, informe apenas o número!\n");
                    
                            scanner.nextLine();
                        }
                    } while (idade < 0);
                    
                    scanner.nextLine();
                    
                    // Variável para armazenar quantidade de horas informada pelo usuário
                    String[] qtdHorasUsoStr;
                    // Variável para armazenar quantidade de horas formatada com tipagem numérica
                    Double qtdHorasUso = 0.0;
                    
                    // Variável para controle da validação das informações
                    Boolean valido = false;
                    
                    do {
                        System.out.println("\nInforme a quantidade média de horas que você" + 
                            " usa seus dispositivos por dia");
                    
                        System.out.print("* formato (hh:mm): ");
                    
                        qtdHorasUsoStr = scanner.next().split(":");
                        
                        if (qtdHorasUsoStr.length != 2) {
                            System.out.println("\nAtenção, informe no formato correto!");
                        } else {
                            try {
                                Double horas = Double.parseDouble(qtdHorasUsoStr[0]);
                                Double minutos = Double.parseDouble(qtdHorasUsoStr[1]) / 60;
                                
                                // Validação do tempo informado
                                if (horas < 0 || horas > 24 || minutos < 0 || minutos > 1) {    
                                    System.out.println("\nAtenção, informe um tempo válido!");
                                } else {
                                    qtdHorasUso = horas + minutos;
                                    
                                    valido = true;
                                }
                                
                            } catch (NumberFormatException e) {  
                                System.out.println("\nAtenção, informe apenas números!");
                            }
                        }
                    } while (!valido);
                    
                    scanner.nextLine();
                    
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
