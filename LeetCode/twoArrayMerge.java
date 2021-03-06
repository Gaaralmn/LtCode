/**
 * LeetCode 88 Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Tag: Two pointers
 * Take care of the edge conditions!!!!!! 
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        while(m > 0 && n > 0) {
            if(A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        while(n > 0) {
            A[m + n - 1] = B[n - 1];
            n--;
        }
    }
}