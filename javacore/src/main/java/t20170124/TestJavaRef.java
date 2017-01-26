package t20170124;

/**
 * Created by moon on 24/01/2017.
 *
 * @Description: 测试 Java 方法调用时究竟是 值传递还是引用传递
 * Java 调用方法时，使用的是值传递，如果是引用传递时，testSwapRef 时置换了两个引用指向的对象，引用A，B应该也随着变化，但A，B 没有变化，所以方法调用时只是传递了A，B 的拷贝
 */
public class TestJavaRef {
    public static void main(String[] args) {
        Test A = new Test("A");
        Test B = new Test("B");
        testSwapRef(A, B);
        System.out.println("A = " + A);
        System.out.println("B = " + B);
    }

    private static void testSwapRef(Test a, Test b) {
        Test temp = a;
        a = b;
        b = temp;
    }

    private static class Test {
        private String value;

        public Test(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
