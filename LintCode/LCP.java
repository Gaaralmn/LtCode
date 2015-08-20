public class LCP {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     # @tag: Double check for this problem, this is a good example for corner cases.
     */
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        result = strs[0];//Very important corner case
        for (int i = 0; i < strs.length - 1; i++) {
            String temp = getPrefix(strs[i], strs[i + 1]);
            if (temp.length() < result.length()) {
                result = temp;
            }
        }
        return result;
    }

    public String getPrefix(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            sb.append(str1.charAt(i));
        }
        return sb.toString();
    }
}
