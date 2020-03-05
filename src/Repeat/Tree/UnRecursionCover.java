package Repeat.Tree;

import Thread.ThreadPool.ParallelStreamAPI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description:非递归遍历二叉树
 * Created by Administrator on 2019/4/1
 */
public class UnRecursionCover {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
//        treeNode5.right = treeNode8;
//        treeNode8.left = treeNode9;
        System.out.println(find(treeNode1));
    }

    private static void preOrderUnRec(TreeNode root) {//用栈
        System.out.println("前序遍历开始：");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                System.out.print(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        System.out.println("\r");
        System.out.println("前序遍历结束");
    }

    private static void midOrderUnRec(TreeNode root) {
        System.out.println("中序遍历开始");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {//当前节点不为空
                    stack.push(root);
                    root = root.left;
                } else {//当前节点为空
                    root = stack.pop();
                    System.out.print(root.val);
                    root = root.right;
                }
            }
        }
        System.out.println("\r");
        System.out.println("中序遍历结束");
    }

    private static int find(TreeNode root) {
        System.out.println("find开始");
        int max = 0;
        int curDepth = 1;
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> subQueue = new LinkedList<>();
            subQueue.offer(root);
            while (true) {
                boolean can = false;
                if (!subQueue.isEmpty()) {
                    Queue t = queue;
                    queue = subQueue;
                    subQueue = t;
                } else {
                    return max;
                }

                while (!queue.isEmpty()) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        subQueue.offer(cur.left);
                        can = true;
                    }
                    if (cur.right != null) {
                        subQueue.offer(cur.right);
                    }
                }
                curDepth++;
                if (can) {
                    max = Math.max(max, curDepth);
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private static void posOrderUnRec(TreeNode root) {//用两个栈
        System.out.println("后序遍历开始：");
        if (root != null) {
            Stack<TreeNode> operateStack = new Stack<>();
            Stack<TreeNode> popStack = new Stack<>();
            operateStack.push(root);
            while (!operateStack.isEmpty()) {
                TreeNode cur = operateStack.pop();
                popStack.push(cur);
                if (cur.left != null) {
                    operateStack.push(cur.left);
                }
                if (cur.right != null) {
                    operateStack.push(cur.right);
                }
            }
            while (!popStack.isEmpty()) {
                System.out.print(popStack.pop().val);
            }
        }
        System.out.println("\r");
        System.out.println("后序遍历结束");
    }

    private static void levelOrderUnRec(TreeNode root) {//用队列
        System.out.println("层序遍历开始：");
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println("\r");
        System.out.println("层序遍历结束");
    }
}
