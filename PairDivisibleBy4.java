import java.util.Arrays;
import java.util.Scanner;

public class PairDivisibleBy4 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);

        System.out.println("Enter the value of number of integers present in array");
        int n = input.nextInt();

        int [] a = new int[n];
        System.out.println("Enter the array elements present in the array");
        for(int i=0; i<n; i++){
            a[i] = input.nextInt();
        }

        input.close();

        int k=4;
        int[] count = new int[k]; //since divisible by 4

        Arrays.fill(count, 0);

        for(int i=0; i<n; i++){
            count[a[i]%k]++;
        }

        int ans =0;
        ans = ans + (count[0]*( count[0] -1))/2;
        
        for (int i = 1; i <= (k-1)/2; i++) {
            ans = ans + count[i]*count[k-i];
        }

        if(k%2==0){
            ans = ans+ (count[k/2] *(count[k/2]-1))/2;
        }
        // else{
        //     ans = ans +count[k/2]*count[k/2 +1];
        // }

        System.out.println(ans);
    }
}








//O(N^2)

// int count=0;
//         for (int i = 0; i <n; i++) {
//             for (int j = i+1; j <n; j++) {
//                 if((a[i]+a[j])%4==0) count++;
//             }
//         }

//         System.out.println(count);