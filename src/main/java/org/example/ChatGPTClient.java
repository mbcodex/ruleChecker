package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGPTClient {
    public static void chatGPT(String prompt1) throws Exception {
        String url = "https://api.openai.com/v1/chat/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        String model = "gpt-3.5-turbo";
        String prompt = "[{\"role\": \"user\", \"content\": "+prompt1+"}]";
        int maxTokens = 50;

        con.setDoOutput(true);
        String body = "{\"model\": \"" + model + "\", \"messages\": " + prompt + ", \"max_tokens\": " + maxTokens + "}";

        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
        writer.write(body);
        writer.flush();

        System.out.println(body);

        //Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }

    public static void main(String[] args) throws Exception {
        //userHandler uh = new userHandler();
        //uh.startInteraction();
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
String prompt =" String prompt = \"Generate a table for the following rules:\\n\"\n" +
        "                + \"a) If C0100=[0,^], then all active items from C0200 through C0600 must equal [^].\\n\"\n" +
        "                + \"b) If C0100=[1], then all active items from C0200 through C0600 must not equal [^].\\n\"\n" +
        "                + \"c) If C0100=[-], then all active items from C0200 through C0500 must equal [-].\\n\"\n" +
        "                + \"d) If C0100=[-], then if C0600 is active it must equal [1,-].\";";
        chatGPT(prompt);
    }
}
