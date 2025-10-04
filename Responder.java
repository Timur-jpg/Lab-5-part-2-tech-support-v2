import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

/**
 * Responder class with smarter default responses.
 * - Synonyms mapped to the same response.
 * - Multiple matches combined.
 * - Default responses chosen based on input cues.
 */
public class Responder
{
    private HashMap<String, String> responses;
    private ArrayList<String> generalDefaults;
    private ArrayList<String> questionDefaults;
    private String lastDefault;
    private Random random;

    public Responder()
    {
        responses = new HashMap<>();
        generalDefaults = new ArrayList<>();
        questionDefaults = new ArrayList<>();
        random = new Random();
        lastDefault = "";

        fillResponsesMap();
        fillDefaultResponses();
    }

    private void fillResponsesMap()
    {
        // Performance issues
        responses.put("slow", "Your computer may be running too many programs at once.");
        responses.put("lag", "Your computer may be running too many programs at once.");
        responses.put("freeze", "Try closing unnecessary programs or restarting your computer.");

        // Crashes / errors
        responses.put("crash", "Try restarting your computer and checking for updates.");
        responses.put("error", "Take note of the error message and restart your program.");

        // Network issues
        responses.put("internet", "Check your router or try reconnecting to Wi-Fi.");
        responses.put("wifi", "Check your Wi-Fi settings or restart your router.");
        responses.put("disconnect", "Ensure all cables are connected and try reconnecting.");
        responses.put("slow internet", "Try disconnecting other devices or restarting your modem.");

        // Printer issues
        responses.put("printer", "Make sure the printer is turned on and connected.");

        // Software issues
        responses.put("software", "Reinstalling the software may solve the issue.");
        responses.put("install", "Follow the installation instructions carefully and restart if needed.");

        // Security issues
        responses.put("virus", "Run a full antivirus scan and remove any threats found.");
        responses.put("malware", "Run a full antivirus scan and remove any threats found.");

        // Password issues
        responses.put("password", "Try resetting your password using the 'Forgot Password' link.");

        // Hardware / blue screen
        responses.put("blue screen", "This may indicate a hardware or driver issue. Consider restarting.");
    }

    private void fillDefaultResponses()
    {
        // General default responses
        generalDefaults.add("That sounds like a difficult problem. Can you tell me more?");
        generalDefaults.add("I see. Can you explain the issue in more detail?");
        generalDefaults.add("Hmm, that is tricky. Can you give me more information?");
        generalDefaults.add("Interesting. Please provide more details about the problem.");

        // Question-based defaults
        questionDefaults.add("Why do you think this happened?");
        questionDefaults.add("How did this issue start?");
        questionDefaults.add("Who else is affected by this problem?");
        questionDefaults.add("Can you explain more about this situation?");
    }

    /**
     * Generate a response based on all matching words in the set.
     * If no match, pick a smart default based on cue words.
     */
    public String generateResponse(HashSet<String> words)
    {
        HashSet<String> matchedResponses = new HashSet<>();

        for(String word : words) {
            if(responses.containsKey(word)) {
                matchedResponses.add(responses.get(word));
            }
        }

        if(!matchedResponses.isEmpty()) {
            // Single or multiple matches
            if(matchedResponses.size() == 1) {
                return matchedResponses.iterator().next();
            } else {
                StringBuilder combined = new StringBuilder();
                for(String resp : matchedResponses) {
                    combined.append(resp).append(" ");
                }
                return combined.toString().trim();
            }
        } else {
            // No keyword matched → use cue words to pick default
            for(String word : words) {
                if(word.equals("why") || word.equals("how") || word.equals("who")) {
                    return pickCueDefault();
                }
            }
            return pickGeneralDefault();
        }
    }

    private String pickGeneralDefault()
    {
        String response;
        do {
            int index = random.nextInt(generalDefaults.size());
            response = generalDefaults.get(index);
        } while(response.equals(lastDefault));

        lastDefault = response;
        return response;
    }

    private String pickCueDefault()
    {
        String response;
        do {
            int index = random.nextInt(questionDefaults.size());
            response = questionDefaults.get(index);
        } while(response.equals(lastDefault));

        lastDefault = response;
        return response;
    }
}
