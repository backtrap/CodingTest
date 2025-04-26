import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] firstLine = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        
        HashMap<String, Boolean> hashMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String name = bufferedReader.readLine();
            hashMap.put(name, false);
        }
        
        for (int i = 0; i < M; i++) {
            String name = bufferedReader.readLine();
            
            if (hashMap.containsKey(name)) {
                hashMap.put(name, true);
            }
        }
        
        List<String> nameList = new ArrayList<>();
        
        for (Map.Entry<String, Boolean> i : hashMap.entrySet()) {
            if (i.getValue()) {
                nameList.add(i.getKey());
            }
        }
        
        Collections.sort(nameList);
        bufferedWriter.write("" + nameList.size() + "\n");
        
        for (int i = 0; i < nameList.size(); i++) {
            bufferedWriter.write(nameList.get(i) + "\n");
        }
        
        bufferedWriter.flush();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}