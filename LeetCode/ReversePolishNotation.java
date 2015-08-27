/**
 * @tag: To be familiar with the use of stack
 */
 public class ReversePoishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String operator = "+-*/";
        for (String str : tokens) {
            if (!operator.contains(str)) {
                stack.push(Integer.valueOf(str));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if (str == "+") {
                    stack.push(b + a); //The sequence is important here
                } else if (str == "-") {
                    stack.push(b - a);
                } else if (str == "*") {
                    stack.push(b * a);
                } else {
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }
 }
