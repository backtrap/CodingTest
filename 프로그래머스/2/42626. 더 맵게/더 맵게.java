import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 배열 -> 우선순위 큐
        int scovilleLength = scoville.length;
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < scovilleLength; i++) {
            list.add(scoville[i]);
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(list);
        
        int count = 0;
        int root = priorityQueue.peek();
        
        // while 루프. root <7인 경우
        while (root < K) {
            int min1 = priorityQueue.poll();
            
            if (priorityQueue.isEmpty()) {
                return -1;
            }
            
            int min2 = priorityQueue.poll();
            
            int newFood = min1 + min2 * 2;
            
            count++;
            
            priorityQueue.offer(newFood);
            root = priorityQueue.peek();        
        }
        
        answer = count;
        
        return answer;
    }
}

/*
스코빌 지수 K 이상 만들기
스코빌 지수가 가장 낮은 2개를 섞어 새로운 음식을 만듬
공식은 new = min1 + min2 x 2

k가 10억 이상
scoville 100만 이하

scoville -> 우선순위 큐 변환

while 루프로 root가 7보다 큰지 확인
아니면 min1, min2로 새로운 음식 만들고 우선순위 큐에 넣기


시간 복잡도를 n으로 해도 되나?

*/