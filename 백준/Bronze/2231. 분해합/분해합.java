import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;
            int num = i;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == N) {
                result = i;
                break; 
            }
        }

        System.out.println(result);
    }
}
