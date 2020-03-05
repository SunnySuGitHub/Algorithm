package Class_5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:判断某二叉树是否为完全二叉树
 * Created by Administrator on 2019/1/7
 */
public class IsCBT {
    public static void main(String[] args) {

    }

    private static boolean isBCT(TreeNode node){
        if(node == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        boolean isLeaf = false;
        TreeNode left = null;
        TreeNode right = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            left = node.left;
            right = node.right;
            if(left == null && right != null){//左孩子为空但是右孩子不为空
                return false;
            }
            if((left != null || right != null) && isLeaf){//只要左右孩子中有一个非空，并且该节点所在行是叶节点之后
                return false;
            }
            if(left != null){
                queue.offer(left);
            }
            if(right != null){
                queue.offer(right);
            } else {
                isLeaf = true;
            }
        }
        return true;
    }
}
