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
    public TreeNode sortedArrayToBST(int[] num) {
        return helper(num, 0, num.length - 1);
    }
    
    private TreeNode helper(int[] num, int start, int end) {
        if (start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode r = new TreeNode(num[mid]);
        r.left = helper(num, start, mid - 1);
        r.right = helper(num, mid + 1, end);
        
        return r;
    }
}