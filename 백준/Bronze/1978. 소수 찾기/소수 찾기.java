import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            boolean isPrime = true;
            
            if (num == 1) {
                continue;
            }
            
            for (int j = 2; j <= Math.sqrt(num) && isPrime; j++) {
                if (num%j == 0) {
                    isPrime = false;
                }
            }
            
            if (isPrime) {
                count++;
            }
        }
        
        System.out.println(count);
        
        scanner.close();
    }
}