public class searchRange {
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(-1);
        result.add(-1);
        if (A.size() == 0) {
            return result;
        }
        int start = 0;
        int end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A.get(start) == target) {
            result.set(0, start);
        } else if (A.get(end) == target){
            result.set(0, end);
        } else {
            return result;
        }
        start = 0;
        end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A.get(end) == target) {
            result.set(1, end);
        } else {
            result.set(1, start);
        }
        return result;
    }
}
