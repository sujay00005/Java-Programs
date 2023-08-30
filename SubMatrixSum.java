// Given a NxN 2-D matrix, the task to find the sum of all the submatrices.

import java.util.Scanner;

public class SubMatrixSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows.");
        int row = input.nextInt();

        System.out.println("Enter the number of columns.");
        int column = input.nextInt();

        int arr[][] = new int[row][column];
        System.out.println("Enter the elements of the array");

        for(int i=0; i< row; i++){
            for(int j = 0; j<column; j++){
                arr[i][j] = input.nextInt();
            }
        }

        System.out.println(matrixSum( arr, row, column));
    }

    public static int matrixSum(int arr[][], int row, int column){
        int ans = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                ans = ans + arr[i][j]*(i+1)*(j+1)*(row-i)*(column-j); 
            }
        }
        return ans;
    }

}
