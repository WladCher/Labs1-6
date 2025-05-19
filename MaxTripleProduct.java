import java.util.*;

public class MaxTripleProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        scanner.close();

        int[] numbers = Arrays.stream(inputLine.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(numbers);

        int length = numbers.length;

        int productFromMax = numbers[length - 1] * numbers[length - 2] * numbers[length - 3];
        int productFromMins = numbers[0] * numbers[1] * numbers[length - 1];

        if (productFromMax >= productFromMins) {
            printTriple(numbers[length - 3], numbers[length - 2], numbers[length - 1]);
        } else {
            printTriple(numbers[0], numbers[1], numbers[length - 1]);
        }
    }

    private static void printTriple(int a, int b, int c) {
        System.out.println(a + " " + b + " " + c);
    }
}
