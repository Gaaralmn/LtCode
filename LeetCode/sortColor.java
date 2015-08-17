/** Sort Color
 * Given an array with n objects colored red, white or blue, sort them so that 
 * objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * @author Qing Wang
 * Tag: Counting sort, two pointers
 */
public class sortColor {
    public static void main(String[] args) {
    	int[] A = {1, 0};
        int[] result = new int[A.length];
        int[] count = new int[3];
        for (int i = 0; i < A.length; i++) {
        	System.out.print(A[i]);
            count[A[i]]++;
        }
        System.out.println();
        for (int i = 1; i < 3; i++) {
            count[i] = count[i] + count[i - 1]; 
        }
        for (int i = 0; i < A.length; i++) {
            result[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }
        A = result;
        for (int i = 0; i < A.length; i++) {
        	System.out.print(A[i]);
        }
        System.out.println();
    }
}