package codebook;

/**
 * Created by moon on 9/19/16.
 *
 * @Description: 二维数组中的查找
 * 热度指数：22403时间限制：1秒空间限制：32768K
 * 本题知识点： 查找
 * 算法知识视频讲解
 * 题目描述
 * <p>
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
//public class Solution {
//    public boolean Find(int[][] array, int target) {
//        for (int[] ints : array) {
//            for (int anInt : ints) {
//                if (target == anInt)
//                    return true;
//            }
//        }
//        return false;
//    }
//}

public class Solution {
    public boolean Find(int[][] array, int target) {
        int m, n, x, y;
        m = array.length;//行数
        n = array[0].length;//列数
        x = m - 1;
        y = 0;//坐标定在左下角
        while (x >= 0 && y <= n - 1) {
            if (target < array[x][y]) {
                x--;//遇小上移
            } else if (target > array[x][y]) {
                y++;//遇大右移
            } else {
                return true;
            }
        }
        return false;
    }
}