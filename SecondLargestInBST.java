import java.util.Scanner;

public class SecondLargestInBST {

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
        else node.right = add(node.right, key);
        return node;
    }

    private static int getSecondMax(TreeNode root) {
        TreeNode prev = null;
        TreeNode current = root;

        while (current.right != null) {
            prev = current;
            current = current.right;
        }

        if (current.left != null) {
            current = current.left;
            while (current.right != null) {
                current = current.right;
            }
            return current.key;
        }

        return prev.key;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) break;
            root = add(root, number);
        }

        System.out.println(getSecondMax(root));
    }
}
