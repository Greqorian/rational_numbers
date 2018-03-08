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

public class Engine {

	// globale Variablen
	// --------------------------------------------------------------------------------------

	Ratio angabe1;
	Ratio angabe2;

	String stringRatioZahl1;
	String stringRatioZahl2;
	String operator;

	int angabeNenner;
	int angabeZaehler;

	boolean weiterJaNein = true;
	boolean losgehtsWeiter = true;

	// Konstruktoren
	// ------------------------------------------------------------------------------------------

	Scanner scanner = new Scanner(System.in);

	List<String> ratioList = new ArrayList<String>(5);

	List<String> operatorList = new ArrayList<String>(5);

	//////// Methoden deklaration
	//////// -----------------------------------------------------------------------------

	// Methode saveRatioZahl
	// -------------------------------------------------------------------------------------
	// speichert die rationale Zahl in Stringform in den Speicher (Array)

	public void saveRatioZahl(Ratio r) {

		String stringR = "" + r;

		ratioList.add(stringR);

	}

	// Methode saveOperator
	// -------------------------------------------------------------------------------------
	// sichert den Operator als String in den Speicher (Array)

	public void saveOperator(String op) {

		operatorList.add(op);
	}

	// Methode Ratio to String
	// --------------------------------------------------------------------------------
	// gibt einen String aus dem Speicher zurück
	// @param index - die Position des String im Speicher (Array)
	// @return String

	public String restore(int index) {

		String restore = (String) ratioList.get(index);

		return restore;

	}

	// Methode restore operator
	// -------------------------------------------------------------------------------------
	// gibt einen Operator aus dem Speicher zurück
	// @param index - die Position des String im Speicher (Array)
	// @return String

	public String restoreOperator(int index) {

		String restoreOperator = (String) operatorList.get(index);

		return restoreOperator;

	}

	// Methode String to ratio
	// --------------------------------------------------------------------------------
	// konvertiert einen String in eine rationale Zahl
	// @param str - enthält die rationale Zahl in Stringform "2/3"
	// @return Ratio - die Zahl als rationale Zahl

	public Ratio string2ratio(String str) {
		String[] parts = str.split("/");
		String part1 = parts[0]; // z
		String part2 = parts[1]; // n

		int zaehler = Integer.parseInt(part1);
		int nenner = Integer.parseInt(part2);

		Ratio ratioZahl = new Ratio(zaehler, nenner);
		return ratioZahl;
	}

	// Main Ausfuerhrungsmethode implementation
	// -------------------------------------------------------------------------------

	public void losgehts() {

		do { // do-while Wiederholung Schleife start

			// 1. Ratio Zahl Angabe
			// ------------------------------------------------------------------------------------

			do { // do-while kontroll Schleife

				weiterJaNein = false;

				try {

					System.out.println("Bitte erste rationale Zahl eingeben in der Form z/n");
					stringRatioZahl1 = scanner.nextLine();

					angabe1 = string2ratio(stringRatioZahl1); // Ratio aus String	
					angabeNenner = angabe1.getNenner();
		
					if (angabeNenner == 0) {
						System.out.println("Angabe ist leider nicht korrekt. Man kann nicht durch 0 dividieren");
						weiterJaNein = true;
					}

				} catch (Exception e) {
					System.out.println("Angabe ist leider nicht korrekt");
					weiterJaNein = true;
				}
				
				

			} while (weiterJaNein);

			// 2. Ratio Zahl Angabe
			// --------------------------------------------------------------------------------

			do { // do-while Schleife Angabe ueberpruefung

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


			} while (weiterJaNein);

			// Angaben speichern
			// -----------------------------------------------------------------------------
			angabeZaehler = angabe2.getZaehler(); // Zehler in Variable speichern
			
			saveRatioZahl(angabe1); // Angabe in Array speichern

			saveRatioZahl(angabe2);

			// matematische Methoden implementation
			// -----------------------------------------------------------------------------

			do { // do-while kontroll Schleife

				System.out.println("Bitte operator eingeben [ + - * oder / ]");
				operator = scanner.nextLine();

				weiterJaNein = false; // kontroll Schleife reset

				switch (operator) {

				case "+":
					Ratio addiereOut = angabe1.addiere(angabe2);
					System.out.println(addiereOut);
					saveRatioZahl(addiereOut); // speichert Ergebiss in Array
					break;

				case "-":
					Ratio subtrahiereOut = angabe1.subtrahiere(angabe2);
					System.out.println(subtrahiereOut);
					saveRatioZahl(subtrahiereOut); // speichert Ergebiss in
													// Array
					break;
				case "*":
					Ratio multipliziereOut = angabe1.multipliziere(angabe2);
					System.out.println(multipliziereOut);
					saveRatioZahl(multipliziereOut); // speichert Ergebiss in
														// Array
					break;
				case "/":
					if (angabeZaehler == 0) { // kontroll frage
						System.out.println("Angabe ist leider nicht korrekt. Man kann nicht durch 0 dividieren");
						weiterJaNein = true;
						break;
					}
					Ratio dividiereOut = angabe1.dividiere(angabe2);
					System.out.println(dividiereOut);
					saveRatioZahl(dividiereOut); // speichert Ergebiss in Array
					break;
				default:
					System.out.println("Falsche operator Angabe");
					weiterJaNein = true;
					break;
				}
			} while (weiterJaNein);

			saveOperator(operator); // Operator in Array speichern

			// Weiterführen Anfrage
			// --------------------------------------------------------------------------------------

			do { // do-while Schleife Angabe ueberpruefung

				System.out.println("weiter ? (j/n)");
				String weiter = scanner.nextLine();

				weiterJaNein = false;

				if (weiter.equalsIgnoreCase("n")) {
					losgehtsWeiter = false;
				} else if (weiter.equalsIgnoreCase("j")) {
					losgehtsWeiter = true;
				} else {
					System.out.println("Angabe ist nicht korrekt bitte j oder n eintippen");
					weiterJaNein = true;
				}

			} while (weiterJaNein);

		} while (losgehtsWeiter); // Ende der losgehts Schleife

		// Array Methoden implementation
		// --------------------------------------------------------------------------------------
		// Ergebisse Ausgabe
		// --------------------------------------------------------------------------------------

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

	} // End of losgehts methode

} // End of class
