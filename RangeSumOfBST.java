public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return traverse(root, low, high);
    }

    private int traverse(TreeNode current, int low, int high) {
        if (current == null) return 0;

        int value = current.val;
        int sum = (value >= low && value <= high) ? value : 0;

        if (value > low) {
            sum += traverse(current.left, low, high);
        }
        if (value < high) {
            sum += traverse(current.right, low, high);
        }

        return sum;
    }
}
