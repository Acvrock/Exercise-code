package digits;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] s1 = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(s1, target));
        int[] s96 = new int[]{1,1,1,1};
        int target96 = 0;
        System.out.println(threeSumClosest(s96, target96));
        int[] s130 = new int[]{-3,-2,-5,3,-4};
        int target130 = -1;
        System.out.println(threeSumClosest(s130, target130));
    }

    public static int threeSumClosest(int[] nums, int target) {
        long ans = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) return target;
                else if (sum < target) L++;
                else if (sum > target) R--;
                ans = Math.abs(target - ans) > Math.abs(target - sum) ? sum : ans;
            }
        }
        return (int)ans;
    }
}