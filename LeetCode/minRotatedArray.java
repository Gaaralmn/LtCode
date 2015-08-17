/** Find Minimum in Rotated Sorted Array 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * @author Qing Wang
 * Tag: Binary Search
 */
public class minRotatedArray {
    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
        
    }
    public int findMin(int[] num, int start, int end) {
        if (num[start] <= num[end]) {
            return num[start];
        }
        int mid = (start + end) / 2;
        if (num[mid] > num[start]) {
            return findMin(num, mid + 1, end);
        } else if (num[mid] < num[start]) {
            return findMin(num, start, mid);
        } else {
            return Math.min(num[start], num[end]);
        }
        
    }
}