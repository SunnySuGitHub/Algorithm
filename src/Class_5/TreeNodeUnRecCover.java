package Class_5;


import java.util.Stack;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/1/7
 */
public class TreeNodeUnRecCover {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        preOrderUnRecur(treeNode1);
        posOrderUnRecur1(treeNode1);
    }

    private static void preOrderUnRecur(TreeNode head) {//非递归实现先序遍历
        System.out.print("preOrder Start:" + " ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {//有右先压右
                    stack.push(head.right);
                }
                if (head.left != null) {//有左后压左
                    stack.push(head.left);
                }
            }
        }
    }

    private static void inOrderUnRecur(TreeNode head) {//非递归实现中序遍历
        System.out.print("inOrderUnRecur Start:" + " ");
        Stack<TreeNode> stack = new Stack<>();
        if (head != null) {
            stack.push(head);
            while (!stack.isEmpty() || head != null) {
                if(head != null){//如果当前节点不为空，持续压他的左边界
                    stack.push(head);
                    head = head.left;
                } else {//如果当前节点为空，打印弹出的栈顶元素，并将head指向栈顶元素的右孩子
                    //如果当前节点为空，弹出的必定是空节点的父节点，再查看该父节点是否有右孩子
                    //如果有右孩子，将右孩子压栈
                    //如果没有右孩子，继续弹出栈顶元素，此时栈顶元素是父节点的父节点
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    private static void posOrderUnRecur1(TreeNode head){
        System.out.print("posOrderUnRecur Start:"+ " ");
        if(head != null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().val + " ");
            }
        }
    }
}
