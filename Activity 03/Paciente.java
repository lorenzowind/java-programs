/**
 * A classe Paciente é a estrutura para descrever as características do Paciente, contendo os dados
 * necessários para o cadastro.
 */
public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String convenio;
    private String diagnostico;
    private Integer numConsultaMes;
    
    public Paciente(String nome, String cpf, String telefone, String convenio, String diagnostico, 
        Integer numConsultaMes) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.convenio = convenio;
        this.diagnostico = diagnostico;
        this.numConsultaMes = numConsultaMes;
    }
    
    public Paciente(String nome, String cpf, String convenio, String diagnostico, 
        Integer numConsultaMes) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = cpf.substring(0,7);
        this.convenio = convenio;
        this.diagnostico = diagnostico;
        this.numConsultaMes = numConsultaMes;
    }
    
    public String toString() {
        return "Nome: " + this.nome + "\n" +
            "CPF: " + this.cpf + "\n" +
            "Telefone: " + this.telefone + "\n" +
            "Convênio: " + this.convenio + "\n" +
            "Diagnóstico: " + this.diagnostico + "\n" +
            "Consultas no mês: " + this.numConsultaMes;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCPF() {
        return this.cpf;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getConvenio() {
        return this.convenio;
    }
    
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    
    public String getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    public Integer getNumConsultaMes() {
        return this.numConsultaMes;
    }
    
    public void setNumConsultaMes(Integer numConsultaMes) {
        this.numConsultaMes = numConsultaMes;
    }
}
