
/* 
 --------------------------------------------------------
  Assignment 1
  Written by: Lucas Catchlove id: 27145640
  For COMP 248 Section EE – Fall 2016

  ~Entertainment Bundle Selector v1.0~
   
   This helps the user choose an appropriate entertainment
   package based on their pay-per-view usage. The program
   also displays savings that the user would gain from
   selecting certain packages over others. 
  
 --------------------------------------------------------
 */






/* Import statements allow the programmer to make
 use of classes that arent included the standard packages (i.e. java.lang). */

import java.util.Scanner; 


public class BundleSelect { // Begins the class definition block for the "BundleSelect" application.

	public static void main(String[] args) { // // Begins the definition of the main method.


		System.out.println("---------------------------------------------\n" 		// Welcome message.
							+ "      Entertainment Bundle Selector v1.0\n" 
							+ "---------------------------------------------");


		Scanner kbinput = new Scanner(System.in); // Receives input from user.

		// Initializing and declaring general variables.

		int ShowCount, MovieCount; 
		int WeeksInMonth = 4;

		// Initializing and declaring variables pertaining to pay-per-view costs.

		double PpvShowCost = 0.99;
		double PpvMovieCost = 3.99; 
		double PpvTotalCost; 

		// Initializing (and declaring variables pertaining to the limited option.

		int LimMaxShow = 5; 
		int LimMaxMovie = 2; 
		double LimBaseCost = 15.95;
		double LimShowCost = 1.99; 
		double LimMovieCost = 3.99; 
		double LimTotalCost;

		// These variables store information about the extra costs associated to the limited option.

		double LimShowCount = 0; 
		double LimMovieCount = 0;


		double UnlimTotalCost = 25.95; // cost of the unilmited option.

		
		// Asks the user how many shows and movies he watches in a week. 

		System.out.print("Enter how many shows do you watch in a week: \n");
		ShowCount = kbinput.nextInt();
		System.out.print("Enter how many movies you watch in a month: \n");
		MovieCount = kbinput.nextInt();

		// The following section calculates the total cost of pay-per-view. 

		PpvShowCost = ShowCount * WeeksInMonth * PpvShowCost; 
		PpvMovieCost = MovieCount * PpvMovieCost; 
		PpvTotalCost = PpvShowCost + PpvMovieCost;

		/* The following two "if" statements calculate how many extra shows and movies the user has watched.
			(for use when calculating the total cost of the limited package with additional purchases.) */

		if (ShowCount > LimMaxShow) 
				LimShowCount = ShowCount - LimMaxShow; 
			
			
		if (MovieCount > LimMaxMovie) 
				LimMovieCount = MovieCount - LimMaxMovie;

		/* The assignment below calculates the total cost of the limited package. The reason for this and the preceding "if" statements being done
		   preemtively is to ensure the that the "if" statements (those which help in selecting the best package) have the 
		   necessary information to function correctly. */

		LimTotalCost = LimBaseCost + (LimMovieCount * LimMovieCost) + (LimShowCount * LimShowCost * WeeksInMonth); 


		System.out.println("\nYou watch " + PpvTotalCost + "$ worth of pay-per-view per month.\n"); // prints the total amount spent on pay-per-view.

		/* The following "if" statement suggests the user the pay-per-view option because his usage is not 
		   great enough to warrant subscribing to the other more expensive packages. */

		if (PpvTotalCost < LimBaseCost) 
			System.out.println("Based on your viewing habits, we recommend the pay-per-view option.\n");
 
		/* The following "if" statement suggests the user the limited option because
		    his usage falls between the cost of the limited and unlimited packages.
		    It also displays the amount that the user would save if he subscribed to the suggested package. */

		if (PpvTotalCost >= LimBaseCost && LimTotalCost < UnlimTotalCost) {

			System.out.println("The cost of limited package including overages is " + LimTotalCost + "$/month\n");
			System.out.println("Based on your viewing habits, we recommend the limited option\n");
			System.out.println("This option saves you " + (PpvTotalCost - LimTotalCost) + "$/month" 
														+ " from pay-per-view.\n");								
			}


		/* The following "if" statement suggests the user the unlimited option because
		   it is the cheapest option with respect to the users usage. It also displays 
		   the amount that the user would save if he subscribed to the suggested package.  */


		if (LimTotalCost > UnlimTotalCost) {
			System.out.println("Based on your viewing habits, we recommend the unlimited option.\n");
			System.out.println("This option saves you " + (PpvTotalCost - UnlimTotalCost) + "$/month"
														 + " from pay-per-view, and "
														 + (LimTotalCost - UnlimTotalCost) + "$/month"
														 + " from the limited package" 
														 + " which costs " + LimTotalCost + "$/month\n"); 
			}


		System.out.println("Thanks for using Entertainment Bundle Selector v1.0!"); // Prints farewell message





	}





}