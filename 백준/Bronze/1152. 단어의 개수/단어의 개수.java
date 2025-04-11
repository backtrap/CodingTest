import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine().trim();
        String [] srr = str.split(" ");
        int num = srr.length;
        
        if (srr[0].equals("")) {
            System.out.println("0");
            
            return ;
        }
        
        System.out.println(num);
        
        scanner.close();
    }
}