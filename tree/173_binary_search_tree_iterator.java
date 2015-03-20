/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private LinkedList<TreeNode> stack;
    private TreeNode next;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            next = stack.pop();
            TreeNode curr = next.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        
        return next.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */