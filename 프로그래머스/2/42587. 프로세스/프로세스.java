import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int alength = priorities.length;
        
        Queue<int []> queue = new LinkedList<>();
        
        for (int i = 0; i < alength; i++)
            queue.offer(new int [] {priorities[i], i});
        
        int max = -1;
        int count = 0;
        
        while (!queue.isEmpty()) {
            max = findMax(queue);
            
            int [] current = doProcess(queue, max);
            System.out.println(current[1]);
            count++;
            
            if (current[1] == location) {
                answer = count;
                
                break;
            }
        }
        
        
        return answer;
    }
    
    public int findMax(Queue<int []> queue) {
        int max = -1;
        int qSize = queue.size();
        
        for (int i = 0; i < qSize; i++) {
            int [] current = queue.poll();
            max = Math.max(max, current[0]);
            
            queue.offer(current);
        }
        
        return max;
        
    }
    
    public int [] doProcess(Queue<int []> queue, int max) {
        int [] current;
        
        while (true) {
            current = queue.poll();
            
            if (current[0] == max)
                break;
            else
                queue.offer(current);
        }
        
        return current;
    }
}

/*
특정 프로세스가 몇 번째로 실행되는가

프로세스 목록 priorities
특정 프로세스 번호 location

우선순위는 하향식으로


우선순위 큐?

원형 큐?

큐 두 개 쓰기?
인덱스용이랑 우선순위용

프로세스 클래스 만들기?
인데긋랑 우선순위 둘 다 보관
코테용으로는 이차원 배열이 더 맘 편할 수 있음

우선순위 목록을 저장할 배열 만들기?


이차원 배열로 문제 풀기

모듈
1. 우선순위와 인덱스 결합
priorities는 0-based이고 location은 1-based이니 location에 맞춰 1-based로 통일
그리고 큐에 넣기

2. 프로세스 계산
while() 루프 써야될듯. 큐가 빌 때까지
우선순위 바탕으로 max에 저장해두고 큐 사이즈만큼 for 문 돌리기
체크는 큐에서 빼고 넣기 반복..


while () 루프. 큐가 빌 때까지
    max 구하는 함수. 큐는 원상태로 돌아와야 하기 때문에.
    
    max 만날 때까지 큐에서 빼고 넣기 반복
    
    max 만나면 큐에서 아예 빼기
    count++
    max의 index가 location과 같다면 count 리턴하고 끝
    

*/