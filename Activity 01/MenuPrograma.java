import java.util.Scanner;

/**
 * Escreva a descrição da classe Menu aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class MenuPrograma {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        ControladorTarefa controladorTarefa = new ControladorTarefa();
        Integer option;
        
        do {
            System.out.print("\f");
            System.out.println("----- Trabalho 01 -----\n");

            System.out.println("0 - Sair");            
            System.out.println("1 - Tarefa 01");
            System.out.println("2 - Tarefa 02\n");
            
            System.out.print("Escolha uma opção: ");
            
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1: {
                    System.out.print("\f");
                    
                    controladorTarefa.calcularPctgUsoFaixaEtariaEscolar();
                    
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
                    
                    String[] qtdHorasUsoStr = scanner.next().split(":");
                    scanner.nextLine();
                    
                    Double qtdHorasUso = Double.parseDouble(qtdHorasUsoStr[0]) 
                        + Double.parseDouble(qtdHorasUsoStr[1]) / 60;
                    
                    controladorTarefa.calcularPctgUsoUsuario(idade, qtdHorasUso);
                    
                    System.out.println("Aperte enter para voltar...");
                    scanner.nextLine();
                    
                    break;
                }
                default: {
                    break;
                }
            }
        } while (option != 0);
        
        scanner.close();
    }
}
