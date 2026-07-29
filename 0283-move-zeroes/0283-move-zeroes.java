class Solution {
    public void moveZeroes(int[] nums) {
        int w=0, r=0;
        int n = nums.length;

        while(r<n){
            if(nums[w]!=0 && nums[r]==0){
                w++;
                r++;
            }else if(nums[w]==0 && nums[r]!=0){
                nums[w] = nums[r];
                nums[r] = 0;
                w++;
                r++;
            }else if(nums[r]==0 && nums[w]==0){
                r++;
            }else if(nums[r]!=0 && nums[w]!=0){
                w++;
                r++;
            }
        }
    }
}

/*
[0,1,0,3,12]
 w
     r

[1,3,12,0,0]
        w   r
*/