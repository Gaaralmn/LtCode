import java.util.*;
public class BinaryRepresentation {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public static void main(String[] args) {
        BinaryRepresentation BR = new BinaryRepresentation();
        String str = "2.0";
        System.out.println(BR.binaryRepresentation(str));
    }

    public String parseInteger(String n) {
        if (n.equals("0") || n.equals("")) {
            return "0";
        }
        int num = Integer.parseInt(n);
        String result = "";
        while (num > 0) { // I made a mistake here that I wrote while as if
            result = Integer.toString(num % 2) + result;
            num = num / 2;
        }
        return result;
    }

    public String parseFloat(String n) {
        double num = Double.parseDouble("0." + n);
        String result = "";
        HashSet<Double> set = new HashSet<Double>();
        while (num > 0) {
            if (result.length() >= 32 || set.contains(num)) {
                return "ERROR";
            }

            num *= 2;
            if (num > 1) { // Should be >= 1
                result += "1";
                num -= 1;
            } else {
                result += "0";
            }
        }
        return result;
    }

    public String binaryRepresentation(String n) {
        if (n.indexOf(".") == -1) {
            return parseInteger(n);
        }
        String[] params = n.split("\\.");
        System.out.println("params[0] " + params[0]);
        String left = parseInteger(params[0]);
        String right = parseFloat(params[1]);
        if (right == "ERROR") {
            return right;
        }
        if (right.equals("0") || right.equals("")) {
            return left;
        }
        return left + "." + right;
    }
}
