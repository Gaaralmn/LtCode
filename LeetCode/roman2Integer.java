/** Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author Qing Wang
 */
import java.util.*;
public class roman2Integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int last = map.get(s.charAt(0));
        int result = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            result += map.get(s.charAt(i));
            if (map.get(s.charAt(i)) > last) {
                result -= 2 * last;
            }
            last = map.get(s.charAt(i));
        }
        return result;
    }
}