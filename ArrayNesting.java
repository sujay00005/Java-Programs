import java.util.Arrays;
import java.util.Scanner;

public class ArrayNesting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n =  input.nextInt();

        int marked[] = new int[n];
        Arrays.fill(marked, -1);

        System.out.println("Enter the value of array elements");
        int[] a =new int[n];
        for(int i=0; i<n; i++){
           a[i] = input.nextInt();
        }
        input.close();
        
        int prev=0,count=0;

        marked[a[0]] = a[0];
                prev = marked[a[0]];
                System.out.println(a[0]+"---------=");

        while(true){

            count++;

            if(marked[a[prev]] != -1){
                System.out.println(count);
                break;
            }
        
            marked[a[prev]] = a[prev];
            System.out.println(marked[a[prev]]+"---------");
            prev =a[prev];
        }

    }
}






//ALGO FOR L-13
// for(int i=0; i<n; i++){
//     if(a[i]>=0){
//         int ind = a[i];
//         int val = i;

//         while (ind != i) {
//             int temp = a[ind];
//             a[ind] = -(val+1);
//             val = ind;
//             ind = temp;
//         }
//         a[ind] = -(val+1);
//     }
// }
// for(int i=0; i<n; i++){
//     a[i] =  -a[i] -1;
//     System.out.print(a[i]);
// }