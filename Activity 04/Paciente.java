/**
 * A classe Paciente é a estrutura para descrever as características do Paciente, contendo os dados
 * necessários para o cadastro.
 */
public class Paciente implements RepositorioConstantes  {
    private String nome;
    private String cpf;
    private String telefone;
    private String convenio; // "SUS" | "Particular"
    private String diagnostico = "COVID-19";
    private String dataEntrada;
    private String dataSaida;
    private Boolean status; // Ainda internado - true | Deixou o hospital - false 
    private Integer local; // Emergência - 1 | UTI - 2 | Ambos - 3
    private Integer tempoInternacao;
    
    public Paciente(String nome, String cpf, String convenio, String dataEntrada, String dataSaida, 
        Boolean status, Integer local) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = "519" + cpf.replace(".", "").substring(0,8);
        this.convenio = convenio;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.status = status;
        this.local = local;
        this.tempoInternacao = this.calcularTempoInternacao();
    }
    
    public String toString() {
        String localAux;
        
        switch (local) {
            case 1: 
                localAux = "Emergência";
                break;
            case 2: 
                localAux = "UTI";
                break;
            default: 
                localAux = "Emergência + UTI";
                break;
        }
        
        return "Nome: " + this.nome + "\n" +
            "CPF: " + this.cpf + "\n" +
            "Telefone: " + this.telefone + "\n" +
            "Convênio: " + this.convenio + "\n" +
            "Diagnóstico: " + this.diagnostico + "\n" +
            "Data de entrada na internação: " + this.dataEntrada + "\n" +
            "Data de saída da internação: " + (!this.dataSaida.equals("") ? this.dataSaida 
            : "Ainda internado") + "\n" +
            "Status: " + (this.status ? "Ainda internado" : "Já deixou o hospital") + "\n" +
            "Local: " + localAux + "\n";
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
    
    public String getDataEntrada() {
        return this.dataEntrada;
    }
    
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    public String getDataSaida() {
        return this.dataSaida;
    }
    
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public Integer getLocal() {
        return this.local;
    }
    
    public void setLocal(Integer local) {
        this.local = local;
    }
    
    public Integer getTempoInternacao() {
        return this.tempoInternacao;
    }
    
    public void setTempoInternacao(Integer tempoInternacao) {
        this.tempoInternacao = tempoInternacao;
    }
    
    /**
     * Método para calcular tempo de internação do paciente. 
     *  
     * @param paciente Paciente - Instância de paciente
     * 
     * @return Integer - Quantidade de dias de internação
     */
    public Integer calcularTempoInternacao() {
        String[] dataEntrada = this.dataEntrada.split("/");
        
        Integer diaEntrada = Integer.parseInt(dataEntrada[0]);
        Integer mesEntrada = Integer.parseInt(dataEntrada[1]);
        Integer anoEntrada = Integer.parseInt(dataEntrada[2]);
        
        String[] dataSaida;
        
        Integer diaSaida;
        Integer mesSaida;
        Integer anoSaida;
            
        Integer difDias = 0, difMeses = 0, difAnos = 0;
        
        if (!this.dataSaida.equals("")) {
            dataSaida = this.dataSaida.split("/");
            
            diaSaida = Integer.parseInt(dataSaida[0]);
            mesSaida = Integer.parseInt(dataSaida[1]);
            anoSaida = Integer.parseInt(dataSaida[2]);
        } else {
            DataAtual dataAtual = new DataAtual();
            
            diaSaida = dataAtual.getDia();
            mesSaida = dataAtual.getMes();
            anoSaida = dataAtual.getAno();
        }
            
        if (anoEntrada != anoSaida) {
            difAnos = anoSaida - anoEntrada;
        }
        
        if (mesEntrada != mesSaida) {
            if (anoEntrada != anoSaida && mesEntrada > mesSaida) {
                difMeses = mesSaida + this.qtdMesesAno - mesEntrada;
            } else {
                difMeses = mesSaida - mesEntrada;
            }
        }
        
        if (diaEntrada != diaSaida) {
            if (mesEntrada != mesSaida && diaEntrada > diaSaida) {
                difDias = diaSaida + this.qtdDiasMes - diaEntrada;
            } else {
                difDias = diaSaida - diaEntrada;
            }
        }

        return difAnos * this.qtdDiasAno + difMeses * this.qtdDiasMes + difDias;
    }
}
