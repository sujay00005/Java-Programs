// Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

import java.util.Scanner;

public class SearchingSortedMatrix {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of row present");
        int row = input.nextInt();

        System.out.println("Enter the number of column present");
        int column = input.nextInt();


        System.out.println("Enter the values of the matrix");

        int[][] a = new int[row][column];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                a[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter the values of the element to be searched");
        int target = input.nextInt();
        
        System.out.println(searchMatrix(a, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        //starting from the top-right corner
        int i=0; 
        int j= column-1;

        while(i<row && j>=0){
            if(matrix[i][j] == target){
                System.out.println(" i and j are: " +i +" and "+j );
                return true;
            }
            else if(matrix[i][j] >target){
                j--;
            }
            else{
                i++;
            }
        }

        return false;
    }
}

