import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] firstLine = bufferedReader.readLine().split(" ");
        
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        
        int [] arr = new int[N];
        int [] subset = new int [N];
        
        String [] secondLine = bufferedReader.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }
        
        subset[0] = arr[0];
        
        for (int i = 1; i < N; i++) {
            subset[i] = subset[i-1] + arr[i];
        }
        
        for (int i = 0; i < M; i++) {
            String [] quiz = bufferedReader.readLine().split(" ");
            
            int start = Integer.parseInt(quiz[0]) - 1;
            int last = Integer.parseInt(quiz[1]) - 1;
            int sum = -1;
            
            if (start == 0) {
                sum = subset[last];
            }
            else {
                sum = subset[last] - subset[start-1];
            }

            bufferedWriter.write("" + sum + "\n");
        }
        
        bufferedWriter.flush();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}