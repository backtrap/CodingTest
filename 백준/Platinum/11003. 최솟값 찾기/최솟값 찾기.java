import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = bufferedReader.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int L = Integer.parseInt(firstLine[1]);

        String[] secondLine = bufferedReader.readLine().split(" ");
        int[] numArray = new int[N];

        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(secondLine[i]);
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int start = i - L + 1;

            while (!deque.isEmpty() && deque.peekFirst() < start) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && numArray[deque.peekLast()] >= numArray[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            bufferedWriter.write(numArray[deque.peekFirst()] + " ");
        }

        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
    }
}