import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]
        );

        int length = nums.length;
        int[] result = new int[length - k + 1];

        for (int i = 0; i < k - 1; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }

        for (int i = k - 1, idx = 0; i < length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            result[idx++] = maxHeap.peek()[0];
        }

        return result;
    }
}
