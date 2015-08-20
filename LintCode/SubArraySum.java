public class SubArraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     * @tags: Great use of HashMap, worth the double think about this problem
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }

            map.put(sum, i);// Most important step
        }
        return result;
    }
}
