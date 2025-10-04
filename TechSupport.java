
import java.util.HashMap;

/**
 * TechSupport system that uses a HashMap of keywords
 * and their associated responses.
 */
public class TechSupport
{
    private HashMap<String, String> responses;

    /**
     * Constructor - initializes the response map.
     */
    public TechSupport()
    {
        responses = new HashMap<>();
        fillResponsesMap();
    }

    /**
     * Fill the response map with known keywords and responses.
     */
    private void fillResponsesMap()
    {
        responses.put("slow", "Your computer may be running too many programs at once.");
        responses.put("crash", "Try restarting your computer and checking for updates.");
        responses.put("internet", "Check your router or try reconnecting to Wi-Fi.");
        responses.put("printer", "Make sure the printer is turned on and connected.");
        responses.put("software", "Reinstalling the software may solve the issue.");
    }

    /**
     * Generate a response for a given keyword.
     * @param word The word to look up.
     * @return The associated response or a default response if not found.
     */
    public String generateResponse(String word)
    {
        String response = responses.get(word);
        if (response != null) {
            return response;
        } else {
            return pickDefaultResponse();
        }
    }

    /**
     * Return a default response if no keyword matches.
     */
    private String pickDefaultResponse()
    {
        return "That sounds like a difficult problem. Can you tell me more?";
    }
}
