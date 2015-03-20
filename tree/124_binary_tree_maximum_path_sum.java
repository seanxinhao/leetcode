/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private static int max_path_sum;
    
    public int maxPathSum(TreeNode root) {
        max_path_sum = Integer.MIN_VALUE;
        helper(root);
        return max_path_sum;
    }
    
    private int helper(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int left_max = helper(root.left);
        int right_max = helper(root.right);
        int[] curr_max = {root.val, root.val + left_max, root.val + right_max, root.val + left_max + right_max};
        
        for (int i : curr_max) {
            max_path_sum = Math.max(max_path_sum, i);
        }
        
        return Math.max(root.val, Math.max(root.val + left_max, root.val + right_max));
    }
}