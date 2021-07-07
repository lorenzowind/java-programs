/**
 * A classe ControleEstacionamento é a camada de modelo do programa, sendo a estrutura que contém os 
 * métodos e atributos referentes a parte lógica do programa, gerenciando o comportamento dos dados.
 */
public abstract class ControleEstacionamento implements RepositorioOperacoes {
    // Matriz para armazenar os carros no estacionamento
    private Carro[][][] estacionamento = new Carro[2][5][1];

    public Carro[][][] getEstacionamento() {
        return this.estacionamento;
    }
    
    public void adicionarCarro(Integer linha, Integer coluna, Carro carro) {
        Integer carrosArmazenados = estacionamento[linha][coluna].length;
        
        if (estacionamento[linha][coluna][carrosArmazenados - 1] != null) {
            Carro[] arrayCarros = estacionamento[linha][coluna];
            
            estacionamento[linha][coluna] = new Carro[carrosArmazenados + 1];
            Integer indice = 0;
            
            for (Carro carroAux : arrayCarros) {
                estacionamento[linha][coluna][indice++] = carroAux;
            }
            
            estacionamento[linha][coluna][indice] = carro;
        } else {
            estacionamento[linha][coluna][carrosArmazenados - 1] = carro;
        }
    }
    
    public Integer buscarQuantidadeCategoriaPorDia(Integer categoria, String diaSemana) {
        Integer acumuladorCategoria = 0;
        
        for (int linha = 0; linha < 2; linha += 1) {
            for (int coluna = 0; coluna < 5; coluna += 1) {
                for (int indiceCarro = 0; indiceCarro < estacionamento[linha][coluna].length; 
                    indiceCarro += 1) {
                    if (estacionamento[linha][coluna][indiceCarro] != null) {
                        if (estacionamento[linha][coluna][indiceCarro].getCategoria() == 
                            categoria && estacionamento[linha][coluna][indiceCarro].
                                getDiaSemana().equals(diaSemana)) {
                            acumuladorCategoria++;
                        }  
                    } 
                }
            }    
        }
        
        return acumuladorCategoria;
    }
    
    public Carro[] buscarVeiculosCategoriaPorDia(Integer categoria, String diaSemana) {
        Carro[] acumuladorCarros = new Carro[1];
        
        for (int linha = 0; linha < 2; linha += 1) {
            for (int coluna = 0; coluna < 5; coluna += 1) {
                for (int indiceCarro = 0; indiceCarro < estacionamento[linha][coluna].length; 
                    indiceCarro += 1) {
                    if (estacionamento[linha][coluna][indiceCarro] != null) {
                        if (estacionamento[linha][coluna][indiceCarro].getCategoria() == 
                            categoria && estacionamento[linha][coluna][indiceCarro].
                                getDiaSemana().equals(diaSemana)) {
                            Integer carrosArmazenados = acumuladorCarros.length;
            
                            if (acumuladorCarros[carrosArmazenados - 1] != null) {
                                Carro[] arrayCarros = acumuladorCarros;
                                
                                acumuladorCarros = new Carro[carrosArmazenados + 1];
                                Integer indice = 0;
                                
                                for (Carro carroAux : arrayCarros) {
                                    acumuladorCarros[indice++] = carroAux;
                                }
                                
                                acumuladorCarros[indice] = estacionamento[linha][coluna][indiceCarro];
                            } else {
                                acumuladorCarros[carrosArmazenados - 1] = 
                                    estacionamento[linha][coluna][indiceCarro];
                            }  
                        } 
                    }   
                }
            }    
        }
        
        return acumuladorCarros;
    }
}
