/*
특정 수를 연속된 수의 합으로 나타내는 개수 구하기

I/O
기본/기본


투포인터 i, j
int left = 1
int right = 1
int N

while (right < N)
 . sum 구하기
 . sum == N이면 count++
 . sum < N이면 left++
 . sum > N이면 right++

        
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int left = 1;
        int right = 1;
        int count = 0;
        
        while (right <= N) {
            int sum = 0;
            
            for (int i = left; i <= right; i++) {
                sum += i;
            }
            
            if (sum == N) {
                count++;
                left++;
            }
            else if (sum < N) {
                right++;
            }
            else {
                left++;
            }
        }
        
        System.out.println(count);
        
        scanner.close();
    }
}