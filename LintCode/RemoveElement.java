public class RemoveElement {
    /**
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) { //Watch out to this corner case
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if (A[left] == elem && A[right] != elem) {
                swap(A, left, right);
            } else {
                if (A[left] != elem) {
                    left++;
                }
                if (A[right] == elem) {
                    right--;
                }
            }
        }
        if (A[left] != elem) {
            A = Arrays.copyOf(A, left + 1);
            return left + 1;
        }
        if (A[right] != elem) {
            A = Arrays.copyOf(A, right + 1);
            return right + 1;
        }
        A = Arrays.copyOf(A, left);
        return left;
    }

    public void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
