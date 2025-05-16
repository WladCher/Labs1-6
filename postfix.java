import java.util.*;

public class postfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expressionLine = scanner.nextLine().trim();
        scanner.close();

        int result = calculatePostfix(expressionLine);
        System.out.println(result);
    }

    public static int calculatePostfix(String expr) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = expr.split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int right = stack.pop();
                int left = stack.pop();
                switch (token) {
                    case "+": stack.push(left + right); break;
                    case "-": stack.push(left - right); break;
                    case "*": stack.push(left * right); break;
                    default: throw new RuntimeException("Неизвестный оператор: " + token);
                }
            }
        }
        return stack.pop();
    }
}
