import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(bufferedReader.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            String command = bufferedReader.readLine();

            if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }
            else if (command.equals("empty")) {
                set.clear();
            }
            else {
                String[] srr = command.split(" ");
                String str = srr[0];
                int x = Integer.parseInt(srr[1]);

                switch (str) {
                    case "add":
                        set.add(x);
                        break;
                    case "remove":
                        set.remove(x);
                        break;
                    case "check":
                        if (set.contains(x)) {
                            bufferedWriter.write("1\n");
                        } else {
                            bufferedWriter.write("0\n");
                        }
                        break;
                    case "toggle":
                        if (set.contains(x)) {
                            set.remove(x);
                        } else {
                            set.add(x);
                        }
                        break;
                }
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
