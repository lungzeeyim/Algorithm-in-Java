public class IsBst {
    public boolean isBst(TreeNode root) {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(TreeNode root, int min, int max) {
        if (root == null) {return true;}
        if (root.key < min || root.key > max) {return false;}
        return isBst(root.left, min, root.key - 1) && isBst(root.right, root.key+1, max);
    }

    public static void main(String[] args) {
     /*
         10[-inf, inf]
        /  \
       5    15  
      / \   / \
           12 
 */    
        TreeNode tn1 = new TreeNode(10);
        TreeNode tn2 = new TreeNode(5);
        TreeNode tn3 = new TreeNode(15);
        TreeNode tn4 = new TreeNode(12);
        TreeNode tn5 = new TreeNode(14);
        tn1.left = tn2;
        tn1.right = tn3;
        tn3.left = tn4;
        
        IsBst is = new IsBst();
        boolean res = is.isBst(tn1);
        System.out.println(res);

        // 反例
        tn3.right = tn5;
        res = is.isBst(tn1);
        System.out.println(res);

    }
}
