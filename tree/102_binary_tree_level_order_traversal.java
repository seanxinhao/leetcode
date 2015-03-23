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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null)
            return res;
            
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            List<Integer> item = new ArrayList<Integer>();
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                item.add(curr.val);
                
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            
            res.add(item);
        }
        
        return res;
    }
}