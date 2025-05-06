import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        
        boolean [][] graph = new boolean [N][N];
        
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            
            graph[u-1][v-1] = true;
            graph[v-1][u-1] = true;
        }
        
        int answer = dfs(graph);
        
        System.out.println(answer);
        
        bufferedReader.close();
    }
    
    public static int dfs(boolean [][] graph) {
        int N = graph.length;
        boolean [] visited = new boolean [N];
        Stack<Integer> stack = new Stack<>();
        int connected = 0;
        
        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                stack.push(i);
                visited[i] = true;
                connected++;
            }
            else {
                continue;
            }
            
            while (stack.isEmpty() == false) {
                int next = stack.pop();
                
                for (int j = 0; j < N; j++) {
                    if (graph[next][j] && visited[j] == false) {
                        stack.push(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return connected;
    }
}