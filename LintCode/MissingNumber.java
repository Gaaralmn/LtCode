public class MissingNumber {
    public missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
            result ^= nums[i - 1];
        }
        return result;
    }

    public int missingNumber(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]!=i){
                try{
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }catch(Exception e){
                    if(nums[i]!=nums.length){
                        return nums.length;
                    }
                    i++;
                }
            }else{
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j){
                return j;
            }
        }
        return nums.length;
    }
}
