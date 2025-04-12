import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < T; i++) {
            String line = scanner.nextLine();
            
            isVPS(line);
        }
    }
    
    public static void isVPS(String str) {
        char [] crr = str.toCharArray();
        int size = crr.length;
        Stack<Character> stack = new Stack<>();
        
        if (crr[0] == ')' || crr[size-1] == '(') {
            System.out.println("NO");
            
            return ;
        }
        
        for (int i = 0; i < size; i++) {
            stack.push(crr[i]);
        }
        
        int count = 0;
        
        for (int i = 0; i < size; i++) {
            char c = stack.pop();
            
            if (c == ')') {
                count++;
            }
            else if (c == '(') {
                count--;
            }
            
            if (count < 0) {
                System.out.println("NO");
                
                return ;
            }
        }
        
        if (count == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
        
        return ;
    }
}