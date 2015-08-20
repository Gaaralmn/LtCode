import java.util.*;
import java.io.*;
public class CoordinatesUtil {
    class Point implements Comparable<Point> {
        private int x;
        private int y;
        private int distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = getDistanceToZero(x, y);
        }

        public int getDistanceToZero(int x, int y) {
            int num = x * x + y * y;
            return (int)Math.sqrt(num);
        }

        public int compareTo(Point p) {
            return distance - p.distance;
        }

        public String toString() {
            String result = x + " , " + y + " and distance is " + distance;
            return result;
        }
    }
    public Point[] getCoordsNearZero(Point[] points) {
        if (points.length <= 10) {
            return points;
        }
        Arrays.sort(points);
        return Arrays.copyOf(points, 11);
    }

    public Point[] getPointsFromPath(String path) throws IOException {
        List<Point> list = new ArrayList<Point>();
		File file = new File("engineer.txt");
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
			if (line != null && line.length() > 0 && line.charAt(0) == '8') {
				break;
			}
        }
        while (line != null && line.length() > 0) {
            String[] temp = line.split(", ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            list.add(new Point(x, y));
			line = br.readLine();
        }
        Point[] points = new Point[list.size()];
        for (int i = 0; i < list.size(); i++) {
            points[i] = list.get(i);
        }
        return points;
    }

    public static void main(String[] args) throws IOException {
        CoordinatesUtil CU = new CoordinatesUtil();
        String path = "engineer.txt";
        Point[] points = CU.getPointsFromPath(path);
        Point[] result = CU.getCoordsNearZero(points);
        for (Point p : result) {
            System.out.println(p.toString());
        }
    }
}
