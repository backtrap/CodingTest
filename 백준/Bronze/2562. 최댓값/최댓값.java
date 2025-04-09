import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Integer> numList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            int num = scanner.nextInt();
            numList.add(num);
            indexList.add(num);
        }
        
        Collections.sort(numList, Collections.reverseOrder());
        
        System.out.println(numList.get(0));
        System.out.println(indexList.indexOf(numList.get(0))+1);
    }
}