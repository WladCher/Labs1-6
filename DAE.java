import java.util.Scanner;

public class DAE {

    static class TreeNode {
        int key;
        TreeNode left, right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    private static int insertAndGetDepth(TreeNode current, int key, int level) {
        if (key < current.key) {
            if (current.left == null) {
                current.left = new TreeNode(key);
                return level + 1;
            } else {
                return insertAndGetDepth(current.left, key, level + 1);
            }
        } else if (key > current.key) {
            if (current.right == null) {
                current.right = new TreeNode(key);
                return level + 1;
            } else {
                return insertAndGetDepth(current.right, key, level + 1);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int input = scanner.nextInt();
            if (input == 0) break;

            if (root == null) {
                root = new TreeNode(input);
                System.out.print("1 ");
            } else {
                int depth = insertAndGetDepth(root, input, 1);
                if (depth != -1) {
                    System.out.print(depth + " ");
                }
            }
        }

        scanner.close();
    }
}
