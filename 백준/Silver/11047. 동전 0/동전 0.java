/*
동전 종류 N
동전들 조합해서 가치 합이 K로
필요한 동전 개수의 최소값


N K
가치 A


I/O
스캐너/print()

정답은 최소값 출력


coinArr[] 코인 종류 저장
[0]이 기준이 되고 이후의 코인은 [0]의 배수


coinArr[] 내림차순 정렬
int count = 0;

while () K가 0이 될 때까지
K - coinArr[] 제일 큰 거
count++
제일 큰 거 못 빼면 인덱스 이동


count 출력

*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        List<Integer> coinList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            coinList.add(scanner.nextInt());
        }
        
        Collections.sort(coinList, Collections.reverseOrder());
        
        int i = 0;
        int count = 0;
        
        while (K > 0) {
            if (K >= coinList.get(i)) {
                K = K - coinList.get(i);
                count++;
            }
            else {
                i++;
            }
        }
        
        System.out.println(count);
    }
}