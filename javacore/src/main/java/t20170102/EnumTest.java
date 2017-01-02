package t20170102;

/**
 * Created by moon on 02/01/2017.
 *
 * @Description:
 * 枚举相当于一个类，可以定义构造方法、成员变量、普通方法、抽象方法
 * 枚举元素位于枚举体最开始部分，带分号分割
 * 枚举构造方法必须定义为私有的
 *
 */
public class EnumTest {
    public static void main(String[] args) {
        WeekDay fri = WeekDay.FRI;
        System.out.println(fri);
        System.out.println(fri.name());
        System.out.println(fri.ordinal());

    }

    public enum WeekDay {
        SUN(1), MON(), TUE, WED, THI, FRI, SAT;

        private WeekDay() {
            System.out.println("first");
        }

        private WeekDay(int day) {
            System.out.println("second");
        }
    }

    public enum TrafficLamp {
        RED(40) {
            public TrafficLamp nextLamp() {
                return GREEN;
            }
        }, GREEN(45) {
            public TrafficLamp nextLamp() {
                return YELLOW;
            }

        }, YELLOW(5) {
            public TrafficLamp nextLamp() {
                return RED;
            }

        };

        public abstract TrafficLamp nextLamp();

        private int time;

        TrafficLamp(int time) {
            this.time = time;
        }
    }

}
