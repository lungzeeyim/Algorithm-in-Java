public class ReOrderLinkedList {

    public ListNode reorder(ListNode head) {

        if (head == null || head.next == null) {

            return head;

        }

        // 1.find the middle node

        ListNode  mid = middleNode(head);

        ListNode one = head;

        ListNode two = mid.next;

        mid.next = null;

        return merge(one, reverse(two));

    }



    private ListNode middleNode(ListNode head) {

        ListNode slow = head;

        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;

            fast = fast.next.next;

        }

        return slow;

    }



    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {

            return head;

        }

        ListNode prev = null;

        while (head != null) {

            ListNode next = head.next;

            head.next = prev;

            prev = head;

            head = next;

        }

        return prev;

    }



    private ListNode merge(ListNode one, ListNode two) {

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        while (one != null && two != null) {

            cur.next = one;

            one = one.next;

            cur.next.next = two;

            two = two.next;

            cur = cur.next.next;

        }

        if (one != null) {

            cur.next = one;

        } else {

            cur.next = two;

        }

        return dummy.next;

    }

    private void printf(ListNode head) {
        ListNode temp = new ListNode(0);
        temp = head;
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReOrderLinkedList rl = new ReOrderLinkedList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        System.out.println("1 -> 2 -> 3 -> 4 -> null");
        one.next = two;
        two.next = three;
        three.next = four;

        rl.reorder(one);
        rl.printf(one);
    }
}
