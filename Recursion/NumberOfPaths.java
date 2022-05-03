package Recursion;

import java.util.Scanner;

public class NumberOfPaths {
    public static int count = 0; 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of 'm' and 'n', the dimensions of the matrix");
        int m = input.nextInt();
        int n = input.nextInt();

        input.close();
        countPath(0,0,m,n);
        System.out.println(count);
    }
    public static void countPath(int i, int j, int m, int n){
        if(i==m-1 || j==n-1){
            count++;
            return;
        }
        countPath(i+1, j, m, n);
        countPath(i, j+1, m, n);
    }
    
}

//INTEGER RETURNING METHOD
// public static int countPath(int i, int j, int m, int n){
//     if(i==m-1 || j==n-1){
//         return 1;
//     }
//     return countPath(i+1, j, m, n) + countPath(i, j+1, m, n);
// }