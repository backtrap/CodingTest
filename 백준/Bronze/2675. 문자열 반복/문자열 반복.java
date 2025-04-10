import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(bufferedReader.readLine());
        
        for (int i = 0; i < T; i++) {
            String str = bufferedReader.readLine();
            String [] srr = str.split(" ");
            int N = Integer.parseInt(srr[0]);
            char [] crr = srr[1].toCharArray();
            
            for (int j = 0; j < srr[1].length(); j++) {
                for (int k = 0; k < N; k++) {
                    bufferedWriter.write(crr[j]);
                }
            }
            
            bufferedWriter.newLine();
        }
        
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}