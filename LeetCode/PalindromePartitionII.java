public class PalindromePartitionII {
    public int mincut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int[] result = new int[len];
        for (int j = 0; j < len; j++) {
            result[j] = j;
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    if (i > 0) {
                        result[j] = Math.min(result[j], result[i - 1] + 1)
                    } else {
                        result[j] = 0;
                    }
                }
            }
        }
        return result[len - 1];
    }
}
