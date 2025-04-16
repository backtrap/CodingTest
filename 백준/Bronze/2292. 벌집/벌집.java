import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int now = 1;
        int i = 1;
        
        while (true) {
            if (N == 1) {
                System.out.println(1);
                
                break;
            }
            else if (N <= now) {
                System.out.println(i++);
                
                break;
            }
            else {
                now = now + 6*i;
                i++;
            }
        }
    }
}