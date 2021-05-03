package base.utils;
import java.io.InputStream;
import java.util.Scanner;

/**
 * <h1>Keyboard Reader Utility</h1>
 * <h2>Object for handling user input at runtime.</h2>
 * <p>Utilizes a Scanner object.</p>
 * <p>Constructor accepts a InputStream for testability.</p>
 *
 */
public class KeyboardReader {
    Scanner scanner;

    public KeyboardReader(InputStream stream) {
        scanner = new Scanner(stream);
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
