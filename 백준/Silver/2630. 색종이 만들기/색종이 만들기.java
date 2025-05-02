import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        boolean [][] paper = new boolean [N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = scanner.nextInt();
                
                if (val == 1) {
                    paper[i][j] = true;
                } 
                else {
                    paper[i][j] = false;
                }
            }
        }

        int [] count = new int[2]; // count[0]는 white, count[1]는 blue
        
        divide(paper, 0, 0, N, count);

        System.out.println(count[0]); 
        System.out.println(count[1]); 
    }

    public static void divide(boolean[][] paper, int x, int y, int size, int[] count) { // x, y는 시작 index
        if (check(paper, x, y, size)) {
            if (paper[x][y]) {
                count[1]++; 
            } else {
                count[0]++; 
            }
            return;
        }

        int newSize = size/2;
        
        divide(paper, x, y, newSize, count);
        divide(paper, x, y + newSize, newSize, count);
        divide(paper, x + newSize, y, newSize, count);
        divide(paper, x + newSize, y + newSize, newSize, count);
    }

    public static boolean check(boolean[][] paper, int x, int y, int size) {
        boolean color = paper[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
