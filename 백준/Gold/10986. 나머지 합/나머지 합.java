import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String [] firstLine = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        
        String [] secondLine = bufferedReader.readLine().split(" ");
        
        int[] numArray   = new int [N];
        int[] prefixSum  = new int [N];
        long[] modResult = new long[M];   // int → long
        
        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(secondLine[i]);
        }
        
        // 1) prefixSum[0] 세팅 및 modResult 누적
        prefixSum[0] = numArray[0] % M;
        if (prefixSum[0] < 0) prefixSum[0] += M;  // 필요없다면 생략
        modResult[prefixSum[0]]++;
        
        // 2) i=1..N-1
        for (int i = 1; i < N; i++) {
            prefixSum[i] = (prefixSum[i-1] + numArray[i]) % M;
            if (prefixSum[i] < 0) prefixSum[i] += M;
            modResult[prefixSum[i]]++;
        }
        
        // 3) 단일 prefix가 0인 경우
        long count = modResult[0];
        
        // 4) 같은 나머지끼리 nC2
        for (int r = 0; r < M; r++) {
            if (modResult[r] >= 2) {
                count += modResult[r] * (modResult[r] - 1) / 2;
            }
        }
        
        System.out.println(count);
        bufferedReader.close();
    }
}
