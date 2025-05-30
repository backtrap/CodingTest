import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int size = Math.max(n, 2);
        int [] dp = new int [size+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }

        System.out.println(dp[n]);
        
        scanner.close();
    }
}