import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            String command = scanner.nextLine();
            
            if (command.equals("0 0 0")) {
                break;
            }
            
            String [] srr = command.split(" ");
            int [] arr = new int [3];
            arr[0] = Integer.parseInt(srr[0]);
            arr[1] = Integer.parseInt(srr[1]);
            arr[2] = Integer.parseInt(srr[2]);
            
            Arrays.sort(arr);
            
            int c = arr[2] * arr[2];
            int a = arr[0] * arr[0];
            int b = arr[1] * arr[1];
            
            if (c == a + b) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }
}