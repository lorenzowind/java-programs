import java.util.ArrayList;

public class Prova {
  private ArrayList<Question> questoes;

  public Prova()
  {
    this.questoes = new ArrayList<Question>();
  }

  public ArrayList<Question> getQuestoes()
  {
    return this.questoes;
  }

  public void addQuestao(Question questao)
  {
    this.questoes.add(questao);
  }

  public Question recuperarQuestao(int numero)
  {
    return this.questoes.get(numero - 1);
  }

  public void removerQuestao(int numero)
  {
    this.questoes.remove(numero - 1);
  }
  
  public void exibirProva()
  {
    for (int i = 0; i < this.questoes.size(); i++)
    {
      int questaoNumber = i + 1;

      System.out.println();
      System.out.print("Questão " + questaoNumber + ": ");
      this.questoes.get(i).display();
      System.out.println("\n- - - - - - - - - - - - - - - - - - - - - -");
    }
  }
}
