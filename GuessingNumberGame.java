import java.util.*;

public class LabExer5A {

    public static void main(String[] args) {
       Random r = new Random();
       int num = r.nextInt(50);
       int counter = 0;
       String flag = "True";
       Scanner sc = new Scanner(System.in);                  
           System.out.println("Guess a number from 1 - 50!");
           if (num == 0){
               num = num+1;
           }
     //      System.out.println("Hint: " + num);
       
       while(flag.equals("True")){
       try{          
           int guess = sc.nextInt();
           if (guess > 50){
               counter++;
               throw new ExceedException();
           }else if(guess > num){
               counter++;
               throw new TooHighException();               
           }else if (guess < num){
               counter++;
                throw new TooLowException();
           }else if (guess == num){
               counter++;
               flag = "False";
               throw new CorrectException();
           }
       }catch(InputMismatchException a){           
           System.out.println("Invalid Input!");
           break;
       }catch(TooHighException b){
           System.out.println("Too High! Try Again!");
       }catch(TooLowException c){
           System.out.println("Too Low! Try Again!");
       }catch(ExceedException d){
           System.out.println("Out of range.");
       }catch(CorrectException e){
           System.out.println("Correct");
           System.out.println("You got "+ counter +" attempt(s)");
       }
       
    }
    }   
    private static class TooHighException extends Exception {

        public TooHighException() {
        }
    }

    private static class TooLowException extends Exception {

        public TooLowException() {
        }
    }

    private static class CorrectException extends Exception {

        public CorrectException() {
        }
    }

    private static class ExceedException extends Exception {

        public ExceedException() {
        }
    }
    
}
