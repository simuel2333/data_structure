package math;

public class QuickMi {
    public static long quickMi(long a, long k, long p) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(quickMi(2, 20, 100000007));
    }
}