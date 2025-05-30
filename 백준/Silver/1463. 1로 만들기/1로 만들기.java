import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int [] dp = new int [N+3];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            
            if (i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            
            if (i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }
        
        System.out.println(dp[N]);
    }
}