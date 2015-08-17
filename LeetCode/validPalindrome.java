/** Valid Palindrome
 */
public class validPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int len = s.length();
        s = s.toLowerCase();
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            while (i < len - 1 && (s.charAt(i) < 'a' || s.charAt(i) > 'z')) {
            	System.out.println(i);
                i++;
            }
            while (j > 0 && (s.charAt(j) < 'a' || s.charAt(i) > 'z')) {
                j--;
            }
            if (i > j) {
            	return true;
            }
            if (s.charAt(i) != s.charAt(j)) {
            	System.out.println("s.charAt(i) != s.charAt(j)");
          		System.out.println(s.charAt(i));
          		System.out.println(s.charAt(j));
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	String s = ".,";
    	System.out.println(s.length());
    	System.out.println(isPalindrome(s));
    }
}