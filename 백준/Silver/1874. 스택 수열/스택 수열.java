/*
스택 이용한 수열

I/O
버퍼/버퍼

 1. n // 수열의 개수
 2. 수열의 이루는 수들..

push 연산은 +
pop 연산은 -
정렬 불가능하면 NO


예시에서
수열은 4 3 6 8 7 5 2 1
(1 2 3 4 5 6 7 8)

스택에는 1 2 5 7 8

스택 출력은 4 3 6 8 7 5 2 1


즉, 숫자 n이 주어지고 수열이 주어지면
스택 오름차순 push & pop으로 주어진 수열을 만들 수 있는가?


첫 숫자가 n이면 -> 일단 n까지 넣음
일단 n을 뺌
두번째 숫자가 n-1이면 -> 또다시 n-1을 뺌
이걸 반복

근데 n-1이 아니면 -> n+1부터 다시 넣음


일반화하면
int index = 0, int num = 1부터 시작

peek()가 arr[index]이랑 같으면 -> pop()
그리고 index++

다를 때는
push(num)
num++

num이 n이랑 같으면 반복문 끝

실패 케이스는 어떻게?
boolean [] print 만들고 false가 있으면 실패

        

*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> stack = new Stack<>();
        
        int n = Integer.parseInt(bufferedReader.readLine());
        
        int [] arr = new int [n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        
        int index = 0;
        int num = 1;
        
        List<String> output = new ArrayList<>();
        
        while (num <= n) {
            if (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                output.add("-\n");
                index++;
                continue;
            }
            
            stack.push(num);
            output.add("+\n");
            num++;
        }
        
        while (!stack.isEmpty()) {
            if (stack.pop() != arr[index++]) {
                // 실패 시 즉시 NO 출력하고 종료
                bufferedWriter.write("NO\n");
                bufferedWriter.flush();
                bufferedReader.close();
                bufferedWriter.close();
                return;
            }
            output.add("-\n");
        }

        // 성공 시에만 출력
        for (String s : output) {
            bufferedWriter.write(s);
        }
        
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
