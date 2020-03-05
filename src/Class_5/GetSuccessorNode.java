package Class_5;


/**
 * Description:寻找一个节点的中序后继节点
 * Created by Administrator on 2019/1/7
 */
public class GetSuccessorNode {
    public static void main(String[] args) {

    }

    private static TreeNode getSuccessorNode(TreeNode node) {
        if(node == null){
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {

        }
        return null;
    }
}
