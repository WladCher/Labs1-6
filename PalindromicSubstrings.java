public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int length = s.length();

        for (int center = 0; center < 2 * length - 1; center++) {
            int left = center / 2;
            int right = (center + 1) / 2;

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
