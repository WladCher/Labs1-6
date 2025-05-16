import java.util.*;

public class AWL {

    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode add(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.value) root.left = add(root.left, value);
        else if (value > root.value) root.right = add(root.right, value);
        return root;
    }

    static class TreeStatus {
        boolean isBalanced;
        int height;

        TreeStatus(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private static TreeStatus analyze(TreeNode node) {
        if (node == null) return new TreeStatus(true, 0);

        TreeStatus left = analyze(node.left);
        TreeStatus right = analyze(node.right);

        boolean balanced = left.isBalanced && right.isBalanced &&
                Math.abs(left.height - right.height) <= 1;
        int height = 1 + Math.max(left.height, right.height);

        return new TreeStatus(balanced, height);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) break;
            root = add(root, number);
        }

        boolean balanced = analyze(root).isBalanced;
        System.out.println(balanced ? "YES" : "NO");
    }
}
