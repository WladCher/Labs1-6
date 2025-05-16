import java.util.*;

public class ForkOutput {

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

    private static void findForks(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left != null && node.right != null) {
            result.add(node.key);
        }
        findForks(node.left, result);
        findForks(node.right, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int value = scanner.nextInt();
            if (value == 0) break;
            root = add(root, value);
        }

        List<Integer> forkNodes = new ArrayList<>();
        findForks(root, forkNodes);
        Collections.sort(forkNodes);

        for (int val : forkNodes) {
            System.out.println(val);
        }
    }
}
