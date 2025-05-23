/*
좋은 수 구하기
N개의 수가 주어짐
특정 수가 다른 수 2개의 합으로 표현되면 좋은 수
좋은 수가 몇개인지 찾기


I/O
버퍼/기본

 1. 수의 개수
 2. 값 값 값 ...


배열 사용?

int count = 0

for문 사용. arr[2] ~ arr[N-1]까지 돌면서 합 찾기
 . int left = 0
 . int right = i - 1
 . boolean done = false
 . while (left < right)
  . int sum = arr[left] + arr[right]
  . sum이 arr[i]랑 같으면 -> count++, done = true, break
  . sum이 arr[i]보다 작으면 -> left++
  . sum이 arr[i]보다 크면 -> right--
 . done이 true이면 -> continue

        
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        String [] secondLine = bufferedReader.readLine().split(" ");
        
        int [] numArray = new int [N];
        
        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(secondLine[i]);
        }
        
        Arrays.sort(numArray);
        
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            boolean done = false;
            
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                
                if (right == i) {
                    right --;
                    continue;
                }
                
                int sum = numArray[left] + numArray[right];
                
                if (sum == numArray[i]) {
                    if (left != right) {
                        count++;
                        done = true;
                    
                        break;
                    }
                    else if (left == i) {
                        right++;
                    }
                    else {
                        left++;
                    }
                }
                else if (sum < numArray[i]) {
                    left++;
                }
                else {
                    right--;
                }
                
                if (done == true) {
                    continue;
                }
            }
        }
        
        System.out.println(count);
        
        bufferedReader.close();
    }
}