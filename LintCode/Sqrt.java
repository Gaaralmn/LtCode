class Sqrt {
    /**
     * @tag: Even though this problem is easy, it needs to be reconsidered
     */
    public int sqrt(int x) {
        long start = 0;
        long end = x;
        while (start <= end) { // Must be <= rather than <
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                end = mid - 1; //Can not be mid, must - 1
            } else {
                start = mid + 1; // Can not be mid, must - 1
            }
        }
        return (int)end;
    }
}
