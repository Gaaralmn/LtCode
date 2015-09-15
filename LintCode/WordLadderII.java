import java.util.*;
public class WordLadderII {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public static void main(String[] args) {
        String start = "a";
        String end = "c";
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        findLadders(start, end, dict);
    }

    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        Map<String, Integer> distances = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);

        bfs(map, distances, start, dict);
        System.out.println("distances: " + distances.get(end));
        System.out.println("map: " + map.get(end).get(0));
        ArrayList<String> path = new ArrayList<String>();
        dfs(ladders, map, distances, path, end, start);
        return ladders;
    }

    public static void dfs (List<List<String>> ladders, Map<String, ArrayList<String>> map, Map<String, Integer> distances, ArrayList<String> path, String end, String start) {
        path.add(end);
        if (end.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(end)) {
                if (distances.containsKey(next) && distances.get(next) + 1 == distances.get(end)) {
                    dfs(ladders, map, distances, path, next, start);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public static void bfs(Map<String, ArrayList<String>> map, Map<String, Integer> distances, String start, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distances.put(start, 0);
        for (String str : dict) {
            map.put(str, new ArrayList<String>());
        }
        while (!queue.isEmpty()) {
            String word = queue.poll();
            ArrayList<String> wordList = getNextWordList(word, dict);
            for (String next : wordList) {
                map.get(next).add(word);
                if (!distances.containsKey(next)) {
                    distances.put(next, distances.get(word) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    public static ArrayList<String> getNextWordList(String word, Set<String> dict) {
        ArrayList<String> wordList = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, i, c);
                if (dict.contains(newWord)) {
                    wordList.add(newWord);
                }
            }
        }
        return wordList;
    }

    public static String replace(String word, int index, char c) {
        char[] carr = word.toCharArray();
        carr[index] = c;
        return String.valueOf(carr);
    }
}
