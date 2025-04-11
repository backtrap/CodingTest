import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = bufferedReader.readLine();
        int N = Integer.parseInt(firstLine);
        String secondLine = bufferedReader.readLine();
        String [] srr = secondLine.split(" ");
        List<Integer> score = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            score.add(Integer.parseInt(srr[i]));
        }
        
        Collections.sort(score, Collections.reverseOrder());
        
        int M = score.get(0);
        double sum = 0;
        
        for (int i = 0; i < N; i++) {
            double num = (double)score.get(i)/M * 100;
            sum += num;
        }
        
        System.out.println(sum/N);
    }
}