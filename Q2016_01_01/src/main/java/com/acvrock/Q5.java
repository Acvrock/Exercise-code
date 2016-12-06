package com.acvrock;

/**
 * Created by moon on 06/12/2016.
 *
 * @Description:
 */
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
