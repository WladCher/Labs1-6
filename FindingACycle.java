import java.util.*;

public class FindingACycle {

    private static int cycleStart = -1;
    private static int cycleEnd = -1;

    private static boolean detectCycle(int node, int parent, int size, int[][] matrix, boolean[] visited, int[] parents) {
        visited[node] = true;
        parents[node] = parent;

        for (int neighbor = 0; neighbor < size; neighbor++) {
            if (matrix[node][neighbor] == 1) {
                if (neighbor == parent) continue;

                if (visited[neighbor]) {
                    cycleStart = neighbor;
                    cycleEnd = node;
                    return true;
                }

                if (detectCycle(neighbor, node, size, matrix, visited, parents)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int[][] graph = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && detectCycle(i, -1, vertices, graph, visited, parent)) {
                break;
            }
        }

        if (cycleStart == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            List<Integer> path = new ArrayList<>();
            int node = cycleEnd;
            while (node != cycleStart) {
                path.add(node + 1);
                node = parent[node];
            }
            path.add(cycleStart + 1);

            System.out.println(path.size());
            Collections.reverse(path);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
