import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            list.add(num);
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i));
        }
        
        scanner.close();
    }
}