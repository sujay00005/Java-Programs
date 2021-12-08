//product of prime factors in a range
import java.util.Scanner;


public class ProductOfPrimeInRange{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the left bound and right bound number");
        int left = input.nextInt();
        int right =input.nextInt();

        input.close();

        System.out.println(primeProduct(right)/primeProduct(left-1));

    }

    public static int primeProduct(int n) {
        if(n==0) return 1;

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
        
        int prod =1;
        for(int i=1; i<=n; i++){
            if(primes[i]== 1) prod =prod*i;
        }

        return prod;
    }

    // List<Integer> getPrimes(){
    //     List<Boolean> isPrime =new ArrayList<Boolean>();

    //     List<Integer> ints = new ArrayList<Integer>();

    // }
}