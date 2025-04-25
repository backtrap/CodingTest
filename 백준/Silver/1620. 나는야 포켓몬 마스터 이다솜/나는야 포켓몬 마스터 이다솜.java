import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] firstLine = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        
        HashMap<Integer, String> pokedex1 = new HashMap<>();
        HashMap<String, Integer> pokedex2 = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String name = bufferedReader.readLine();
            
            pokedex1.put(i+1, name);
            pokedex2.put(name, i+1);
        }
        
        for (int i = 0; i < M; i++) {
            String quiz = bufferedReader.readLine();
            char c = quiz.charAt(0);
            
            if (c >= 'A' && c <= 'Z') {
                bufferedWriter.write("" + pokedex2.get(quiz) + "\n");
            }
            else {
                int n = Integer.parseInt(quiz);
                bufferedWriter.write("" + pokedex1.get(n) + "\n");
            }
        }
        
        bufferedWriter.flush();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}