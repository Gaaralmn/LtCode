public class JumpGameII {
    public int getSteps(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] steps = new int[A.length];
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = -1;
            for (int j = 0; j < i; i++) {
                if (steps[j] != -1 && A[j] + j >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[A.length - 1];
    }

    public int getSteps(int[] A) {
        if (A == null && A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = 0;
        int steps = 0;
        while (end < A.length - 1 && steps < A.length) {
            steps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (i <= farthest && farthest <= A[i] + i) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        if (steps >= A.length) {
            return -1;
        }
        return steps;
    }
}
