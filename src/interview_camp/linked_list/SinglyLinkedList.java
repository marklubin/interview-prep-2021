package interview_camp.linked_list;

public class SinglyLinkedList<T> {

    public Node<T> getHead() {
        return head;
    }

    private Node<T> head;

    private Node<T> tail;

    public static <T> SinglyLinkedList<T> of(T... items) {
        SinglyLinkedList<T> linkedList = new SinglyLinkedList<>();

        for (T item : items) {
            linkedList.append(new Node(item));
        }

        return linkedList;
    }


    /*

       1->2->3->null

       # Initial State

       prev = [null,null]
       curr = [1,2]
       next = [2,3]

       # Loop 1

       curr = [1,null]
       prev [1,null]
       curr = [2,3]
       next [3, null]

       # Loop 2

       curr = [2, 1]
       prev = [2,1]
       curr = [3, null]
       next = [null, null]


      #Loop 3

      curr = [3, 2]
      prev = [3,2]
      curr = [null, null]

     */
    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {
            Node<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        Node<T> temp = head;
        head = tail;
        tail = head;
    }


    public void append(Node node) {
        if (node == null) {
            return;
        }

        node.setNext(null);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.setNext(node);
        tail = node;
    }


    private void delete(Node node) {
        if (node == head) {
            head = head.getNext();
            return;
        }

        Node prev = head;

        while (prev != null && prev.getNext() != node) {
            prev = prev.getNext();
        }

        //Not in list
        if (prev == null) {
            return;
        }

        prev.setNext(node.getNext());

        if (node == tail) {
            tail = prev;
        }
    }


    @Override
    public String toString() {
        Node<T> node = head;
        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.getData().toString() + "->");
            node = node.getNext();
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = SinglyLinkedList.of(1, 2, 3, 4);
        list.reverse();
        System.out.println(list);
    }
}
