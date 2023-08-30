// Given an array A[] with N elements , you need to find the sum all sub arrays of array A.

import java.util.Scanner;

public class SubArraySum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array ");
        int size = input.nextInt();

        System.out.println("Enter the values of the array element");
        int[] a = new int[size];
        for(int i= 0; i<size; i++){
            a[i] = input.nextInt();
        }

        System.out.println( subarraySum(a, size));
    }

    public static int subarraySum(int[] A, int N){
        int ans = 0;

        for(int i=0 ; i<=N-1; i++){
            //summing the contribution of each element in the formation of sub array
            ans = ans + ((i+1)*(N-i)*A[i]);
        }
        return ans;
    }
}
