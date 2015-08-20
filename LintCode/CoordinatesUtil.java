import java.util.*;
import java.io.*;
public class CoordinatesUtil {
    class Point implements Comparable<Point> {
        private int x;
        private int y;
        private distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = getDistanceToZero(x, y);
        }

        public int getDistanceToZero(int x, int y) {
            int num = x * x + y * y;
            return Math.sqrt(num);
        }

        public int compareTo(Point p) {
            return distance - p.distance;
        }
    }
    public Point[] getCoordsNearZero(Point[] points) {
        if (points.length <= 10) {
            return points;
        }
        Arrays.sort(points);
        return copyOf(points, 11);
    }

    public Point[] getPointsFromPath(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundExeption e) {
            e.printStackTrace();
        }
        List<Point> list = new ArrsyList<Point>();
        String line = br.readLine();
        while (line.charAt(0) != '8') {
            line = br.readLine;
        }
        while (line != null && line.length() != 0) {
            String[] temp = line.split("");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            list.add(new Point(x, y));
        }
        Point[] points = new Point[list.size()];
        for (int i = 0; i < list.size(); i++) {
            points[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        CoordinatesUtil CU = new CoordinatesUtil();
        String path = "./engineer.txt";
        Point[] points = CU.getPointsFromPath(path);
        return CU.getCoordsNearZero(points);
    }
}
