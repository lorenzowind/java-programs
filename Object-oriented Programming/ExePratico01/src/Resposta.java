public class Resposta {
  private String resposta;
  private int numeroQuestao;
  
  public Resposta(String resposta, int numeroQuestao)
  {
    this.resposta = resposta;
    this.numeroQuestao = numeroQuestao;
  }

  public String getResposta()
  {
    return this.resposta;
  }

  public int getNumeroQuestao()
  {
    return this.numeroQuestao;
  }
}