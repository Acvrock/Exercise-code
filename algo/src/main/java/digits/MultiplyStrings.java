package digits;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MultiplyStrings {
    public static void main(String[] args) {

//        System.out.println(multiply("2", "3"));
//        System.out.println(multiply("123", "456"));
        System.out.println(multiply("123456789", "987654321"));

    }

    public static String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '1') return num2;
        if (num2.length() == 1 && num2.charAt(0) == '1') return num1;
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";

        int[] num1arr = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            num1arr[i] = num1.charAt(i) - '0';
        }
        int[] num2arr = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            num2arr[i] = num2.charAt(i) - '0';
        }
        int[] res = new int[num1arr.length + num2arr.length];

        int digits = 0;
        for (int i = num1arr.length - 1; i >= 0; i--) {
            int[] mResItem = new int[num2.length() + 1];
            int count = multiplyOne(num2arr, num1arr[i], mResItem);

            int resIdx = digits;
            int itemIdx = 0;
            int carry = 0;
            while (count >= 0) {
                int sum = mResItem[itemIdx] + res[resIdx] + carry;
                res[resIdx] = sum % 10;
                carry = sum / 10;
                count--;
                resIdx++;
                itemIdx++;
            }
            if (carry != 0) {
                res[resIdx] = carry;
            }
            digits++;
        }
        return toString(res);
    }

    private static int multiplyOne(int[] num2arr, int num1Item, int[] tempres) {
        int carry = 0;
        int count = 0;
        for (int idx = num2arr.length - 1; idx >= 0; idx--) {
            int tempi = num1Item * num2arr[idx] + carry;
            tempres[count] = tempi % 10;
            carry = tempi / 10;
            count++;
        }
        if (carry != 0) {
            tempres[count] = carry;
        }
        return count;
    }

    private static String toString(int[] res) {
        StringBuilder stringBuilder = new StringBuilder(res.length);
        boolean start = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] != 0) start = true;
            if (start) stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }
}

