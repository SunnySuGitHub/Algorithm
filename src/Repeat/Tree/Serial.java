package Repeat.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:序列化二叉树
 * Created by Administrator on 2019/4/2
 */
public class Serial {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.left = treeNode7;
        TreeNode t = reconByPreString(serialByPre(treeNode1));
        System.out.println(t);
        System.out.println("a");
    }

    private static String serialByPre(TreeNode head){
        String res = "";
        if (head == null){
            return "!#";
        }
        res += head.val + "#";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;

    }

    private static TreeNode reconByPreString(String ss){
        String[] s = ss.split("#");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < s.length; i++){
            queue.offer(s[i]);
        }
        return reconPre(queue);
    }

    private static TreeNode reconPre(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("!")){
            return null;
        }
        TreeNode head = generateNodeByValue(s);
        head.left = reconPre(queue);
        head.right = reconPre(queue);
        return head;
    }

    private static TreeNode generateNodeByValue(String s){
        if(s.equals("!")){
            return null;
        } else {
            return new TreeNode(Integer.valueOf(s));
        }
    }
}
