import java.util.*;

public class PostOrder {
    public List<Integer> postOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> dque = new LinkedList<TreeNode>();
        dque.offerFirst(root);
        while (!dque.isEmpty()) {
            TreeNode cur = dque.pollFirst();
            result.add(cur.key);
            if (cur.left != null) {
                dque.offerFirst(cur.left);
            }
            if (cur.right != null) {
                dque.offerFirst(cur.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] arsgs) {
        TreeNode tn1 = new TreeNode(5);
        TreeNode tn2 = new TreeNode(3);
        TreeNode tn3 = new TreeNode(8);
        TreeNode tn4 = new TreeNode(1);
        TreeNode tn5 = new TreeNode(4);
        TreeNode tn6 = new TreeNode(11);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.right = tn6;

        PostOrder po = new PostOrder();
        List<Integer> list = po.postOrder1(tn1);
        System.out.println(list.toString());


    }
}

/* 
        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]



*/
