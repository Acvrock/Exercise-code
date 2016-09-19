package util;

/**
 * Created by moon on 9/1/16.
 *
 * @Description:
 */
public class Comper {

    public static void main(String[] args) {
        System.out.println(needUpdate("1.1.0", "1.1"));
        System.out.println(needUpdate("1.1.1", "1.1"));
        System.out.println(needUpdate("1.02.1", "1.1"));
        System.out.println(needUpdate("1.3", "1.1"));
        System.out.println(needUpdate("1.12.1", "1.2.1"));
        System.out.println(needUpdate("1.1.1.1.1.1.1.1", "1.2"));
        System.out.println(needUpdate("1.10000", "1.1222"));
        System.out.println(needUpdate("1", "1"));
        System.out.println(needUpdate("1.1.1", "1.1.2"));

    }

    public static boolean needUpdate(String 当前版本,String 客户端过来的版本)
            throws NumberFormatException {
        if (客户端过来的版本 == null || 客户端过来的版本.length() < 1) {
            throw new NumberFormatException("Empty version string");
        }

        String[] sa = 客户端过来的版本.split("\\.", -1);
        int[] si = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            si[i] = Integer.parseInt(sa[i]);
            if (si[i] < 0)
                throw new NumberFormatException("" + si[i]);
        }

        String[] da = 当前版本.split("\\.", -1);
        int[] di = new int[da.length];
        for (int i = 0; i < da.length; i++) {
            di[i] = Integer.parseInt(da[i]);
            if (di[i] < 0)
                throw new NumberFormatException("" + di[i]);
        }

        int len = Math.max(di.length, si.length);
        for (int i = 0; i < len; i++) {
            int d = (i < di.length ? di[i] : 0);
            int s = (i < si.length ? si[i] : 0);
            if (s > d)
                return false;
            if (s < d)
                return true;
        }
        return false;
    }
}
