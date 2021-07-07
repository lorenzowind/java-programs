/**
 * A classe ControladorTarefa é a camada de controle do programa, sendo a estrutura que contém os 
 * métodos referentes a todas as tarefas, tendo a responsabilidade de manipular os dados informados 
 * pelo usuário.
 */
public class ControladorTarefa extends ControleEstacionamento {
    public ControladorTarefa() {
    }
    
    public void preencherPlanilha(String diaSemana, Integer categoria, Integer linha, Integer coluna, 
        String placa) {             
        if (linha == 1 && coluna == 1 && categoria != 1) {
            System.out.println("\nEssa categoria não é permitida para essa vaga!\n");
            return;
        }
        
        if (linha == 2 && coluna == 1 && categoria != 3) {
            System.out.println("\nEssa categoria não é permitida para essa vaga!\n");
            return;
        }
        
        if (((linha == 1 && coluna == 5) || (linha == 2 && coluna == 5)) && categoria != 2) {
            System.out.println("\nEssa categoria não é permitida para essa vaga!\n");
            return;
        }
        
        this.adicionarCarro(linha - 1, coluna - 1, new Carro(diaSemana, placa, categoria));
        
        System.out.println("\nO carro foi adicionado no registro de estacionamento com sucesso!\n");
    }
    
    public void gerarRelatorio(String diaSemana) {
        Integer quantidadeCategoria = this.buscarQuantidadeCategoriaPorDia(1, diaSemana);
        
        System.out.printf("\nQuantidade de veículos da categoria 1: %d\n", quantidadeCategoria);
        
        if (quantidadeCategoria != 0) {
            System.out.println("\nPlacas: \n");
            
            for (Carro carro : this.buscarVeiculosCategoriaPorDia(1, diaSemana)) {
                System.out.printf("%s\n", carro.getPlaca());
            }
        }
        
        quantidadeCategoria = this.buscarQuantidadeCategoriaPorDia(2, diaSemana);
        
        System.out.printf("\nQuantidade de veículos da categoria 2: %d\n", quantidadeCategoria);
        
        if (quantidadeCategoria != 0) {
            System.out.println("\nPlacas: \n");
            
            for (Carro carro : this.buscarVeiculosCategoriaPorDia(2, diaSemana)) {
                System.out.printf("%s\n", carro.getPlaca());
            }
        }
        
        quantidadeCategoria = this.buscarQuantidadeCategoriaPorDia(3, diaSemana);
        
        System.out.printf("\nQuantidade de veículos da categoria 3: %d\n", quantidadeCategoria);
        
        if (quantidadeCategoria != 0) {
            System.out.println("\nPlacas: \n");
            
            for (Carro carro : this.buscarVeiculosCategoriaPorDia(3, diaSemana)) {
                System.out.printf("%s\n", carro.getPlaca());
            }
        }
        
        quantidadeCategoria = this.buscarQuantidadeCategoriaPorDia(4, diaSemana);
        
        System.out.printf("\nQuantidade de veículos da categoria 4: %d\n\n", quantidadeCategoria);
        
        if (quantidadeCategoria != 0) {
            System.out.println("Placas: \n");
            
            for (Carro carro : this.buscarVeiculosCategoriaPorDia(4, diaSemana)) {
                System.out.printf("%s\n", carro.getPlaca());
            }
        }
    }
    
    public void calcularCategoria() {
        Integer[] categoriaEspecial = this.buscarCategoriaEspecial();
        
        if (categoriaEspecial[1] != 0) {
            System.out.println("A categoria especial que mais utilizou o estacionamento da loja foi:");
            
            System.out.printf("\nCategoria: %d\n", categoriaEspecial[0] + 1);
            System.out.printf("Quantidade de veículos: %d\n\n", categoriaEspecial[1]);
        } else {
            System.out.println("Nenhum veículo foi registrado no estacionamento!\n");
        }
    }
    
    public void descobrirClienteIdoso() {
        Carro[] carrosClientesIdosos = this.buscarClientesIdosos();
        String[] placasCarros = new String[1];
        Boolean clienteRetornou = false;
        
        for (int indice = 0; indice < carrosClientesIdosos.length; indice += 1) {
            Boolean placaVista = false;
            Integer quantidade = 0;
            
            if (carrosClientesIdosos[indice] != null) {                
                for (int indicePlaca = 0; indicePlaca < placasCarros.length; indicePlaca += 1) {
                    if (placasCarros[indicePlaca] != null) {
                        if (carrosClientesIdosos[indice].getPlaca().equals(placasCarros[indicePlaca])) {
                            placaVista = true;        
                        }
                    }
                }
                
                if (!placaVista) {
                    for (int indiceSec = 0; indiceSec < carrosClientesIdosos.length; indiceSec += 1) {
                        if (carrosClientesIdosos[indice].getPlaca().
                            equals(carrosClientesIdosos[indiceSec].getPlaca())) {
                            quantidade++;    
                        }
                    }
                    
                    if (quantidade > 1) {
                        clienteRetornou = true;
                        
                        System.out.printf("Cliente idoso com placa %s compareceu %d vezes\n\n", 
                            carrosClientesIdosos[indice].getPlaca(), quantidade);
                    }
                        
                    Integer placasArmazenadas = placasCarros.length;
            
                    if (placasCarros[placasArmazenadas - 1] != null) {
                        String[] arrayPlacas = placasCarros;
                        
                        placasCarros = new String[placasArmazenadas + 1];
                        Integer indiceAux = 0;
                        
                        for (String placaAux : arrayPlacas) {
                            placasCarros[indiceAux++] = placaAux;
                        }
                        
                        placasCarros[indiceAux] = carrosClientesIdosos[indice].getPlaca();
                    } else {
                        placasCarros[placasArmazenadas - 1] = 
                            carrosClientesIdosos[indice].getPlaca();
                    }  
                }
            }
        }
        
            
        if (!clienteRetornou) {
            System.out.println("Nenhum cliente idoso retornou ao estacionamento!\n");
        }
    }
}
