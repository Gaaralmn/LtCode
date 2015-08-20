import java.util.*;
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n <= 0) {
            return result;
        }
        List<Integer> path  = new ArrayList<Integer>();
        search(result, path, n);
        return result;
    }

    public List<String> drawChessBoard(List<Integer> path) {
        int n = path.size();
        List<String> result = new ArrayList<String>();
        for (int val : path) {
            StringBuilder SB = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == val) {
                    SB.append("Q");
                } else {
                    SB.append(".");
                }
            }
            result.add(new String(SB));
        }
        return result;
    }

    public void search(List<List<String>> result, List<Integer> path, int n) {
        if (path.size() == n) {
            result.add(drawChessBoard(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(path, i)) {
                continue;
            }
            path.add(i);
            search(result, path, n);
            path.remove(path.size() - 1);
        }
    }

    public boolean isValid(List<Integer> path, int col) {
        int row = path.size();
        for (int i = 0; i < row; i++) {
            if (path.get(i) == col) {
                return false;
            }
            if (i + path.get(i) == row + col) {
                return false;
            }
            if (i - path.get(i) == row - col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        NQueens NQ = new NQueens();
        List<List<String>> result = NQ.solveNQueens(8);
        List<String> example = result.get(0);
        for (String str : example) {
            System.out.println(str);
        }
    }
}
