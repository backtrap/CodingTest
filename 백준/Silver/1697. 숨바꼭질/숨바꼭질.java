import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();

        int[] visited = new int[300001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(visited[current] - 1);
                break;
            }

            int next1 = current * 2;
            if (next1 <= 300000 && visited[next1] == 0) {
                queue.offer(next1);
                visited[next1] = visited[current] + 1;
            }

            int next2 = current + 1;
            if (next2 <= 300000 && visited[next2] == 0) {
                queue.offer(next2);
                visited[next2] = visited[current] + 1;
            }

            int next3 = current - 1;
            if (next3 >= 0 && visited[next3] == 0) {
                queue.offer(next3);
                visited[next3] = visited[current] + 1;
            }
        }
    }
}
