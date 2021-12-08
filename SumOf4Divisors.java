//array a[n], o/p sum of divisors of nos in array having exactly 4 divisors

import java.util.Scanner;

public class SumOf4Divisors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements present in the array");
        int n= input.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the array elements");
        for(int i=0; i<n; i++){
            a[i] = input.nextInt();
        }
        input.close();

        int sum = 0;
        for(int i=0; i<n; i++){
            int count= 0;
            int temp =0;

            for(int j=1; j<Math.sqrt(a[i]); j++){
                if(a[i]%j ==0){
                    if(j*j==a[i]) {
                        count++;
                        temp = temp+j;
                    }
                    else {
                        count = count+2;
                        temp = temp + j +a[i]/j;
                    }
                }
                
            }
            if(count==4) sum = sum+temp;
        }

        System.out.println(sum);
    }
}
