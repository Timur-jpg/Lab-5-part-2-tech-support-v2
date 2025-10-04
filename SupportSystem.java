import java.util.HashSet;

/**
 * The SupportSystem class manages the user input and delegates
 * to the Responder class to generate responses.
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;

    /**
     * Constructor for objects of class SupportSystem
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Start the system (simplified version).
     */
    public void start()
    {
        boolean finished = false;
        while(finished) {
            System.out.println("> ");  
            HashSet<String> input = reader.getInput();  

            if(input.contains("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        System.out.println("Goodbye!");
    }
}
