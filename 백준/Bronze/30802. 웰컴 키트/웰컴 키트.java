import java.util.*;
import java.io.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = bufferedReader.readLine();
        String secondLine = bufferedReader.readLine();
        String [] srr = secondLine.split(" ");
        String thirdLine = bufferedReader.readLine();
        String [] srr2 = thirdLine.split(" ");
        int N = Integer.parseInt(firstLine);
        int S = Integer.parseInt(srr[0]);
        int M = Integer.parseInt(srr[1]);
        int L = Integer.parseInt(srr[2]);
        int X = Integer.parseInt(srr[3]);
        int XL = Integer.parseInt(srr[4]);
        int XXL = Integer.parseInt(srr[5]);
        int T = Integer.parseInt(srr2[0]);
        int P = Integer.parseInt(srr2[1]);
        
        int min = count(S, T) + count(M, T) + count(L, T) + count(X, T) + count(XL, T) + count(XXL, T);
        
        System.out.println(min);
        System.out.println("" + N/P + " " + N%P);
    }
    
    public static int count(int n, int T) {
        if (n%T == 0) {
            return n/T;
        }
        else {
            return n/T + 1;
        }
    }
}