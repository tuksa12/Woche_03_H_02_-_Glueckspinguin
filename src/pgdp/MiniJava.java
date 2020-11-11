package pgdp;

import java.io.*;
import java.util.Random;

/**
 * This class provides convenience methods to make the barrier of entry into
 * programming easier. In addition to that it realizes an educational
 * sub-language to Java called "Mini Java" with simpler grammar.
 * <p>
 * <i>Diese Klasse stellt simple Methoden zur Verfügung um den Einstieg in die
 * Programmierung zu vereinfachen. Zusätzlich dazu wird damit eine für die Lehre
 * zusammengestellte Sub-Programmiersprache von Java umgesetzt, die sich "Mini
 * Java" nennt und eine einfachere Grammatik besitzt.</i>
 */
public class MiniJava {

	private static Random rand;
	private static InputStream is = System.in;
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

	/**
	 * Task-specific method for W03H01:
	 * Takes the number of fish in fields 3 to 11 and outputs them
	 */
	public static void writeBoard(int f3, int f4, int f5, int f6, int f7, int f8, int f9, int f10, int f11) {

		//determine board dimensions and helper values
		int f7Width = 1;
		for(int x = f7; 10 <= x; x /= 10)
			f7Width++;
		int width = 14 + Math.max(f7Width, 3);

		int spacing; //helper var for correct spacing


		//create board string
		StringBuilder boardStr = new StringBuilder();

		//crown top
		spacing = width - 11;
		boardStr.append("┌").append("─".repeat(spacing - spacing / 2))
				.append(" o  o  o ")
				.append("─".repeat(spacing / 2)).append("┐\n");

		//crown middle
		spacing = width - 9;
		boardStr.append("│").append(" ".repeat(spacing - spacing / 2))
				.append("│╲╱ ╲╱│")
				.append(" ".repeat(spacing /2)).append("│\n");

		//crown bottom
		spacing = width - 9;
		boardStr.append("│").append(" ".repeat(spacing - spacing / 2))
				.append("│_F12_│")
				.append(" ".repeat(spacing /2)).append("│\n");

		//crown border
		spacing = width - 12;
		boardStr.append("├────┬")
				.append("─".repeat(spacing))
				.append("┬────┤\n");

		//f9, f10, f11 labels
		spacing = width - 15;
		boardStr.append("│ F9 │").append(" ".repeat(spacing - spacing / 2))
				.append("F10")
				.append(" ".repeat(spacing / 2)).append("│ F11│\n");

		//f9, f10, f11 values
		spacing = width - 13;
		boardStr.append("│  ").append(f9).append(" │")
				.append(" ".repeat(spacing - spacing / 2)).append(f10).append(" ".repeat(spacing / 2))
				.append("│  ").append(f11).append(" │\n");

		//f9, f10, f11 border
		spacing = width - 12;
		boardStr.append("├────┼")
				.append("─".repeat(spacing))
				.append("┼────┤\n");

		//f6, f7, f8 labels
		spacing = width - 14;
		boardStr.append("│ F6 │").append(" ".repeat(spacing / 2))
				.append("F7")
				.append(" ".repeat(spacing - spacing / 2)).append("│ F8 │\n");

		//f6, f7, f8 values
		spacing = width - 12 - f7Width;
		boardStr.append("│  ").append(f6).append(" │")
				.append(" ".repeat(spacing - spacing / 2)).append(f7).append(" ".repeat(spacing / 2))
				.append("│  ").append(f8).append(" │\n");

		//f6, f7, f8 border
		spacing = width - 12;
		boardStr.append("├────┼")
				.append("─".repeat(spacing))
				.append("┼────┤\n");

		//f3, f4, f5 labels
		spacing = width - 14;
		boardStr.append("│ F3 │").append(" ".repeat(spacing / 2))
				.append("F4")
				.append(" ".repeat(spacing - spacing / 2)).append("│ F5 │\n");

		//f3, f4, f5 values
		spacing = width - 13;
		boardStr.append("│  ").append(f3).append(" │")
				.append(" ".repeat(spacing - spacing / 2)).append(f4).append(" ".repeat(spacing / 2))
				.append("│  ").append(f5).append(" │\n");

		//f3, f4, f5 border
		spacing = width - 12;
		boardStr.append("├────┴")
				.append("─".repeat(spacing))
				.append("┴────┤\n");

		//penguin head
		spacing = width - 10;
		boardStr.append("│ ('>")
				.append(" ".repeat(spacing))
				.append("<') │\n");

		//penguin body
		spacing = width - 12;
		boardStr.append("│ ╱/╲")
				.append(" ".repeat(spacing/2)).append("F2").append(" ".repeat(spacing - spacing/2))
				.append("╱\\╲ │\n");

		//penguin feet
		spacing = width - 14;
		boardStr.append("├─V_╱─┐")
				.append(" ".repeat(spacing))
				.append("┌─╲_V─┤\n");

		//penguin border
		spacing = width - 14;
		boardStr.append("└─────┴")
				.append("─".repeat(spacing))
				.append("┴─────┘\n");

		//output board
		writeConsole(boardStr.toString());
	}

	/**
	 * Reads a {@link String} from the console, and prompts the user by printing the
	 * given <code>text</code> with a line break to the console.
	 * <p>
	 *
	 * <i>Liest einen {@link String} von der Konsole ein, und fordert den oder die
	 * Benutzerin durch die Ausgabe des übergebenen <code>text</code>es zur Eingabe
	 * auf (mit Zeilenumbruch).</i>
	 *
	 * @param text the text to display on the console before reading an input.
	 * @return the input string or <code>null</code>, if no input is available
	 * (should normally not happen)
	 */
	public static String readString(String text) {
		// Exchange the reader in case System.in has changed.
		// This is necessary for testing, as for every test input, System.in is changed.
		if(System.in != is) {
			is = System.in;
			bufferedReader = new BufferedReader(new InputStreamReader(is));
		}
		try {
			System.out.println(text);
			return bufferedReader.readLine();
		}
		catch(IOException e) {
			// We "hide" the exception in the method signature by rethrowing an unchecked
			// exception
			throw new UncheckedIOException("Konnte Eingabe nicht lesen.", e);
		}
	}

	/**
	 * Reads a {@link String} from the console, and prompts the user by printing the
	 * line
	 *
	 * <pre>
	 * Eingabe:
	 * </pre>
	 *
	 * <i>Liest einen {@link String} von der Konsole ein, und fordert den oder die
	 * Benutzerin dazu auf durch die Ausgabe von
	 *
	 * <pre>
	 * Eingabe:
	 * </pre>
	 *
	 * </i>
	 */
	public static String readString() {
		return readString("Eingabe:");
	}

	/**
	 * Tries to read an <code>int</code> from the console, and retires if the input
	 * was not a valid integer. It prompts the user by printing the given
	 * <code>text</code> with a line break to the console.
	 * <p>
	 * <i>Versucht einen <code>int</code>-Wert von der Konsole einzulesen, und
	 * wiederholt die Anfrage solange es nicht nicht um eine ganze Zahl handelt. Der
	 * oder die Benutzerin wird durch die Ausgabe des übergebenen
	 * <code>text</code>es zur Eingabe aufgefordert (mit Zeilenumbruch).</i>
	 *
	 * @see Integer#parseInt(String)
	 */
	public static int readInt(String text) {
		Integer x = null;
		do {
			String s = readString(text);
			if(s == null)
				throw new IllegalStateException("Es ist keine Eingabe (mehr) verfügbar.");
			try {
				x = Integer.parseInt(s.trim());
			}
			catch(@SuppressWarnings("unused") NumberFormatException e) {
				// try again
			}
		}
		while(x == null);
		return x;
	}

	/**
	 * Works like {@link #readInt(String)}, but uses the following preset text to
	 * prompt the user:
	 *
	 * <pre>
	 * Geben Sie eine ganze Zahl ein:
	 * </pre>
	 *
	 * <i>Funktioniert wie {@link #readInt(String)}, nutzt jedoch folgenden
	 * vorgegebenen Text:
	 *
	 * <pre>
	 * Geben Sie eine ganze Zahl ein:
	 * </pre>
	 *
	 * </i>
	 */
	public static int readInt() {
		return readInt("Geben Sie eine ganze Zahl ein:");
	}

	/**
	 * Identical to {@link #readInt(String)}.
	 * <p>
	 * <i>Identisch zu {@link #readInt(String)}</i>
	 */
	public static int read(String text) {
		return readInt(text);
	}

	/**
	 * Identical to {@link #readInt()}.
	 * <p>
	 * <i>Identisch zu {@link #readInt()}</i>
	 */
	public static int read() {
		return readInt();
	}

	/**
	 * Tries to read an <code>double</code> from the console, and retires if the
	 * input was not a valid double value. It prompts the user by printing the given
	 * <code>text</code> with a line break to the console.
	 * <p>
	 * <i>Versucht einen <code>double</code>-Wert von der Konsole einzulesen, und
	 * wiederholt die Anfrage solange es nicht nicht um eine gültige
	 * <code>double</code>-Fließkommazahl handelt. Der oder die Benutzerin wird
	 * durch die Ausgabe des übergebenen <code>text</code>es zur Eingabe
	 * aufgefordert (mit Zeilenumbruch).</i>
	 *
	 * @see Double#parseDouble(String)
	 */
	public static double readDouble(String text) {
		Double x = null;
		do {
			String s = readString(text);
			if(s == null)
				throw new IllegalStateException("Es ist keine Eingabe (mehr) verfügbar.");
			try {
				x = Double.parseDouble(s.trim());
			}
			catch(@SuppressWarnings("unused") NumberFormatException e) {
				// try again
			}
		}
		while(x == null);
		return x;
	}

	/**
	 * Works like {@link #readDouble(String)}, but uses the following preset text to
	 * prompt the user:
	 *
	 * <pre>
	 * Geben Sie eine Zahl ein:
	 * </pre>
	 *
	 * <i>Funktioniert wie {@link #readDouble(String)}, nutzt jedoch folgenden
	 * vorgegebenen Text:
	 *
	 * <pre>
	 * Geben Sie eine Zahl ein:
	 * </pre>
	 *
	 * </i>
	 */
	public static double readDouble() {
		return readDouble("Geben Sie eine Zahl ein:");
	}

	/**
	 * Prints the {@link String} to the console and breaks the line.
	 * <p>
	 * <i>Gibt den {@link String} auf der Konsole aus und beginnt eine neue
	 * Zeile.</i>
	 */
	public static void write(String output) {
		System.out.println(output);
	}

	/**
	 * Prints the <code>int</code> to the console and breaks the line.
	 * <p>
	 * <i>Gibt den <code>int</code>-Wert auf der Konsole aus und beginnt eine neue
	 * Zeile.</i>
	 */
	public static void write(int output) {
		write(String.valueOf(output));
	}

	/**
	 * Prints the <code>double</code> to the console and breaks the line.
	 * <p>
	 * <i>Gibt den <code>double</code>-Wert auf der Konsole aus und beginnt eine
	 * neue Zeile.</i>
	 */
	public static void write(double output) {
		write(String.valueOf(output));
	}

	/**
	 * Identical to {@link #write(String)}.
	 * <p>
	 * <i>Identisch zu {@link #write(String)}</i>
	 */
	public static void writeLineConsole(String output) {
		System.out.println(output);
	}

	/**
	 * Identical to {@link #write(int)}.
	 * <p>
	 * <i>Identisch zu {@link #write(int)}</i>
	 */
	public static void writeLineConsole(int output) {
		writeLineConsole(String.valueOf(output));
	}

	/**
	 * Identical to {@link #write(double)}.
	 * <p>
	 * <i>Identisch zu {@link #write(double)}</i>
	 */
	public static void writeLineConsole(double output) {
		writeLineConsole(String.valueOf(output));
	}

	/**
	 * Prints a line separator in the console.
	 * <p>
	 * <i>Gibt einen Zeilenumbruch auf der Konsole aus.</i>
	 */
	public static void writeLineConsole() {
		writeLineConsole("");
	}

	/**
	 * Prints the {@link String} to the console. Does not end with a line break.
	 * <p>
	 * <i>Gibt den {@link String} auf der Konsole aus. Endet nicht mit einem
	 * Zeilenumbruch.</i>
	 */
	public static void writeConsole(String output) {
		System.out.print(output);
	}

	/**
	 * Prints the <code>int</code> to the console. Does not end with a line break.
	 * <p>
	 * <i>Gibt den <code>int</code>-Wert auf der Konsole aus. Endet nicht mit einem
	 * Zeilenumbruch.</i>
	 */
	public static void writeConsole(int output) {
		writeConsole(String.valueOf(output));
	}

	/**
	 * Prints the <code>double</code> to the console. Does not end with a line
	 * break.
	 * <p>
	 * <i>Gibt den <code>double</code>-Wert auf der Konsole aus. Endet nicht mit
	 * einem Zeilenumbruch.</i>
	 */
	public static void writeConsole(double output) {
		writeConsole(String.valueOf(output));
	}

	/**
	 * Draws a random card, represented by its value. The value ranges from 1
	 * (inclusive) to 105 (inclusive).
	 * <p>
	 * <i>Zieht eine zufällige Karte, repräsentiert durch ihren Wert. Der Wert liegt
	 * im Bereich 1 (inklusive) bis 105 (inklusive).</i>
	 */
	public static int drawCard() {
		return randomInt(1, 105);
	}

	/**
	 * Returns a random integer between 1 (inclusive) to 6 (inclusive).
	 * <p>
	 * <i>Gibt eine zufällige Zahl zwischen 1 (inklusive) bis 6 (inklusive)
	 * zurück.</i>
	 */
	public static int dice() {
		return randomInt(1, 6);
	}

	/**
	 * Returns a random integer in the range minval (inclusive) to maxval
	 * (inclusive)
	 * <p>
	 * <i>Gibt eine zufällige Zahl zwischen minval (inklusive) bis maxval
	 * (inklusive) zurück.</i>
	 */
	public static int randomInt(int minval, int maxval) {
		if(rand == null) {
			setRandom();
		}
		return minval + rand.nextInt(maxval - minval + 1);
	}

	public static void setRandom() {
		setRandomWithSeed(6969, null);
	}

	public static void resetRandom(Random oldRandom) {
		if(rand != null && rand != oldRandom)
			throw new SecurityException("Don't use resetRandom()!");
		rand = null;
	}

	public static Random setRandomWithSeed(int seed, Random oldRandom) {
		if(rand != null && rand != oldRandom)
			throw new SecurityException("Don't use setRandom()!");
		rand = new Random(seed);
		return rand;
	}
}
