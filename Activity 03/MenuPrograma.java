import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A classe MenuPrograma é a camada de apresentação do programa, sendo a estrutura que contém o 
 * método main, e além disso um fluxo de entrada a fim de controlar as opções do úsuario, 
 * encaminhando-o para as tarefas ou saindo do programa. Essa classe também é responsável pela 
 * tratativa e validação das informações recebidas.
 *
 * @author (Lorenzo Windmoller Martins | 21104284-1) 
 * @version (v.01 | 19/05/21)
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
            
            System.out.println("----- Trabalho 03 -----\n");
        
            System.out.println("1 - Tarefa 01 (Cadastrar paciente)");
            System.out.println("2 - Tarefa 02 (Listar pacientes)");
            System.out.println("3 - Tarefa 03 (Alterar diagnóstico do paciente)");
            System.out.println("4 - Tarefa 04 (Alterar convênio do paciente)");
            System.out.println("5 - Tarefa 05 (Consultar valor total a pagar pelas consultas)");
            System.out.println("6 - Tarefa 06 (Descobrir paciente com mais vogais)");
            System.out.println("7 - Sair");    
            
            // Atribuição para certificar a redefinição da opção
            opcao = -1;
            
            do {
                System.out.print("\nEscolha uma opção: ");
            
                try {
                    // Comando para leitura da opção desejada
                    opcao = scanner.nextInt();
                    
                    // Validação da opção informada
                    if (opcao < 1 || opcao > 4) {
                        System.out.println("\nAtenção, informe apenas 1, 2, 3, 4, 5, 6 ou 7!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nAtenção, informe apenas 1, 2, 3, 4, 5, 6 ou 7!");
            
                    // Comando para limpeza do buffer do teclado
                    scanner.nextLine();
                }
            } while (opcao < 1 || opcao > 7);
            
            scanner.nextLine();
            
            switch (opcao) {
                case 1: {
                    System.out.print("\f");
                    
                    // Variáveis para armazenar informações do paciente informadas pelo usuário
                    String nome, cpf, telefone, convenio, diagnostico;
                    Integer numConsultasMes;
                    
                    // Variável para controle da validação das informações
                    Boolean valido = false;
                    
                    System.out.print("\nInforme o nome do paciente:");
                    nome = scanner.next();
                    
                    do {
                        System.out.println("\nDesejas gerar o CPF?");
                        System.out.print("* (S/N): ");
                       
                        // Variável para armazenar a preferência do usuário em relação ao CPF
                        String preferenciaCPF = scanner.next();
                        
                        if (preferenciaCPF.length != 1 || 
                            preferenciaCPF != "S" || 
                            preferenciaCPF != "N") {
                            System.out.println("\nAtenção, informe uma resposta válida!");
                        } else {
                            valido = true;
                        }
                        
                        if (valido) {
                            if (preferenciaCPF == "S") {
                                cpf = CPF.();
                                
                                System.out.printf("\nCPF do paciente: %s\n", cpf);
                            } else {
                                System.out.print("\nInforme o CPF do paciente:");
                                cpf = scanner.next();
                            }
                        }
                    } while (!valido);
                    
                    System.out.print("\nInforme o telefone do paciente:");
                    telefone = scanner.next();
                    
                    System.out.print("\nInforme o convênio do paciente:");
                    convenio = scanner.next();
                    
                    System.out.print("\nInforme o diagnóstico do paciente:");
                    diagnostico = scanner.next();
                    
                    valido = false;
                    
                    do {
                        try {
                            System.out.print("\nInforme o número de consultas no mês:");
                            numConsultas = scanner.nextInt();
                            
                            valido = true;
                        } catch (Error e) {  
                            System.out.println("\nAtenção, informe apenas números!");
                        }
                    } while (!valido);
                    
                    scanner.nextLine();
                    
                    // Método referente a tarefa 01
                    controladorTarefa.(nome, cpf, telefone, convenio, diagnostico, numConsultasMes);
                    
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                case 2:
                case 6: {
                    System.out.print("\f");
                    
                    if (opcao == 2) {
                        // Método referente a tarefa 02
                        controladorTarefa.();
                    } else {
                        // Método referente a tarefa 06
                        controladorTarefa.();
                    }
                    
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                case 3:
                case 4:
                case 5:  {
                    System.out.print("\f");
                    
                    // Variável para armazenar a preferência do usuário em relação à tarefa 05
                    String preferenciaConsulta;
                    
                    // Variável para controle da validação das informações
                    Boolean valido = false;
                    
                    if (opcao == 5) {
                        do {
                            System.out.println("\nDesejas consultar apenas um paciente ou todos?");
                            System.out.print("* (1/N): ");
                           
                            preferenciaConsulta = scanner.next();
                            
                            if (preferenciaConsulta.length != 1 || 
                                preferenciaConsulta != "1" || 
                                preferenciaConsulta != "N") {
                                System.out.println("\nAtenção, informe uma resposta válida!");
                            } else {
                                valido = true;
                            }
                            
                            if (valido) {
                                if (preferenciaConsulta == "N") {
                                    // Método referente a tarefa 05
                                    controladorTarefa.();
                                }
                            }
                        } while (!valido);
                    }
                    
                    if (opcao == 3 || opcao == 4 || preferenciaConsulta == "1") {
                        // Variável para armazenar o nome do paciente informado pelo usuário
                        String nome;
                        
                        System.out.print("\nInforme o nome do paciente:");
                        nome = scanner.next();
                        
                        scanner.nextLine();
                        
                        if (opcao == 3) {
                            // Método referente a tarefa 03
                            controladorTarefa.();
                        } else if (opcao == 4) {
                            // Método referente a tarefa 04
                            controladorTarefa.();
                        } else {
                            // Método referente a tarefa 05
                            controladorTarefa.();
                        }
                    }
                    
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 7);
        
        scanner.close();
    }
}
