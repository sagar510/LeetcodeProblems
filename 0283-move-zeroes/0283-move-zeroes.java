class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;

        while(fast<n && nums[fast]!=0){
            slow++;
            fast++;
        }

        while(fast < n){
            if(nums[slow]==0 && nums[fast]!=0){
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
            fast++;
        }
    }
}

/*
nums = [1,3,0,0,12]
            s    f      

       [1,0,0,3,12]
          s f
       
       [1,3,12,0,0]
            s    f

num 0
l++ r--

best 
0 num  -> swap
l++ r--

num num
l++

0 0
r--



1 2 3 0 0
      s
         f

*/



