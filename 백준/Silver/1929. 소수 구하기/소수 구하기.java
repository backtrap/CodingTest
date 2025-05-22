import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<Integer> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            if (i < 2) continue;

            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            bufferedWriter.write(list.get(i).toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        scanner.close();
        bufferedWriter.close();
    }
}
