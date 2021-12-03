import java.util.*;

public class RotateImage {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of n where it in the size of nxn matrix");
        int n = input.nextInt();

        System.out.println("Enter the value of elements present in the array");
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            System.out.println("Enter the " + (i+1)+"th row");
            for(int j=0; j<n; j++){
                arr[i][j] = input.nextInt();
            }
        }
        input.close();

        rotate(arr);
        
    }

    public static void rotate(int a[][]){
        int n = a.length; //for row length  arr[0].length;
        int limit = n-1;
        int k = n-1;

        for(int i=0; i<n/2; i++){
            if(limit < i) break;
            for(int j=i; j<limit; j++){
                
                int temp = a[i][j];
            
                if(i==j){
                    System.out.println("..........");
                    a[i][j] = a[k-i][j];
                    a[k-i][j] = a[k-i][k-j];
                    a[k-i][k-j] = a[i][k-j];
                    a[i][k-j] = temp;
                    System.out.println(a[i][j] + " " + a[i][k-j] );
                    System.out.println(a[k-i][j] + " " + a[k-i][k-j] );
                    System.out.println("*---------");
                }
                else{
                    a[i][j] = a[k-j][i];
                    a[k-j][i] = a[k-i][k-j];
                    a[k-i][k-j] = a[j][k-i];
                    a[j][k-i] = temp;
                    System.out.println(a[i][j] + " " + a[j][k-i] );
                    System.out.println(a[k-j][i] + " " + a[k-i][k-j] );
                    System.out.println("---------");
                }
            }
            limit = limit-1;
        }
        for(int i=0; i<n; i++){
            for(int j =0; j<n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
