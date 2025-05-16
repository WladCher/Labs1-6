import java.util.*;

public class RoomArea {

    static int size;
    static char[][] grid;
    static boolean[][] explored;
    static final int[] dRow = {-1, 1, 0, 0};
    static final int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = Integer.parseInt(scanner.nextLine());
        grid = new char[size][size];
        explored = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;

        System.out.println(exploreArea(row, col));
    }

    private static int exploreArea(int startX, int startY) {
        int area = 0;
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.offer(new int[]{startX, startY});
        explored[startX][startY] = true;

        while (!toVisit.isEmpty()) {
            int[] position = toVisit.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int newX = position[0] + dRow[i];
                int newY = position[1] + dCol[i];

                if (newX >= 0 && newY >= 0 && newX < size && newY < size &&
                        !explored[newX][newY] && grid[newX][newY] == '.') {
                    explored[newX][newY] = true;
                    toVisit.offer(new int[]{newX, newY});
                }
            }
        }

        return area;
    }
}
