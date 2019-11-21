package algorithm;

import java.util.Arrays;

public class EightQueenes {
    int result[] = new int[8]; //数组下标代表行，值代表queen存在哪一列

    public void cal8queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (isOk(row, col)) {
                result[row] = col;
                cal8queens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int col) {
        int leftUp = col - 1, rightUp = col + 1;
        row--;
        for (; row >= 0; row--) {
            if (result[row] == col || result[row] == leftUp || result[row] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private void printQueens(int[] result) {
        System.out.println(Arrays.toString(result));
        int len = result.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (result[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        new EightQueenes().cal8queens(0);
    }
}
