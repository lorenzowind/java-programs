public class AplicacaoEspecialDeProva extends AplicacaoDeProva {
  @Override
  public double calcularNota()
  {
    double nota = 0;

    for (Resposta resposta : this.getRespostas()) 
    {
      Question questao = this.getProva().recuperarQuestao(resposta.getNumeroQuestao());

      if (questao.checkAnswer(resposta.getResposta())) {
        if (questao instanceof ChoiceQuestion) {
          nota += 1.5;
        } else if (questao instanceof TrueFalseQuestion) {
          nota += 1;
        } else {
          nota += 2;
        }
      } else {
        nota -= 1;
      }
    }

    return nota < 0 ? 0 : nota;
  }
}
