//rotate the array by k units

//Time ~ O(n)  Space ~ O(1)

import java.util.Scanner;

public class RotateArrayByK {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of K ");
        int k = input.nextInt();

        System.out.println("Enter the size of array");
        int size = input.nextInt();

        System.out.println("Enter the values of the array");
        int[] a =new int[size];
        for(int i=0; i<size; i++){
            a[i] = input.nextInt();
        }

        rotate(a, k);


    }

    public static void rotate(int[] nums, int k) {
        int size = nums.length;

        reverse(nums, k-1, size-1 );
        reverse(nums, 0 , k-2);

        nums = reverse(nums, 0, size-1);

        for(int i=0; i<size ; i++){
            System.out.println(nums[i]);
        }
        
    }

    public static int[] reverse(int[] a, int i, int j){
    
            int temp;
                while(i<j){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }

        return a;
    }
}






//Time ~ O(n)  Space ~ O(n)


// public static void rotate(int[] nums, int k) {
//     int size = nums.length;
//     int[] temp = new int[size];

//     for(int j =0; j<size ; j++){
//         temp[(j+k) % size] = nums[j];
//     }

//     for(int j =0; j<size ; j++){
//         System.out.println(temp[j]);
//     }
// }
