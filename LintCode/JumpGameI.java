public class JumpGameI {
    //Solved with DP method
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int[] flag = new int[A.length];
        flag[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && A[j] + j >= i) {
                    can[i] = true;
                    break; //Really important step to prevent some unnecessary steps
                }
            }
        }
        return can[A.length - 1];
    }
    //Solved with Greedy method
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && farthest < A[i] + i) {
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }
}
