import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        
        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];
        int[] start = new int[2];
        
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                
                if (map[i][j] == 2) {
                    start[0] = j; // x 좌표
                    start[1] = i; // y 좌표
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[] {start[0], start[1]}); // (x, y)
        visited[start[1]][start[0]] = true;
        answer[start[1]][start[0]] = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int x2 = x + dx[i];
                int y2 = y + dy[i];
                
                if (x2 < 0 || x2 >= m || y2 < 0 || y2 >= n) {
                    continue;
                }
                
                if (visited[y2][x2]) {
                    continue;
                }
                
                if (map[y2][x2] == 0) {
                    continue;
                }
                
                queue.offer(new int[] {x2, y2});
                visited[y2][x2] = true;
                answer[y2][x2] = answer[y][x] + 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j != 0) {
                    bufferedWriter.write(" ");
                }
                
                if (map[i][j] == 0) {
                    bufferedWriter.write("0");
                } else if (!visited[i][j]) {
                    bufferedWriter.write("-1");
                } else {
                    bufferedWriter.write(String.valueOf(answer[i][j]));
                }
            }
            bufferedWriter.newLine();
        }
        
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
