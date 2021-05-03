package base.utils;
import java.io.PrintStream;

/**
 * <h1>ConsolePrinter Utility</h1>
 * <h2>Object for printing output to the console</h2>
 * <p>Constructor accepts a PrintStream for testability.</p>
 *
 */
public class ConsolePrinter {
    public ConsolePrinter(PrintStream stream) {
        System.setOut(stream);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(int message)  {
        System.out.println(message);
    }
}
