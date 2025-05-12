import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        
        divide(N, 0, 0, 0, r, c);
        
        scanner.close();
    }
    
    public static void divide(int N, int startR, int startC, int startValue, int r, int c) {
        if (N == 1) {
            int plus = -1;
            
            if (r == 0 && c == 0) {
                plus = 0;
            }
            else if (r == 0 && c == 1) {
                plus = 1;
            }
            else if (r == 1 && c == 0) {
                plus = 2;
            }
            else if (r == 1 && c == 1) {
                plus = 3;
            }
            
            System.out.println(startValue + plus);
            
            return ;
        }
        else {
            int half = (int)Math.pow(2, N-1);
            int plus = half * half;
            
            if (half > r && half > c) {
                divide(N-1, startR, startC, startValue, r, c);
            }
            else if (half > r && half <= c) {
                divide(N-1, startR , startC+ half, startValue + plus, r, c - half);
            }
            else if (half <= r && half > c) {
                divide(N-1, startR + half, startC, startValue + plus*2, r - half, c);
            }
            else if (half <= r && half <= c) {
                divide(N-1, startR + half, startC + half, startValue + plus*3, r - half, c - half);
            }
        }
    }
}