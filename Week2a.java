//Time complexity O(log(max(a,b)))

public class Week2a {
    public static void main(String[] args) {
        int a = 12;
        int b = 18;

        System.out.println("GDC " +gdc(a, b)+ " LCM "+ lcm(a, b));
    }

    public static int gdc(int a, int b){
        int max = max(a, b);
        int min = min(a, b);
        int temp;

        if(min == 0) return max;

        while(max%min != 0){
            temp = max;
            max = min;
            min = temp % min;
        }
        return min;
    }

    public static int lcm(int a, int b){
        return (a*b)/gdc(a, b);
    }

    public static int min(int a, int b){
        if(a<b) return a;
        return b;
    }

    public static int max(int a, int b){
        if(a>b) return a;
        return b;
    }
}





//Time complexity O(n)

// public static void main(String[] args) {
//     int a = 12;
//     int b = 18;

//     int gdc = 0;
//     for(int i=1; i< min(a,b); i++){
//         if(a%i == 0 && b%i == 0){
//             gdc = i;
//         }
//     }
//     System.out.println(gdc);
// }

// public static int min(int a, int b){
//     if(a<b) return a;
//     return b;
// }