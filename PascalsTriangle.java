import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows of Pascal's triangle you want to print");
        int n = input.nextInt();

        int[][] a = new int[n][n];

        for(int i=0; i<n; i++){
            if(i == 0){
                a[0][0] = 1;
                System.out.println(a[0][0]);
                continue;
            }

            for(int j=0; j<=i; j++){
                if(j==0) a[i][0] =1;
                else if(i==j) a[i][j] =1;
                else a[i][j] = a[i-1][j-1] + a[i-1][j];

                System.out.print(a[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}
