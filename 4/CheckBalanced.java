public class CheckBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {return true;}
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        
        if (root == null) {return 0;}
        System.out.println(root.key);
        int leftHeight = height(root.left);
        if (leftHeight == -1) {return -1;}
        int rightHeight = height(root.right);
        if (rightHeight == -1) {return -1;}

        System.out.println(leftHeight + " - " + rightHeight);
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(8);
        TreeNode four = new TreeNode(1);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(11);
        TreeNode seven = new TreeNode(14);
        
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;
        CheckBalanced check = new CheckBalanced();
        System.out.println(check.isBalanced(one));

        // 反例
        six.right = seven;
        System.out.println(check.isBalanced(one));
    }
    
}

/*

        5

      /    \

    3        8     

  /   \        \  2

1      4        11   

                 \  1

                  14


*/
