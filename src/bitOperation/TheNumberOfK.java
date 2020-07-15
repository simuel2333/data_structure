package bitOperation;

public class TheNumberOfK {
    public static void main(String[] args) {
        int num = 100;
        for (int k = 31; k < 32; k++) System.out.print(num >> k & 1);
    }
}
