import java.util.Scanner;

public class BuyAndSellStock2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements present in array");

        int n = input.nextInt();

        System.out.println("Enter the prices of the stock on different days");

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = input.nextInt();
        }

        int profit2=-1;
        int ans =-1;
        int gap;

        for(int i =0; i<n; i++){
            for(int j =i; j<n-1; j++){
                if(a[j]<= a[i]) continue;
                else {
                    gap = a[j]-a[i];
                    profit2 = maxProfit(a,j+1) + gap;
                    ans = max(ans, profit2);
                }
            }
        }
        int profit1= maxProfit(a, 0);
        ans = max(ans, profit1);
            if(ans ==-1)
                System.out.println("0 ----------");
            else
            System.out.println(ans + "----------");
    }

    public static int maxProfit(int[] a, int j2){

                    int temp =-1;
                    int PositionToBuy = minBuy(a, j2);
                    System.out.println(PositionToBuy);
                    int PositionToSell = -1 ;

                    if(PositionToBuy == -1){
                        System.out.println("0");
                    }
                    else{
                        PositionToSell = maxSell(a, PositionToBuy);
                        System.out.println(PositionToSell);
                        if(PositionToSell ==-1){
                            System.out.println("0");
                        }
                        else{
                            temp = a[PositionToSell] - a[PositionToBuy];
                            if(temp <0) System.out.println("0");
                            else {
                                System.out.println(temp);
                            }
                        }
                    }
                    return temp;
    }

    public static int max(int a, int b){
        if(a>b) return a;
        return b;
    }

    public static int minBuy( int[] a, int start){
        int min=Integer.MAX_VALUE;
        int pos=-1;
        for(int i=start; i<a.length-1; i++){
            if (a[i] < min){
                pos = i;
                min = a[i];
            }
        }

        if(pos>=0) return pos;
        return -1;
    }


    public static int maxSell( int[] a, int startPos){
        int max=Integer.MIN_VALUE;
        int pos = -1;
        if(startPos+1<1) return -1;
        for(int i=startPos+1; i<a.length; i++ ){
            if (a[i] > max){
                pos = i;
                max = a[i];
            }
        }
        if(pos>=1) return pos;
        return -1;
    }
}
