import java.util.Scanner;

public class NumberOfPrimeFactor {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);

        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();

        for(int j=0; j<n; j++){
            NumOfPrimeFactor(a[j]);
        }
    }

    public static void NumOfPrimeFactor(int a){
        int count =0;

        for(int i=2; i*i<=a; i++){
            int prev =0;
            while (a%i==0) {
                //System.out.println(i+"-----");
                if(prev != i){
                    count++;
                }
                prev = i;
                a = a/i;
            }
        }
        if(a!=1){
            //System.out.println(a +"=====");
            count++;
        }

        System.out.println(count);;
    }
}
