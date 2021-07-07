/**
 * A classe ControleEstacionamento é a camada de modelo do programa, sendo a estrutura que contém os 
 * métodos e atributos referentes a parte lógica do programa, gerenciando o comportamento dos dados.
 */
public abstract class ControleEstacionamento implements RepositorioOperacoes {
    // Matriz para armazenar os carros no estacionamento
    private Carro[][][] estacionamento = new Carro[2][5][1];
        
    /**
     * Método para adicionar um carro na matriz estacionamento.
     * 
     * @param linha Integer - Linha da matriz estacionamento
     * @param coluna Integer - Coluna da matriz estacionamento
     * @param carro Carro - Objeto da classe Carro
     */
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
        
    /**
     * Método para buscar a quantidade de carros de determinada categoria que utilizaram o
     * estacionamento em um dia da semana específico.
     * 
     * @param categoria Integer - Categoria do cliente
     * @param diaSemana String - Dia da semana
     * 
     * @return Integer - Quantidade de carros
     */
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
        
    /**
     * Método para buscar os carros de determinada categoria que utilizaram o estacionamento em um 
     * dia da semana específico.
     * 
     * @param categoria Integer - Categoria do cliente
     * @param diaSemana String - Dia da semana
     * 
     * @return Carro[] - Array de carros
     */
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
     
    /**
     * Método para buscar a categoria especial e a quantidade de carros que mais utilizou o
     * estacionamento.
     * 
     * @return Integer[] - Array de inteiro, sendo a primeira posição o código da categoria e a
     * segunda posição a quantidade de carros
     */
    public Integer[] buscarCategoriaEspecial() {
        Integer[] categorias = new Integer[4];
        
        for (int linha = 0; linha < 2; linha += 1) {
            for (int coluna = 0; coluna < 5; coluna += 1) {
                for (int indiceCarro = 0; indiceCarro < estacionamento[linha][coluna].length; 
                    indiceCarro += 1) {
                    if (estacionamento[linha][coluna][indiceCarro] != null) {
                        if (categorias[estacionamento[linha][coluna][indiceCarro].
                            getCategoria() - 1] != null) {
                            categorias[estacionamento[linha][coluna][indiceCarro].
                                getCategoria() - 1]++;
                        } else {
                            categorias[estacionamento[linha][coluna][indiceCarro].
                                getCategoria() - 1] = 1;
                        }
                    } 
                }
            }    
        }
        
        Integer categoriaMaxima = 0, quantidadeMaxima = 0;
        
        for (int indice = 0; indice < 4; indice += 1) {
            if (categorias[indice] != null) {
                if (categorias[indice] > quantidadeMaxima) {
                    categoriaMaxima = indice;
                    quantidadeMaxima = categorias[indice];
                }
            }
        }
        
        return new Integer[]{categoriaMaxima, quantidadeMaxima};
    }
    
    /**
     * Método para buscar os carros da categoria de clientes idosos que utilizaram o estacionamento
     * mais de uma vez.
     * 
     * @return Carro[] - Array de carros
     */
    public Carro[] buscarClientesIdosos() {
        Carro[] acumuladorCarros = new Carro[1];
        
        for (int linha = 0; linha < 2; linha += 1) {
            for (int coluna = 0; coluna < 5; coluna += 1) {
                for (int indiceCarro = 0; indiceCarro < estacionamento[linha][coluna].length; 
                    indiceCarro += 1) {
                    if (estacionamento[linha][coluna][indiceCarro] != null) {
                        if (estacionamento[linha][coluna][indiceCarro].getCategoria() == 1) {
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
