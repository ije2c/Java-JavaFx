import java.util.*;
class DriverExam_Ephrem
{
   public static int exam_questions=20;
   public static void main(String args[])
   {
       Scanner userinput=new Scanner(System.in);
      char [] userAnswer=new char[20];
       char keyAnswer[]={'B','D','A','A','C','A','B','A','C','D','B','C','D','A','D','C','C','B','D','A'};


       for(int i=0;i<exam_questions;i++)  /*for loop that gets input and prints message 20 times*/
       {
           System.out.print("Answer for No."+(i+1)+": ");
           userAnswer[i]=userinput.next().charAt(0);
       }

       System.out.println("Passed? "+Passed(userAnswer,keyAnswer)); /*prints whether user passed or failed based on return value from Passed method*/
       System.out.println("Your total correct answers: "+totalCorrect(userAnswer,keyAnswer));/*prints total correct answers based on return value from totalCorrect method*/
       System.out.println("Your total incorrect answers: "+totalIncorrect(userAnswer,keyAnswer));/*prints total incorrect answers based on return value from totalIncorrect method*/
       System.out.println("A list of your missed questions: "+Arrays.toString(questionsMissed(userAnswer,keyAnswer)));/*prints specific questions missed as an string array based on return value from questions missed method*/
   }

   public static boolean Passed(char userAnswer[],char keyAnswer[]) /*this method returns whether passed(true) or failed(false)*/
   {
       return totalCorrect(userAnswer,keyAnswer)>=17;
   }

   public static int totalCorrect(char userAnswer[],char keyAnswer[]) /*this method uses a for loop that goes through the twenty exam questions and uses an if statement to compare if useranswer is equal to the keyanswer(correct answer) and if equal then the count of total correct answers is incremented and the value is returned at the end of the loop*/
   {
       int y=0;
       for(int i=0;i<exam_questions;i++)
       {
           if(userAnswer[i]==keyAnswer[i])
           {
               y++;
           }
       }
       return y;
   }

   public static int totalIncorrect(char userAnswer[],char keyAnswer[])/*this method finds the total of incorrect answers by returning the value of 20(exam_questions) - totalCorrect*/
   {
       return 20-totalCorrect(userAnswer,keyAnswer);
   }

   public static int [] questionsMissed(char userAnswer[], char keyAnswer[])/*this method finds the specific questions missed by initializing totalCorrect questions as a variable x, and initializing a new array that has the same array element size as the return value of int variable x, and then using a for loop that goes through the twenty exam questions and compares using an if statement to see if the useranswer is not equal to the keyanswer(correct answer). If it is not equal then set the array wrongquestions[] to the value of count i+1 to specify that wrong question and then increment the subscript and when the for loop is done return the total array value of wrong questions which would contain every single incorrect answer*/
   {
       int x=totalIncorrect(userAnswer,keyAnswer);
       int [] wrongquestions=new int[x];
       int subscript=0;
       for(int i=0;i<exam_questions;i++)
       {
           if(userAnswer[i]!=keyAnswer[i])
           {
               wrongquestions[subscript]=i+1;
               subscript++;
           }
       }
       return wrongquestions;
   }
}

