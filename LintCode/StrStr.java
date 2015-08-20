class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int j;
        for (int i = 0; i <= source.length() - target.length(); i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

    //Notice the mistake you made in the following solution under the case ("", "")
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int j;
        for (int i = 0; i <= source.length() - target.length(); i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
                if (j == target.length() - 1) {
                    //target.length() - 1 = -1 when the input is ("", "")
                    return i;
                }
            }
        }
        return -1;
    }
}
