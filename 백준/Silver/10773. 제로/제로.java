import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(bufferedReader.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            
            if (num == 0) {
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }
        
        int sum = 0;
        
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        System.out.println(sum);
    }
}