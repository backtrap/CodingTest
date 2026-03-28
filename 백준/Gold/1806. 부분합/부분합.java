import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        
        scanner.nextLine();
        
        int [] arr = new int [N+1];
        
        String secondLine = scanner.nextLine();
        
        scanner.close();
        
        StringTokenizer stringTokenizer = new StringTokenizer(secondLine);
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        
        int min = N + 1;
        int sum = 0;
        int end = 1;
        
        for (int start = 1; start <= N; start++) {
            while (end <= N && sum < S) {
                sum += arr[end];
                end++;
            }
            
            if (sum >= S) {
                min = Math.min(min, end-start);
            }
            
            sum -= arr[start];
        }
        
        if (min == (N+1)) {
            System.out.println(0);
            
            return ;
        }
        
        System.out.println(min);
    }
}