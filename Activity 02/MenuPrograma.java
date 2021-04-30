import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A classe MenuPrograma é a camada de apresentação do programa, sendo a estrutura que contém o 
 * método main, e além disso um fluxo de entrada a fim de controlar as opções do úsuario, 
 * encaminhando-o para a tarefa 01, tarefa 02, tarefa 03 ou saindo do programa. Essa classe 
 * também é responsável pela tratativa e validação das informações recebidas.
 * 
 * @author (Lorenzo Windmoller Martins | 21104284-1) 
 * @version (v.01 | 30/04/21)
 */
public class MenuPrograma {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        // Objeto para permitir a execução dos métodos referentes a tarefa 01, 02 e 03
        ControladorTarefa controladorTarefa = new ControladorTarefa();
        
        // Variável para controle da opção do usuário
        Integer opcao = -1;
            
        do {  
            // Comando para limpar a tela
            System.out.print("\f");
            
            System.out.println("----- Trabalho 02 -----\n");
        
            System.out.println("1 - Tarefa 01 (Descobrir signo do zodíaco)");
            System.out.println("2 - Tarefa 02 (Descobrir idade)");
            System.out.println("3 - Tarefa 03 (Descobrir dia da semana do nascimento)");
            System.out.println("4 - Sair");    
            
            // Atribuição para certificar a redefinição da opção
            opcao = -1;
            
            do {
                System.out.print("\nEscolha uma opção: ");
            
                try {
                    // Comando para leitura da opção desejada
                    opcao = scanner.nextInt();
                    
                    // Validação da opção informada
                    if (opcao < 1 || opcao > 4) {
                        System.out.println("\nAtenção, informe apenas 1, 2, 3 ou 4!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nAtenção, informe apenas 1, 2, 3 ou 4!");
            
                    // Comando para limpeza do buffer do teclado
                    scanner.nextLine();
                }
            } while (opcao < 1 || opcao > 4);
            
            scanner.nextLine();
            
            switch (opcao) {
                case 1: {
                    System.out.print("\f");
                    
                    // Variável para armazenar dia e mês de nascimento informados pelo usuário
                    String[] diaMesNascimento;
                    
                    // Variável para controle da validação das informações
                    Boolean valido = false;
                    
                    do {
                        System.out.println("\nInforme o dia e mês que você nasceu");
                    
                        System.out.print("* formato (dd/MM): ");
                    
                        diaMesNascimento = scanner.next().split("/");
                        
                        if (diaMesNascimento.length != 2) {
                            System.out.println("\nAtenção, informe no formato correto!");
                        } else {
                            try {
                                Integer dia = Integer.parseInt(diaMesNascimento[0]);
                                Integer mes = Integer.parseInt(diaMesNascimento[1]);
                                
                                // Validação do tempo informado
                                if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {    
                                    System.out.println("\nAtenção, informe dia/mês válido!");
                                } else {
                                    valido = true;
                                }
                                
                            } catch (NumberFormatException e) {  
                                System.out.println("\nAtenção, informe apenas números!");
                            }
                        }
                    } while (!valido);
                    
                    scanner.nextLine();
                    
                    // Método referente a tarefa 01
                    controladorTarefa.descobrirSignoZodiaco(diaMesNascimento);
                    
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                case 2:
                case 3:  {
                    System.out.print("\f");
                    
                    // Variável para armazenar data de nascimento informada pelo usuário
                    String[] dataNascimento;
                    
                    // Variável para controle da validação das informações
                    Boolean valido = false;
                    
                    do {
                        System.out.println("\nInforme data que você nasceu");
                    
                        System.out.print("* formato (dd/MM/yyyy): ");
                    
                        dataNascimento = scanner.next().split("/");
                        
                        if (dataNascimento.length != 3) {
                            System.out.println("\nAtenção, informe no formato correto!");
                        } else {
                            try {
                                Integer dia = Integer.parseInt(dataNascimento[0]);
                                Integer mes = Integer.parseInt(dataNascimento[1]);
                                Integer ano = Integer.parseInt(dataNascimento[2]);
                                
                                // Validação do tempo informado
                                if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1900) {    
                                    System.out.println("\nAtenção, informe data válida!");
                                } else {
                                    valido = true;
                                }
                                
                            } catch (NumberFormatException e) {  
                                System.out.println("\nAtenção, informe apenas números!");
                            }
                        }
                    } while (!valido);
                    
                    scanner.nextLine();
                    
                    if (opcao == 2) {
                        // Método referente a tarefa 02
                        controladorTarefa.descobrirIdade(dataNascimento);
                    } else {
                        // Método referente a tarefa 03
                        controladorTarefa.descobrirDiaSemana(dataNascimento);
                    }
                    
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 4);
        
        scanner.close();
    }
}
