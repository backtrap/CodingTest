import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int L = scanner.nextInt();
        scanner.nextLine(); 
        String str = scanner.nextLine();

        int r = 31;
        int M = 1234567891;

        char[] crr = str.toCharArray();
        long[] arr = new long[L];

        for (int i = 0; i < L; i++) {
            arr[i] = crr[i] - 'a' + 1;
        }

        long sum = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            sum = (sum + arr[i] * pow) % M;
            pow = (pow * r) % M;
        }

        System.out.println(sum);
    }
}
