package digits;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        print1(permute);
    }

    private static void print1(List<List<Integer>> permute) {
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.printf("," + integer);
            }
            System.out.println("");
        }
    }

    private static void print(List<Integer> permute) {
        for (Integer integer : permute) {
            System.out.printf("," + integer);
        }
        System.out.println("");
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> es = new ArrayList<>();
        p(es, nums, nums.length, 0, res);
        return res;
    }

    private static void p(ArrayList<Integer> es, int[] nums, int length, int i, List<List<Integer>> res) {
        if (length == i) {
            res.add(new ArrayList<>(es));
            return;
        }
        for (int i1 = 0; i1 < length; i1++) {
            Integer num = Integer.valueOf(nums[i1]);
            if (es.contains(num)) continue;
            es.add(num);
            p(es, nums, length, i + 1, res);
            es.remove(num);
        }
    }


}
