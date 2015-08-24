import java.util.*;
public class PalindromePartition {
    public static void main(String[] args) {
        PalindromePartition PP = new PalindromePartition();
        String s = "aasdfjghaahgsdfklala";
        List<List<String>> result = PP.partition(s);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null && s.length() == 0) {
            return result;
        }
        List<String> path = new ArrayList<String>();
        search(result, path, 0, s);
        return result;
    }

    public void search(List<List<String>> result, List<String> path, int pos, String s) {
        if (pos >= s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String temp = s.substring(pos, i + 1);
            if (!isPalindrome(temp)) {
                continue;
            }
            path.add(temp);
            search(result, path, i + 1, s);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
