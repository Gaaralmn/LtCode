/**
 * @To Be Remember: Really important to use the index of the Arrays to solve problems
 * @To Summarize or not: Yes, thought, code implemention
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        //cur, first, run. I have to track three indexes here
        int cur = 0;
        int first = 0;
        while (first < nums.length) {
            int run;
            for (run = first; run < nums.length; run++) {
                if (nums[first] != nums[run]) {
                    break;
                }
                if (run - first < 2) {   //Core part
                    nums[cur] = nums[first];
                    cur++;
                }
            }
            first = run;
        }
        return cur;
    }
}
