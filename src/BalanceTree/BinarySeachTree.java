package BalanceTree;

/**
 * Description:二叉查找树
 *
 * 对于一般的二叉搜索树（Binary Search Tree），其期望高度（即为一棵平衡树时）为log2n，
 * 其各操作的时间复杂度（O(log2n)）同时也由此而决定。
 *
 * 但是，在某些极端的情况下（如在插入的序列是有序的时），二叉搜索树将退化成近似链，
 * 此时，其操作的时间复杂度将退化成线性的，即O(n)。
 *
 * 我们可以通过随机化建立二叉搜索树来尽量的避免这种情况，但是在进行了多次的操作之后，
 * 由于在删除时，我们总是选择将待删除节点的后继代替它本身，这样就会造成总是右边的节点数目减少，
 * 以至于树向左偏沉。这同时也会造成树的平衡性受到破坏，提高它的操作的时间复杂度。
 *
 * Created by Administrator on 2019/3/22
 */
public class BinarySeachTree {

    TreeNode root = null;

    /**
     * 插入节点
     */
    public void insert(int val){
        TreeNode node = new TreeNode(val);
        TreeNode parent = root;
        TreeNode curr = parent;
        if(root == null){
            root = node;
        } else {
            while(true){
                if(val < parent.val){
                    curr = parent.left;
                    if(curr == null){
                        parent.left = node;
                        break;
                    } else {
                        parent = curr;
                    }
                } else if(val > parent.val) {
                    curr = parent.right;
                    if(curr == null){
                        parent.right = node;
                        break;
                    } else {
                        parent = curr;
                    }
                } else if(val == parent.val){
                    curr = parent.left;
                    parent.left = node;
                    node.left = curr;
                    break;
                }
            }

        }
    }

    /**
     * 查找节点
     */
    public boolean hasVal(int val){
        TreeNode cur = root;
        while(cur != null && cur.val != val){
            if(val < cur.val){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if(cur == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 删除节点
     */
    public boolean delete(int val){
            boolean isLeft = true;
            TreeNode cur = root;
            TreeNode delParent = null;
            while(cur != null && cur.val != val){
                delParent = cur;
                if(val < cur.val){
                    cur = cur.left;
                    isLeft = true;
                } else {
                    cur = cur.right;
                    isLeft = false;
                }
            }
            if(cur == null) {//没有找到要删除的节点
                return false;
            }
            /**
             * 被删除的节点左右子树都为空，直接删除
             */
            if(cur.left == null && cur.right == null){
                if(isLeft){
                    delParent.left = null;
                } else {
                    delParent.right = null;
                }
                return true;
            }

            /**
             * 被删除的子树有左子树或者右子树
             */
            if(cur.left == null && cur.right != null){
                TreeNode right = cur.right;
                if(isLeft){
                    delParent.left = right;
                } else {
                    delParent.right = right;
                }
                return true;
            } else if (cur.left != null && cur.right == null){
                TreeNode left = cur.left;
                if(isLeft){
                    delParent.left = left;
                } else {
                    delParent.right = left;
                }
                return true;
            }

            /**
             * 被删除的子树同时具有左右子树,需要寻找中序后继节点
             */
            if(cur.left != null && cur.right != null){
                TreeNode successor = findSuccessor(cur);
                TreeNode left = cur.left;
                if(isLeft){
                    delParent.left = successor;
                } else {
                    delParent.right = successor;
                }
                successor.left = left;
                return true;
            }
            return false;
    }

    /**
     * 寻找中序后继节点
     */
    public TreeNode findSuccessor(TreeNode delNode){
        TreeNode successor = delNode.right;
        TreeNode successorParent = null;
        while(successor.left != null){
            successorParent = successor;
            successor = successor.left;
        }
        if(successorParent != null){
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public static void main(String[] args) {
        BinarySeachTree tree = new BinarySeachTree();
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        System.out.println(tree.hasVal(2));
        tree.delete(2);
        System.out.println(tree.hasVal(2));
    }

    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
