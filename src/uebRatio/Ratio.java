
package uebRatio;

/**
 * 
 * @author Grzegorz Pawlak 
 * Email: s0563317@htw-berlin.de
 * @version Eclipse Mars Java 1.8
 * @since 26.12.2017
 */

public class Ratio implements IRatio {

	// Attributes
	// ------------------------------------------------------

	private int zaehler;
	private int nenner;

	// Getter & Setter methods
	// ------------------------------------------------------

	/** getZaehler
	   * @return (int): numerator or rational numbers
	   * Getter of the numerator of rational numbers
	   */
	
	public int getZaehler() {
		return zaehler;
	}
	
	/** setZaehler
	   * @param zaehler (int): new numerator
	   * Setter to set up new numerator of rational number
	   */

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	/** getNenner
	   * @return (int): denominator of rational numbers
	   * Getter of the denominator of rational number
	   */
	
	  public int getNenner() {
	    return this.nenner;
	  }
	

	/** setNenner
	   * @param (int): new denominator
	   * Setter to set up new denominator of rational number
	   */
	
	public void setNenner(int nenner) {
		this.nenner = nenner;
	}
	
	/** toString
	   * @return (String): rational numbers
	   * change rational numbers to string format 'Zähler/Nenner'
	   */

	// toString

	@Override
	public String toString() {
		return zaehler + "/" + nenner;
	}

	// Constructors
	// ------------------------------------------------------
	
	/** Constructor with parameters
	   * @param zaehler (int): Numerator of the new rational number
	   * @param nenner (int): Denominator of the new rational number
	   * ----
	   * To initialize the new rational number with new parameters
	   */

	public Ratio(int zaehler, int nenner) {

		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	/** Default constructor without parameters
	   * To initialize the new rational number with numerator = 0 denominator= 1
	   */

	public Ratio() {

		zaehler = 0;
		nenner = 1;
	}

	// mathematics methods
	//  ------------------------------------------------------

	/** addiere
	   * @param zahl2 (Ratio): second summand
	   * @return (Ratio): sum as a new number
	   * Calculate a sum of two rational numbers
	   */
	
	
	@Override
	public Ratio addiere(Ratio zahl2) {

		// TODO Auto-generated method stub
		Ratio addiereOut = new Ratio();

		addiereOut.zaehler = (this.zaehler * zahl2.nenner) + (this.nenner * zahl2.zaehler); // z/n
																							// =
																							// this.zaehler
																							// /
																							// this.nenner
		addiereOut.nenner = this.nenner * zahl2.nenner; // x/y = zahl2.zaehler /
														// zahl2.nenner

		addiereOut.kuerze();

		return addiereOut;
	}

	/** subtrahiere 
	   * @param zahl2 (Ratio): second Subtrahend
	   * @return (Ratio): Difference as a new rational number
	   * Calculates the difference between two rational numbers
	   */
	
	@Override
	public Ratio subtrahiere(Ratio zahl2) {
		// TODO Auto-generated method stub
		Ratio subtrahiereOut = new Ratio();

		subtrahiereOut.zaehler = (this.zaehler * zahl2.nenner) - (this.nenner * zahl2.zaehler);
		subtrahiereOut.nenner = this.nenner * zahl2.nenner;

		subtrahiereOut.kuerze();

		return subtrahiereOut;
	}

	
	/** multipliziere
	   * @param number2 (ratio): factor
	   * @return (ratio): product as a new rational number
	   * Calculates the factor from two rational numbers
	   */
	
	@Override
	public Ratio multipliziere(Ratio zahl2) {
		// TODO Auto-generated method stub

		Ratio multipliziereOut = new Ratio();

		multipliziereOut.zaehler = (this.zaehler * zahl2.zaehler);
		multipliziereOut.nenner = (this.nenner * zahl2.nenner);

		// z/n * x/y = (z * x ) / (n * y )
		multipliziereOut.kuerze();
		return multipliziereOut;
	}

	/** dividiere
	   * @ param number (ratio): divisor
	   * @return (ratio): quotient as new rational number
	   * Calculates the quotient of two rational numbers
	   *
	   */
	
	@Override
	public Ratio dividiere(Ratio zahl2) throws ArithmeticException {
		// TODO Auto-generated method stub

		Ratio dividireOut = new Ratio();

		dividireOut.zaehler = (this.zaehler * zahl2.nenner);
		dividireOut.nenner = (this.nenner * zahl2.zaehler);
		// z/n : x/y = (z * y ) / (n * x )
		dividireOut.kuerze();
		return dividireOut;
	}
	/** kuerze
	   * @return (ratio): abbreviated rational number
	   * Shorten a rational number using the Euclidean algorithm
	   */
	
	@Override
	public Ratio kuerze() {
		// TODO Auto-generated method stub

		int i, n = Math.abs(nenner), z = Math.abs(zaehler);

		while (z > 0) {
			if (z < n) {
				i = n;
				n = z;
				z = i;
			}
			z = z - n;
		}
		nenner = nenner / n;
		zaehler = zaehler / n;
		return this;

	}

	// comparison method
	// ------------------------------------------------------
	

	/** equals
	   * @param obj
	   * @return boolean
	   * Checks if denominator & counter of rational numbers are identical
	   */

	public boolean equals(Object obj) {

		if (obj.getClass() == this.getClass()) {

			Ratio zahl = (Ratio) obj;
			Ratio zahl1 = this.kuerze();
			Ratio zahl2 = zahl.kuerze();

			if (zahl1.getZaehler() == zahl2.getZaehler() && zahl2.getNenner() == zahl1.getNenner()) 
			return true;
			else return false;
		}

		else return false;
		
	}

}
