import java.util.Scanner;

public class TreeHeight {

    static class TreeNode {
        int key;
        TreeNode left, right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    private static TreeNode add(TreeNode node, int key) {
        if (node == null) return new TreeNode(key);
        if (key < node.key) node.left = add(node.left, key);
        else if (key > node.key) node.right = add(node.right, key);
        return node;
    }

    private static int calculateHeight(TreeNode node) {
        if (node == null) return 0;
        int left = calculateHeight(node.left);
        int right = calculateHeight(node.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int value = scanner.nextInt();
            if (value == 0) break;
            root = add(root, value);
        }

        System.out.println(calculateHeight(root));
    }
}
