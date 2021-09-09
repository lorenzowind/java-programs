import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A classe MenuPrograma é a camada de apresentação do programa, sendo a estrutura que contém o 
 * método main, e além disso um fluxo de entrada a fim de controlar as opções do úsuario, 
 * encaminhando-o para as tarefas ou saindo do programa. Essa classe também é responsável pela 
 * tratativa e validação das informações recebidas.
 *
 * @author (Lorenzo Windmoller Martins | 21104284-1) 
 * @version (v.01 | 14/06/21)
 */
public class MenuPrograma {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        // Objeto para permitir a execução dos métodos referentes as tarefas
        ControladorTarefa controladorTarefa = new ControladorTarefa();
        
        // Variável para controle da opção do usuário
        Integer opcao = -1;
            
        do {  
            // Comando para limpar a tela
            System.out.print("\f");
            
            System.out.println("----- Trabalho Integrador -----\n");
        
            System.out.println("1 - Tarefa 01 (Preencher planilha do dia)");
            System.out.println("2 - Tarefa 02 (Gerar relatório semanal)");
            System.out.println("3 - Tarefa 03 (Calcular categoria especial)");
            System.out.println("4 - Tarefa 04 (Descobrir cliente idoso)");
            System.out.println("5 - Sair");    
            
            // Atribuição para certificar a redefinição da opção
            opcao = -1;
            
            do {
                System.out.print("\nEscolha uma opção: ");
            
                try {
                    // Comando para leitura da opção desejada
                    opcao = scanner.nextInt();
                    
                    // Validação da opção informada
                    if (opcao < 1 || opcao > 5) {
                        System.out.println("\nAtenção, informe apenas 1, 2, 3, 4 ou 5!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nAtenção, informe apenas 1, 2, 3, 4 ou 5!");
            
                    // Comando para limpeza do buffer do teclado
                    scanner.nextLine();
                }
            } while (opcao < 1 || opcao > 5);
            
            scanner.nextLine();
            
            if (opcao != 5) {
                switch (opcao) {
                    case 1: {
                        System.out.print("\f");
                        
                        // Variáveis para armazenar informações de alocação
                        String diaSemana, placa;
                        Integer categoria = 0, linha = 0, coluna = 0;
                        
                        // Variável para controle da validação das informações
                        Boolean valido = false;
                        
                        do {
                            System.out.println("Informe dia da semana: ");
                            System.out.print("(seg, ter, qua, qui, sex, sab): ");
                            diaSemana = scanner.next();
                        
                            if (!diaSemana.equals("seg") &&
                                !diaSemana.equals("ter") &&
                                !diaSemana.equals("qua") &&
                                !diaSemana.equals("qui") &&
                                !diaSemana.equals("sex") &&
                                !diaSemana.equals("sab")) {
                                System.out.println("\nAtenção, informe um dia da semana válido!\n"); 
                            } else {
                                valido = true;
                            }
                        } while (!valido);
                        
                        valido = false;
                                
                        do {
                            try {
                                System.out.println("\n1 - Idosos");
                                System.out.println("2 - PRF");
                                System.out.println("3 - Gestantes");
                                System.out.print("4 - Vaga simples");
                                System.out.print("\nInforme a categoria do cliente: ");
                                categoria = scanner.nextInt();
                                
                                if (categoria < 1 || categoria > 4 ) {
                                    System.out.println("\nAtenção, informe apenas 1, 2, 3 ou 4!");
                                } else {
                                    valido = true;
                                }
                            } catch (InputMismatchException e) {  
                                System.out.println("\nAtenção, informe apenas números!");
                        
                                scanner.nextLine();
                            }
                        } while (!valido);  
                        
                        valido = false;
                                
                        do {
                            try {
                                System.out.println("\nInforme a linha da vaga: ");
                                System.out.print("(1, 2): ");
                                linha = scanner.nextInt();
                                
                                if (linha != 1 && linha != 2 ) {
                                    System.out.println("\nAtenção, informe apenas 1 ou 2!");
                                } else {
                                    valido = true;
                                }
                            } catch (InputMismatchException e) {  
                                System.out.println("\nAtenção, informe apenas números!");
                        
                                scanner.nextLine();
                            }
                        } while (!valido);
                        
                        valido = false;
                                
                        do {
                            try {
                                System.out.println("\nInforme a coluna da vaga: ");
                                System.out.print("(1, 2, 3, 4, 5): ");
                                coluna = scanner.nextInt();
                                
                                if (coluna < 1 || coluna > 5 ) {
                                    System.out.println("\nAtenção, informe apenas 1, 2, 3, 4 ou 5!");
                                } else {
                                    valido = true;
                                }
                            } catch (InputMismatchException e) {  
                                System.out.println("\nAtenção, informe apenas números!");
                        
                                scanner.nextLine();
                            }
                        } while (!valido);
                        
                        System.out.print("\nInforme a placa do carro do cliente: ");
                        placa = scanner.next();
                    
                        scanner.nextLine();
                        
                        // Método referente a tarefa 01
                        controladorTarefa.preencherPlanilha(diaSemana, categoria, linha, coluna, 
                            placa);
                        break;
                    }
                    case 2: {
                        System.out.print("\f");
                        
                        // Variáveis para armazenar dia da semana
                        String diaSemana;
                        
                        // Variável para controle da validação das informações
                        Boolean valido = false;
                        
                        do {
                            System.out.println("Informe dia da semana: ");
                            System.out.print("(seg, ter, qua, qui, sex, sab): ");
                            diaSemana = scanner.next();
                        
                            if (!diaSemana.equals("seg") &&
                                !diaSemana.equals("ter") &&
                                !diaSemana.equals("qua") &&
                                !diaSemana.equals("qui") &&
                                !diaSemana.equals("sex") &&
                                !diaSemana.equals("sab")) {
                                System.out.println("\nAtenção, informe um dia da semana válido!\n"); 
                            } else {
                                valido = true;
                            }
                        } while (!valido);
                    
                        scanner.nextLine();
                        
                        // Método referente a tarefa 02
                        controladorTarefa.gerarRelatorio(diaSemana);
                        break;
                    }
                    case 3: {
                        System.out.print("\f");
                        
                        // Método referente a tarefa 03
                        controladorTarefa.calcularCategoria();
                        break;
                    }
                    case 4: {
                        System.out.print("\f");
                        
                        // Método referente a tarefa 04
                        controladorTarefa.descobrirClienteIdoso();
                        break;
                    }
                    default: {
                        System.out.println("\nPrograma encerrado com sucesso, volte sempre!");
                    }
                }
                
                System.out.println("Aperte enter para voltar...");
                scanner.nextLine();
            }
        } while (opcao != 5);
        
        scanner.close();
    }
}
