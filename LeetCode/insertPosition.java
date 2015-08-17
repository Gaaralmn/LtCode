/**
 *  Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * @author Qing Wang
 * Tag: Binary Search  Take care of the edge of the array!
 */
public class insertPosition {
    public static int searchInsert(int[] A, int target) {
        return binarySearch(0, A.length - 1, target, A);
    }
    
    public static int binarySearch(int start, int end, int target, int[] A) {
        if (start >= end) {
            if (target > A[end]) {
                return end + 1;
            } else {
                return end;
            }
        } else {
            int mid = (end + start + 1) / 2;
            if (target == A[mid]) {
                return mid;
            } else if (target > A[mid]) {
                return binarySearch(mid + 1, end, target, A);
            } else {
                return binarySearch(start, mid - 1, target, A);
            }
        }
    }

    public static void main(String[] args) {
    	int[] A = {1, 3, 5, 6, 7};
    	int target = 6;
    	System.out.println(searchInsert(A, target));
    }
}