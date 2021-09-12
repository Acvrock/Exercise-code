package digits;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> integers = spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.printf("," + integer);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return list;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] controller = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] added = new boolean[rows][columns];
        int thisway = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < rows * columns; i++) {
            list.add(matrix[row][column]);
            added[row][column] = true;
            int nextrow = controller[thisway][0] + row;
            int nextcolumn = controller[thisway][1] + column;
            if (nextrow < 0 || nextrow >= columns || nextcolumn < 0 || nextcolumn >= columns || added[nextrow][nextcolumn] == true) {
                thisway = (thisway + 1) % 4;
            }
            row = controller[thisway][0] + row;
            column = controller[thisway][1] + column;
        }
        return list;
    }
}
