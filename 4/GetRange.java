// Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.
import java.util.*;

public class GetRange {    
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer>list = new ArrayList<Integer>();
        getRange(root, min, max, list);
        return list;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer>list) {
        if (root == null) {
            return;
        }
        if (root.key > min) {
            getRange(root.left, min, max, list);
      
        }
        if ((root.key >= min) && (root.key <= max)) {
            list.add(root.key);
        }
        if (root.key < max) {
            getRange(root.right, min, max, list);
        }
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

        tn1.left = tn2;
        tn1.right = tn3;
        tn3.left = tn4;
        GetRange get = new GetRange();
        List<Integer>list = get.getRange(tn1, 5, 11);
        System.out.println(list.toString());
        
    }
}
