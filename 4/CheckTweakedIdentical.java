public class CheckTweakedIdentical {
    public boolean isIdentical(TreeNode one, TreeNode two){
        if (one == null && two == null) {
            if (one == null && two == null) {
                return true;
            }
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return isIdentical(one.left, two.left) && isIdentical(one.right, two.right) || isIdentical(one.left, two.right) && isIdentical(one.right, two.left);
    }

    public static void main(String[] args) {
/*
         10
        /  \
       5    5  
      / \   / \
     1  2   2  1

         10
        /  \
       5     5  
      / \   / \
     1  2   1 2
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

        CheckTweakedIdentical check = new CheckTweakedIdentical();
        System.out.println(check.isIdentical(tn2, tn3));

        // case 2
        tn3.left = tn7;
        tn3.right = tn6;
        System.out.println(check.isIdentical(tn2, tn3));
    }
}
