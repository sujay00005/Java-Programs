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

        int count=0;
        for (int i = 0; i <n; i++) {
            for (int j = i+1; j <n; j++) {
                if((a[i]+a[j])%4==0) count++;
            }
        }

        System.out.println(count);
    }
}
