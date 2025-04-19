import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
    int length;
    String text;
    
    public Word(String text) {
        this.text = text;
        this.length = text.length();
    }
    
    @Override
    public int compareTo(Word other) {
        if (this.length == other.length) {
            return this.text.compareTo(other.text);
        }
        else {
            return this.length - other.length;
        }
    }
    
    String getText() {
        return this.text;
    }
}

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        
        List<String> stringList = new ArrayList<>();
        List<Word> wordList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String text = bufferedReader.readLine();
            
            if (stringList.contains(text)) {
                continue;
            }
            else {
                stringList.add(text);
            }
        }
        
        for (int i = 0; i < stringList.size(); i++) {
            Word word = new Word(stringList.get(i));
            wordList.add(word);
        }
        
        Collections.sort(wordList);
        
        for (int i = 0; i < wordList.size(); i++) {
            bufferedWriter.write(wordList.get(i).getText());
            bufferedWriter.newLine();
        }
        
        bufferedWriter.flush();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}