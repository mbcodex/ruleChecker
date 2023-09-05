package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ChatGPT {
    public static void chatGPT(String text) throws Exception {
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        String apiKey = "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";
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer "+apiKey);

        JSONObject data = new JSONObject();
//        data.put("model", "text-davinci-003");
        data.put("model", "gpt-3.5-turbo");

        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();

        System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
    }

    public static void main(String[] args) throws Exception {
        String prompt = "What is the capital of India";
//        String prompt ="Write negative test cases for the specs below 3658" +
//                "Coding of A0410 depends upon the resident's status on the target date for the assessment.  The target date is defined as follows:" +
//                "" +
//                "   a) If A0310F is equal to [01], then the target date is equal to A1600 (entry date)." +
//                "   b) If A0310F is equal to [10,11,12], then the target date is equal to A2000 (discharge date)." +
//                "   c) If A0310F is equal to [99], then the target date is equal to A2300 (assessment reference date)." +
//
//                "Given the target date, the following rules apply:" +
//
//                "a) If the resident is on a Medicare/Medicaid certified unit on the target date for the assessment, then A0410 must be equal to [3] (federal required submission)." +
//
//                "b) If the resident is on a unit that is not Medicare/Medicaid certified on the target date and if the State requires MDS submission for individuals on the resident's unit, then A0410 must be equal to [2] (state but not federal required submission)." +
//
//                "c)  If the facility is completing the assessment for another purpose (other than to satisfy Federal or State requirements), then A0410 must be equal to [1] (neither federal nor state required submission)." +
//
//                "If A0410 is equal to [2,3], then the assessment MUST be submitted to the MDS Submission System.  If A0410 is equal to [1], then the assessment MUST NOT be submitted to the MDS Submission System." +
//
//                "NOTE: It is a violation of a resident's right to privacy to submit data to CMS's data systems when the data are not required.";
        chatGPT(prompt);
    }
}
