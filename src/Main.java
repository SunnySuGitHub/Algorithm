import java.util.*;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/9/4
 */
import java.util.Scanner;

/**
 * @Author: Mr.Xu
 * @Date: Created in 19:42 2019/9/6
 * @Description:二叉树字符串解析
 */
public class Main {
    static String solution(String input){
        if(input == null || input.length() == 0) return "";
        int curIdx = 0;
        String s = getData(input,curIdx);
        Node cur = new Node(s);
        Node root = cur;
        curIdx += s.length();
        while(curIdx < input.length()){
            if(input.charAt(curIdx) == '('){
                curIdx ++;
                String data = getData(input,curIdx);
                if(data == null){
                    curIdx++;
                    String d = getData(input,curIdx);
                    curIdx += d.length();
                    Node node = new Node(d);
                    cur.right = node;
                    node.parent = cur;
                    cur = node;
                }else{
                    Node node = new Node(data);
                    curIdx += data.length();
                    cur.left = node;
                    node.parent = cur;
                    cur = node;
                }
            }else if(input.charAt(curIdx) == ')'){
                cur = cur.parent;
                curIdx++;
            }else if(input.charAt(curIdx) == ','){
                cur = cur.parent;
                curIdx++;
                String data = getData(input,curIdx);
                if(data != null){
                    curIdx += data.length();
                    Node node = new Node(data);
                    cur.right = node;
                    node.parent = cur;
                    cur = node;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        InOrder(root,res);
        return res.toString();
    }

    private static void InOrder(Node cur, StringBuilder res) {
        if(cur == null) return;
        InOrder(cur.left,res);
        res.append(cur.data);
        InOrder(cur.right,res);
    }

    private static String getData(String input, int i) {
        StringBuilder sb = new StringBuilder();
        if(!isDigit(input.charAt(i))) return null;
        while(i < input.length() && isDigit(input.charAt(i))){
            sb.append(input.charAt(i++));
        }
        return sb.toString();
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        solution("1(2(3,4(,5)),6(7,))");
    }
}

class Node{
    Node parent;
    Node left;
    Node right;
    String data;
    public Node(String data){
        this.data = data;
    }
}

