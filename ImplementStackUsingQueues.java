import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueues {

    private Deque<Integer> primaryQueue = new ArrayDeque<>();
    private Deque<Integer> helperQueue = new ArrayDeque<>();

    public ImplementStackUsingQueues() {
    }

    public void push(int x) {
        helperQueue.offer(x);

        while (!primaryQueue.isEmpty()) {
            helperQueue.offer(primaryQueue.poll());
        }

        Deque<Integer> temp = primaryQueue;
        primaryQueue = helperQueue;
        helperQueue = temp;
    }

    public int pop() {
        return primaryQueue.poll();
    }

    public int top() {
        return primaryQueue.peek();
    }

    public boolean empty() {
        return primaryQueue.isEmpty();
    }
}
