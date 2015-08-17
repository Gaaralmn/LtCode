public class cmpVersionNum {
    public static int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        return compareVersion(str1, str2, 0);
    }
    
    public static int compareVersion(String[] str1, String[] str2, int index) {
        if (str1.length <= index || str2.length <= index) {
            if (str1.length > str2.length) {
                return 1;
            } else {
                return -1;
            }
        } else {
           if (Integer.parseInt(str1[index]) > Integer.parseInt(str2[index])) {
                return 1;
            } else if (Integer.parseInt(str1[index]) < Integer.parseInt(str2[index])) {
                return -1;
            } else {
        
            return compareVersion(str1, str2, ++index);
            } 
        }
    }
    /**
     * Good code!
     */
    public int compareVersion1(String version1, String version2) {
        for (int i = 0, j = 0; i < version1.length() || j < version2.length(); i++, j++) {
            int num1 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            int num2 = 0;
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (num1 > num2) {
                return 1;
            } 
            if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1";
        String version2 = "1.1";
        System.out.println(compareVersion(version1, version2));
    }
}