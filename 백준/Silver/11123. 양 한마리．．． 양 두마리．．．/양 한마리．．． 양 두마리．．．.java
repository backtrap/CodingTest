import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = bufferedReader.readLine();
        int T = Integer.parseInt(firstLine);
        
        for (int i = 0; i < T; i++) {
            String commandLine = bufferedReader.readLine();
            String [] srr = commandLine.split(" ");
            int H = Integer.parseInt(srr[0]);
            int W = Integer.parseInt(srr[1]);
            boolean [][] map = new boolean[H][W];
            
            for (int j = 0; j < H; j++) {
                String makeMap = bufferedReader.readLine();
                char [] crr = makeMap.toCharArray();
                
                for (int k = 0; k < W; k++) {
                    if (crr[k] == '#') {
                        map[j][k] = true;
                    }
                    else if (crr[k] == '.') {
                        map[j][k] = false;
                    }
                }
            }
            
            dfs(map);
        }
    }
    
    public static void dfs(boolean [][] map) {
        int W = map[0].length;
        int H = map.length;
        boolean [][] visited = new boolean [H][W];
        int count = 0;
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] && !visited[i][j]) {
                    Stack<int []> stack = new Stack<>();
                    stack.push(new int [] {i, j});
                    visited[i][j] = true;
                    
                    while (!stack.isEmpty()) {
                        int [] current = stack.pop();
                        int x = current[0];
                        int y = current[1];
                        
                        for (int k = 0; k < 4; k++) {
                            int x2 = x + dx[k];
                            int y2 = y + dy[k];
                                
                            if (x2 >= 0 && x2 < H && y2 >= 0 && y2 < W) {
                                if (map[x2][y2] && !visited[x2][y2]) {
                                    stack.push(new int [] {x2, y2});
                                    visited[x2][y2] = true;
                                }
                            }
                        }
                    }
                    
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}