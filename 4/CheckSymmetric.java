public class CheckSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {return true;}
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode one, TreeNode two) {
        if (one == null && two == null) {return true;}
        else if (one == null || two == null) {return false;}
        else if (one.key != two.key) {return false;}
        return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }

    public static void main(String[] args) {
/*
         10
        /  \
       5    5  
      / \   / \
     1  2   2  1
 */    
        TreeNode tn1 = new TreeNode(10);
        TreeNode tn2 = new TreeNode(5);
        TreeNode tn3 = new TreeNode(5);
        TreeNode tn4 = new TreeNode(1);
        TreeNode tn5 = new TreeNode(2);
        TreeNode tn6 = new TreeNode(2);
        TreeNode tn7 = new TreeNode(1);
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        // case 1
        tn3.left = tn6;
        tn3.right = tn7;

        CheckSymmetric check = new CheckSymmetric();
        System.out.println(check.isSymmetric(tn1));
/*
         10
        /  \
       5    5  
      / \   / \
     1  2   2  3
 */
        // 反例
        TreeNode tn8 = new TreeNode(3);
        tn3.right = tn8;
        System.out.println(check.isSymmetric(tn1));
    }
     

}
