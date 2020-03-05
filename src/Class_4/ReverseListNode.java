package Class_4;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/1/6
 */
public class ReverseListNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(node1);
        Node curr = reverseNode(node1);
        System.out.println(curr);
        Node curr2 = reverseNode(curr);
        System.out.println(node1);
        System.out.println(curr2);
    }

    public static Node reverseNode(Node node){
        Node cur = node;
        Node pre = null;
        Node next = null;
        while(cur != null){
            next = cur.next;//首先保存当前节点的下一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

