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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        preorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void preorder(TreeNode curr) {
        if (curr == null)
            return;
            
        preorder(curr.left);
        
        if (first == null && curr.val < prev.val)
            first = prev;
            
        if (first != null && curr.val < prev.val)
            second = curr;
        
        prev = curr;    
        
        preorder(curr.right);
    }
}