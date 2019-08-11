// Francis Rukab - n00961805 COP3503 Assignment A3
import java.util.Scanner;

public class n00961805 {

       /** Main method */
   	public static void main(String[] args) {
         // Prompt the user to enter two 3 x 3 arrays of integers
         System.out.print("Enter list1: ");
         int[][] list1 = Strict.getArray();
         System.out.print("Enter list2: ");
         int[][] list2 = Strict.getArray();
        	// Display whether the two arrays are equal.
      	System.out.println("The two arrays are" + (Strict.equals(list1, list2) ? " " : " not ") + "equal.");
         // Display how many cells in the two arrays are equal.
      	System.out.println("The two arrays have " + (Strict.howmany(list1, list2)) + " identical cells.");
         // Display how many cells in the diagonal are identical.
         System.out.println("The two arrays have " + (Strict.diagonal(list1, list2)) + " identical in the diagonal.");
         // Display the average of the two arrays.
      	System.out.println("The two arrays an average of " + (Strict.average(list1, list2)));
         // Display how many cells in the two arrays are equal.
         Strict.display(list1, list2); 
         // Display whether the values are <=10.
      	System.out.println("The two arrays are" + (Strict.silly(list1, list2) ? " " : " not ") + "below or equal to 10.");
   
         }
}
class Strict{         
    
   /** getArray initializes and returns a 3 X 3 array */
   public static int[][] getArray() {
		Scanner input = new Scanner(System.in);
		int[][] m = new int[3][3];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextInt();
			}
		}
		return m;
	}

	/** equals returns true if m1 and m2 are strictly identical */
	public static boolean equals(int[][] m1, int[][] m2) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (m1[i][j] != m2[i][j])
					return false;
			}
		}
		return true;
	}
   
   /** howmany returns true the number of identical cells */
   public static int howmany(int[][] m1, int[][] m2){
      int count = 0;
      for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (m1[i][j] == m2[i][j])
					count++;
			}
		}
		return count;

   }

   /** diagonal returns the number of identical cells in the diangonal */
   public static int diagonal(int[][] m1, int[][] m2){
      int count = 0;
      int j = 0;
      for (int i = 0; i < 3; i++) {
				if (m1[i][j] == m2[i][j])
					count++;
            j++;
		}
		return count;
 
   }
   
   /** average returns the average of the two arrays */
   public static double average(int[][] m1,int[][] m2){
      double total = 0;
      double average = 0;
      double cellSum = 0;
      for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cellSum = m1[i][j] + m2[i][j];
            total = total + cellSum; 
			}
		}
      average = total / 18;
      return average;
	}
   
   /** display returns the odd cells in the diangonal */
   public static void display(int[][] m1,int[][] m2){
      System.out.println("List 1   List 2");
      for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
            if (i==j){
				   if((m1[i][j])% 2 == 1){
                  System.out.print(m1[i][j]);
                  System.out.print("  ");
               }
            }
            else{
               System.out.print("\t");
            }
         } 
			for (int j = 0; j < 3; j++) {
            if (i==j){
				   if((m2[i][j])% 2 == 1){
                  System.out.print(m2[i][j]);
                  System.out.print("  ");
               }
            }
            else{
               System.out.print("\t");
            }   
			}
         System.out.println();
      }
   
   }
   
   /** silly returns true if the two arrays have all numbers satisfying
      1 < numbers <=10  and returns  false  otherwise. */
   public static boolean silly(int[][] m1, int[][] m2){
      int count1 = 0;
      int count2 = 0;
      boolean success = true;
      for (int i = 0; i < 3; i++) {
		   for (int j = 0; j < 3; j++) {
				if (m1[i][j] <=10)
            count1++;
			}
		   for (int j = 0; j < 3; j++) {
				if (m2[i][j] <=10)
            count2++;
			}
         int total = count1 + count2;
         if (total == 18)
            success = true;
         else
            success = false; 
		}
		return success;
   }
}