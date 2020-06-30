package algorithm;

public class Euclid {

    public static int euclid(int a, int b) {
        if (b == 0) return a;
        return euclid(b, a % b);
    }

    public static int gcd(int a, int b) {
        int n, m;
        if (a > b) {
            n = a;
            m = b;
        } else {
            n = b;
            m = a;
        }

        return euclid(m, n);
    }

    public static void main(String[] args) {
        System.out.println(gcd(550,1769));
    }
}
