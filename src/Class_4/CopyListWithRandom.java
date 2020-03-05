package Class_4;

import java.util.HashMap;

/**
 * Description:复制链表
 * Created by Administrator on 2019/1/6
 */
public class CopyListWithRandom {
    public static void main(String[] args) {

    }

    private static Node copyListWithRan1(Node head) {//采用HashMap结构，占用额外空间，空间复杂度为O(N)
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {//将每一个节点都放到HashMap中
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    private static Node copyListWithRan2(Node head) {//不使用HashMap，空间复杂度为O(1)
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {//在每一个节点后面都加一个复制的节点，并设置每个复制节点的next指针
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copyNode = null;
        while (cur != null) {//设置每个复制节点的rand指针
            copyNode = cur.next;
            next = cur.next.next;
            copyNode.rand = cur.rand == null ? null : cur.rand.next;
            cur = next;
        }
        //分离该结构
        cur = head;
        Node res = head.next;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next == null ? null : next.next;
            cur = next;
        }
        return res;
    }
}


