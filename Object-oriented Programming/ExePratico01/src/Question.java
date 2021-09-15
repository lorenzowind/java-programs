// This is provided for reference. You don't need to modify this file
// código original em: https://github.com/riedlblower/udacity-cs046/blob/master/PS09/

/**
 A question with a text and an answer.
 */
public class Question
{
    private String text;
    private String answer;

    /**
     Constructs a question with empty question and answer.
     */
    public Question()
    {
        text = "";
        answer = "";
    }

    /**
     Sets the question text.
     @param questionText the text of this question
     */
    public void setText(String questionText)
    {
        text = questionText;
    }

    /**
     Sets the answer for this question.
     @param correctResponse the answer
     */
    public void setAnswer(String correctResponse)
    {
        answer = correctResponse;
    }

    /**
     Gets the answer for this question.
     */
    public String getAnswer()
    {
        return this.answer;
    }

    /**
     Checks a given response for correctness.
     @param response the response to check
     @return true if the response was correct, false otherwise
     */
    public boolean checkAnswer(String response)
    {
        return response.equals(answer);
    }

    /**
     Displays this question.
     */
    public void display()
    {
        System.out.println(text);
    }
}