package algorithm;

public class DynamicProgramming {

    /**
     *
     * @param ws 存放物品对应的重量
     * @param vs 存放物品对应的价值
     * @param n  物品数量
     * @param w  背包容量
     * @return   背包存放最大价值
     */
    public static int knapsack(int ws[], int vs[], int n, int w) {
        int states[][] = new int[n][w + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;   //不放第一件物品
        if (ws[0] <= w) { //放第一件物品
            states[0][ws[0]] = vs[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) { //不放第i件物品
                if (states[i-1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; ws[i] <= w - j; j++) { //放第i件物品
                if (states[i-1][j] >= 0)
                    states[i][j + ws[i]] = Math.max(states[i][j + ws[i]], states[i][j] + vs[i]);
            }
        }

        int maxV = Integer.MIN_VALUE;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > maxV) maxV = states[n - 1][j];
        }
        return maxV;
    }

    public static void main(String[] args) {
        int n = 4;
        int w = 8;
        int[] ws = {2, 2, 3, 5};
        int[] vs = {3, 3, 2, 1};
        int maxV = knapsack(ws, vs, n, w);
        System.out.println(maxV);
    }
}
