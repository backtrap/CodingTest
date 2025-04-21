/*a = 1, b = 2, ... , z = 26

H = 시그마(수열) % M

비둘기 집의 원리
해시 충돌

H = 시그마(a(i) x r^i) % M


Scanner
prinntln()


문자열을 char []로 변환
같은 크기의 int[] 만들기
int[i] = char[i] - 'a' + 1

for()에서
H = int[i] * Math.pow(r, i)

H %= M
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int L = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        
        int r = 31;
        int M = 1234567891;
        
        char [] crr = str.toCharArray();
        long [] arr = new long [L];
        
        for (int i = 0; i < L; i++) {
            arr[i] = crr[i] - 'a' + 1;
        }
        
        long sum = 0;
        
        for (int i = 0; i < L; i++) {
            sum += arr[i] * Math.pow(r, i);
        }
        
        long H = sum % M;
        
        System.out.println(H);
    }
}