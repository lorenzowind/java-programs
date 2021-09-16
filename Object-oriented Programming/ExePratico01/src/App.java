import java.util.Scanner;

/**
 This program shows a simple quiz with one question.
 */
public class App
{
  public static void main(String[] args)
  {
    QuizAPI quizAPI = new QuizAPI(
      "code", "Easy", 10, "FHSsFO5PUdqkPAKyvONvyheakA6ctbtr2ojdvYox"
    );
    
    Prova exam = new Prova();

    for (Question question : quizAPI.getQuestions()) {
      exam.addQuestao(question);
    }

    String option = "0";

    Scanner scanner = new Scanner(System.in);

    AplicacaoDeProva examApplication = new AplicacaoDeProva();

    do {
      System.out.println("\n- - - - - - - - - - MENU - - - - - - - - - -");
      
      System.out.println("\n1 - Show exam");
      System.out.println("2 - Generate new questions");
      System.out.println("3 - Apply exam");
      System.out.println("4 - Apply special exam");
      System.out.println("5 - Show report of last exam");
      System.out.println("6 - Leave");
      
      System.out.print("\nChoose an option: ");

      option = scanner.nextLine();

      switch (option) {
        case "1": {
          exam.exibirProva();
          
          break;         
        }
        case "2": {
          Prova exam_ = new Prova();
          
          try {
            for (Question question : quizAPI.getQuestions()) {
              exam_.addQuestao(question);
            }
          } catch (Exception err) {
            break;         
          }
          
          exam = exam_;

          break;         
        }
        case "3":
        case "4": {
          examApplication = 
            option.equals("3")
              ? new AplicacaoDeProva()
              : new AplicacaoEspecialDeProva();

          examApplication.definirProva(exam);

          for (int i = 0; i < exam.getQuestoes().size(); i++) {
            System.out.print("\n");

            examApplication.cadastrarResposta(
              presentQuestion(exam.recuperarQuestao(i + 1)), 
              i + 1
            );
            
            System.out.print("\nPress enter to continue...");
            scanner.nextLine();
          }

          System.out.println("\nExam was finished successfully");

          break;         
        }
        case "5": {
          if (examApplication.getProva() != null) {
            examApplication.imprimirRelatorio();
          } else {
            System.out.println("\nNo exam was done yet");
          }

          break;         
        }
        case "6": {
          break;         
        }
        default: {
          System.out.println("\nChoose a valid option");

          break;         
        }
      }
      
      if (!option.equals("6")) {
        System.out.print("\nPress enter to go back...");
        scanner.nextLine();
      }
    } while (!option.equals("6"));

    scanner.close();
  }

  /**
   Presents a question to the user and checks the response.
    @param q the question
    */
  public static String presentQuestion(Question q)
  {
    q.display();
    System.out.print("Your answer: ");
    Scanner in = new Scanner(System.in);
    return in.nextLine();
  }
}
