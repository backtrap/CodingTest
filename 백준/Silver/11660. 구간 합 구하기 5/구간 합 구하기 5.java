import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int [][] arr = new int [N+1][N+1];
        int [][] subSum = new int [N+1][N+1];
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
            
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer2.nextToken());
            }
        }
        
        for (int i = 1; i <= N; i++) {
            subSum[1][i] = subSum[1][i-1] + arr[1][i];
            subSum[i][1] = subSum[i-1][1] + arr[i][1];
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                subSum[i][j] = subSum[i-1][j] + subSum[i][j-1] - subSum[i-1][j-1] + arr[i][j];
            }
        }
        
        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer3 = new StringTokenizer(bufferedReader.readLine());
            
            int x1 = Integer.parseInt(stringTokenizer3.nextToken());
            int y1 = Integer.parseInt(stringTokenizer3.nextToken());
            int x2 = Integer.parseInt(stringTokenizer3.nextToken());
            int y2 = Integer.parseInt(stringTokenizer3.nextToken());
            
            int sum = subSum[x2][y2] - subSum[x1-1][y2] - subSum[x2][y1-1] + subSum[x1-1][y1-1];
            
            bufferedWriter.write("" + sum + "\n");
        }
        
        bufferedWriter.flush();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}