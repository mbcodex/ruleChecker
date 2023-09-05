package org.example;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App_no_user_input {
    private static final Logger LOGGER = LoggerFactory.getLogger(App_no_user_input.class);
    public static void main(String[] args) {
        // Set ChatGPT endpoint and API key
        String endpoint = "https://api.openai.com/v1/chat/completions";
//        String endpoint = "https://api.openai.com/v1/engines/chatGPT/completions";
        String apiKey = "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";

        // Prompt user for input string
        try {
            String filepath="/Users/mb/Desktop/chatGPT_Edits copy.txt";
//            File file = new File(filepath);
//            BufferedReader reader = FileInputStream(file);
//            char fileContent[] = new char[(int)file.length()];
//            reader.read(fileContent); reader.close();
            String input  = new String(Files.readAllBytes(Paths.get(filepath)));
            System.out.print("File contents: "+input);
            // Send input to ChatGPT API and display response
            String response = ChatBot.sendQuery(input, endpoint, apiKey);
            LOGGER.info("Response: {}", response);
//            System.out.print("System.out.print(\"File contents: \"+input);: "+response);
            List<String> lines=new ArrayList<>(
                            Arrays.asList(response.split("\\\\n"))
                            );
            lines.forEach(line-> System.out.println(line));
        } catch (IOException e) {
            LOGGER.error("Error reading input: {}", e.getMessage());
        } catch (JSONException e) {
            LOGGER.error("Error parsing API response: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error: {}", e.getMessage());
        }
    }
}
