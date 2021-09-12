package digits;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BracketsisValid {
    public static void main(String[] args) {
//        System.out.println(isValid("()"));
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("(]"));
//        System.out.println(isValid("([)]"));
//        System.out.println(isValid("{[]}"));
//        System.out.println(isValid("(("));
        System.out.println(isValid("[[[[[[[[[[[[[[[[[[["));
        System.out.println(isValid("(])"));

    }

    public static boolean isValid(String s) {
        int length = s.length();
        if (s == null || length < 2 || length % 2 == 1) {
            return false;
        }

        Map map = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        char[] clist = new char[length];
        int idx = 0;
        clist[0] = s.charAt(0);
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (idx < 0) {
                    return false;
                }
                if (clist[idx] == (char) map.get(c)) {
                    idx--;
                } else {
                    return false;
                }
            } else {
                idx++;
                clist[idx] = c;
            }
        }
        return idx == -1 ? true : false;
    }
}
