import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

import org.json.JSONObject;
import com.google.gson.Gson;

public class QuizAPI {
  private String category;
  private String difficulty;
  private int limit;
  private String apiKey;

  public QuizAPI(String category, String difficulty, int limit, String apiKey)
  {
    this.category = category;
    this.difficulty = difficulty;
    this.limit = limit;
    this.apiKey = apiKey;
  }

  public ArrayList<Question> getQuestions()
  {
    try {
      URL url = new URL(
        "https://quizapi.io/api/v1/questions?" + 
        "apiKey=" + this.apiKey + 
        "&category=" + this.category + 
        "&difficulty=" + this.difficulty + 
        "&limit=" + this.limit
      );
      
      HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      
      if (con.getResponseCode() == HttpsURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(new InputStreamReader(
          con.getInputStream()
        ));
        
        String inputLine;
        
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }

        Gson gson = new Gson();
        
        ArrayList<?> objects = 
          gson.fromJson(response.toString(), ArrayList.class);

        ArrayList<Question> questions = new ArrayList<>();

        Random random = new Random();

        for (Object object : objects) {
          // 0 - true/false
          // 1 - multiple choices
          // 2 - text
          int type = random.nextInt(3);

          JSONObject jsonObject = new JSONObject(gson.toJson(object));

          JSONObject answers = jsonObject.getJSONObject("answers");

          try {
            if (
              answers.getString("answer_a") == null ||
              answers.getString("answer_b") == null ||
              answers.getString("answer_c") == null ||
              answers.getString("answer_d") == null ||
              jsonObject.getString("multiple_correct_answers").equals("true")
            ) {
              continue;
            }
            
          } catch (Exception e) {
            continue;
          } 

          String[] answersArray = {
            answers.getString("answer_a"),
            answers.getString("answer_b"),
            answers.getString("answer_c"),
            answers.getString("answer_d"),
          };
              
          JSONObject correctAnswers = jsonObject.getJSONObject("correct_answers");

          int choice;

          switch (type) {
            case 0:
              TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion();
              choice = random.nextInt(4);

              if (correctAnswers.getString("answer_a_correct").equals("true")) {
                trueFalseQuestion.setAnswer(choice == 0 ? "true" : "false");
              } else if (correctAnswers.getString("answer_b_correct").equals("true")) {
                trueFalseQuestion.setAnswer(choice == 1 ? "true" : "false");
              } else if (correctAnswers.getString("answer_c_correct").equals("true")) {
                trueFalseQuestion.setAnswer(choice == 2 ? "true" : "false");
              } else if (correctAnswers.getString("answer_d_correct").equals("true")) {
                trueFalseQuestion.setAnswer(choice == 3 ? "true" : "false");
              }
              
              trueFalseQuestion.setText(
                jsonObject.getString("question") + 
                "\nPremise: " + answersArray[choice]
              );
              questions.add(trueFalseQuestion);

              break;
            case 1:
              ChoiceQuestion choiceQuestion = new ChoiceQuestion();

              choiceQuestion.addChoice(
                answersArray[0], 
                correctAnswers.getString("answer_a_correct").equals("true")
              );
              
              choiceQuestion.addChoice(
                answersArray[1], 
                correctAnswers.getString("answer_b_correct").equals("true")
              );
              
              choiceQuestion.addChoice(
                answersArray[2], 
                correctAnswers.getString("answer_c_correct").equals("true")
              );
              
              choiceQuestion.addChoice(
                answersArray[3], 
                correctAnswers.getString("answer_d_correct").equals("true")
              );
              
              choiceQuestion.setText(jsonObject.getString("question"));
              questions.add(choiceQuestion);

              break;
            case 2:
              Question question = new Question();

              if (correctAnswers.getString("answer_a_correct").equals("true")) {
                question.setAnswer(answersArray[0]);
              } else if (correctAnswers.getString("answer_b_correct").equals("true")) {
                question.setAnswer(answersArray[1]);
              } else if (correctAnswers.getString("answer_c_correct").equals("true")) {
                question.setAnswer(answersArray[2]);
              } else if (correctAnswers.getString("answer_d_correct").equals("true")) {
                question.setAnswer(answersArray[3]);
              }
              
              question.setText(jsonObject.getString("question"));
              questions.add(question);

              break;
            default:
              break;
          }
        }

        return questions;
      } else {
        System.out.println("\nRequest not worked");
      }
    } catch (SSLHandshakeException err) {
      System.out.println("\nSSL error occurred, stop the program and execute it again"); 
    } catch (Exception err) {
      System.out.println("\nAn error occurred"); 
    } 

    return null;
  }
}
