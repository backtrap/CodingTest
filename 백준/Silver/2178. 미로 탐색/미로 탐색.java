import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        
        int [][] map = new int [N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
            String input = scanner.nextLine();
            
            for (int j = 1; j <= M; j++) {
                map[i][j] = (int)input.charAt(j-1) - '0';
            }
        }
        
        int min = bfs(N, M, map);
        
        System.out.print(min);
    }
    
    public static int bfs(int N, int M, int [][] map) {
        Queue<int []> queue = new LinkedList<>();
        
        int [][] visited = new int [N+1][M+1];
        visited[1][1] = 1;
        
        // 시계방향으로 북동남서
        int [] dx = {0, 1, 0, -1};
        int [] dy = {-1, 0, 1, 0};
        
        queue.offer(new int [] {1, 1});
        
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if (x == N && y == M) {
                return visited[x][y];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                
                if (map[nx][ny] == 0) {
                    continue;
                }
                
                if (visited[nx][ny] != 0) {
                    continue;
                }
                
                queue.offer(new int [] {nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }
        }
        
        return visited[N][M];
    }
}