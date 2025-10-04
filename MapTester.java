
import java.util.HashMap;

/**
 * A simple class to demonstrate the use of HashMap
 * for storing a phone book.
 * 
 * @author (Timur Turdaliev)
 * @version (October 3 2025)
 */
public class MapTester
{
    // HashMap to store the phone book (name -> number)
    private HashMap<String, String> phoneBook;

    /**
     * Constructor for objects of class MapTester
     */
    public MapTester()
    {
        // initialise the phoneBook HashMap
        phoneBook = new HashMap<>();
    }

    /**
     * Add or update a phone number in the phone book.
     * @param name The name of the person.
     * @param number The phone number to store.
     */
    public void enterNumber(String name, String number)
    {
        phoneBook.put(name, number);
    }

    /**
     * Look up a phone number by name.
     * @param name The name to search for.
     * @return The phone number, or null if not found.
     */
    public String lookupNumber(String name)
    {
        return phoneBook.get(name);
    }
}
