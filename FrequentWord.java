import java.io.*;
import java.util.*;

public class FrequentWord {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder fullText = new StringBuilder();
        String currentLine;

        while ((currentLine = input.readLine()) != null) {
            fullText.append(currentLine).append(" ");
        }

        String[] tokens = fullText.toString().trim().split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : tokens) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String mostCommon = tokens[0];
        int highest = wordCount.get(mostCommon);

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > highest || (value == highest && key.compareTo(mostCommon) < 0)) {
                highest = value;
                mostCommon = key;
            }
        }

        output.write(mostCommon);
        output.newLine();

        input.close();
        output.flush();
        output.close();
    }
}
