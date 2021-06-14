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
            
            System.out.println("----- Trabalho 04 -----\n");
        
            System.out.println("1 - Tarefa 01 (Listar pacientes)");
            System.out.println("2 - Tarefa 02 (Calcular média de dias dos pacientes na UTI)");
            System.out.println("3 - Tarefa 03 (Listar pacientes por tempo de internação)");
            System.out.println("4 - Tarefa 04 (Calcular porcentagem de pacientes por convênio)");
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
                System.out.print("\f");
                
                if (opcao == 1) {
                    // Método referente a tarefa 01
                    controladorTarefa.listarPacientes();
                } else if (opcao == 2) {
                    // Método referente a tarefa 02
                    controladorTarefa.calcularMediaDiasInternacaoUTI();
                } else if (opcao == 3) {
                    // Método referente a tarefa 03
                    controladorTarefa.listarPacientesPorTempoInternacao();
                } else if (opcao == 4) {
                    // Método referente a tarefa 04
                    controladorTarefa.calcularPorcentagemConvenioPacientes();
                }
                
                System.out.println("Aperte enter para voltar...");
                scanner.nextLine();
            } else {
                System.out.println("\nPrograma encerrado com sucesso, volte sempre!");
            }
        } while (opcao != 5);
        
        scanner.close();
    }
}
