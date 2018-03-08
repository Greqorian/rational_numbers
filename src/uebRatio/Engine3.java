package uebRatio;

/** 
 * 
 * @author Grzegorz Pawlak
 * Email: s0563317@htw-berlin.de
 * @version Eclipse Mars Java 1.8
 * @since 26.12.2017
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine3 {

	// Reference variables used by more methods
	// ------------------------------------------------------

	int angabeZaehler;

	// Constructors
	// ------------------------------------------------------

	Scanner scanner = new Scanner(System.in);

	List<String> ratioList = new ArrayList<String>(5);

	List<String> operatorList = new ArrayList<String>(5);

	// Main method
	// ------------------------------------------------------

	/**
	 * losgehts     * ----     * Initial method for running the Engine3     *
	 * This method can be run as often as desired and is used to calculate
	 * rational numbers.     * These are stored in a memory (ArrayList) in two
	 * arrays.     * ----    
	 */

	public void losgehts() {

		do { // continuation loop

			Ratio number1 = firstNumberDeclaration();
			Ratio number2 = secondNumberDeclaration();
			angabeZaehler = number2.getZaehler(); //to save the numbertor 
			String operator = operatorDeclaration();
			this.saveRatioZahl(number1);
			this.saveRatioZahl(number2);
			Ratio number3 = this.calculate(number1, number2, operator);
			this.saveOperator(operator);
			this.saveRatioZahl(number3);

		} while (continueQuestion()); // end of the continuation loop
		this.showResults();

	}

	// Store methods
	// ------------------------------------------------------

	/**
	 * saveRatioNumber     * @param r (ratio): Rational number to save     *
	 * Stores a rational number r in the form of a string in the ratioList
	 * array.    
	 */

	public void saveRatioZahl(Ratio r) {

		String stringR = "" + r;

		ratioList.add(stringR);

	}

	/**
	 * saveOperator     * @param op (String): Operator to save.     * Stores a
	 * rational number r in the form of a string in the ratioList array.    
	 */

	public void saveOperator(String op) {

		operatorList.add(op);
	}

	/**
	 * restore     * @param index (int): position of string in array
	 * 
	 * @return restore (String): rational number     * Restore rational number
	 *         as string from the array.    
	 */

	public String restore(int index) {

		String restore = (String) ratioList.get(index);

		return restore;

	}

	/**
	 * restoreOperator     * @param index (int): position of operator in array
	 * 
	 * @return restoreOperator (String): oparator symbols     * Restore operator
	 *         ( + - / *) as string from the array.    
	 */

	public String restoreOperator(int index) {

		String restoreOperator = (String) operatorList.get(index);

		return restoreOperator;

	}

	/**
	 * string2ratio     * @param str (String): rational number in string form
	 * 
	 * @return ratioZahl (Ratio): converted rational number     * converts
	 *         string numbers to rational numbers form "number1/number2"    
	 */

	public Ratio string2ratio(String str) {
		String[] parts = str.split("/");
		String part1 = parts[0]; // z
		String part2 = parts[1]; // n

		int zaehler = Integer.parseInt(part1);
		int nenner = Integer.parseInt(part2);

		Ratio ratioZahl = new Ratio(zaehler, nenner);
		return ratioZahl;
	}

	/**
	 * showResults     * show in the right order all stored in a memory
	 * (ArrayList) numbers and operators.    
	 */

	public void showResults() {

		int arrayLaenge = ratioList.size();
		int i;
		int j = 0;

		System.out.println("---------------berechnet wurden---------------");

		for (i = 0; i < arrayLaenge; i = i + 3) {

			System.out.println("");
			System.out.print(restore(i) + " ");
			System.out.print(restoreOperator(j++) + " ");
			System.out.print(restore(i + 1));
			System.out.print(" = ");
			System.out.print(restore(i + 2));
		}

	}

	// Read user input methods
	// ------------------------------------------------------

	/**
	 * firstNumberDeclaration
	 * 
	 * @return angabe1 (Ratio): first declared rational number     * read users
	 *         declaration of the first rational number and prevent input
	 *         errors.    
	 */

	public Ratio firstNumberDeclaration() {

		boolean weiterJaNein;
		String stringRatioZahl1;
		Ratio angabe1 = null;

		do { // control loop to catch input errors

			weiterJaNein = false;

			try {

				System.out.println("Bitte erste rationale Zahl eingeben in der Form z/n");
				stringRatioZahl1 = scanner.nextLine();

				angabe1 = string2ratio(stringRatioZahl1); // Ratio aus St

				if (angabe1.getNenner() == 0) {
					System.out.println("Angabe ist leider nicht korrekt. Man kann nicht durch 0 dividieren");
					weiterJaNein = true;
				}

			} catch (Exception e) {
				System.out.println("Angabe ist leider nicht korrekt");
				weiterJaNein = true;
			}

		} while (weiterJaNein); // end of loop

		return angabe1;

	}

	/**
	 * secondNumberDeclaration
	 * 
	 * @return angabe1 (Ratio): second declared rational number     * read users
	 *         declaration of the first rational number and prevent input
	 *         errors.    
	 */

	public Ratio secondNumberDeclaration() {

		boolean weiterJaNein;
		String stringRatioZahl2;
		Ratio angabe2 = null;
		int angabeNenner;

		do { // control loop to catch input errors

			weiterJaNein = false;

			try {
				System.out.println("Bitte zweite rationale Zahl eingeben in der Form z/n");
				stringRatioZahl2 = scanner.nextLine();

				angabe2 = string2ratio(stringRatioZahl2); // Ratio aus
															// String

				angabeNenner = angabe2.getNenner();

				if (angabeNenner == 0) {
					System.out.println("Angabe ist leider nicht korrekt. Man kann nicht durch 0 dividieren");
					weiterJaNein = true;
				}
			} catch (Exception e) {
				System.out.println("Angabe ist leider nicht korrekt");
				weiterJaNein = true;
			}

		} while (weiterJaNein); // end of loop

		return angabe2;
	}

	/**
	 * operatorDeclaration
	 * 
	 * @return operator (String): declared operator     * read users declaration
	 *         of the operator and prevent input errors.    
	 */

	public String operatorDeclaration() {

		boolean question;
		String operator;

		do {
			question = false;
			System.out.println("Bitte operator eingeben [ + - * oder / ]");
			operator = scanner.nextLine();

			if (operator.equals("/") && angabeZaehler == 0) {
				System.out.println("Angabe ist leider nicht korrekt. Man kann nicht durch 0 dividieren");
				question = true;
			}

		} while (question);

		return operator;

	}

	// Calculation methods
	// ------------------------------------------------------

	/**
	 * calculate
	 * 
	 * @param number1
	 *            (Ratio): declared first number
	 * @param number2
	 *            (Ratio): declared second number
	 * @param operator
	 *            (String): declared operator
	 * @return result (Ratio): result rational number     * use defined in Ratio
	 *         class mathematics algorithms to calculate rational numbers.
	 *         oparation on numbers depend on input operator    
	 */

	public Ratio calculate(Ratio number1, Ratio number2, String operator) {

		boolean weiterJaNein;
		Ratio result = null;

		do { // control loop to catch errors

			weiterJaNein = false; // reset the control loop

			switch (operator) {

			case "+":
				result = number1.addiere(number2);
				System.out.println(result);
				break;

			case "-":
				result = number1.subtrahiere(number2);
				System.out.println(result);
				break;
			case "*":
				result = number1.multipliziere(number2);
				System.out.println(result);
				break;
			case "/":
				result = number1.dividiere(number2);
				System.out.println(result);
				break;
			default:
				System.out.println("Falsche operator Angabe");
				weiterJaNein = true;
				break;
			}
		} while (weiterJaNein);

		return result;

	}

	/**
	 * continueQuestion
	 * 
	 * @return contin (boolean): yes or not answer     * ask user to continue or
	 *         to finish calculations. Catch input errors.    
	 */

	public boolean continueQuestion() {

		boolean yesNotQuestion;
		boolean contin = false;

		do { // do-while Schleife Angabe ueberpruefung

			System.out.println("weiter ? (j/n)");
			String input = scanner.nextLine();

			yesNotQuestion = false;

			if (input.equalsIgnoreCase("n")) {
				contin = false;
			} else if (input.equalsIgnoreCase("j")) {
				contin = true;
			} else {
				System.out.println("Angabe ist nicht korrekt bitte j oder n eintippen");
				yesNotQuestion = true;
			}

		} while (yesNotQuestion);

		return contin;
	}

} // End of class
