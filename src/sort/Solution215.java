package sort;


import org.junit.Test;

//数组中的第K个最大元素
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quicksort(nums, 0, nums.length - 1, k);
    }

    private int quicksort(int[] nums, int p, int r, int k) {
        if (p >= r) return nums[p];
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
        if (j >= k) return quicksort(nums, p, j, k);
        else return quicksort(nums, j + 1, r, k);
    }


    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 1));
    }

}
