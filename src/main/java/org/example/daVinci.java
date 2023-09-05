package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class daVinci {
        public static void main(String[] args) {
            try {
                // Initialize the API endpoint and set up the connection
                URL url = new URL("https://api.openai.com/v1/engines/davinci-codex/completions");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");

                // Add the necessary headers, including your API key
                con.setRequestProperty("Authorization", "Bearer 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");
                con.setRequestProperty("Content-Type", "application/json");

                // Add POST data in JSON format
                String payload = "{ 'prompt': 'Translate the following English text to French: \'Hello, world!\', 'max_tokens': 60 }";

                // Send the POST data
                con.setDoOutput(true);
                try(DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.writeBytes(payload);
                }
                // Read and print the response
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                System.out.println("Response: " + content.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


