import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String [] firstLine = bufferedReader.readLine().split(" ");
        String [] secondLine = bufferedReader.readLine().split(" ");
        
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int [] trees = new int [N];
        
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(secondLine[i]);
        }
        
        Arrays.sort(trees);
        
        int h = binarySearch(trees, 0, trees[N-1], M);
        
        System.out.println(h);
    }
    
    public static int binarySearch(int [] trees, int low, int high, int M) {
        int cut = -1;
        
        while (low <= high) {
            int mid = (low+high)/2;
            
            if (check(trees, mid, M)) {
                cut = Math.max(cut, mid);
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
            
        }
        
        return cut;
    }
    
    public static boolean check(int [] trees, int cut, int M) {
        int n = trees.length;
        long left = 0;
        
        for (int i = 0; i < n; i++) {
            if (trees[i] > cut) {
                left = left + trees[i] - cut;
            }
        }
        
        if (left >= M) {
            return true;
        }
        else {
            return false;
        }
    }
}