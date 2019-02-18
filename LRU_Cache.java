

import java.util.*;

class LRUCache {
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	int cap; 

	static Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);


    public LRUCache(int capacity) {
        this.cap = capacity;
        joinNodes(head, tail);
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null){
        	return -1;
        }

    	joinNodes(n.prev, n.next);
    	moveToHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n == null){
        	if(cap == map.size()){
        		joinNodes(tail.prev.prev, tail);
        		map.remove(tail.prev.key);
        	}
        	Node newNode = new Node(key, value);
        	map.put(key, newNode);
        	moveToHead(newNode);
        }
        else {
        	n.val = value;
        	joinNodes(n.prev, n.next);
    		moveToHead(n);
        }
    }

    public static void moveToHead(Node n){
//     	Node temp = head.next;
//     	head.next = n;
//     	n.next = temp;
        joinNodes(n, head.next);
        joinNodes(head, n);
    }

    public static void joinNodes(Node n1, Node n2){
    	n1.next = n2;
    	n2.prev = n1;
    }
    
    
}
class Node{
    int val;
    int key;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */