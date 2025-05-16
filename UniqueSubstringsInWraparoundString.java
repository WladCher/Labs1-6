import java.util.Arrays;

public class Solution {

    public int findSubstringInWraproundString(String s) {
        int[] maxLengths = new int[26];
        int currentStreak = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }

            int index = s.charAt(i) - 'a';
            maxLengths[index] = Math.max(maxLengths[index], currentStreak);
        }

        return Arrays.stream(maxLengths).sum();
    }
}
