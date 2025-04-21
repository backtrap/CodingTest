import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point other) {
        if (this.y == other.y) {
            return this.x - other.x;
        }
        else {
            return this.y - other.y;
        }
    }
    
    String getPoint() {
        return "" + this.x + " " + this.y;
    }
}

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        List<Point> pointList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String [] srr = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(srr[0]);
            int y = Integer.parseInt(srr[1]);
            
            Point point = new Point(x, y);
            pointList.add(point);
        }
        
        Collections.sort(pointList);
        
        for (int i = 0; i < N; i++) {
            bufferedWriter.write(pointList.get(i).getPoint() + "\n");
        }
        
        bufferedWriter.flush();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}