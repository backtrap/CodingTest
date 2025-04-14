import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        
        boolean [][] board = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String secondLine = scanner.nextLine();
            
            for (int j = 0; j < M; j++) {
                char c = secondLine.charAt(j);
                
                if (c == 'B') {
                    board[i][j] = true;
                }
                else if (c == 'W') {
                    board[i][j] = false;
                }
            }
        }
        
        check(board);
    }
    
    public static void check(boolean [][] board) {
        int N = board.length;
        int M = board[0].length;
        boolean [][] startBlack = new boolean [8][8]; // 검은색 시작 보드판
        boolean [][] startWhite = new boolean [8][8]; // 흰색 시작 보드판
        
        startBlack[0][0] = true;
        startWhite[0][0] = false;
        
        // 검은색 보드판 채우기
        for (int i = 0; i < 8; i++) {
            if (i%2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j%2 == 0) {
                        startBlack[i][j] = true;
                    }
                    else {
                        startBlack[i][j] = false;
                    }
                }
            }
            else {
                for (int j = 0; j < 8; j++) {
                    if (j%2 == 0) {
                        startBlack[i][j] = false;
                    }
                    else {
                        startBlack[i][j] = true;
                    }
                }
            }
        }
        
        // 흰색 보드판 채우기
        for (int i = 0; i < 8; i++) {
            if (i%2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j%2 == 0) {
                        startWhite[i][j] = false;
                    }
                    else {
                        startWhite[i][j] = true;
                    }
                }
            }
            else {
                for (int j = 0; j < 8; j++) {
                    if (j%2 == 0) {
                        startWhite[i][j] = true;
                    }
                    else {
                        startWhite[i][j] = false;
                    }
                }
            }
        }
        
        // 딱 맞는 경우
        if (N == 8 && M == 8) {
            int count1 = 0;
            int count2 = 0;
            

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != startBlack[i][j]) {
                        count1++;
                    }
                    if (board[i][j] != startWhite[i][j]) {
                        count2++;
                    }
                }
            }
            
            int count = Math.min(count1, count2);
            
            System.out.println(count);
            
            return ;
        }
        else {
            int min = -1;
            int n = N - 8;
            int m = M - 8;
            boolean [][] newBoard = new boolean[8][8];
        
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    // 부분 보드 잘라오기
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            newBoard[k][l] = board[i + k][j + l];
                        }
                    }
        
                    int repaintBlack = 0;
                    int repaintWhite = 0;
        
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (newBoard[k][l] != startBlack[k][l]) {
                                repaintBlack++;
                            }
                            
                            if (newBoard[k][l] != startWhite[k][l]) {
                                repaintWhite++;
                            }
                        }
                    }
        
                    int repaint = Math.min(repaintBlack, repaintWhite);
        
                    if (min == -1 || repaint < min) {
                        min = repaint;
                    }
                }
            }
        
            System.out.println(min);
        }

    
    }
}