/*
회의실 1개
회의는 N개
회의는 시작시간, 끝나는 시간 있음
최대한 많은 회의 배정


N
시작시간 끝나는 시간


I/O
버퍼/출력


bfs? 그리디?

bfs로 실패


회의 클래스
정렬 기준 1. 끝나는 시간 2. 시작 시간


배열에 회의 저장
배열 정렬

[0]는 넣고 시작

반복문에서
이전 회의 endTime <= 현재 회의 startTime이면 count++


*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        
        Meeting [] meetingArr = new Meeting [N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startTime = Integer.parseInt(stringTokenizer.nextToken());
            int endTime = Integer.parseInt(stringTokenizer.nextToken());
            
            Meeting newMeeting = new Meeting();
            newMeeting.startTime = startTime;
            newMeeting.endTime = endTime;
            
            meetingArr[i] = newMeeting;
        }
        
        Arrays.sort(meetingArr);
        
        int count = 0;
        int endTime = 0;
        
        for (Meeting i : meetingArr) {
            if (i.startTime >= endTime) {
                count++;
                
                endTime = i.endTime;
            }
        }
        
        System.out.println(count);
        
        bufferedReader.close();
    }
}

class Meeting implements Comparable<Meeting> {
    int startTime;
    int endTime;
    
    @Override
    public int compareTo(Meeting other) {
        if (this.endTime == other.endTime) {
            return this.startTime - other.endTime;
        }
        else {
            return this.endTime - other.endTime;
        }
    }
}