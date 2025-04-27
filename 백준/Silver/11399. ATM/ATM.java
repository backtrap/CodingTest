import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();
        
        int [] arr = new int [N];
        
        for (int i = 0; i < N; i++) {
            int p = scanner.nextInt();
            
            arr[i] = p;
        }
        
        Arrays.sort(arr);
        
        int [] subset = new int [N];
        subset[0] = arr[0];
        
        for (int i = 1; i < N; i++) {
            subset[i] = subset[i-1] + arr[i];
        }
        
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += subset[i];
        }
        
        System.out.println(sum);
        
        scanner.close();
    }
}