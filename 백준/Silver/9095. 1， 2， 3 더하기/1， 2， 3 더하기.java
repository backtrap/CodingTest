import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(bufferedReader.readLine());
        
        int [] arr = new int [T];
        int max = 4;
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            
            arr[i] = n;
            max = Math.max(max, n);
        }
        
        int [] dp = new int [max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        
        if (max > 4) {
            for (int i = 5; i <= max; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        
        for (int i = 0; i < T; i++) {
            bufferedWriter.write("" + dp[arr[i]] + "\n");
        }
        
        bufferedWriter.flush();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}