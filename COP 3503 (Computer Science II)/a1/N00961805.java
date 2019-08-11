//Program made by Francis Rukab 8-26-2017
// Course - COP3503 TR 12-15
import java.util.Scanner; //Importing the Scanner from java.util
import java.text.DecimalFormat;

public class n00961805 {
   public static void main(String[] args){
      // Create Scanner
      Scanner input = new Scanner(System.in);
      
      //Prompt User to enter driving distance
      System.out.print("Enter the driving distance: ");
      double dd = input.nextDouble();
      
      //Prompt User to enter miles per gallon
      System.out.print("Enter miles per gallon: ");
      double mpg = input.nextDouble();
      
      //Prompt User to enter price per gallon
      System.out.print("Enter price per gallon: ");
      double ppg = input.nextDouble();
      
      // Calculate the answer
      double answer = dd / mpg * ppg;
      
      // Use the DecimalFormat method to print out corrected format
      DecimalFormat roundOff = new DecimalFormat("0.00");
      
      //Print out the final answer
      System.out.println("The cost of driving is: " + roundOff.format(answer));        
   }
}