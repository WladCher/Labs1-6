import java.util.*;

public class BranchOutput {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private static TreeNode addNode(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.data) root.left = addNode(root.left, value);
        else if (value > root.data) root.right = addNode(root.right, value);
        return root;
    }

    private static void findSingleChildNodes(TreeNode node, List<Integer> result) {
        if (node == null) return;

        boolean onlyLeft = node.left != null && node.right == null;
        boolean onlyRight = node.right != null && node.left == null;

        if (onlyLeft || onlyRight) {
            result.add(node.data);
        }

        findSingleChildNodes(node.left, result);
        findSingleChildNodes(node.right, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int input = scanner.nextInt();
            if (input == 0) break;
            root = addNode(root, input);
        }

        List<Integer> singles = new ArrayList<>();
        findSingleChildNodes(root, singles);
        Collections.sort(singles);

        for (int value : singles) {
            System.out.println(value);
        }
    }
}
