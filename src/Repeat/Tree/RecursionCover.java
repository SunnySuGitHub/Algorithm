package Repeat.Tree;

/**
 * Description:递归遍历二叉树
 * Created by Administrator on 2019/4/1
 */
public class RecursionCover {
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
        preOrder(treeNode1);
        System.out.print("\n");
        midOrder(treeNode1);
        System.out.print("\n");
        lastOrder(treeNode1);
    }

    private static void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void midOrder(TreeNode root){
        if(root == null){
            return;
        }

        midOrder(root.left);
        System.out.print(root.val);
        midOrder(root.right);
    }

    private static void lastOrder(TreeNode root){
        if(root == null){
            return;
        }

        lastOrder(root.left);
        lastOrder(root.right);
        System.out.print(root.val);
    }

}
