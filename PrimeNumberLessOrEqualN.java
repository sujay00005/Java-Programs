//O(N lg(lg N)) 
//primes less than equal to N(non- negative)

import java.util.Scanner;

public class PrimeNumberLessOrEqualN {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);

        System.out.println("Enter the number(N) to count the primes less than or equal to N");
        int n= input.nextInt();

        input.close();

        int[] primes =new int[n+1];

        for(int i=1; i<=n; i++){
            primes[i] =1;
        }
        primes[1]=0;

        for(int i=0; i*i<=n; i++){
            if(primes[i]== 1){
                for(int j=i; i*j<=n; j++){
                    primes[i*j]=0;
                }
            }
        }

        int count =0;
        for(int i=1; i<=n; i++){
            if(primes[i]== 1) count++;
        }
        System.out.println(count); 
    }
}









//O(N.sqrt(N))

// int finalCount = 0;
//         for(int i=2; i<=n; i++){
//             int count =0;
//             for(int j=2; j*j<=i; j++){
//                 if(i%j==0) {
//                     count++;
//                     break;
//                 }
//             }
//             if(count>0) continue;
//             else {
//                 finalCount++;
//             }
//         }
//         System.out.println(finalCount);