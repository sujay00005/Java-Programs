public class Week1j {
    public static void main (String[] args){
        int[] nums = {1, 3, 0, 2}; 
        arrange(nums);
    }

    public static void arrange(int[] nums) {

        for(int i=0;i<nums.length; i++){
            int old_value = nums[i] % nums.length;
            nums[old_value] = nums.length * i + nums[old_value];
        }

        for(int j = 0; j<nums.length; j++){

            nums[j] = nums[j] / nums.length;
            System.out.println(nums[j]);
        }
    }
}



//BRUTE FORCE APPROACH

// public static void arrange(int[] nums) {
//     int[] temp = new int[nums.length];
//     for(int i=0;i<nums.length; i++){
//         temp[nums[i]] = i;
//     }

//     for(int j = 0; j<nums.length; j++){
//         System.out.println(temp[j]);
//     }
// }
