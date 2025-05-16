/*
N행 M열
N이 세로 개수
M이 가로 개수

하루 지나면 인접 토마토도 익음. 안 익은 토마토가 익음
위 아래 오른쪽 왼쪽만. 대각선은 영향 x
토마토가 다 익는 최소 일수 찾기

토마토가 없는 칸도 있음


I/O
버퍼/기본

M N
1은 익은 토마토
0은 안 익은 토마토
-1 토마토가 없는 칸

출력은 토마토가 다 익는데 걸리는 시간 count


bfs

시작 지점은 익은 토마토가 있는 모든 지점? 동시에 넣는 게 가능한가?
다음 지점 조건은 0인 지점 (익은 토마토랑 토마토가 없는 칸은 해당 x)
방문 처리는 위치 기반 boolean visited[M][N]

동시에 시작해서 동시에 한 스텝씩 올라가는 게 포인트
시작 위치 모두 기록하고 current도 여러개로?

count++은 어떻게?
큐에 넣을 때마다?
동시에 넣을 때 할 것

*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        
        int [][] storage = new int [N][M];
        List<int []> startPoint = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            
            for (int j = 0; j < M; j++) {
                storage[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                
                if (storage[i][j] == 1) {
                    startPoint.add(new int [] {i, j});
                }
            }
        }
        
        bfs(storage, startPoint);
        
        bufferedReader.close();
    }
    
    public static void bfs(int [][] storage, List<int []> startPoint) {
        int N = storage.length;
        int M = storage[0].length;
        
        boolean [][] visited = new boolean [N][M];
        List<int []> currentPoint = new ArrayList<>();
        Queue<int []> queue = new LinkedList<>();
        
        int [] dr = new int [] {-1, 1, 0, 0};
        int [] dc = new int [] {0, 0, -1, 1};
        
        if (startPoint.size() == 0) {
            System.out.println(-1);
            
            return ;
        }
        
        int count = -1;
        
        for (int i = 0; i < startPoint.size(); i++) {
            queue.offer(startPoint.get(i));
            
            int [] point = startPoint.get(i);
            visited[point[0]][point[1]] = true;
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int j = 0; j < size; j++) {
                int [] current = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    int r2 = current[0] + dr[i];
                    int c2 = current[1] + dc[i];
                
                    if (r2 < 0 || r2 > N-1 || c2 < 0 || c2 > M-1) {
                        continue;
                    }
                
                    if (visited[r2][c2]) {
                        continue;
                    }
                
                    if (storage[r2][c2] == 1 || storage[r2][c2] == -1) {
                        continue;
                    }
                
                    queue.offer(new int [] {r2, c2});
                    visited[r2][c2] = true;
                    storage[r2][c2] = 1;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (storage[i][j] == 0) {
                    System.out.println(-1);
                    
                    return;
                }
            }
        }
        
        System.out.println(count);
    }
}