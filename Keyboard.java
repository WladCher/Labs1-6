import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numKeys = Integer.parseInt(scanner.nextLine());
        int[] keyDurabilities = parseLineToIntArray(scanner.nextLine(), numKeys);

        int numPresses = Integer.parseInt(scanner.nextLine());
        int[] pressFrequencies = new int[numKeys];
        updatePressFrequencies(scanner.nextLine(), pressFrequencies);

        checkDurability(keyDurabilities, pressFrequencies);

        scanner.close();
    }

    private static int[] parseLineToIntArray(String line, int expectedLength) {
        String[] tokens = line.trim().split("\\s+");
        int[] result = new int[expectedLength];
        for (int i = 0; i < expectedLength; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    private static void updatePressFrequencies(String pressesLine, int[] frequencies) {
        String[] keys = pressesLine.trim().split("\\s+");
        for (String key : keys) {
            int keyIndex = Integer.parseInt(key) - 1;
            if (keyIndex >= 0 && keyIndex < frequencies.length) {
                frequencies[keyIndex]++;
            }
        }
    }

    private static void checkDurability(int[] durability, int[] presses) {
        for (int i = 0; i < durability.length; i++) {
            System.out.println(presses[i] > durability[i] ? "YES" : "NO");
        }
    }
}
