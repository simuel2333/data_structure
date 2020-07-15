package bitOperation;

public class LowbitDemo {
    public static int lowbit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) {
        int x = 15;
        int num = 0;
        while (x != 0) {
            num++;
            x -= lowbit(x);
        }
        System.out.println(num);
    }
}
