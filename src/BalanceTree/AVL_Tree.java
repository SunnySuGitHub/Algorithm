package BalanceTree;

/**
 * Description:AVL平衡二叉搜索树
 * 任何一个节点的左右子树的高度差不超过1
 * Created by Administrator on 2019/3/22
 */
public class AVL_Tree<T extends Comparable<? super T>> {
    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<T> root;

    private int height(AvlNode<T> node){
        return node == null ? -1 : node.height;
    }

    private AvlNode<T> doubleLeftRotate(AvlNode<T> k2){
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }
    private AvlNode<T> doubleRightRotate(AvlNode<T> k2){
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> leftRightRotate(AvlNode<T> k3){
        k3.left = doubleRightRotate(k3.left);
        return doubleLeftRotate(k3);
    }

    private AvlNode<T> rightLeftRotate(AvlNode<T> k3){
        k3.right = doubleLeftRotate(k3.right);
        return doubleRightRotate(k3);
    }

    //调整平衡
    private AvlNode<T> balance(AvlNode<T> root){
        if(root == null) {
            return null;
        }
        //左边高
        if(height(root.left) - height(root.right) > ALLOWED_IMBALANCE){
            if(height(root.left.left) >= height(root.left.right)){
                //左左旋
                root = doubleLeftRotate(root);
            } else {
                //左右旋
                root = leftRightRotate(root);
            }
        }
        //右边高
        else if(height(root.right) - height(root.left) > ALLOWED_IMBALANCE){
            if(height(root.right.left) >= height(root.right.right)){
                //右右旋
                root = doubleRightRotate(root);
            } else {
                //右左旋
                root = rightLeftRotate(root);
            }
        }
        root.height = Math.max(height(root.left), height(root.right));
        return root;
    }

    //插入节点入口
    public void insert(T val){
        root = insert(val, root);
    }

    private AvlNode<T> insert(T val, AvlNode<T> root){
        if(root == null){
            return new AvlNode<>(val);
        }
        int compareResult = val.compareTo(root.val);
        if(compareResult < 0){
            root.left = insert(val, root.left);
        } else if(compareResult > 0){
            root.right = insert(val, root.right);
        } else {
            //duplicate do nothing
        }
        return balance(root);
    }

    //寻找最小值顶层入口
    public T findMin(){
        return findMin(root);
    }

    private T findMin(AvlNode<T> root){
        if(root == null){
            return root.val;
        } else if(root.left == null){
            return null;
        }
        return findMin(root.left);
    }

    //寻找最大值顶层入口
    public T findMax(){
        return findMax(root);
    }

    private T findMax(AvlNode<T> root){
        if(root == null){
            return null;
        } else if(root.right == null){
            return root.val;
        }
        return findMax(root.right);
    }

    //是否包含顶层入口
    public boolean contains(T v){
        return contains(root, v);
    }

    private boolean contains(AvlNode<T> root, T v){
         if(root == null){
             return false;
         }
         int compareResult = v.compareTo(root.val);
         if(compareResult < 0){
             return contains(root.left, v);
         } else if(compareResult > 0){
             return contains(root.right, v);
         } else {
             return true;
         }
    }










    public static class AvlNode<T>{
        T val;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
        AvlNode(T theElement){
            this(theElement,null,null);
        }
        AvlNode(T theElement, AvlNode<T> lt,AvlNode<T> rt){
            val = theElement;
            left = lt;
            right = rt;
            height = 0;
        }
    }
}
