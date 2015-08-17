/** Generate Parenthesis
 */
 public class generateParen {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n == 1) {
            list.add("()");
            return list;
        }
        List<String> tmplist = generateParenthesis(n - 1);
        for (String s : tmplist) {
            if (!list.contains("(" + s + ")")) {
                list.add("(" + s + ")");
            }
            if (!list.contains("()" + s)) {
                list.add("()" + s);
            }
            if (!list.contains(s + "()")) {
                list.add(s + "()");
            }
        }
        return list;
    }
}