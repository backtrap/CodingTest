import java.io.*;
import java.util.*;
import java.time.*;

class Flower implements Comparable<Flower> {
    LocalDate start;
    LocalDate end;

    public Flower(int m1, int d1, int m2, int d2) {
        this.start = LocalDate.of(2025, m1, d1);
        this.end = LocalDate.of(2025, m2, d2);
    }

    @Override
    public int compareTo(Flower o) {
        if (this.start.equals(o.start)) {
            return o.end.compareTo(this.end);
        }
        return this.start.compareTo(o.start);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        List<Flower> flowerList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m1 = Integer.parseInt(stringTokenizer.nextToken());
            int d1 = Integer.parseInt(stringTokenizer.nextToken());
            int m2 = Integer.parseInt(stringTokenizer.nextToken());
            int d2 = Integer.parseInt(stringTokenizer.nextToken());

            flowerList.add(new Flower(m1, d1, m2, d2));
        }

        Collections.sort(flowerList);

        LocalDate targetStart = LocalDate.of(2025, 3, 1);
        LocalDate targetEnd = LocalDate.of(2025, 11, 30).plusDays(1);

        int count = 0;
        LocalDate currentEnd = targetStart;
        int idx = 0;
        int size = flowerList.size();

        while (currentEnd.isBefore(targetEnd)) {
            LocalDate maxEnd = currentEnd;
            boolean found = false;

            while (idx < size && !flowerList.get(idx).start.isAfter(currentEnd)) {
                if (flowerList.get(idx).end.isAfter(maxEnd)) {
                    maxEnd = flowerList.get(idx).end;
                    found = true;
                }
                idx++;
            }

            if (!found) {
                count = 0;
                break;
            }

            count++;
            currentEnd = maxEnd;
        }

        System.out.println(count);
        bufferedReader.close();
    }
}
