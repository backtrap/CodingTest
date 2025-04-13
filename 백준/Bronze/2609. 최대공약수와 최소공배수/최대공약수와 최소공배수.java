import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        List<Integer> smallX = new ArrayList<>();
        List<Integer> smallY = new ArrayList<>();
        
        int tempX = x;
        int tempY = y;
        int min = Math.min(x, y);
        
        for (int i = 2; i <= Math.sqrt(x); i++) {
            while (tempX % i == 0) {
                smallX.add(i);
                tempX /= i;
            }
        }
        
        if (tempX > 1) {
            smallX.add(tempX);
        }
        
        for (int i = 2; i <= Math.sqrt(y); i++) {
            while (tempY % i == 0) {
                smallY.add(i);
                tempY /= i;
            }
        }
        
        if (tempY > 1) {
            smallY.add(tempY);
        }
        
        int answer1 = 1;
        List<Integer> smallX2 = new ArrayList<>(smallX);
        List<Integer> smallY2 = new ArrayList<>(smallY);
        
        for (int i = 2; i <= min; i++) {
            while (smallX.contains(i) && smallY.contains(i)) {
                answer1 *= i;
                smallX.remove(smallX.indexOf(i));
                smallY.remove(smallY.indexOf(i));
            }
        }
        
        int answer2 = x * y / answer1;
        
        System.out.println(answer1); 
        System.out.println(answer2); 
        
        scanner.close();
    }
}
