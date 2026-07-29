class Solution {
    public int removeDuplicates(int[] nums) {
        int w = 0;
        int n = nums.length;

        for(int r=0; r<n; r++){
            if(nums[w]!=nums[r]){
                nums[++w] = nums[r];
            }
        }
        
        return w+1;
    }
}

/*
Input: nums = [0,1,2,3,4,2,2,3,3,4]
                       w           r
*/
