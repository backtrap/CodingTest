import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int first = scanner.nextInt();
        int min = first;
        int max = first;
        
        for (int i = 0; i < N-1; i++) {
            int num = scanner.nextInt();
            
            if (num < min) {
                min = num;
            }
            
            if (num > max) {
                max = num;
            }
        }
        
        System.out.print(min + " " + max);
    }
}