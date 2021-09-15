import java.util.Scanner;

/**
 This program shows a simple quiz with one question.
 */
public class App
{
    public static void main(String[] args)
    {
        Question first = new Question();
        first.setText("Quem é o inventor do Java?");
        first.setAnswer("James Gosling");

        ChoiceQuestion second = new ChoiceQuestion();
        second.setText("Em que país o inventor do Java nasceu?");
        second.addChoice("Austrália", false);
        second.addChoice("Canadá", true);
        second.addChoice("Dinamarca", false);
        second.addChoice("Estados Unidos da América", false);

        TrueFalseQuestion third = new TrueFalseQuestion();
        third.setText("A terra é plana?");
        third.setAnswer("verdadeiro");

        // presentQuestion(first);
        // presentQuestion(second);

        Prova prova = new Prova();
        prova.addQuestao(first);
        prova.addQuestao(second);
        prova.addQuestao(third);
        prova.exibirProva();

        AplicacaoDeProva aplicacaoDeProva1 = new AplicacaoDeProva();
        aplicacaoDeProva1.definirProva(prova);
        aplicacaoDeProva1.cadastrarResposta("James Gosling", 1);
        aplicacaoDeProva1.cadastrarResposta("2", 2);
        aplicacaoDeProva1.cadastrarResposta("verdadeiro", 3);
        aplicacaoDeProva1.imprimirRelatorio();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        AplicacaoDeProva aplicacaoDeProva2 = new AplicacaoDeProva();
        aplicacaoDeProva2.definirProva(prova);
        aplicacaoDeProva2.cadastrarResposta("James", 1);
        aplicacaoDeProva2.cadastrarResposta("3", 2);
        aplicacaoDeProva2.cadastrarResposta("verdadeiro", 3);
        aplicacaoDeProva2.imprimirRelatorio();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        AplicacaoDeProva aplicacaoDeProva3 = new AplicacaoDeProva();
        aplicacaoDeProva3.definirProva(prova);
        aplicacaoDeProva3.cadastrarResposta("James", 1);
        aplicacaoDeProva3.cadastrarResposta("3", 2);
        aplicacaoDeProva3.cadastrarResposta("falso", 3);
        aplicacaoDeProva3.imprimirRelatorio();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        AplicacaoDeProva aplicacaoEspecialDeProva1 = new AplicacaoEspecialDeProva();
        aplicacaoEspecialDeProva1.definirProva(prova);
        aplicacaoEspecialDeProva1.cadastrarResposta("James Gosling", 1);
        aplicacaoEspecialDeProva1.cadastrarResposta("2", 2);
        aplicacaoEspecialDeProva1.cadastrarResposta("verdadeiro", 3);
        aplicacaoEspecialDeProva1.imprimirRelatorio();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        AplicacaoDeProva aplicacaoEspecialDeProva2 = new AplicacaoEspecialDeProva();
        aplicacaoEspecialDeProva2.definirProva(prova);
        aplicacaoEspecialDeProva2.cadastrarResposta("James", 1);
        aplicacaoEspecialDeProva2.cadastrarResposta("3", 2);
        aplicacaoEspecialDeProva2.cadastrarResposta("verdadeiro", 3);
        aplicacaoEspecialDeProva2.imprimirRelatorio();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        AplicacaoDeProva aplicacaoEspecialDeProva3 = new AplicacaoEspecialDeProva();
        aplicacaoEspecialDeProva3.definirProva(prova);
        aplicacaoEspecialDeProva3.cadastrarResposta("James", 1);
        aplicacaoEspecialDeProva3.cadastrarResposta("3", 2);
        aplicacaoEspecialDeProva3.cadastrarResposta("falso", 3);
        aplicacaoEspecialDeProva3.imprimirRelatorio();
    }

    /**
     Presents a question to the user and checks the response.
     @param q the question
     */
    public static void presentQuestion(Question q)
    {
        q.display();
        System.out.print("Your answer: ");
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        System.out.println(q.checkAnswer(response));
    }
}