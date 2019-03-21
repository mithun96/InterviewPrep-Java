/* Question

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the 
following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise 
return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its 
capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

*/


import java.util.*;

class LRUCache {
	Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
        join(head, tail);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                if (tail.prev != head) {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
            }
            Node node = new Node(key, value);
            moveToHead(node); 
            map.put(key, node);
        }       
    }   

    public void join(Node n1, Node n2) {
        n1.next = n2;
        n2.prev = n1;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node) {
        Node next = head.next; 
        join(head, node);
        join(node, next);
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    } 
}
// class Node{
//     int val;
//     int key;
//     Node prev;
//     Node next;

//     public Node(int key, int val){
//         this.val = val;
//         this.key = key;
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */