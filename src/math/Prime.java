package math;

import org.junit.Test;

import java.util.*;


public class Prime {
    //判断是否是质数,O(sqrt(n))
    public boolean isPrime(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //因数分解,O(sqrt(n))
    public void primeFactor(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    n /= i;
                    count++;
                }
                System.out.println(i + " " + count);
            }
        }
        if (n > 1) System.out.println(n + " " + 1);
    }

    //筛质数---朴素 O(nloglogn)
    //思路: 用n以内的质数去筛掉合数
    public List<Integer> getPrimes1(int n) {
        List<Integer> ans = new ArrayList<>();
        boolean[] st = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                for (int j = i + i; j <= n; j += i) st[j] = true;
                ans.add(i);
            }
        }
        return ans;
    }

    //线性筛法O(n)
    //每一个合数都是有其最小质因数筛选掉的
    public List<Integer> getPrimes2(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] st = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes.add(i);
            for (int j = 0; primes.get(j) <= n / i; j++) {
                st[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) break; //说明pj是i的最小质因数,因此pj一定是pj*i的最小质因数
            }
        }
        return primes;
    }

    //试除法求所有的约数
    public List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) divisors.add(n / i);
            }
        }
        divisors.sort(Comparator.comparingInt(o -> o));
        return divisors;
    }

    //约数的个数
    public int countDivisor(int n) {
        int count = 1;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int a = 0;
                while (n % i == 0) {
                    n /= i;
                    a++;
                }
                count *= (a + 1);
            }
        }
        if (n > 1) count++;
        return count;
    }

    //约数求和
    public long divisorSum(int n) {
        Map<Integer, Integer> mem = new HashMap<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                n /= i;
                mem.merge(i, 1, Integer::sum);
            }
        }
        if (n > 1) mem.put(n, 1);
        long  sum = 1;
        for (Map.Entry<Integer, Integer> entry : mem.entrySet()) {
            int p = entry.getKey(), a = entry.getValue();
            long t = 1;
            long tt = t;
            for (int i = 1; i <= a; i++) tt += (t *= p);
            sum *= tt;
        }
        return sum;
    }

    //欧几里得算法求最大公约数O(logn)
    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }


    @Test
    public void test1() {
        System.out.println(isPrime(13));
    }

    @Test
    public void test2() {
        primeFactor(79);
    }

    @Test
    public void test3() {
        System.out.println(getPrimes1(100));
    }

    @Test
    public void test4() {
        System.out.println(getPrimes2(100));
    }

    @Test
    public void test5() {
        System.out.println(countDivisor(17));
    }

    @Test
    public void test6() {
        System.out.println(getDivisors(100));
    }

    @Test
    public void test7() {
        System.out.println(gcd(111, 153));
    }

    @Test
    public void test8(){
        System.out.println(divisorSum(115));
    }
}
