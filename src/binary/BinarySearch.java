package binary;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int p = 0, r = nums.length - 1;
        while (p < r) {
            int mid = p + r + 1 >> 1;
            if (nums[mid] <= target) p = mid;
            else r = mid - 1;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(new BinarySearch().binarySearch(nums,11));
    }
}
