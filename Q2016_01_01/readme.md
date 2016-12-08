### Q1

```
 byte ba=127;
 byte bb=ba<<2;
 System.out.println(bb);
这个为什么会出错？给出解释，并且纠正错误
```
* bit:位   
一个位只能存一个二进制数据，0 或者 1
* byte:字节   
1 byte = 8 bit
* short   
1 short = 2 bit
* int   
1 int = 4 bit
 
```byte ba=127;``` 中的 127 用 bit 表示是这样子的   

| 128 | 64 | 32 | 16 | 8 | 4 | 2 | 1 |
| :-: |:-: |:-: |:-: |:-:|:-:|:-:|:-:|
|  0  | 1  | 1  | 1  | 1 | 1 | 1 | 1 |

如果这时候执行 ```ba<<1``` 操作，ba 就会整体向左移动一格，变成这样子

| 128 | 64 | 32 | 16 | 8 | 4 | 2 | 1 |
| :-: |:-: |:-: |:-: |:-:|:-:|:-:|:-:|
|  1  | 1  | 1  | 1  | 1 | 1 | 1 | 0 |   

这时候 ba = 254 ，如果再过分一点，对值为 127 的 ba 进行 ```byte bb=ba<<2;``` 操作，会变成下面这样子：

| 256 | 128 | 64 | 32 | 16 | 8 | 4 | 2 | 1 |
| :-: | :-: |:-: |:-: |:-: |:-:|:-:|:-:|:-:|
|  1  |  1  | 1  | 1  | 1  | 1 | 1 | 0 | 0 |     

需要使用 9 个 bit 来盛放该值，但是``` 1 byte = 8 bit``` ,所以使用 byte 无法正确的表示该值，可以使用 short/int 来表示该值   

### Q2
```
int a=-1024;
给出 a>>1与a>>>1的的结果，并且用位移方式图示解释
```   
```
/**
 * Created by moon on 04/12/2016.
 *
 * @Description:
 */
public class Q2 {
    public static void main(String[] args) {
        int a = -1024;
        Integer 右位移 = a >> 1;
        Integer 无符号右移 = a >>> 1;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(右位移);
        System.out.println(Integer.toBinaryString(右位移));
        System.out.println(无符号右移);
        System.out.println(Integer.toBinaryString(无符号右移));
    }
}
```
out

```
-1024
11111111111111111111110000000000
-512
11111111111111111111111000000000
2147483136
1111111111111111111111000000000
```   
### Q3
```
定义一个10240*10240的byte数组，分别采用行优先与列优先的循环方式来计算 这些单元格的总和，看看性能的差距，并解释原因
行优先的做法，每次遍历一行，然后到下一行。
```
```
public class Q3 {
    public static void main(String[] args) {
        byte[][] b = new byte[10240][10240];
        Random random = new Random();
        for (byte[] bytes : b) {
            random.nextBytes(bytes);
        }
        long start = new Date().getTime();
        int row = 10240;
        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < row; i1++) {
                byte ll = b[i][i1];

            }
        }
        long end = new Date().getTime();
        System.out.println(end - start);

        long start1 = new Date().getTime();
        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < row; i1++) {
                byte ll = b[i1][i];
            }
        }
        long end1 = new Date().getTime();
        System.out.println(end1 - start1);
    }
}
```
out

```
11
1222
```   
行优先遍历的速度比较快，因为二维数组就是一个一维数组里放一个一维数组    

Q4

```
定义Java类Salary {String name, int baseSalary, int bonus  },随机产生1万个实例，属性也随机产生（baseSalary范围是5-100万，
bonus为（0-10万），其中name长度为5，随机字符串，然后进行排序，排序方式为收入总和（baseSalary*13+bonus），
输出收入最高的10个人的名单
```

```
public class Q4 {
    static final int W = 10000;
    static final int BASESALARYMAX = 100 * W;
    static final int BASESALARYMIN = 5 * W;
    static final int BASESALARYRYBOUND = BASESALARYMAX - BASESALARYMIN + 1;
    static final int BOUNDMAX = 10 * W;
    static final int BOUNDBOUND = BOUNDMAX + 1;
    static final String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        Salary[] salaries = new Salary[10000];
        Random random = new Random();
        List<Salary> collect = Arrays.stream(salaries).map(salary -> {
                    salary = new Salary();
                    salary.setBaseSalary(random.nextInt(BASESALARYRYBOUND) + BASESALARYMIN);
                    salary.setBonus(random.nextInt(BOUNDBOUND));
                    StringBuffer buf = new StringBuffer();
                    for (int i = 0; i < 5; i++) {
                        int num = random.nextInt(62);
                        buf.append(str.charAt(num));
                    }
                    salary.setName(buf.toString());
                    return salary;
                }
        ).sorted().limit(10).collect(Collectors.toList());
        for (Salary salary : collect) {
            System.out.println(salary);
        }
    }

    static class Salary implements Comparable {
        private String name;
        private int baseSalary;
        private int bonus;

        public int compareTo(Object o) {
            Salary salary = (Salary) o;
            return Integer.compare(salary.getBaseSalary() * 13 + salary.getBonus(), baseSalary * 13 + bonus);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBaseSalary(int baseSalary) {
            this.baseSalary = baseSalary;
        }

        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        public String getName() {
            return name;
        }

        public int getBaseSalary() {
            return baseSalary;
        }

        public int getBonus() {
            return bonus;
        }

        @Override
        public String toString() {
            return "Salary{" +
                    "name='" + name + '\'' +
                    ", baseSalary=" + baseSalary +
                    ", bonus=" + bonus +
                    '}';
        }
    }
}
```
out

```
Salary{name='HKaDN', baseSalary=999607, bonus=91133}
Salary{name='3idVf', baseSalary=999356, bonus=93523}
Salary{name='Zj0PC', baseSalary=999057, bonus=96805}
Salary{name='3jumO', baseSalary=998733, bonus=91274}
Salary{name='yVNlW', baseSalary=998862, bonus=87629}
Salary{name='wV3ti', baseSalary=998723, bonus=88584}
Salary{name='LuaMP', baseSalary=997467, bonus=96577}
Salary{name='brDou', baseSalary=997557, bonus=94881}
Salary{name='9UWCU', baseSalary=998877, bonus=76922}
Salary{name='eLVxw', baseSalary=998236, bonus=84132}
```   

Q5

```
编码实现下面的要求
现有对象 MyItem {byte type,byte color,byte price} ，要求将其内容存放在一个扁平的byte[]数组存储数据的ByteStore {byte[] storeByteArry}对象里,
即每个MyItem占用3个字节，第一个MyItem占用storeByteArry[0]-storeByteArry[2] 3个连续字节，以此类推，最多能存放1000个MyItem对象
ByteStore提供如下方法
putMyItem(int index,MyItem item) 在指定的Index上存放MyItem的属性，这里的Index是0-999，而不是storeByteArry的Index
getMyItem(int index),从指定的Index上查找MyItem的属性，并返回对应的MyItem对象。

要求放入3个MyItem对象（index为0-2）并比较getMyItem方法返回的这些对象是否与之前放入的对象equal。
```

```
public class Q5 {

    public static void main(String[] args) {
        ByteStore byteStore = new ByteStore();
        MyItem myItem0 = new MyItem((byte) 0, (byte) 1, (byte) 0);
        MyItem myItem1 = new MyItem((byte) 1, (byte) 1, (byte) 1);
        MyItem myItem2 = new MyItem((byte) 2, (byte) 1, (byte) 2);
        byteStore.putMyItem(0, myItem0);
        byteStore.putMyItem(1, myItem1);
        byteStore.putMyItem(2, myItem2);
        System.out.println(byteStore.getMyItem(0).equals(myItem0));
        System.out.println(byteStore.getMyItem(1).equals(myItem1));
        System.out.println(byteStore.getMyItem(2).equals(myItem2));

    }

    static class MyItem {
        byte type;
        byte color;
        byte price;

        public MyItem() {
        }

        public MyItem(byte type, byte color, byte price) {
            this.type = type;
            this.color = color;
            this.price = price;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyItem)) return false;

            MyItem myItem = (MyItem) o;

            if (type != myItem.type) return false;
            if (color != myItem.color) return false;
            return price == myItem.price;
        }

        @Override
        public int hashCode() {
            int result = (int) type;
            result = 31 * result + (int) color;
            result = 31 * result + (int) price;
            return result;
        }

        @Override
        public String toString() {
            return "MyItem{" +
                    "type=" + type +
                    ", color=" + color +
                    ", price=" + price +
                    '}';
        }
    }

    static class ByteStore {
        byte[] storeByteArry = new byte[1000 * 3];

        public void putMyItem(int index, MyItem item) {
            int offset = index * 3;
            storeByteArry[offset] = item.type;
            storeByteArry[offset + 1] = item.color;
            storeByteArry[offset + 2] = item.price;
        }

        public MyItem getMyItem(int index) {
            int offset = index * 3;
            MyItem myItem = new MyItem();
            myItem.type = storeByteArry[offset];
            myItem.color = storeByteArry[offset + 1];
            myItem.price = storeByteArry[offset + 2];
            return myItem;
        }
    }
}

```

### Q6

```
Arrays.parallelSort在数组超过多少时候才开启并行排序？采用位运算，给出推导过程
```

```
public class Q6 {
    public static void main(String[] args) {
        System.out.println(1 << 13);
        Random random = new Random();
        List<int[]> arrays = new ArrayList<>();
        arrays.add(random.ints().limit(1 << 20).toArray());
        arrays.add(random.ints().limit(1 << 19).toArray());
        arrays.add(random.ints().limit(1 << 18).toArray());
        arrays.add(random.ints().limit(1 << 17).toArray());
        arrays.add(random.ints().limit(1 << 16).toArray());
        arrays.add(random.ints().limit(1 << 15).toArray());
        arrays.add(random.ints().limit(1 << 14).toArray());
        arrays.add(random.ints().limit(1 << 13).toArray());
        arrays.add(random.ints().limit(1 << 12).toArray());
        arrays.add(random.ints().limit(1 << 11).toArray());
        arrays.add(random.ints().limit(1 << 10).toArray());
        arrays.add(random.ints().limit(1 << 9).toArray());
        arrays.add(random.ints().limit(1 << 8).toArray());
        arrays.add(random.ints().limit(1 << 7).toArray());
        arrays.add(random.ints().limit(1 << 6).toArray());
        arrays.add(random.ints().limit(1 << 5).toArray());
        arrays.add(random.ints().limit(1 << 4).toArray());
        arrays.add(random.ints().limit(1 << 3).toArray());
        arrays.add(random.ints().limit(1 << 2).toArray());
        arrays.add(random.ints().limit(1 << 1).toArray());
        for (int i = 0; i < arrays.size(); i++) {
            long start1 = new Date().getTime();
            for (int j = 0; j <(1 << (i+1)); j++) {
                Arrays.parallelSort(arrays.get(i));
            }
            long end1 = new Date().getTime();
            System.out.println(end1 - start1+"ms 长度 "+arrays.get(i).length);
        }
    }
}
```
### Q7

```
DualPivotQuicksort 算法与普通冒泡算法相比，有哪些改进，对比常见的几种基于数组的排序算法，说说为什么Java选择了快排
```

```
对比冒泡算法，快速排序采用了分治法，每一趟排序都把问题的规模减低
Java 内的 DualPivotQuicksort 对比普通的快速排序，实现了：小数组使用插入排序、双枢轴快速三向切分、五取样划分
```

