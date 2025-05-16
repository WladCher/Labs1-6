class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            insert(root, num);
        }

        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, query(root, num));
        }
        return maxXor;
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }

    private int query(TrieNode root, int num) {
        TrieNode node = root;
        int xor = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = bit ^ 1;
            if (node.child[opposite] != null) {
                xor |= (1 << i);
                node = node.child[opposite];
            } else {
                node = node.child[bit];
            }
        }
        return xor;
    }
}
