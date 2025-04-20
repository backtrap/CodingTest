import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Point implements Comparable<Point> {
    public int x;
    public int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point other) { // this 객체가 더 크면 양수 반환
        if (this.x == other.x) {
            return this.y - other.y;
        }
        else {
            return this.x - other.x;
        }
    }
}

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        List<Point> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String [] srr = new String [2];
            srr = bufferedReader.readLine().split(" ");
            
            list.add(new Point(Integer.parseInt(srr[0]), Integer.parseInt(srr[1])));
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < N; i++) {
            bufferedWriter.write(String.valueOf(list.get(i).x));
            bufferedWriter.write(" ");
            bufferedWriter.write(String.valueOf(list.get(i).y));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}