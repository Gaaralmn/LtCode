/** Reverse Integer 
 */
public class reverseInt {
    public static int reverse(int x) {
         long y = (long)x;
         String s = String.valueOf(y);
         boolean isPos = true;
         int len = s.length();
         if (y < 0) {
             isPos = false;
             len = len - 1;
         }
         y = Math.abs(y);
         if (len >= 10 && (y % 10) > 2) {
             return 0;
         }
         int facLen = 1;
         long result = 0;
         while (facLen <= len) {
            long digit = y % 10;
            result += digit * (long)Math.pow(10, len - facLen);
            y = (y - digit) / 10;
            facLen++;
         }
         if (isPos) {
             if (result > (long)Integer.MAX_VALUE) {
                 return 0;
             }
             return (int)result;
         } else {
             if (result * (-1) < (long)Integer.MIN_VALUE) {
                 return 0;
             }
             System.out.println(result);
             return (int)result * (-1);
         }
    }

    public static int reverse1(int x) {
         int sign = 1;
         int curv = Integer.MAX_VALUE / 10;
         int result = 0;
         if (x < 0) {
             sign = -1;
         }
         x = Math.abs(x);
         while (x > 0) {
             int digit = x % 10;
             result = result * 10 + digit;
             if (result > curv || (result == curv && digit >= 2)) {
             	 if (result > curv) {
             	 	System.out.println(result);
             	 	System.out.println(curv);
             	 	System.out.println("result > curv");
             	 } else {
             	 	System.out.println("result == curv && digit >= 2");
             	 }
                 return 0;
             }
             x = x /10;
         }
         return result * sign;
    }

    public static void main(String[] args) {
    	int x = -2147483412;
    	System.out.println(reverse1(x));
    }
}