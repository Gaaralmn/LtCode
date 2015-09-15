public class GasStation {
    //Method that is hard to get and Understand
    public int gasStation(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return total < 0 ? -1 : index;
    }

    //Method that is easier to get and Understand
    public int gasStation(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len;) {
            int leftgas = 0;
            int j = 0;
            for (; j < len; j++) {
                int k = (i + j) % len;
                leftgas += gas[k] - cost[k];
                if (leftgas < 0) {
                    break;
                }
            }
            if (j == len) {
                return i;
            } else {
                i += j + 1;
            }
        }
        return -1;
    }
}
