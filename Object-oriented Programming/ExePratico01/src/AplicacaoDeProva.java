import java.util.ArrayList;

public class AplicacaoDeProva {
  private Prova prova;
  private ArrayList<Resposta> respostas;

  public AplicacaoDeProva()
  {
  }

  public ArrayList<Resposta> getRespostas()
  {
    return this.respostas;
  }

  public Prova getProva()
  {
    return this.prova;
  }

  public void definirProva(Prova prova)
  {
    this.prova = prova;
    this.respostas = new ArrayList<Resposta>();
  }

  public void cadastrarResposta(String resposta, int numeroQuestao)
  {
    if (prova.recuperarQuestao(numeroQuestao) == null) {
      System.out.println("Essa questão não existe");
    } else {
      respostas.add(new Resposta(resposta, numeroQuestao));
    }
  }

  public double calcularNota()
  {
    double nota = 0;

    for (Resposta resposta : this.respostas) 
    {
      Question questao = prova.recuperarQuestao(resposta.getNumeroQuestao());

      if (questao.checkAnswer(resposta.getResposta())) {
        if (questao instanceof ChoiceQuestion) {
          nota += 1.5;
        } else if (questao instanceof TrueFalseQuestion) {
          nota += 1;
        } else {
          nota += 2;
        }
      }
    }

    return nota;
  }

  public void imprimirRelatorio()
  {
    for (int i = 0; i < this.prova.getQuestoes().size(); i++)
    {
      int questaoNumber = i + 1;
      Question questao = this.prova.recuperarQuestao(questaoNumber);

      System.out.print("\nQuestão " + questaoNumber + ": ");
      questao.display();

      int cont = 0;

      while (
        questaoNumber != this.respostas.get(cont).getNumeroQuestao() && 
        cont < this.respostas.size()
      ) {
        cont++;
      }
      
      System.out.print("Resposta: ");

      if (cont == this.respostas.size()) {
        System.out.println("Questão não respondida");
      } else {
        String resposta = this.respostas.get(cont).getResposta();
        System.out.println(resposta);

        if (!questao.checkAnswer(resposta)) {
          System.out.println("Resposta certa: " + questao.getAnswer());
        }
      }
    }
    
    System.out.println("\nNota final: " + this.calcularNota() + "\n");
  }
}
