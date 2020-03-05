package Class_5;

/**
 * Description:已知一颗完全二叉树，求其节点的个数。要求时间复杂度小于O(N)
 * 如果一棵树是满二叉树，高度为L，它的节点个数为2^L-1
 * Created by Administrator on 2019/1/7
 */
public class GetNodeNums {
    public static void main(String[] args) {

    }

    private static int getNodeNums(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return bs(node, 1, mostLeftLevel(node, 1));
    }

    /**
     * node代表当前节点，level代表当前节点在第几层，h代表整棵树的深度
     * 对于完全二叉树，整棵树的深度就是最左子树的深度
     * 返回的结果是该完全二叉树的节点的个数
     */
    private static int bs(TreeNode node, int level, int h) {
        if (level == h) {
            return 1;
        }
        //一个节点右子树到达最后一层，则它的左子树肯定是满的
        //一个节点的右子树没有到达最后一层，则它的(右子树层数 - 1)肯定是满的
        if (mostLeftLevel(node.right, level + 1) == h) {
            //节点的右子树到达最后一层
            //当前节点的左子树为满二叉树，2^(h-level) - 1 + 1就是当前节点，再加上当前节点右子树的bs
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            //节点的右子树没有到达最后一层，(右子树层数 - 1)是满的，将当前节点的左孩子及以下的当做一个新的完全二叉树再去递归解决
            //当前节点的右子树 - 1为满二叉树，2^(h-level-1)-1+1，再加上当前节点左子树的bs
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    /**
     * node代表当前节点，level代表当前节点在第几层
     * 返回以node节点为root的完全二叉树的层数
     */
    private static int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
