//find all elements that appears more than n/3(floor) time
import java.util.Arrays;
import java.util.Scanner;

public class MajorityElements2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n =  input.nextInt();
        int third;

        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        third = n/3;

        System.out.println("Enter the value of array elements");

        int[] a =new int[n];
        for(int i=0; i<n; i++){
           a[i] = input.nextInt();
        }

        for(int i=0; i<n; i++){
            if(visited[i]==true)
                continue;

            int count =1;
            for(int j=i+1; j<n;j++){
                if(a[i]==a[j]){
                    visited[j] = true;
                    count++;
                }
            }
            if(count> third) {
                System.out.println(a[i]);
            }
        }

    }
}
