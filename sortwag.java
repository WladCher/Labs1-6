import java.util.*;

public class sortwag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagonCount = scanner.nextInt();
        int[] sequence = new int[wagonCount];

        for (int i = 0; i < wagonCount; i++) {
            sequence[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(isSortable(wagonCount, sequence) ? "YES" : "NO");
    }

    public static boolean isSortable(int n, int[] order) {
        Deque<Integer> siding = new ArrayDeque<>();
        int current = 1;

        for (int wagon : order) {
            siding.push(wagon);
            while (!siding.isEmpty() && siding.peek() == current) {
                siding.pop();
                current++;
            }
        }

        return siding.isEmpty();
    }
}
