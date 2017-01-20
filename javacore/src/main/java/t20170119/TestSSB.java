package t20170119;

/**
 * Created by moon on 19/01/2017.
 *
 * @Description:
 */
public class TestSSB {
    public static void main(String[] args) {
        int[] data = {4, 2, 5, 23, 6, 7, 3, 223, 232, 123, 45, 467, 28, 66};
        sort(data, 0, data.length - 1);
        System.out.println(toString(data));
    }

    private static void sort(int[] data, int low, int high) {
        if (low < high) {
            int partition = partition(data, low, high);
            sort(data, low, partition - 1);
            sort(data, partition + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        arr[low] = pivot;//扫描完成，枢轴到位
        return low;  //返回的是枢轴的位置
    }

    public static String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
