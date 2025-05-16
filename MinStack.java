import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private final Deque<Integer> mainStack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int value) {
        mainStack.push(value);
        minStack.push(Math.min(value, minStack.peek()));
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
