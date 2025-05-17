/*정수 배열 A
정수 배열 B

S = A[i] x B[i]의 합

A 정렬
B는 건들면 안됨

S 최소값 출력


I/O
버퍼/일반

N
배열 A
배열 B


B는 순서 정해져 있음


*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        
        int S = 0;
        
        for (int i = 0; i < N; i++) {
            S = S + A.get(i) * B.get(i);
        }
        
        System.out.println(S);
    }
}