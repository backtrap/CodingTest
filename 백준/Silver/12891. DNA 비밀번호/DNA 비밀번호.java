/*
DNA 문자열 : A, C, G, T로만 이루어진 문자열
DNA의 부분 문자열로 비밀번호로
한 문자 연속 반복은 x? 상관 없음
각 문자별로 최소 개수 있음. 이건 주어짐

사용 가능한 비밀번호의 개수 리턴
부분 문자열의 위치가 다르면 같은 문자라고 하더라도 다른 비밀번호로 취급


I/O
기본/기본
 1. N P // DNA 문자열 길이 N이랑 부분 문자열 길이 P
 2. DNA 문자열
 3. n1 n2 n3 n4 // A, C, G, T의 최소 개수


슬라이딩 윈도우

윈도우 만들기. 배열로?
첫 크기만큼 넣기. 근데 굳이 윈도우에 문자를 넣을 필요는 없음. 개수만 넣으면 될듯? 다 넣는 게 맞는 것 같다
int countA, countC, countG, countT 만들고 맞춰서 ++

for() 문. i = P ~ dna.length
 . 맨 앞에 있는 것 빼기
 . 맨 뒤에 있는 것 넣기
 . 만약 countA, countC, countG, countT가 조건을 만족하면 count++
 . firstChar, lastChar 갱신?
 
        
        
        
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int P = scanner.nextInt();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        
        char [] dna = secondLine.toCharArray();
        
        String [] thirdLine = scanner.nextLine().split(" ");
        
        int minA = Integer.parseInt(thirdLine[0]);
        int minC = Integer.parseInt(thirdLine[1]);
        int minG = Integer.parseInt(thirdLine[2]);
        int minT = Integer.parseInt(thirdLine[3]);
        
        int count = 0;
        
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;
        
        char [] password = new char [P];
        
        for (int i = 0; i < P; i++) {
            if (dna[i] == 'A') {
                countA++;
            }
            else if (dna[i] == 'C') {
                countC++;
            }
            else if (dna[i] == 'G') {
                countG++;
            }
            else if (dna[i] == 'T') {
                countT++;
            }
        }
        
        if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) {
            count++;
        }
        
        for (int i = P; i < dna.length; i++) {
            if (dna[i-P] == 'A') {
                countA--;
            }
            else if (dna[i-P] == 'C') {
                countC--;
            }
            else if (dna[i-P] == 'G') {
                countG--;
            }
            else if (dna[i-P] == 'T') {
                countT--;
            }
            
            if (dna[i] == 'A') {
                countA++;
            }
            else if (dna[i] == 'C') {
                countC++;
            }
            else if (dna[i] == 'G') {
                countG++;
            }
            else if (dna[i] == 'T') {
                countT++;
            }
            
            if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) {
                count++;
            }
        }
        
        System.out.println(count);
        
        scanner.close();
    }
}