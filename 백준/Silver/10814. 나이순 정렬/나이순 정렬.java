import java.io.*;
import java.util.*;

class Member implements Comparable<Member> {
    int age;
    String name;
    int num;
    
    public Member(int age, String name, int num) {
        this.age = age;
        this.name = name;
        this.num = num;
    }
    
    public String getInfo() {
        return age + " " + name;
    }
    
    @Override
    public int compareTo(Member other) {
        if (this.age == other.age) {
            return this.num - other.num;
        }
        else {
            return this.age - other.age;
        }
    }
}

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        
        List<Member> memberList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String command = bufferedReader.readLine();
            
            String [] str = command.split(" ");
            int age = Integer.parseInt(str[0]);
            String name = str[1];
            Member member = new Member(age, name, i);
            
            memberList.add(member);
        }
        
        Collections.sort(memberList);
        
        for (int i = 0; i < N; i++) {
            bufferedWriter.write(memberList.get(i).getInfo());
            bufferedWriter.newLine();
        }
        
        bufferedWriter.flush();
        
        bufferedWriter.close();
        bufferedReader.close();
    }
}