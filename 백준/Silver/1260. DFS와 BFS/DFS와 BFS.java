import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = bufferedReader.readLine();
        String [] srr = firstLine.split(" ");
        int N = Integer.parseInt(srr[0]);
        int M = Integer.parseInt(srr[1]);
        int V = Integer.parseInt(srr[2]);
        
        boolean [][] graph = new boolean[N][N];
        
        for (int i = 0; i < M; i++) {
            String edge = bufferedReader.readLine();
            String [] srr02 = edge.split(" ");
            int x = Integer.parseInt(srr02[0]);
            int y = Integer.parseInt(srr02[1]);
            
            graph[x-1][y-1] = true;
            graph[y-1][x-1] = true;
        }
        
        dfs(graph, V);
        bfs(graph, V);
        
        bufferedReader.close();
    }
    
    public static void dfs(boolean [][] graph, int V) {
        int N = graph.length;
        boolean [] visited = new boolean [N];
        int current = V;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        stack.push(current);
        
        while (!stack.isEmpty()) {
            current = stack.pop();
            
            if (visited[current-1]) {
                continue;
            }
            
            visited[current-1] = true;
            list.add(current);
            
            for (int i = N; i >= 1; i--) {
                if (graph[current-1][i-1] && !visited[i-1]) {
                    stack.push(i);
                }
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        
        System.out.println();
    }
    
    public static void bfs(boolean [][] graph, int V) {
        int N = graph.length;
        boolean [] visited = new boolean [N];
        int current = V;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        queue.offer(current);
        
        while(!queue.isEmpty()) {
            current = queue.poll();
            
            if (visited[current-1]) {
                continue;
            }
            
            visited[current-1] = true;
            list.add(current);
            
            for (int i = 1; i <= N; i++) {
                if (graph[current-1][i-1] && !visited[i-1]) {
                    queue.offer(i);
                }
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        
        System.out.println();
    }
}