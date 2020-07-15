package sort;

import java.util.Arrays;

public class MergeSort {
    private int[] tmp;

    public void mergesort(int[] nums) {
        tmp = new int[nums.length];
        mergesortCore(nums, 0, nums.length - 1);
    }

    private void mergesortCore(int[] nums, int p, int r) {
        if (p >= r) return;
        int mid = p + r >> 1;
        mergesortCore(nums, p, mid);
        mergesortCore(nums, mid + 1, r);
        int i = p, j = mid + 1, k = p;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];
        for (i = p; i <= r; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {5, 6, -1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergesort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
