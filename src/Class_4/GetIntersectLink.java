package Class_4;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/1/6
 */
public class GetIntersectLink {
    public static void main(String[] args) {

    }

    private static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
//            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;//一个有环，另一个无环，必不可能相交

    }

    private static Node getLoopNode(Node head) {
        if (head == null) {
            return null;
        }
        Node n1 = head.next;//慢指针，一次移动一个
        Node n2 = head.next.next;//快指针，一次移动两个
        while (n1 != n2) {
            if (n1 == null || n2 == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;//代表n1与n2已经相遇，快指针n2回到头结点
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;

        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;//head1是长的链表
        cur2 = cur1 == head1 ? head2 : head1;//head2是短的链表
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

//    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
//
//    }
}
