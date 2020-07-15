package binary;

import javax.swing.event.MenuKeyListener;

/**
 * 整数二分法，需要注意区间
 * 二分的本质：能够找出满足条件或不满足条件的边界点
 */
public class IntegerTemplate {
    boolean check(int mid) {
        return false;
    }

    //将[p,r]换分成[p, mid] 和[mid+1, r]
    int binarySearch1(int p, int r) {
        while (p < r) {
            int mid = p + r >> 1;
            if (check(mid)) r = mid;
            else p = mid + 1;
        }
        return p;
    }

    //将[p,r]划分成[p, mid-1]和[mid,r]
    int binarySearch2(int p, int r) {
        while (p < r) {
            int mid = p + r + 1 >> 1;
            if (check(mid)) p = mid;
            else r = mid - 1;
        }
        return p;
    }
}
