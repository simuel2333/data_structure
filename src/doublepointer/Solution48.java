package doublepointer;

public class Solution48 {
    //先用暴力写出代码，然后看一下j和i是否有单调关系，若有可以从时间复杂度O(n^2)--->O(n)
    public int lengthOfLongestSubstring(String s) {
        int[] mem = new int[256];
        int max= 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            mem[s.charAt(i)]++;
            while(mem[s.charAt(i)]>1){
                mem[s.charAt(j)]--;
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
