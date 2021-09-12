package digits;

import java.util.Arrays;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "dtgrtoxuybwyfskikukcqlvprfipgaygawcqnfhpxoifwgpnzjfdnhpgmsoqzlpsaxmeswlhzdxoxobxysgmpkhcylvqlzenzhzhnakctrliyyngrquiuvhpcrnccapuuwrrdufwwungaevzkvwbkcietiqsxpvaaowrteqgkvovcoqumgrlsxvouaqzwaylehybqchsgpzbkfugujrostopwhtgrnrggocprnxwsecmvofawkkpjvcchtxixjtrnngrzqpiwywmnbdnjwqpmnifdiwzpmabosrmzhgdwgcgidmubywsnshcgcrawjvfiuxzyzxsbpfhzpfkjqcpfyynlpshzqectcnltfimkukopjzzmlfkwlgbzftsddnxrjootpdhjehaafudkkffmcnimnfzzjjlggzvqozcumjyazchjkspdlmifvsciqzgcbehqvrwjkusapzzxyiwxlcwpzvdsyqcfnguoidiiekwcjdvbxjvgwgcjcmjwbizhhcgirebhsplioytrgjqwrpwdciaeizxssedsylptffwhnedriqozvfcnsmxmdxdtflwjvrvmyausnzlrgcchmyrgvazjqmvttabnhffoe";
//        String ss = "-";
//        System.out.println(isPalindrome(ss));
        System.out.println(longestPalindromeByte(s));
        System.out.println(longestPalindromeAAA(s));
    }

    public static String longestPalindromeAAA(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static boolean isPalindrome(String s) {
        for (short i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(char[] s) {
        for (short i = 0; i < s.length / 2; i++) {
            if (s[i] != s[s.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindromeByte(String s) {
        char[] charArray = s.toCharArray();
        short maxi = 0;
        short maxj = 0;
        for (short i = 0; i < charArray.length; i++) {

            for (short j = (short) (i + 1); j <= charArray.length; j++) {
                boolean is = true;
                for (short pi = i, pj = (short) (j - 1); pi < j; pi++, pj--) {
                    if (charArray[pi] != charArray[pj]) {
                        is = false;
                    }
                }
                if (j - i > maxj - maxi && is) {
                    maxi = i;
                    maxj = j;
                }
            }
        }
        return new String(Arrays.copyOfRange(charArray, maxi, maxj));
    }

    public static String longestPalindrome(String s) {
        String maxStr = "";
        for (short i = 0; i < s.length(); i++) {
            for (short j = (short) (i + 1); j < s.length(); j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring) && substring.length() > maxStr.length()) {
                    maxStr = substring;
                }
            }
        }
        return maxStr;
    }
}
