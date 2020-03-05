package Class_5;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:二叉树的序列化与反序列化
 * 序列化：转换成字符串
 * 反序列化：根据序列化字符串反构造二叉树
 * Created by Administrator on 2019/1/7
 */
public class Serial {
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
        String str = serialByPre(treeNode1);
        System.out.println(str);
        System.out.println(reconByPreString(str));
    }

    private static String serialByPre(TreeNode node) {
        if (node == null) {
            return "#!";
        }
        String res = node.val + "!";
        res = res + serialByPre(node.left);
        res = res + serialByPre(node.right);
        return res;
    }

    private static TreeNode reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("!")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = reconPreOrder(queue);
        root.right = reconPreOrder(queue);
        return root;
    }

    private static String serialByLevel(TreeNode node) {
        if (node == null) {
            return "#!";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String res = node.val + "!";
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                res = res + cur.left.val + "!";
                queue.offer(cur.left);
            } else {
                res = res + "#!";
            }
            if (cur.right != null) {
                res = res + cur.right.val + "!";
                queue.offer(cur.right);
            } else {
                res = res + "#!";
            }
        }
        return res;
    }

    private static TreeNode reconByLevelString(String str) {
        if (str.equals("#!")) {
            return null;
        }
        String[] values = str.split("!");
        int index = 0;
        TreeNode root = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    private static TreeNode generateNodeByString(String val) {
        if (val.equals("#!")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}
