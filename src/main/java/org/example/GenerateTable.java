package org.example;

import java.util.Arrays;
//import com.openai.*;
//import com.openai.ApiException;

public class GenerateTable {
    public static void main(String[] args) {
//        Configuration.setDefaultApiKey("YOUR_API_KEY");
//
//        // Define the prompt and model settings
//        String prompt = "Generate a table for the following rules:\n"
//                + "a) If C0100=[0,^], then all active items from C0200 through C0600 must equal [^].\n"
//                + "b) If C0100=[1], then all active items from C0200 through C0600 must not equal [^].\n"
//                + "c) If C0100=[-], then all active items from C0200 through C0500 must equal [-].\n"
//                + "d) If C0100=[-], then if C0600 is active it must equal [1,-].";
//        String model_engine = "text-davinci-002";
//        List openai_stop = Arrays.asList("\n");
//        int max_tokens = 150;
//        double temperature = 0.5;
//        double top_p = 1.0;
//        boolean nucleus_sampling = false;
//        double frequency_penalty = 0.5;
//        double presence_penalty = 0.5;
//        String format = "table";
//
//        // Call the model to generate the table
//        try {
//            List<Completion> completions =
//                    OpenAI.complete(
//                            prompt,
//                            model_engine,
//                            null,
//                            max_tokens,
//                            temperature,
//                            top_p,
//                            nucleus_sampling,
//                            null,
//                            openai_stop,
//                            null,
//                            null,
//                            null,
//                            frequency_penalty,
//                            presence_penalty,
//                            format
//                    );
//            String result = completions.get(0).getText();
//            System.out.println(result);
//        } catch (ApiException ex) {
//            // Handle the exception accordingly
//        }
    }
}