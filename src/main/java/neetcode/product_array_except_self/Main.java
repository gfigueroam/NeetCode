package neetcode.product_array_except_self;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //int[] nums= new int[]{1,2,4,6};
        int[] nums= new int[]{-1,0,1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.productExceptSelf(nums));
    }

}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // solved the problem using the prefix-suffix arrays we can calculate the multiplication
        // from both sides of the i we are interested in.

        int[] result = new int[nums.length];
        int[] prefix =  new int[nums.length+1];
        Arrays.fill(prefix,1);

        int[] suffix = new int[nums.length+1];
        Arrays.fill (suffix,1);

        for (int i=1, j=nums.length-1 ; i<=nums.length; i++,j--) {
           prefix[i] = prefix[i-1] * nums[i-1];
           suffix[j] = suffix[j+1] * nums[j];
        }

        for (int i=1; i<= nums.length; i++){
            result[i-1] = prefix[i-1] * suffix[i];
        }
        return result;
    }
}
