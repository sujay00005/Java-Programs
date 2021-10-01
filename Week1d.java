import java.util.Scanner;

// Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

public class Week1d { 

    public static void main( String[] args) {
        Scanner input= new Scanner(System.in);

        System.out.println("Enter the vlaue of K ");
        int k = input.nextInt();

        System.out.println("Enter the size of array");
        int size = input.nextInt();

        System.out.println("Enter the elements of the array ");
        int[] a = new int[size];
        for(int i = 0; i<size; i++){
            a[i] = input.nextInt();
        }

        System.out.println(minSwap(a, size, k));

    }

    public static int minSwap( int[] a, int n, int K) {
        int countLegal = 0;
        int freq = 0;

        //total count of legal elements in whole array
        for(int i=0; i< n; i++){
            if(a[i] <= K) countLegal++;
        }
        System.out.println(countLegal);

        //count of legal element in first window
        for(int k =0 ; k< countLegal; k++){
            if(a[k]<=K) freq ++;
        }

        //count of legal element in subsequent windows
        for(int j=K; j<=n-1; j++) {

            //we only care if the number of legal no in the window increases
            if(a[j] <= K) { 
                if(a[j-K] >K)  freq++;
                System.out.println(freq);
            }
        }
        return countLegal-freq;
    }
}