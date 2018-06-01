import java.util.Scanner;
import java.util.Random;

public class MathTrainer {
	public static void main(String[] args) {

		System.out.println("Hello and welcome to the Math Trainer!");
		System.out.println("======================================");
		// Implement Program1 - Math Trainer
		System.out.println("Which math operation would you like to practice?");
		System.out.println("[A]ddition");
		System.out.println("[S]ubtraction");
		System.out.println("[M]ultiplication");
		System.out.println("[D]ivision");
		System.out.println("[R]emainder");
		System.out.print("Enter your choice:");
		// Ask the user which math operation to use
		
		String name; 
		// create a new String
		Scanner STEINSGATE = new Scanner(System.in);
		/* create a new Scanner with "STEINSGATE" as the scanner name 
		 * p.s. "STEINSGATE" doesn't really meant anything
		 */
		name = STEINSGATE.next();
		/* Assign scanner to main String so that all input are scanned 
		 * into the main String*/
		STEINSGATE.nextLine();
		/* To scan for the next input when STEINSGATE.nextLine(); 
		 * is declared in any part of the program*/
		Random randGen = new Random(Config.RANDOM_SEED);
		// Create a random number generator

		int counter = 0;
		// To count the number of questions that the user answered correctly
		int userSolution = 0;
		// To count how many input of solutions that the user answered
		int numColumn;
		// To declare number of columns for constructing the table later
		int numRow;
		// To declare number of rows for constructing the table later
		double correctAnswer = 0.0;
		// To set a variable for every correct answer of every question
		double correctTableAnswer = 0.00;
		// To set a variable for every solution in the table
		double approximation = Config.CLOSE_ENOUGH;
		/* To declare a variable to set the range of correct solutions the user
		can input*/

		for (int j = 0; j < Config.NUMBER_OF_QUESTIONS; j++) {
			//To loop the number of question to ask 
			boolean validInput = true;
			/* To set a space for method used when user enter the correct input
			for choosing the operator*/
			int correctChance = randGen.nextInt(Config.MAX_VALUE); 
					//- Config.MIN_VALUE + 1);
			// 1. pick a random number from the correct number of values
			int correctRange = correctChance + Config.MIN_VALUE;
			// 2. shift whatever number is picked into the correct range
			int correctChance2 = randGen.nextInt(Config.MAX_VALUE - 
					Config.MIN_VALUE + 1);
			int correctRange2 = correctChance2 + Config.MIN_VALUE;
			if ("D".equalsIgnoreCase(name)) {
				System.out.print(
						"What is the solution to the problem:" + " "
				+ correctRange + " / " + correctRange2 + " = ");
				correctAnswer = (double) correctRange / correctRange2;
			} else if ("A".equalsIgnoreCase(name)) {
				System.out.print(
						"What is the solution to the problem:" + " "
				+ correctRange + " + " + correctRange2 + " = ");
				correctAnswer = (double) correctRange + correctRange2;
			} else if ("S".equalsIgnoreCase(name)) {
				System.out.print(
						"What is the solution to the problem: " + ""
				+ correctRange + " - " + correctRange2 + " = ");
				correctAnswer = (double) correctRange - correctRange2;
			} else if ("M".equalsIgnoreCase(name)) {
				System.out.print(
						"What is the solution to the problem: " + ""
				+ correctRange + " x " + correctRange2 + " = ");
				correctAnswer = (double) correctRange * correctRange2;
			} else if ("R".equalsIgnoreCase(name)) {
				System.out.print(
						"What is the solution to the problem: " + ""
								+ "" + correctRange + " % " + correctRange2 + " = ");
				correctAnswer = (double) correctRange % correctRange2;
			} else {
				validInput = false;
				System.out.println("I'm sorry, I only understand choices of: "
						+ "" + "A, S, M, D, or R!");
				break;
			}
			/* scan whether the user input a valid value when choosing
			an operation*/
			// prompt the user to solve the following division problem
			if (validInput == true) {
			// If user input for the solution is true 
				if (STEINSGATE.hasNextDouble()) {
					double solution = STEINSGATE.nextDouble();
					STEINSGATE.nextLine();
					if (solution > correctAnswer - approximation && solution 
							< correctAnswer + approximation) {
					//an algorithm to set a range of correct solution
						System.out.println("That is correct!");
						counter++;
					} else {
					// If user input for the solution is false
						System.out.println("The correct solution is " + ""
								+ "" + correctAnswer + ".");
					/*System will show the correct solution and show a 
						range of solution in a table below*/ 
						System.out.printf("%7s"," ");
						System.out.print("|");
						for (numColumn = correctRange2 - 2; numColumn 
								<= correctRange2 + 2; numColumn++) {
						/*1)limit the number of Column to a value between +/- 2 
							when setting condition for loops*/
							if (numColumn >= Config.MIN_VALUE && numColumn 
									<= Config.MAX_VALUE) {
						//2)limit the literal number of column header from 1-9
								System.out.printf("%7.2f", (double) numColumn);
						//3)System will loop and print the number header
							}
						}
						System.out.println("");
						System.out.print("---------");
						for (numColumn = correctRange2 - 2; numColumn 
								<= correctRange2 + 2; numColumn++) {
							if (numColumn >= Config.MIN_VALUE && numColumn 
									<= Config.MAX_VALUE) {
								System.out.print("-------");
						//Same process but to project"-" instead
							}
						}
						System.out.println("");
						for (numRow = correctRange - 2; numRow 
								<= correctRange + 2; numRow++) {
							if (numRow >= Config.MIN_VALUE && numRow 
									<= Config.MAX_VALUE) {
								System.out.printf("%6.2f", (double) numRow);
								System.out.print(" ");
								System.out.print("|");
						//same process when projecting the first line of row
							}
							for (numColumn = correctRange2 - 2; numColumn 
									<= correctRange2 + 2; numColumn++) {
						/*loop the row over again with algorithm automatically 
								calculating solutions of different numbers*/
								if (numRow >= Config.MIN_VALUE 
										&& numRow <= Config.MAX_VALUE
										&& numColumn >= Config.MIN_VALUE && 
										numColumn <= Config.MAX_VALUE) {
									if ("D".equalsIgnoreCase(name)) {
										correctTableAnswer = 
												(double) numRow / numColumn;
									} else if ("A".equalsIgnoreCase(name)) {
										correctTableAnswer = 
												(double) numRow + numColumn;
									} else if ("S".equalsIgnoreCase(name)) {
										correctTableAnswer = 
												(double) numRow - numColumn;
									} else if ("M".equalsIgnoreCase(name)) {
										correctTableAnswer = 
												(double) numRow * numColumn;
									} else if ("R".equalsIgnoreCase(name)) {
										correctTableAnswer = 
												(double) numRow % numColumn;
									}
									System.out.printf("%7.2f", 
											(double) correctTableAnswer);
						/*declare different methods for different operators and 
							subject to a single variable answer*/		
								}
							}
							if (numRow >= Config.MIN_VALUE && numRow 
									<= Config.MAX_VALUE) {
								System.out.println("");
							}
						}
					}
				} else {
					System.out.println("All solutions must be entered as decimal "
							+ "" + "numbers.");
					System.out.println("The correct solution is "
							+ "" + correctAnswer + ".");
					/*repeat the same process below when user input something 
					invalid when answering the questions*/
					System.out.printf("%7s", " ");
					System.out.print("|");
					for (numColumn = correctRange2 - 2; numColumn 
							<= correctRange2 + 2; numColumn++) {
						if (numColumn >= Config.MIN_VALUE && numColumn 
								<= Config.MAX_VALUE) {
							System.out.printf("%7.2f", (double) numColumn);
						}
					}
					System.out.println("");
					System.out.print("---------");
					for (numColumn = correctRange2 - 2; numColumn 
							<= correctRange2 + 2; numColumn++) {
						if (numColumn >= Config.MIN_VALUE && numColumn 
								<= Config.MAX_VALUE) {
							System.out.print("-------");
						}
					}
					System.out.println("");
					for (numRow = correctRange - 2; numRow 
							<= correctRange + 2; numRow++) {
						if (numRow >= Config.MIN_VALUE && numRow 
								<= Config.MAX_VALUE) {
							System.out.printf("%6.2f", (double) numRow);
							System.out.print(" ");
							System.out.print("|");
						}
						for (numColumn = correctRange2 - 2; numColumn 
								<= correctRange2 + 2; numColumn++) {
							if (numRow >= Config.MIN_VALUE && numRow 
									<= Config.MAX_VALUE
									&& numColumn >= Config.MIN_VALUE && 
									numColumn <= Config.MAX_VALUE) {
								if ("D".equalsIgnoreCase(name)) {
									correctTableAnswer = 
											(double) numRow / numColumn;
								} else if ("A".equalsIgnoreCase(name)) {
									correctTableAnswer = 
											(double) numRow + numColumn;
								} else if ("S".equalsIgnoreCase(name)) {
									correctTableAnswer = 
											(double) numRow - numColumn;
								} else if ("M".equalsIgnoreCase(name)) {
									correctTableAnswer = 
											(double) numRow * numColumn;
								} else if ("R".equalsIgnoreCase(name)) {
									correctTableAnswer = 
											(double) numRow % numColumn;
								}
								System.out.printf("%7.2f", 
										(double) correctTableAnswer);
							}
						}
						if (numRow >= Config.MIN_VALUE && numRow 
								<= Config.MAX_VALUE) {
							System.out.println("");
						}
					}
					STEINSGATE.nextLine();
				}
			}
			userSolution++;
		}
		if (userSolution == Config.NUMBER_OF_QUESTIONS) {
		/*if the questions have repeated the same time as the Number of 
			Questions wanted, proceed to final phase of program*/
			System.out.println(
					"*** You answered " + counter + " out of " 
			+ Config.NUMBER_OF_QUESTIONS + " questions correctly.");
		}
		System.out.println("=====================================");
		System.out.println("Thank you for using the Math Trainer!");
		// finish Math Trainer
	}
}



