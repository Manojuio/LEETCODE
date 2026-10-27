class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currentLevel.add(node);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            // Swap values for odd levels
            if (level % 2 == 1) {
                int left = 0, right = currentLevel.size() - 1;
                while (left < right) {
                    int temp = currentLevel.get(left).val;
                    currentLevel.get(left).val = currentLevel.get(right).val;
                    currentLevel.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}