public class RemoveDuplicates {
    /**
     * @param A: a array of integers
     * @return : return an integer
     * @Tags: Similar to the quick sort, concentrate mostly on coding ability,
     *        that is, the ability to realize the algorithms with code
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int right = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            nums[i] = nums[right];
            while (nums[right] == nums[i] && right < nums.length) {
                right++;
                if (right == nums.length) {
                    nums = Arrays.copyOf(nums, i + 1);
                    return i + 1;
                }
            }
        }
        nums = Arrays.copyOf(nums, i + 1);
        return 0;// AC even without return
    }
}
