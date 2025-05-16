import java.util.*;

public class ConnectivityComponents {

    private static List<List<Integer>> adjacencyList;
    private static boolean[] explored;
    private static List<List<Integer>> allComponents;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        adjacencyList = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        }

        explored = new boolean[vertices + 1];
        allComponents = new ArrayList<>();

        for (int i = 1; i <= vertices; i++) {
            if (!explored[i]) {
                List<Integer> currentComponent = new ArrayList<>();
                explore(i, currentComponent);
                allComponents.add(currentComponent);
            }
        }

        System.out.println(allComponents.size());
        for (List<Integer> component : allComponents) {
            System.out.println(component.size());
            for (int node : component) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private static void explore(int start, List<Integer> group) {
        explored[start] = true;
        group.add(start);
        for (int neighbor : adjacencyList.get(start)) {
            if (!explored[neighbor]) {
                explore(neighbor, group);
            }
        }
    }
}
