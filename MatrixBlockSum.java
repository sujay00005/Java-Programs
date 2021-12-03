import java.util.*;

public class MatrixBlockSum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of 'm' as row and 'n' as column for a mxn matrix ");
        int m = input.nextInt();
        int n = input.nextInt();

        System.out.println("Enter the value of 'k' ");
        int k = input.nextInt();


        int[][] a = new int[m][n];
        System.out.println("Provide the input for the values of the matrix");
        for(int i=0; i<m; i++){
            System.out.println("Provide the input for the " +(i+1)+"th matrix");
            for(int j=0; j<n; j++){
                a[i][j] = input.nextInt();
            }
        }
        a = matrixBlockSum(a, k);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixBlockSum(int[][] a, int k){
        int m = a.length; //gives no of column
        int n = a[0].length; //gives no of row
        System.out.println(m + " " + n);
        
        int r1,r2,c1,c2;
        int[][] sum =new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int s = 0;

                r1 = i-k;
                if(r1<0) r1 =0;
                r2 = i+k;
                if(r2>m-1) r2 =m-1;
                c1 = j-k;
                if(c1<0) c1 =0;
                c2 = j+k;
                if(c2>m-1) c2 =n-1;
                System.out.println("r1 "+r1+" r2 "+r2+" c1 "+c1+" c2 "+c2);

                for(int x=r1; x<=r2; x++){
                    for(int y=c1; y<=c2; y++){
                        s = s + a[x][y];
                    }
                }
                sum[i][j] = s;
            }
        }
        return sum;
    }
}
