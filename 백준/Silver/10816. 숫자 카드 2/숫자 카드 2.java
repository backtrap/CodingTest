import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = scanner.nextInt();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        int M = scanner.nextInt();
        scanner.nextLine();
        String fourthLine = scanner.nextLine();
        
        String [] srr1 = secondLine.split(" ");
        String [] srr2 = fourthLine.split(" ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(srr1[i]);
            
            if (hashMap.containsKey(num)) {
                int count = hashMap.get(num);
                count++;
                hashMap.put(num, count);
            }
            else {
                hashMap.put(num, 1);
            }
        }
        
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(srr2[i]);
            
            if (hashMap.containsKey(num)) {
                bufferedWriter.write(hashMap.get(num) + " ");
            }
            else {
                bufferedWriter.write(0 + " ");
            }
        }
        
        bufferedWriter.flush();
        
        scanner.close();
        bufferedWriter.close();
    }
}