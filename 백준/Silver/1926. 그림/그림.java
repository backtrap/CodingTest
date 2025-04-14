import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = bufferedReader.readLine();
        String [] srr = firstLine.split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);
        List<Integer> [] graph = new ArrayList [n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            String secondLine = bufferedReader.readLine();
            String [] srr2 = secondLine.split(" ");
            
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(srr2[j]);
                graph[i].add(num);
            }
        }
        
        dfs(graph);
        
    }
    
    public static void dfs(List<Integer>[] graph) {
        int n = graph.length;
        int m = graph[0].size();
        List<Boolean>[] visited = new ArrayList [n];
        Stack<int []> stack = new Stack<>();
        int max = 0;
        int count = 0;
    
        for (int i = 0; i < n; i++) {
            visited[i] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                visited[i].add(false);
            }
        }
    
        int [] dx = new int [] {-1, 1, 0, 0};
        int [] dy = new int [] {0, 0, -1, 1};
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i].get(j) == 1 && !visited[i].get(j)) {
                    stack.push(new int [] {i, j});
                    visited[i].set(j, true);
                    int tempSize = 1;
    
                    while (!stack.isEmpty()) {
                        int [] current = stack.pop();
                        int x = current[0];
                        int y = current[1];
    
                        for (int k = 0; k < 4; k++) {
                            int x2 = x + dx[k];
                            int y2 = y + dy[k];
    
                            if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < m) {
                                if (graph[x2].get(y2) == 1 && !visited[x2].get(y2)) {
                                    stack.push(new int [] {x2, y2});
                                    visited[x2].set(y2, true);
                                    tempSize++;
                                }
                            }
                        }
                    }
    
                    count++;
                    max = Math.max(max, tempSize);
                }
            }
        }
    
        System.out.println(count);
        System.out.println(max);
    }

}