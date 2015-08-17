/**
 */
public class rotateArray {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            move(nums, nums.length - k + i, nums.length - k);
        }
        System.out.println(nums.length - k);
        for (int i : nums) {
        	System.out.print(i);
        	System.out.print(" ");
        }
        System.out.println();
    }
    
    public static void move(int[] nums, int from, int shift) {
        while (shift > 0) {
            shift--;
            int temp = nums[from];
            nums[from] = nums[--from];
            nums[fromif (Integer.parseInt(str1[0]) > Integer.parseInt(Str2[0])) {
            return 1;
        } else if (Integer.parseInt(str1[0]) < Integer.parseInt(str2[0])) {
            return 0;
        } else {
            return 
        }] = temp;
        }
    }

    public static void rotate1(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,step - 1);
        reverse(nums,step,nums.length - 1);
        for (int i : nums) {
        	System.out.print(i);
        	System.out.print(" ");
        }
        System.out.println();
    }

    //reverse int array from n to m
    public static void reverse(int[] nums, int n, int m){
        while(n < m){
            nums[n] ^= nums[m];
            nums[m] ^= nums[n];
            nums[n] ^= nums[m];
            n++;
            m--;
        }
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,6,7};
    	move(nums, 5, 5);
    	for (int i : nums) {
    		System.out.print(i + ",");
    	}
    	System.out.println();
    }
}