import java.util.Scanner;

public class BuyAndSellStock {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements present in array");

        int n = input.nextInt();

        System.out.println("Enter the prices of the stock on different days");

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = input.nextInt();
        }
        
        int PositionToSell = minBuy(a);
        System.out.println(PositionToSell);
        int PositionToBuy = -1 ;

        if(PositionToSell == -1){
            System.out.println("0");
        }
        else{
            PositionToBuy = maxSell(a, PositionToSell);
            System.out.println(PositionToBuy);
            if(PositionToBuy ==-1){
                System.out.println("0");
            }
            else{
                int temp = a[PositionToBuy] - a[PositionToSell];
                if(temp <0) System.out.println("0");
                else System.out.println(temp);
            }
        }
    }

    public static int minBuy( int[] a){
        int min=Integer.MAX_VALUE;
        int pos=-1;
        for(int i=0; i<a.length-1; i++ ){
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










// public static int maxGap(int[] a){
//     int n = a.length;

//     if(n<2) return 0;

//     int maxNum = Integer.MIN_VALUE;
//     int minNum = Integer.MAX_VALUE;

//     for( int i=0; i<=n-1; i++) {
//         maxNum = max(maxNum,a[i]);
//         minNum = min(minNum,a[i]);
//     }

//     if(minNum == maxNum) return 0;
//     int gap = (maxNum - minNum)/ (n-1);
//     if((maxNum - minNum) % (n-1) != 0) gap++;
    
//     int[] minArr = new int[n];
//     int[] maxArr = new int[n];

//     for(int i=0; i<n; i++){
//         minArr[i] = Integer.MAX_VALUE;
//         maxArr[i] = Integer.MIN_VALUE;
//     }

//     for(int i=0; i<n; i++){
//         int bucket = (a[i] - minNum)/gap;
//         minArr[bucket] = min(minArr[bucket], a[i]);
//         maxArr[bucket] = max(maxArr[bucket], a[i]);
//         //System.out.println(" "+minArr[i] + " " + maxArr[i]);
//     }
//     for(int i=0; i<n; i++){
//         System.out.println(" "+minArr[i] + " " + maxArr[i]);
//     }
//     System.out.println("================");


//     int ans = Integer.MIN_VALUE;
//     int prev = Integer.MIN_VALUE;

//     for(int i=0; i<n; i++){
//         if(minArr[i] == Integer.MAX_VALUE) { //if encountered bucket is empty
//             System.out.println(minArr[i]+"-----");
//             continue;
//          } //bucket empty so skip
        
//         if(prev == Integer.MIN_VALUE) {
//             prev = maxArr[i]; //encountering first bucket
//             System.out.println(prev+"......");
//         }

//         else{
//             ans = max(ans, minArr[i]- prev); //comparing max of prev bucket with min of present bucket
//             prev = maxArr[i];
//             System.out.println(ans + " " + minArr[i] + " " +prev);
//         }
        
//     }

//     return ans;
// }

// public static int max(int a , int b){
//     if(a>b) return a;
//     return b;
// }

// public static int min(int a , int b){
//     if(a<b) return a;
//     return b;
// }

// }