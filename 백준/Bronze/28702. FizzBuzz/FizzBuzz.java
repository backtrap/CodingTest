import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        String [] srr = new String [3];
        srr[0] = scanner.nextLine();
        srr[1] = scanner.nextLine();
        srr[2] = scanner.nextLine();
        
        int num = -1;
        int index = -1;
        
        for (int i = 0; i < 3; i++) {
            char c = srr[i].charAt(0);
            
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                continue;
            }
            else {
                index = i;
                num = Integer.parseInt(srr[i]);
            }
        }
        
        switch (index) {
            case 0 :
                num++;
                num++;
                
                break;
            case 1 :
                num++;
                
                break;
            case 2:
                break;
        }
        
        int next = num + 1;
        
        if (next%3 == 0) {
            if (next%5 ==0) {
                System.out.println("FizzBuzz");
            }
            else {
                System.out.println("Fizz");
            }
        }
        else {
            if (next%5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(next);
            }
        }
        
        scanner.close();
    }
}