public class SearchInsertPosition {
    public int searchInsertPosition(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) { //Really important here
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //Find the first number that is larger than target
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
