package digits;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:  世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 * 输入例子:
 * 1999 2299
 * 输出例子:
 * 7
 */
public class BinaryCommonDigit1 {

    /**
     * 二进制字符串转字符串集合
     * @param binaryString 二进制字符串
     * @return List<String>
     */
    private List<String> convertList(String binaryString) {

        int intStringLength = binaryString.length();

        List<String> intStringList = new ArrayList<String>();

        for (int i = 0; i < intStringLength; i++) {
            String intChar = binaryString.substring(i, i + 1);
            intStringList.add(intChar);
        }

        //二进制补位,统一位数32
        if (intStringLength < 32) {
            int temp = 32 - intStringLength;
            List<String> tempList = new ArrayList<String>();
            for(int i =0;i<temp;i++){
                tempList.add("0");
            }
            tempList.addAll(intStringList);
            intStringList = tempList;
        }else if (intStringLength > 32) {
            int temp = intStringLength -32;
            intStringList = intStringList.subList(temp, intStringLength);
        }

        return intStringList;
    }


    /**
     * 两个int32整数的二进制表达位不同数
     * @param mList 第一个集合
     * @param nList 第二个集合
     * @return int
     */
    private int comparisonNumber(List<String> mList, List<String> nList) {
        int finalNumber = 0;

        for (int i = 0; i < mList.size(); i++) {
            String tempMString = mList.get(i);
            String tempNString = nList.get(i);
            if (!(tempMString.equals(tempNString))) {
                finalNumber += 1;
            }
        }

        return finalNumber;
    }

    /**
     * 获得两个整形二进制表达位数不同的数量
     * @param m 整数m
     * @param n 整数n
     * @return 整数
     */
    public int countBitDiff(int m, int n) {

        // 转二进制字符串
        String mString = Integer.toBinaryString(m);
        String nString = Integer.toBinaryString(n);

        // 转二进制集合
        List<String> mList = convertList(mString);
        List<String> nList = convertList(nString);

        return comparisonNumber(mList, nList);
    }

    public static void main(String[] args) {
        BinaryCommonDigit1 solution = new BinaryCommonDigit1();
        Date date = new Date();
        long starttime = date.getTime();
        for (int i = 0; i < 10000; i++)  {
            solution.countBitDiff(1815962319, -489800625);
            solution.countBitDiff(54167145, 2114514288);
            solution.countBitDiff(-1581369222, -653247842);
            solution.countBitDiff(-1078268980, 1849709238);
            solution.countBitDiff(-1709027433, -1453581363);
            solution.countBitDiff(-1279682205, 241245704);
            solution.countBitDiff(320519384, 649833072);
            solution.countBitDiff(-1236370486, -643125692);
            solution.countBitDiff(1382626804, 1112471511);
            solution.countBitDiff(648396615, 1692057598);
            solution.countBitDiff(-1336798021, -1693736045);
            solution.countBitDiff(1617025787, 1844243107);
            solution.countBitDiff(-339544214, -1414883527);
            solution.countBitDiff(-248079532, 896682977);
            solution.countBitDiff(-1328377280, 1909406309);
            solution.countBitDiff(1761992645, -416414394);
            solution.countBitDiff(-948730287, -526425343);
            solution.countBitDiff(488505273, 1934192679);
            solution.countBitDiff(58544537, -961313337);
            solution.countBitDiff(214239940, 1094527939);
            solution.countBitDiff(365669459, -407180541);
            solution.countBitDiff(-264546277, -1212520025);
            solution.countBitDiff(694544267, -844633187);
            solution.countBitDiff(-1089267386, 1941052499);
            solution.countBitDiff(-56286990, 1878293078);
            solution.countBitDiff(-27139053, -632427491);
            solution.countBitDiff(778657777, -238060207);
            solution.countBitDiff(1982621645, 1082725973);
            solution.countBitDiff(1608183808, -704136235);
            solution.countBitDiff(-2034515538, 1565891241);
            solution.countBitDiff(-986280905, -1718524847);
            solution.countBitDiff(-309386095, -216245557);
            solution.countBitDiff(-789041116, 1741647519);
            solution.countBitDiff(93571051, 1227690064);
            solution.countBitDiff(-442392097, -828744051);
            solution.countBitDiff(1249399292, 127745243);
            solution.countBitDiff(-661190308, -7198056);
            solution.countBitDiff(1922052416, -1906083718);
            solution.countBitDiff(-1923274496, 1356942074);
            solution.countBitDiff(-787572436, -714161585);
            solution.countBitDiff(-517338250, -1653394202);
            solution.countBitDiff(-626518506, 223328114);
            solution.countBitDiff(1819425474, -1409235439);
            solution.countBitDiff(-1004213132, -2130455530);
            solution.countBitDiff(-2010524523, 2037998708);
            solution.countBitDiff(-463620280, -271506710);
            solution.countBitDiff(1477578723, -1099442608);
            solution.countBitDiff(482277851, -1406992703);
            solution.countBitDiff(-2029646, 618534514);
            solution.countBitDiff(1409783976, 406768244);
            solution.countBitDiff(1469767477, -1029461832);
            solution.countBitDiff(-2118029925, -1783512314);
            solution.countBitDiff(2035323673, -1248447789);
            solution.countBitDiff(-718115973, 113725449);
            solution.countBitDiff(15338525, 1367629133);
            solution.countBitDiff(-881326941, -1670810047);
            solution.countBitDiff(1122387688, -1555611443);
            solution.countBitDiff(627427576, -1128050554);
            solution.countBitDiff(-1571445482, 127853466);
            solution.countBitDiff(1775988502, 1645720302);
            solution.countBitDiff(1711258515, -249918627);
            solution.countBitDiff(1003863244, -742630358);
            solution.countBitDiff(1776759340, 1821239082);
            solution.countBitDiff(935396042, 525097264);
            solution.countBitDiff(309561443, 2082493888);
            solution.countBitDiff(818618264, 875200282);
            solution.countBitDiff(1387385730, 2115226640);
            solution.countBitDiff(-1604436534, 295116622);
            solution.countBitDiff(345688562, -902488069);
            solution.countBitDiff(1993130353, -1775609378);
            solution.countBitDiff(576565196, -943735968);
            solution.countBitDiff(2143951060, 1354150448);
            solution.countBitDiff(-409667408, -2120549547);
            solution.countBitDiff(1859347552, 1018022369);
            solution.countBitDiff(709014229, 1081589683);
            solution.countBitDiff(-765056548, -1050974746);
            solution.countBitDiff(-1296035999, -977735976);
            solution.countBitDiff(-2146269472, 703144436);
            solution.countBitDiff(-793994245, 1064956327);
            solution.countBitDiff(442078855, 1314879009);
            solution.countBitDiff(-1499528803, 296905683);
            solution.countBitDiff(-1558184349, 1644098251);
            solution.countBitDiff(539122862, -1163479971);
            solution.countBitDiff(1569183409, 194434744);
            solution.countBitDiff(-1163361713, -842476966);
            solution.countBitDiff(-1081843251, -1356045442);
            solution.countBitDiff(-1144338700, -1473904135);
            solution.countBitDiff(-1045608728, 1738052645);
            solution.countBitDiff(-1028122057, -927398460);
            solution.countBitDiff(1375618039, -1057482230);
            solution.countBitDiff(-1589081112, -843462618);
            solution.countBitDiff(395021038, 472105990);
            solution.countBitDiff(807112296, -226029267);
            solution.countBitDiff(-1862123987, 1847964622);
            solution.countBitDiff(296192567, -2142284657);
            solution.countBitDiff(424656954, 520226204);
            solution.countBitDiff(-1753835830, 845798386);
            solution.countBitDiff(-1404974415, 1466945039);
            solution.countBitDiff(-734696287, -694038169);
            solution.countBitDiff(-1147371400, 1871286863);
        }
        Date enddate = new Date();
        long endTime = enddate.getTime();
        System.out.println((endTime - starttime)+"");
    }
}