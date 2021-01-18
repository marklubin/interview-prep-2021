package interview_camp.linked_list;

public class PalindromeChecker {


    /*
     * Get length of list
     * Reverse the part of the second part of the list
     * Iterate two pointers together and check if elements match
     *
     * A->B->B-A
     *
     * Length = 4
     * Reverse starting on Node 2
     *
     *
     * 4/2 = 2
     *
     * K->A->Y-A->K
     *
     * Length = 5
     * Reverse starting node Node 3
     *
     * 5/2 = 2 + 1 = 3
     */
    private static <T> boolean isPalindrome(Node<T> head) {
        int length = getLength(head);

        int reverseStart = length / 2;

        if (length % 2 == 1) {
            reverseStart++;
        }

        Node<T> reverseHead = head;

        for (int i = 0; i < reverseStart; i++) {
            reverseHead = reverseHead.getNext();
        }

        Node<T> midHead = reverse(reverseHead);


        while (midHead != null) {
            if (!head.getData().equals(midHead.getData())) {
                return false;
            }
            head = head.getNext();
            midHead = midHead.getNext();
        }


        return true;


    }


    private static <T> Node<T> reverse(Node<T> head) {
        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {
            Node<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }


    private static <T> int getLength(Node<T> head) {
        int length = 0;

        while (head != null) {
            head = head.getNext();
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = SinglyLinkedList.of("K", "A", "Y", "A", "K");
        System.out.println(isPalindrome(list.getHead()));
    }
}