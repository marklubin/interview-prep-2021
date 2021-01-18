package interview_camp.linked_list;

public class EvenOddSplit {

    private static SinglyLinkedList<Integer>[] evenOddSplit(SinglyLinkedList<Integer> list) {

        Node next = list.getHead();
        int cnt = 0;

        SinglyLinkedList<Integer> evenList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> oddList = new SinglyLinkedList<>();

        while (next != null) {
            Node node = next;
            next = node.getNext();
            if (cnt % 2 == 0) {
                evenList.append(node);
            } else {
                oddList.append(node);
            }
            cnt++;
        }

        return new SinglyLinkedList[]{evenList, oddList};

    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> original = SinglyLinkedList.of(1, 2, 3, 4, 5);
        SinglyLinkedList<Integer>[] result = evenOddSplit(original);
        System.out.println("Even Positions: " + result[0]);
        System.out.println("Odd Positions: " + result[1]);
    }
}
