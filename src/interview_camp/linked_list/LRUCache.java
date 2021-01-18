package interview_camp.linked_list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {


    private static class Node<K, V> {
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private final K key;
        private final V value;

        private Node<K, V> prev;
        private Node<K, V> next;

    }

    private Node<K, V> head;

    private Node<K, V> tail;

    private int currentLoad = 0;

    private Map<K, Node<K, V>> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private final int capacity;


    /*
        1. Create a node, put into Map for storage at slot K
        2. If list exceed capacity delete the LR ndoe
        2. Append to new end of the LRU list
     */
    public void put(K key, V value) {
        Node node = new Node(key, value);

        if (currentLoad == capacity) {
            map.remove(head.key);
            deleteNode(head);
        }

        map.put(head.key, node);
        appendNode(node);
    }


    public V get(K key) {
        if (map.containsKey(key)) {
            return null;
        }

        Node<K, V> node = map.get(key);
        deleteNode(node);
        appendNode(node);

        return node.value;
    }


    private void appendNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;

    }

    private void deleteNode(Node node) {
        if (node == head) {
            head = head.next;
            head.prev = null;
        }

        if (node == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }

        if (node == head || node == tail) {
            return;
        }

        Node prev = node.prev;
        Node next = node.next;

        prev.next = node.next;
        next.prev = node.prev;
    }
}
