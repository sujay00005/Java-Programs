//Leetcode: 1658
//You are given an integer array nums and an integer x. In one operation, you can either remove 
//the leftmost or the rightmost element from the array nums and subtract its value from x. Note
//that this modifies the array for future operations.

//Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

class Solution {
    int round = 0;
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int i=0, j=len-1;

        reduceVal(nums, x, i, j,0);

        return round==0 ? -1 :round;
        
    }

    public void reduceVal(int[] nums,int x, int i, int j,int count){
        if(x==0){
            System.out.println(x+" "+i+" "+j+" "+count);
            System.out.println(round+" "+count);

            if(round==0)
                round= count;
            else if(round>count)
                round = count;
            return;
        }
        if(i>j || x<0){
            return;
        }
        

        reduceVal(nums, x-nums[i], i+1, j,count+1);
        reduceVal(nums, x-nums[j], i, j-1,count+1);
    }
} 
