import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            boolean [][] map = new boolean [N][M];
            
            for (int j = 0; j < K; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                map[y][x] = true;
            }
            
            int answer = dfs(map);
            
            System.out.println(answer);
        }
        
        scanner.close();
    }
    
    public static int dfs(boolean [][] map) {
        int M = map[0].length;
        int N = map.length;
        boolean [][] visited = new boolean[N][M];
        int count = 0;

        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};
        
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (map[y][x] && !visited[y][x]) {
                    visited[y][x] = true;
                    count++;
                    Stack<int []> stack = new Stack<>();
                    stack.push(new int [] {y, x});
                    
                    while (!stack.isEmpty()) {
                        int [] current = stack.pop();
                        int y1 = current[0];
                        int x1 = current[1];
                        
                        for (int i = 0; i < 4; i++) {
                            int y2 = y1 + dy[i];
                            int x2 = x1 + dx[i];
                            
                            if (x2 >= 0 && x2 < M && y2 >= 0 && y2 < N) {
                                if (map[y2][x2] && !visited[y2][x2]) {
                                    stack.push(new int [] {y2, x2});
                                    visited[y2][x2] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }        
}