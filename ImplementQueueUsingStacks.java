import java.util.Stack;

public class ImplementQueueUsingStacks {

    private final Stack<Integer> inputStack;
    private final Stack<Integer> outputStack;

    public ImplementQueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        shiftStacks();
        return outputStack.pop();
    }

    public int peek() {
        shiftStacks();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
