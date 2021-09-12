package digits;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(5);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf("," + i);
            }
            System.out.println("");
        }
    }

    public static int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }
        int rows = n;
        int columns = n;
        int[][] res = new int[rows][columns];
        boolean[][] ends = new boolean[rows][columns];
        int[][] conter = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int thiswary = 0;
        int row = 0;
        int column = 0;
        for (int i = 1; i <= rows * columns; i++) {
            res[row][column] = i;
            ends[row][column] = true;
            int nextrow = conter[thiswary][0] + row;
            int nextcolumn = conter[thiswary][1] + column;
            if (nextrow < 0 || nextrow >= rows || nextcolumn < 0 || nextcolumn >= columns || ends[nextrow][nextcolumn]) {
                thiswary = (thiswary + 1) % 4;
            }
            row = conter[thiswary][0] + row;
            column = conter[thiswary][1] + column;
        }
        return res;
    }
}
