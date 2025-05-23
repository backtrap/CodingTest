/*
재료마다 고유 번호가 있음
고유 번호 2개를 합쳐서 M이 되면 갑옷이 만들어짐


I/O
버퍼/기본

 1. 재료 개수 N
 2. 번호 합 M
 3. 값들..
 

투 포인터

배열 사용?
일단 배열에 넣고 정렬

투포인터 사용
left = 0
right = 배열 크기 - 1
sum = arr[left] + arr[right]
count = 0

투포인터 이동 방향은
 . 값이 맞으면 left++
 . sum이 작으면 left++
 . sum이 크면 right--
 
        
        
*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String [] thirdLine = bufferedReader.readLine().split(" ");
        
        int [] arr = new int [N];
        
        for (int i = 0; i< N; i++) {
            arr[i] = Integer.parseInt(thirdLine[i]);
        }
        
        Arrays.sort(arr);  
        
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == M) {
                count++;
                left++;
            }
            else if (sum < M) {
                left++;
            }
            else {
                right--;
            }
        }
        
        System.out.println(count);
        
        bufferedReader.close();
    }
}