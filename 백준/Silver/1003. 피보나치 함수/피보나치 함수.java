import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        int max = -1;
        int [] quiz = new int [T]; // index번째 문제의 숫자
        
        for (int i = 0; i < T; i++) {
            quiz[i] = scanner.nextInt();
            
            max = Math.max(max, quiz[i]);
        }
        
        int [] dp_0 = new int [max+2];
        int [] dp_1 = new int [max+2];
        dp_0[0] = 1;
        dp_1[0] = 0;
        dp_0[1] = 0;
        dp_1[1] = 1;
        
        for (int i = 2; i < max+1; i++) {
            dp_0[i] = dp_0[i-1] + dp_0[i-2];
            dp_1[i] = dp_1[i-1] + dp_1[i-2];
        }
        
        for (int i = 0; i < T; i++) {
            System.out.println("" + dp_0[quiz[i]] + " " + dp_1[quiz[i]]);
        }
        
        scanner.close();
    }
}