//for N print all its unique prime factors and exponents in N
import java.util.Arrays;
import java.util.Scanner;

public class PrimeFactorAndExponents {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number whose prime factor is to be found");
        int n = input.nextInt();
        
        int num =n;
        int[] count = new int[n];
        Arrays.fill(count, 0);

        input.close();

        for(int i=2; i*i<= n; i++){
            while (n%i==0) {
                System.out.println(i+"===");
                count[i]++;
                n =n/i;
            }
        }
        if(n!=1) {
            System.out.println(n+"---");
            count[n]++;
        }


        for(int i=2; i< num; i++){
            //System.out.println(i);
            if(count[i]!=0){
                System.out.println(i+" "+count[i]);
            }
        }

        
    }
}







//O(sqrt(N))

// int[] primes = new int[n+1];
//         int[] spf = new int[n+1];
        
//         Arrays.fill(primes, 1);
//         primes[1] =0;
//         Arrays.fill(spf, -1);

//         for(int i=2; i*i <=n;i++){
//             if(primes[i] == 1){
//                 for(int j=i; i*j<=n; j++){
//                     if(primes[i*j]==1){
//                         spf[i*j] =i;
//                         primes[i*j] =0;
//                     }
//                 }
//             }
//         }

//         for (int i=2; i*i<=n;i++) {
//             while(spf[i]!= -1){
//                 System.out.println(spf[i]);
//                 i = i/spf[i];
//             }
//             if(i!=1){
//                 System.out.println(i);
//             }
//         }
