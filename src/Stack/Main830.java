package Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 给定一个长度为N的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出-1。
 * <p>
 * 输入格式
 * 第一行包含整数N，表示数列长度。
 * <p>
 * 第二行包含N个整数，表示整数数列。
 * <p>
 * 输出格式
 * 共一行，包含N个整数，其中第i个数表示第i个数的左边第一个比它小的数，如果不存在则输出-1。
 */
public class Main830 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (!stack.isEmpty() && stack.peek() >= x) stack.poll();
            if (!stack.isEmpty()) System.out.print(stack.peek() + " ");
            else System.out.println("-1 ");
            stack.push(x);
        }
    }
}
