import java.util.*;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacency.get(from).add(to);
            adjacency.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        return dfs(adjacency, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int current, int target, boolean[] visited) {
        if (current == target) return true;

        visited[current] = true;

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor] && dfs(graph, neighbor, target, visited)) {
                return true;
            }
        }

        return false;
    }
}
