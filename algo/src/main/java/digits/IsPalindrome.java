package digits;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-01);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x > 0)) {
            return false;
        }
        int res = 0;
        while (res < x) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res == x || (res / 10 == x)) {
            return true;
        }
        return false;
    }
}
