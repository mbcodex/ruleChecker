package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ChatGPT4 {

    private static final String API_KEY = "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";
    private static final String URL = "https://api.openai.com/v1/engines/chatGPT/completions";

    public static String getCompletion(String prompt) throws Exception {
        URL url = new URL(URL + "?prompt=" + prompt + "&temperature=0.5&max_tokens=100");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("API call failed: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.readLine();
        reader.close();

        JSONObject jsonObject = new JSONObject(response);
        return jsonObject.getJSONArray("choices").getJSONObject(0).getString("text");
    }

    public static void main(String[] args) throws Exception {
        String prompt = "What is the meaning of life?";
        String completion = getCompletion(prompt);
        System.out.println(completion);
    }
}

