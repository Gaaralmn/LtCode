import java.util.*;
public class validParen {
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.size() == 0) {
                    System.out.println("stack.size() == 0");
                    return false;
                }
                char c = stack.pop();
                if (map.get(c) != s.charAt(i)) {
                    System.out.println(map.get(c));
                    System.out.println(s.charAt(i));
                    System.out.println("map.get(c) != s.charAt(i)");
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            System.out.println("stack.size() != 0");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}