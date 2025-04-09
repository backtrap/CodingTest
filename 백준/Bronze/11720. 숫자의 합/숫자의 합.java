import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        char [] crr = str.toCharArray();
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            int n = Character.getNumericValue(crr[i]);
            sum += n;
        }
        
        System.out.println(sum);
    }
}