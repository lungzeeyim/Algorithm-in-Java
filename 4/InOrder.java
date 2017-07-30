import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

public class InOrder {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        // Deque: A linear collection that supports element insertion and removal at both ends. The name deque is short for "double ended queue"
        Deque<TreeNode>stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);   // 加在头上
                cur = cur.left;
            } else {
                cur = stack.pollFirst();  // 玲出第一个元素
                inorder.add(cur.key);
                cur = cur.right;
            }
        }
        return inorder;
    }

    public static void main(String[] args) {
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

        InOrder ino = new InOrder();
        List<Integer> list = ino.inOrder(tn1);
        System.out.println(list.toString());
    }
}


/* 
        5

      /    \

    3        8

  /   \        \

1      4        11

Output: In-order traversal is [1, 3, 4, 5, 8, 11]  顺序

s[]
i[1,3,4,5,8,11]

*/
