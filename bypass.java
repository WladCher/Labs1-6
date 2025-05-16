import java.util.Scanner;

class BinarySearchTree {
    static class TreeNode {
        int key;
        TreeNode left, right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    private TreeNode root;

    public void add(int key) {
        root = addRecursive(root, key);
    }

    private TreeNode addRecursive(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }
        if (key < node.key) {
            node.left = addRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = addRecursive(node.right, key);
        }
        return node;
    }

    public void printInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode node) {
        if (node == null) return;
        traverseInOrder(node.left);
        System.out.println(node.key);
        traverseInOrder(node.right);
    }
}

public class bypass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            if (value == 0) break;
            bst.add(value);
        }

        bst.printInOrder();
        scanner.close();
    }
}
