package uebRatio;

/**
 * @author Gregor Pawlak
 * Email: s0563317@htw-berlin.de
 * @version Eclipse Mars, Java-1.8
 * @since 2017-01-02
 * Last Change: 2017-01-02
 */

public interface IRatio {

	public Ratio addiere(Ratio zahl2);

	public Ratio subtrahiere(Ratio zahl2);

	public Ratio multipliziere(Ratio zahl2);

	public Ratio dividiere(Ratio zahl2) throws ArithmeticException;
	
	public Ratio kuerze(); // Euklidischer Algorithmus 
	
	
}// end of interface
