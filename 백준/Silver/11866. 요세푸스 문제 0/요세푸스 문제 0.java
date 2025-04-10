import java.util.*;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class CircularQueue {
    Node head = null;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    void enqueue(int data) {
        Node input = new Node(data);
        if (isEmpty()) {
            head = input;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;
            input.next = head;
            input.prev = tail;
            tail.next = input;
            head.prev = input;
        }
        size++;
    }

    int dequeue(int index) {
        if (size == 0) return -1;

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        int output = node.data;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        if (node == head) {
            head = node.next;
        }

        size--;
        return output;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        CircularQueue circularQueue = new CircularQueue();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            circularQueue.enqueue(i);
        }

        int index = 0;

        while (!circularQueue.isEmpty()) {
            index = (index + K - 1) % circularQueue.getSize();
            result.add(circularQueue.dequeue(index));
        }

        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
