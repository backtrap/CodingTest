import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        int [] arr = new int [N];
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            arr[i] = num;
        }
        
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length; i++) {
            bufferedWriter.write(String.valueOf(arr[i]));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}