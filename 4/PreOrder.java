public class PreOrder {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null) {
            return preorder;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst(); // retrieves and removes the first element of this list, or returns null if this list is empty.
            if (cur.right != null) {
                stack.offerFirst(cur.right);  // Inserts the specified element at the front of this deque 
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            preorder.add(cur.key);   // [arraylist.add] Appends the specified element to the end of this list. 会返回是否成功
        }
        return preorder;
    }
}
