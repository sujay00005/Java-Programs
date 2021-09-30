import java.util.Scanner;

// You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
// Return the largest number of chunks we can make to sort the array.

public class Week1b<bool> {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int size = input.nextInt();

        System.out.println("Enter the array elements");
        int[] a = new int[size];
        for(int i=0 ; i<size; i++){
            a[i] = input.nextInt();
        }

        System.out.println(maxChunksToSorted(a));
    }

    public static int maxChunksToSorted(int[] a) {
        int  i=0, ans=0;

        while(i<a.length){
            for(int j=i; j<a.length; j++){
                if(canBeChunked(i,j,a)) {
                    i = j+1;
                    ans ++;
                    break;
                }   
            }
        }
        return ans;
    }

    public static boolean canBeChunked(int i, int j, int[] a) {
        int count = 0;

        for(int k=i; k<=j; k++){
            if(a[k]>= i && a[k]<= j) count++;
        }

        if(count == j-i+1) return true;

        return false;
    }
}
