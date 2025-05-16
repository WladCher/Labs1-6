import java.util.*;

public class skoboch {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine().trim();
        System.out.println(checkBrackets(input));
    }

    private static String checkBrackets(String text) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : text.toCharArray()) {
            if (isOpening(ch)) {
                stack.push(ch);
            } else if (isClosing(ch)) {
                if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                    return "no";
                }
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }

    private static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
