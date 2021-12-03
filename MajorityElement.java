//find the element that appears more than n/2(floor) time assuming there always exists one
import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements present in the array");
        int n =  input.nextInt();
        int half;

        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        if(n %2 == 0) half =n/2;
        else half = n/2 +1;

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
            if(count>= half) {
                System.out.println(a[i]);
                break;
            }

        }

    }
}
