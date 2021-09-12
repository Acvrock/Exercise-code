package digits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Three3sum {
    public static void main(String[] args) {
        int[] s1 = new int[]{-1, 0, 1, 2, -1, -4};
        print(threeSum(s1));
        int[] s2 = new int[]{};
        print(threeSum(s2));
        int[] s3 = new int[]{0};
        print(threeSum(s3));
        int[] s7 = new int[]{0, 0, 0};
        print(threeSum(s7));
        int[] s25 = new int[]{-2, 0, 0, 2, 2};
        print(threeSum(s25));

    }

    private static void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.printf("[");
            for (Integer integer : list) {
                System.out.printf("," + integer);
            }
            System.out.println("]");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length < 2) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return ans;
            }

            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去重

            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return ans;
    }
}
