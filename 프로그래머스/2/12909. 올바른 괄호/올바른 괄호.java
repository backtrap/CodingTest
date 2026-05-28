import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        // 문자열 -> 배열 변환
        char [] crr = s.toCharArray();
        int clength = crr.length;
        
        if (crr[0] == ')') 
            return answer;
        
        Stack<Character> cStack = new Stack<>();
        char c = 'c';
        
        for (int i = 0; i < clength; i++) {
            c = crr[i];
            
            if (c == '(')
                cStack.push(c);
            else {
                if (cStack.isEmpty()) {
                    answer = false;
                
                    return answer;
                }
                else 
                    cStack.pop();
            }
            
        }
        
        if (!cStack.isEmpty())
            answer = false;
        else
            answer = true;

        return answer;
    }
}

/*
스택 사용

모듈
 1. 문자열 -> 배열 변환

 2. 배열을 원소를 스택에 넣기
'('이면 넣고 ')'이면 빼기


배열 원소를 스택에 넣기

배열 첫 원소가 ')'이면 false 리턴

for () 배열 크기만큼
    '('이면 넣기
    ')'이면 빼기
    
    뺄 때 null 반환하면 false 리턴

스택 비어있으면 true
스택 원소 있으면 false
*/