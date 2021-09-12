package digits;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            ints[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ints[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
                print(ints);
                System.out.println("----");
            }
        }
        return ints[m - 1][n - 1];
    }

    private static void print(int[][] ints) {
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf(","+ i);
            }
            System.out.println("");
        }
    }
}
