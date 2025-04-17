import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String command = scanner.nextLine();
            boolean answer = true;
            
            if (command.equals("0")) {
                break;
            }
            
            char [] crr = command.toCharArray();
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < crr.length/2; i++) {
                stack.push(crr[i]);
            }
            
            if (crr.length%2 == 0) {
                for (int i = crr.length/2; i < crr.length; i++) {
                    if (crr[i] != stack.pop()) {
                        answer = false;
                        
                        break;
                    }
                }
            }
            else {
                for (int i = crr.length/2 + 1; i < crr.length; i++) {
                    if (crr[i] != stack.pop()) {
                        answer = false;
                        
                        break;
                    }
                }
            }
            
            if (answer) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}