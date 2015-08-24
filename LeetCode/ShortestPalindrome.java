public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "adsfasdfjlkasd";
        System.out.println(shortestPalindrome(s));
    }

    public static int helper(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int end = 1;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    if (i == 0) {
                        if (j > end) {
                            end = j;
                        }
                    }
                }
            }
        }
        return end;
    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        int len = s.length();
        int end = helper(s);
        StringBuilder SB = new StringBuilder();
        for (int i = len - 1; i >= end; i--) {
            SB.append(s.charAt(i));
        }
        SB.append(s);
        // String result = new String(SB);
        return SB.toString();
    }
}
