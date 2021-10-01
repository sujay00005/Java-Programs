// Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

import java.util.Scanner;

public class Week1g {
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

        System.out.println("Enter the values of the sum region matrix in order r1,c1 r2,c2");
        int[] region = new int[4];
        for(int i=0; i<4; i++){
            region[i] = input.nextInt();
        }

        int sum =0;

        //must be equal at boundary since that corner value is also taken into consideration
        for(int i =region[0]; i<=region[2]; i++){
            for(int j= region[1]; j<=region[3]; j++){
                sum = sum + a[i][j];
                System.out.println(sum);
            }
        }
        System.out.println(sum+"-------");
    }
}
