import java.util.Scanner;

public class SplitArray {
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

        for(int j=0; j<n; j++){
            if(j==0) continue;
            a[j] = a[j]+a[j-1];
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+ "----");
        }

        System.out.println(check(a));
    }
    public static boolean check(int a[]){
        int[] count = new int[a.length];

        count[a[0]] = a[0];
        for (int i = 1; i < a.length; i++) {
            
            int diff = Math.abs(a[i] -a[i-1]);
            count[diff]++;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(count[i]);
        }

        int flag =0;
        for (int j = 2; j < count.length; j++) {
            System.out.println(count[j]);
            if(count[j]==0) continue;
            if(count[j] != count[j-1]){
                System.out.println(count[j]+"  "+count[j-1]);
                flag =1;
                return false;
            }
        }
        return flag ==0 ? true: false;
    }


}
