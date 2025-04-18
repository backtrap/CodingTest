import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        if (K == 0) {
            System.out.println(1);
            
            return ;
        }
        
        int dividend = 1;
        int n = N;
        
        for (int i = 0; i < K; i++) {
            dividend *= n--;
        }
        
        int divisor = 1;
        
        for (int i = 1; i <= K; i++) {
            divisor *= i;
        } 
        
        System.out.println(dividend/divisor);
    }
}