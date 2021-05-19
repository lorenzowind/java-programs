import java.util.ArrayList; 

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

    /**
     * Método para adicionar paciente no ArrayList de pacientes. 
     *  
     * @param paciente Paciente - Instância de paciente
     */
    public void adicionarPaciente(Paciente paciente)
    {
        this.pacientes.add(paciente);
    }
}
