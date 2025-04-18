import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int V = scanner.nextInt();
        
        int n;
        
        if ((V-A)%(A-B) == 0) {
            n = (V-A)/(A-B) + 1;
        } 
        else {
            n = (V-A)/(A-B) + 2;
        }
        
        System.out.println(n);
    }
}