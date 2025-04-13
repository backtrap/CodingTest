import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] srr = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(srr[0]) - 1;
            int y = Integer.parseInt(srr[1]) - 1;

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(graph);

        bufferedReader.close();
    }

    public static void dfs(List<Integer>[] graph) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = graph.length;
        boolean[] visited = new boolean[N];
        int[] parent = new int[N];
        Stack<Integer> stack = new Stack<>();

        stack.push(0); 
        visited[0] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    parent[next] = current + 1;
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }

        for (int i = 1; i < N; i++) {
            bufferedWriter.write(String.valueOf(parent[i]));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
