import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by moon on 7/17/16.
 *
 * @Description:
 */
public class DateHelper {

    public static Date getOneWeekBefore() {
        Date now = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        cal.add(Calendar.DAY_OF_YEAR, -7);

        return cal.getTime();
    }

    public static Date getOneMonthBefore() {
        Date now = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        cal.add(Calendar.MONTH, -1);

        return cal.getTime();
    }

    public static Date getThreeMonthBefore() {
        Date now = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        cal.add(Calendar.MONTH, -3);

        return cal.getTime();
    }

    public static Date getHalfYearBefore() {
        Date now = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        cal.add(Calendar.MONTH, -6);

        return cal.getTime();
    }

    public static Date getOneYearBefore() {
        Date now = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        cal.add(Calendar.YEAR, -1);

        return cal.getTime();
    }

    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(DateHelper.getHalfYearBefore()));
        System.out.println(df.format(DateHelper.getOneMonthBefore()));
        System.out.println(df.format(DateHelper.getOneWeekBefore()));
        System.out.println(df.format(DateHelper.getOneYearBefore()));
        System.out.println(df.format(DateHelper.getThreeMonthBefore()));
    }

}
