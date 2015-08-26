public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1] && nums[i] != i + 1) {
                //Doesn't work for nums = {2, 1} if write the swap this way
                //Why why why why why why why????????????????
                // int temp = nums[i];
                // nums[i] = nums[nums[i] - 1];
                // nums[nums[i] - 1] = temp;

                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(firstMissingPositive(nums));
    }
}
