import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        int num = -1;
        int i = 1;
        
        while(!queue.isEmpty()) {
            num = queue.peek();
            
            if (i%2 == 1) {
                queue.poll();
            }
            else {
                queue.offer(queue.poll());
            }
            
            i++;
        }
        
        System.out.println(num);
    }
}