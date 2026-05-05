import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        int n = participant.length;
        int m = completion.length;
        
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(participant[i])) {
                int count = hashMap.get(participant[i]);
                hashMap.put(participant[i], ++count);
            }
            else {
                hashMap.put(participant[i], 1);                
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (hashMap.containsKey(completion[i])) {
                int count = hashMap.get(completion[i]);
                
                if (count > 1) {
                    hashMap.put(completion[i], --count);
                }
                else {
                    hashMap.remove(completion[i]);
                }
            }
        }
        
        String [] answers = hashMap.keySet().toArray(new String[0]);
        answer = answers[0];
        
        return answer;
    }
}