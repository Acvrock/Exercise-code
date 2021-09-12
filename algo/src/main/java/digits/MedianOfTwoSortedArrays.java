package digits;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
        int[] nums1 = {};
        int[] nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2 == null || nums2.length == 0) {
                return 0;
            }
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2d;
            } else {
                return nums2[nums2.length / 2];
            }
        } else if (nums2 == null || nums2.length == 0) {
            if (nums1 == null || nums1.length == 0) {
                return 0;
            }
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2d;
            } else {
                return nums1[nums1.length / 2];
            }
        } else {
            double lasttmp = 0;
            int nums1Idx = 0;
            int nums2Idx = 0;
            int tempIdx = 0;
            while (nums1Idx < nums1.length || nums2Idx < nums2.length) {
                double tmp;
                double nums1Tmp = nums1Idx >= nums1.length ? Integer.MAX_VALUE : nums1[nums1Idx];
                double nums2Tmp = nums2Idx >= nums2.length ?  Integer.MAX_VALUE : nums2[nums2Idx];
                if (nums1Tmp > nums2Tmp) {
                    tmp = nums2Tmp;
                    nums2Idx++;
                } else {
                    tmp = nums1Tmp;
                    nums1Idx++;
                }
                if (tempIdx >= (nums1.length + nums2.length) / 2) {
                    if ((nums1.length + nums2.length) % 2 == 0) {
                        return (tmp + lasttmp) / 2;
                    } else {
                        return tmp;
                    }
                }
                lasttmp = tmp;
                tempIdx++;
            }
        }
        return 0d;
    }

}
