public class FourSum {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numbers == null && numbers.length < 4) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i <= numbers.length - 4; i++) {
            //Try to understand and remember why to use i > 0
            if (i > 0 && numbers[i] == numbers[i - 1]) { //Important for the prevention of duplicates
                continue;
            }
            for (int j = i + 1; j <= numbers.length - 3; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = numbers.length - 1;
                while (start < end) {
                    int sum = numbers[i] + numbers[j] + numbers[start] + numbers[end];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[start]);
                        list.add(numbers[end]);
                        result.add(result);
                        start++;
                        end--;
                        while (start < end && numbers[start] == numbers[start - 1]) {
                            start++;
                        }
                        while (start < end && numbers[end] == numbers[end + 1]) {
                            end--;
                        }
                    }
                }
            }
        }
        return result; 
    }
}
