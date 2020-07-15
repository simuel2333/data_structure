package sort;

import java.util.Arrays;

public class QuickSort {

    public void quicksort(int[] nums) {
        quicksortCore(nums, 0, nums.length - 1);
    }

    public void quicksortCore(int[] nums, int p, int r) {
        if (p >= r) return;
        int i = p - 1, j = r + 1, x = nums[i + j >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quicksortCore(nums, p, j);
        quicksortCore(nums, j + 1, r);
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 4, 521, 31, 31241, 5321, 232, -2341, 321};
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
