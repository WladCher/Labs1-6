import java.util.*;

public class PathInTheGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] adjacency = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjacency[i][j] = scanner.nextInt();
            }
        }

        int start = scanner.nextInt() - 1;
        int target = scanner.nextInt() - 1;

        int[] distances = new int[size];
        int[] predecessors = new int[size];
        Arrays.fill(distances, -1);
        Arrays.fill(predecessors, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor = 0; neighbor < size; neighbor++) {
                if (adjacency[current][neighbor] == 1 && distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1;
                    predecessors[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        if (distances[target] == -1) {
            System.out.println(-1);
        } else {
            List<Integer> path = new ArrayList<>();
            for (int v = target; v != -1; v = predecessors[v]) {
                path.add(v + 1);
            }
            Collections.reverse(path);
            System.out.println(distances[target]);
            for (int node : path) {
                System.out.print(node + " ");
            }
        }

        scanner.close();
    }
}
