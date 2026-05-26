import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int numOfFunctions = progresses.length;
        
        Queue<Function> functionQueue = new LinkedList<>();
        
        for (int i = 0; i < numOfFunctions; i++) {
            Function function = new Function(progresses[i], speeds[i]);
            functionQueue.offer(function);
        }
        
        List<Integer> answerList = new ArrayList<>();
        int day = 0;
        
        while (!functionQueue.isEmpty()) {
            day++;
            
            System.out.println();
            System.out.println(day);
            
            Function currentFunction = functionQueue.peek();
            int currentCompleteDay = currentFunction.getCompleteDay();
            
            if (currentCompleteDay > day)
                continue;
            
            int count = 1;
            
            currentFunction = functionQueue.poll();
            
            if (functionQueue.isEmpty()) {
                answerList.add(count);
                
                break;
            }
                
            Function nextFunction = functionQueue.peek();
            
            while (nextFunction.getCompleteDay() <= day) {
                // System.out.println(count);
                functionQueue.poll();
                count++;
                
                if (functionQueue.isEmpty())
                    break;
                
                nextFunction = functionQueue.peek();
            }
            
            answerList.add(count);
            
                     
            
        }
        
        int answerLength = answerList.size();
        answer = new int [answerLength];
        
        for (int i = 0; i < answerLength; i++)
            answer[i] = answerList.get(i);
        
        return answer;
    }
}

class Function {
    int progress;
    int speed;
    int completeDay;
    
    public Function(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
        
        this.completeDay = computeCompleteDay(progress, speed);
    }
    
    private int computeCompleteDay(int progress, int speed) {
        int count = 0;
        
        while (progress < 100) {
            progress += speed;
            count++;
        }
        
        // System.out.println(count);
        
        return count;
    }
    
    public int getCompleteDay() {
        return this.completeDay;
    }
}

/*
개발 속도가 다름 -> 뒤에 있는 기능이 먼저 개발될 수 있음
이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포. 배포 순서는 개발 완료 순서와 무관하게 기능 순서를 따름.

작업 개수
작업 진도
작업 속도

배포는 하루에 한 번씩

최종 출력 배열은 '각 배포일에 배포되는 기능 개수'


1-based index

index 기준으로 큐?

Progress 클래스 만들기?
progress
speed
completeDay

day 기준으로 카운트

while(!queue.isEmpty)
    day++
    
    여기도 while
    queue front의 completeDay 확인
    day랑 비교해서 된 날이면 꺼냄. 아니면 다음 루프
    
    

*/