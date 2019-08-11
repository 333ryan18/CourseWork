//Program made by Francis Rukab 9-15-2017
// Course - COP3503 TR 12:15
import java.util.Scanner; //Importing the Scanner from java.util
import java.text.DecimalFormat;

public class n00961805 {
   public static double sum(double denominator){
     
      double sum = 0.0; 
      for(double i = 1.0;i <= denominator;i+=2 ){
      sum += i/(i+2);
      }
		// Return Result
      return sum;
	}

   public static double pi(double denominator){
     
		// Compute from input to pi 
		double sum = 0;
		for (double i = 1; i <= (2 * denominator - 1); i += 2) {
			sum += 1 / i;
			i += 2;
			sum -= 1 / i; 
		}
		double pi = 4 * sum;

		// Return Result
		return pi;
	}

   public static void main(String[] args){  
      // Create Scanner
      Scanner input = new Scanner(System.in);
      //Prompt User to enter denominator
      System.out.print("Input a denominator: "); 
      // Store input 
      double denominator = input.nextDouble();  
      // Use the DecimalFormat method to print out corrected format
      DecimalFormat roundOff = new DecimalFormat("0.000000000000");     
      
      //Print out the final answer for both methods
      System.out.println("The sum of method 1 is: " + roundOff.format(sum(denominator)));
      System.out.println("The sum of method 2 to compute pi is: " + roundOff.format(pi(denominator)));         
   }

}
