import java.util.*;

public class goblandsham {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operations = scanner.nextInt();

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < operations; i++) {
            String cmd = scanner.next();
            switch (cmd) {
                case "+":
                    int goblinBack = scanner.nextInt();
                    right.addLast(goblinBack);
                    balance(left, right);
                    break;
                case "*":
                    int goblinMiddle = scanner.nextInt();
                    right.addFirst(goblinMiddle);
                    balance(left, right);
                    break;
                case "-":
                    result.append(left.pollFirst()).append("\n");
                    balance(left, right);
                    break;
            }
        }

        scanner.close();
        System.out.print(result);
    }

    private static void balance(Deque<Integer> left, Deque<Integer> right) {
        while (left.size() < right.size()) {
            left.addLast(right.pollFirst());
        }
    }
}
