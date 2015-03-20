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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null)
            return res;
            
        List<Integer> item = new ArrayList<Integer>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        
        int currentLevel = 1;
        int nextLevel = 0;
        int counter = 0;
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            currentLevel--;
            item.add(curr.val);
            
            if (curr.left != null) {
                q.offer(curr.left);
                nextLevel++;
            }
            
            if (curr.right != null) {
                q.offer(curr.right);
                nextLevel++;
            }
            
            if (currentLevel == 0) {
                if (counter % 2 == 0) {
                    res.add(new ArrayList(item));
                } else {
                    Collections.reverse(item);
                    res.add(new ArrayList(item));
                }
                item = new ArrayList();
                currentLevel = nextLevel;
                nextLevel = 0;
                counter++;
            }
        }
        
        return res;
    }
}