import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads user input and returns it as a set of words.
 */
public class InputReader
{
    private Scanner scanner;

    /**
     * Constructor for InputReader
     */
    public InputReader()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Read a line of text from the user and return it as a set of words.
     * @return A set of words typed by the user.
     */
    public HashSet<String> getInput()
    {
        String inputLine = scanner.nextLine().trim().toLowerCase();
        String[] words = inputLine.split("\\s+"); // split on one or more spaces

        HashSet<String> wordSet = new HashSet<>();
        for(String word : words) {
            wordSet.add(word);
        }
        return wordSet;
    }
}
