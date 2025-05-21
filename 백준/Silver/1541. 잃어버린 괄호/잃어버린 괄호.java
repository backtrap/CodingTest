/*
양수, +, -, 괄호로 식 만듬
그리고 괄호 지움
괄호를 다시 쳐서 식의 값을 최소로 만드려고 함


I/O
기본/기본


입력받는 것도 일
 1. nextLine()
 2. length 만큼 boolean [] isNumber
 3. toCharArray()로 문자 배열로 받기
 4. '0' <= [i] <= '9' 이용해서 숫자이면 isNumber = true, numCount++
 5. 숫자만 따로 저장? 배열 이용? 연산자도 따로 저장? int [] numArr, char [] opArr
 6. 이중 for문으로 숫자 확인. isNumber이 true이면 i++해서 
 7. 


선택은 어떻게?
그리디 사용
numList, opList에 순서대로 있음
numList(0) -> opList(0) -> numList(1) -> opList(1) -> ... -> numList(n-1)
        
 . opList(n)이 -면 numList(n+1) 일단 킵
 . opList(n+1)이 +면 numList(n+2)도 같이 킵
 . opList(n+i)가 -면 킵 해둔 애들 다 한번에 뺌
 
        

*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        boolean [] isNumber = new boolean [command.length()];
        char [] crr = command.toCharArray();
        
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();

        Stack<Character> makeNum = new Stack<>();

        for (int i = 0; i < command.length(); i++) {
            char ch = crr [i];
            
            if (Character.isDigit(ch)) {
                makeNum.push(ch);
            } 
            else {
                int num = 0;
                int multiplier = 1;
                
                while (!makeNum.isEmpty()) {
                    num += (makeNum.pop() - '0') * multiplier;
                    multiplier *= 10;
                }
                
                numList.add(num);

                opList.add(ch);
            }
        }

        if (!makeNum.isEmpty()) {
            int num = 0;
            int multiplier = 1;
            
            while (!makeNum.isEmpty()) {
                num += (makeNum.pop() - '0') * multiplier;
                multiplier *= 10;
            }
            numList.add(num);
        }

        int sum = numList.get(0);
        boolean minusStarted = false;

        for (int i = 0; i < opList.size(); i++) {
            char op = opList.get(i);
            int nextNum = numList.get(i + 1);

            if (op == '-') {
                minusStarted = true;
            }

            if (minusStarted) {
                sum -= nextNum;
            } 
            else {
                sum += nextNum;
            }
        }

        System.out.println(sum);
    }
}
