package math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            List<Integer> divisors = new ArrayList<>();
            for (int j = 1; j <= a / j; j++) {
                if(a % j == 0) {
                    divisors.add(j);
                    if(j != a/j) divisors.add(a / j);
                }
            }
            divisors.sort(Comparator.comparingInt(o -> o));
            for (int e : divisors) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
