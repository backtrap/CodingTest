import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            
            list.add(num);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for (int i = 0; i < N; i++) {
            bufferedWriter.write(String.valueOf(list.get(i)));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}