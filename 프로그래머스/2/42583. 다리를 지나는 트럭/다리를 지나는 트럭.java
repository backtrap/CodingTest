import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> truckQueue = new LinkedList<>();
        
        for (int i : truck_weights)
            truckQueue.offer(i);
        
        Queue<Integer> bridgeQueue = new LinkedList<>();
        
        int timeCount = 0;
        int weightCount = 0;
        int truckCount = 0;
        int currentTruck = -1;
        
        currentTruck = truckQueue.poll();
        bridgeQueue.offer(currentTruck);
        timeCount++;
        weightCount += currentTruck;
        truckCount++;
        
        while (!truckQueue.isEmpty()) {
            timeCount++;
            currentTruck = truckQueue.peek();
            
            if (bridgeQueue.isEmpty()) {
                bridgeQueue.offer(currentTruck);
                weightCount += currentTruck;
                truckCount++;
                
                truckQueue.poll();
                
                continue;
            }
            
            if (bridgeQueue.size() == bridge_length) {
                int extractedTruck = bridgeQueue.poll();
                
                if (extractedTruck != 0) {
                    weightCount -= extractedTruck;
                    truckCount--;
                }
            }
            
            if (weightCount + currentTruck <= weight && truckCount < bridge_length) {
                bridgeQueue.offer(currentTruck);
                weightCount += currentTruck;
                truckCount++;
                
                truckQueue.poll();
            }
            else 
                bridgeQueue.offer(0);
            
            
            
        }
        
        
        answer = timeCount + bridge_length;
        
        return answer;
    }
}

/*
일차선 다리
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는가?

최대 올라갈 수 있는 대수 정해져 있음. 1초당 한 칸씩 간다고 생각하면 될듯
weight 이하까지 견딜 수 있음

구분은
 1. 대기 트럭
 2. 건너는 중인 트럭
 3. 건넌 트럭


일단 든 생각. 투 포인터로 풀 수 있음.
내림차순 정렬 -> 맨 앞 원소와 맨 뒤 원소 합해서 무게 제한과 비교

다리를 큐라고 생각하면 될듯
무게 측정 변수 하나 두고


모듈
 1. 배열 내림차순 정렬
 2. 투 포인터로 맨 앞, 맨 뒤 원소로 비교


투 포인터 모듈 : 
front, rear 변수 (기본적으로 0-based index)
저장 큐 bridgeQueue
현재 무게 변수 currentWeight
시간 카운트 변수 timeCount
트럭 수 카운트 변수 truckCount


while () 루프. front가 rear 이하일 동안만 실행
    frontTruck 초기화
    
    if 만약 큐가 비었으면
        frontTruck을 큐에 넣기
        truckCount++
        currentWeight 갱신
        frontTruck++
        timeCount++
        continue
        
    
    큐 front 빼기
    큐는 항상 사이즈 4를 유지하고, 비어있을 때는 0을 넣는다고 생각
    뺸 값이 0이 아니면 truckCount--
    
    
    if truckCount가 bridge_length 미만일 때
        if currentWeight에 frontTruck 더한 값이 무게 제한보다 작을 때
            큐에 frontTruck 넣기
            currentWeight 갱신
            truckCount++
            frontTruck++
        
        if currentWeight에 rearTruck 더한 값이 무게 제한보다 작을 때 
            큐에 rearTruck 넣기
            currentWeight 갱신
            truckCount++
            rearTruck++
    else
        큐에 0 넣기
    
    

    timeCount++


대기 트럭 -> 트럭 리스트 큐 변환

현재 무게 변수
다리 위 트럭 개수 변수
시간 카운트 변수
다리 위 트럭 큐

while 문. 트럭 리스트 큐가 빌 때까지
    다리 위 트럭 큐가 비었으면
        다리 위 트럭 큐에 트럭 리스트 프론트 넣기
        시간 카운트 ++
        현재 무게 갱신
        다리 위 트럭 개수 ++
        컨티뉴
    
    다리 위 트럭에서 프론트 뺌
    뺀 값이 0이 아니면
        현재 무게 갱신
        다리 위 트럭 개수 --
    
    현재 무게에 트럭 리스트 프론트를 더한 값이 무게 제한 이하면
        현재 무게 갱신
        다리 위 트럭 개수 ++
    아니면
        0 넣기
        
    시간 카운트 ++
    

*/