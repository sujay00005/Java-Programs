// Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

import java.security.Principal;
import java.util.Scanner;

public class Week1i{
    public static void main(String[] args) {
        
        int[] nums= {10};
        System.out.println(maximumGap(nums));
    }

    public static int maximumGap(int[] nums) { 
        //We can take List<int> nums too

        int size = nums.length;
        if(size < 2) return 0;

        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for(int i=0 ; i<=size-1; i++){
            maxNum = max(nums[i], maxNum);
            minNum = min(nums[i], minNum);
        }

        if(minNum == maxNum) return 0;

        int gap = (maxNum - minNum) / (size-1);

        if((maxNum-minNum)% (size-1) != 0) gap++;

        System.out.println(maxNum +" Max " + minNum+ " Min " + gap+ " gap ");

        int[] minArr = new int[size];
        int[] maxArr = new int[size];

        for(int i=0; i<size; i++){
            maxArr[i] = Integer.MIN_VALUE;
            minArr[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<size; i++){
            int bucket= (nums[i] - minNum) / gap;
            minArr[bucket] = min(minArr[bucket], nums[i]);
            //System.out.println(minArr[0]+ "========");
            maxArr[bucket] = max(maxArr[bucket], nums[i]);

            // System.out.println(maxArr[bucket] +"------" + minArr[bucket] +" -------" + nums[i] + "-----"+ bucket);
        }

        for(int i=0; i<size; i++){
        System.out.println(maxArr[i] +"------" + minArr[i]);
        }

        int ans = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;

        for(int i=0; i<size; i++){
            
            //if element corresponding to min value's bucket is not present
            if(minArr[i]==Integer.MAX_VALUE){
                continue;
            }

            //if first element of array
            else if(prev == Integer.MIN_VALUE) {
                prev = maxArr[i];
            }

            else {
                ans = max(ans, minArr[i]-prev);
                System.out.println(ans);
                prev = maxArr[i];
            }
        }
        System.out.println(ans);
        
        return ans;
    }

    public static int max(int a, int b){
        if(a>b) return a;
        return b;
    }

    public static int min(int a, int b){
        if(a<b) return a;
        return b;
    }
}