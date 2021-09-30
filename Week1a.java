// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

import java.util.Scanner;

public class Week1a{

    public static int size;

    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array");
        size = input.nextInt();

        System.out.println("Enter the height array values");
        int[] a = new int[size];
        for(int i=0; i<size; i++){
            a[i] = input.nextInt();
        }

        System.out.println( trap(a) );

    }

    public static int trap(int[] height) {
        
        int size = height.length;
        
        int[] pMax = new  int[size];
        int[] sMax = new int[size];

        pMax[0] = height[0];
        for(int i=1; i<=size-1; i++){
            if(pMax[i-1] > height[i])  pMax[i] = pMax[i-1];
            else{
                // if(pMax[i-1] < height[i]) 
                pMax[i] = height[i];
            }
            //System.out.println(pMax[i]);
            // printing from i=1
        }
        

        sMax[size-1] = height[size -1];
        for(int j= size -2; j>=0; j--){
            if(sMax[j+1]>= height[j])
                 sMax[j] = sMax[j+1];

            else if(sMax[j+1] < height[j])
            sMax[j] = height[j];
            
        } 

        
        int waterHeight = 0;
        
        for(int k = 1; k <= size-2 ;k++){
            if(pMax[k] > height[k] && sMax[k] > height[k]){
                if(pMax[k] < sMax[k]) {
                    waterHeight = waterHeight + (pMax[k] - height[k]);
                }
                else {
                    waterHeight = waterHeight + (sMax[k]-height[k]);
                }
                //System.out.println(waterHeight);
            }
            
        }
        //System.out.println(waterHeight+"=========");


        return waterHeight;
        
    }


}

// 0,1,1,2,2,2,2,3,3,3,3,3      sMax 3,3,3,3,3,3,3,3,2,2,2,1                             0,1,0,1,2,1,0,0,1,