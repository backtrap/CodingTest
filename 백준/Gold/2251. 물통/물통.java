import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        
        dfs(A, B, C);
    }
    
    public static void dfs(int A, int B, int C) {
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];
        List<Integer> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] max = new int[]{A, B, C};
    
        queue.offer(new int[]{0, 0, C});
        visited[0][0][C] = true;
    
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int a = current[0];
            int b = current[1];
            int c = current[2];
    
            if (a == 0 && !result.contains(c)) {
                result.add(c);
            }
    
            int[] bottle = new int[]{a, b, c};
    
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
    
                    int[] next = changeBottle(max, bottle, from, to);
                    int na = next[0], nb = next[1], nc = next[2];
    
                    if (!visited[na][nb][nc]) {
                        visited[na][nb][nc] = true;
                        queue.offer(next);
                    }
                }
            }
        }
    
        Collections.sort(result);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    
    public static int[] changeBottle(int[] max, int[] bottle, int start, int dest) {
        int[] newBottle = Arrays.copyOf(bottle, 3);
    
        int move = Math.min(bottle[start], max[dest] - bottle[dest]);
    
        newBottle[start] -= move;
        newBottle[dest] += move;
    
        return newBottle;
    }
}