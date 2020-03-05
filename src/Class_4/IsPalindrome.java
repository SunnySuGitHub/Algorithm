package Class_4;

import java.util.Stack;

/**
 * Description:判断所给链表是否为回文链表
 * Created by Administrator on 2019/1/6
 */
public class IsPalindrome {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(45);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(45);
        Node node6 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(isPalindrome1(node1));
        System.out.println(isPalindrome2(node1));
        System.out.println(isPalindrome3(node1));
        System.out.println(node1);
    }

    private static boolean isPalindrome1(Node head) {//利用了N的辅助空间
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.peek().val) {
                return false;
            } else {
                head = head.next;
                stack.pop();
            }
        }
        return true;
    }

    private static boolean isPalindrome2(Node head) {//利用N/2的辅助空间
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node oneStep = head;
        Node twoStep = head;
        while (oneStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        oneStep = oneStep.next;
        while (oneStep != null) {
            stack.push(oneStep);
            oneStep = oneStep.next;
        }
        while(!stack.isEmpty()){
            if(stack.peek().val != head.val){
                return false;
            } else {
                stack.pop();
                head = head.next;
            }
        }
        return true;
    }

    private static boolean isPalindrome3(Node head){//空间复杂度为O(1)
        if(head == null || head.next == null){
            return true;
        }
        Node oneStep = head;
        Node twoStep = head;
        while (oneStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        Node dummyHead = oneStep.next;
        Node last = ReverseListNode.reverseNode(dummyHead);
        Node cur = last;
        while(cur != null){
            if(cur.val != head.val){
                return false;
            }
            cur = cur.next;
            head = head.next;
        }
        oneStep.next = ReverseListNode.reverseNode(last);
        return true;
    }
}

