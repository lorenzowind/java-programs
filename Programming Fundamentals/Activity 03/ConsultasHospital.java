import java.util.ArrayList;
import java.text.Normalizer;

/**
 * A classe ConsultasHospital é a camada de modelo do programa, sendo a estrutura que contém os 
 * métodos e atributos referentes a parte lógica do programa, gerenciando o comportamento dos dados.
 */
public abstract class ConsultasHospital implements RepositorioOperacoes, RepositorioConstantes {
    private GeradorCPF geradorCPF = new GeradorCPF();
    
    // ArrayList para armazenar os pacientes cadastrados
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>() {{
        add(new Paciente("Maria", geradorCPF.gerarCPF(), "ESTRELA", "febre", 2));
        add(new Paciente("João", geradorCPF.gerarCPF(), "GIRASAUDE", "taquicardia", 3));
    }};
    
    public ArrayList<Paciente> getPacientes() {
        return this.pacientes;
    }

    /**
     * Método para adicionar paciente no ArrayList de pacientes. 
     *  
     * @param paciente Paciente - Instância de paciente
     */
    public void adicionarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }
    
    /**
     * Método para calcular valor total a pagar pelas consultas do mês. 
     *  
     * @return Paciente - Instância de paciente
     */
    public Double calcularValorPagarConsulta(Paciente paciente) {
        return paciente.getNumConsultaMes() * this.valorConsulta;
    }
    
    /**
     * Método para encontrar nome do paciente com mais vogais. 
     *  
     * @return Paciente - Instância de paciente
     */
    public Paciente encontrarNomeMaisVogais() {
        Paciente pacienteEncontrado = null;
        Integer numVogaisMax = 0;
        
        // Laço de repetição para percorrer todos os pacientes
        for (Paciente paciente : this.getPacientes()) {
            Integer numVogais = 0;
            
            // Operações para tratativa do nome do paciente, removendo letras maiúsculas e retirando 
            // os acentos
            String nome = paciente.getNome().toLowerCase();
            nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
            nome = nome.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            
            // Laço de repetição para percorrer cada letra do nome do paciente
            for (Character letra : paciente.getNome().toLowerCase().toCharArray()) {
                // Verificação se a letra corresponde a uma vogal
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    numVogais += 1;
                }
            }
            
            // Verificação se o número de vogais do nome atual da repetição supera o número 
            // anteriormente armazenado
            if (numVogais >= numVogaisMax) {
                numVogaisMax = numVogais;
                pacienteEncontrado = paciente;
            }    
        }
        
        return pacienteEncontrado;
    }
}
