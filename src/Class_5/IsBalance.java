package Class_5;

/**
 * Description:判断一个树是否为平衡二叉树
 * 重点是理解递归函数的设计应用过程
 * 列出可能性，整理返回值格式，进行黑盒调用
 * 处理好baseCase情况
 * 综合各个返回值，进行分析设计，往上返回
 * Created by Administrator on 2019/1/7
 */
public class IsBalance {
    public static void main(String[] args) {

    }

    private static boolean isB(TreeNode node){
        return process(node).isBalance;
    }

    private static ReturnData process(TreeNode node) {
        if (node == null) {
            return new ReturnData(0, true);
        }
        ReturnData leftData = process(node.left);
        if (leftData.isBalance == false) {
            return new ReturnData(0, false);
        }
        ReturnData rightData = process(node.right);
        if (rightData.isBalance == false) {
            return new ReturnData(0, false);
        }
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(0, false);
        }
        return new ReturnData(Math.max(leftData.h, rightData.h) + 1, true);
    }

    public static class ReturnData {
        int h;
        boolean isBalance;

        public ReturnData(int h, boolean isBalance) {
            this.h = h;
            this.isBalance = isBalance;
        }
    }
}
