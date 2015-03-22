import java.util.*;

public class LRUCache {
	
	static class Node {
		Node next;
		Node prev;
		int key, value;
		public Node(int key, int value) {
			prev = next = null;
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity;
	private int size;
	private HashMap<Integer, Node> map;
	private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<Integer, Node>();
        head = tail = null;
    }
    
    public int get(int key) {
		if (size > 0 && map.containsKey(key)) {
			Node target = map.get(key);
			if (target != head) {
				// last node or not
				if (target != tail) {
					target.next.prev = target.prev;
				} else {
					tail = tail.prev;
				}
				target.prev.next = target.next;
				target.prev = null;
				target.next = head;
				head.prev = target;
				head = target;
			}
			return target.value;
		}
		return -1;
    }
    
    public void set(int key, int value) {
    	if (!map.containsKey(key)) {
        	Node newNode = new Node(key, value);
	        
        	if (size + 1 > capacity) {	// delete last node when it's full
	        	map.remove(tail.key);
	        	tail = tail.prev;
	        	if (tail != null) {
	        		tail.next = null;
	        	} else {
	        		head = null;
	        	}
	        }
	        
	        // add new node to head;
        	newNode.next = head;
        	if (head != null) {
        		head.prev = newNode;
        	} else {
        		tail = newNode;
        	}
        	head = newNode;
        	map.put(key, newNode);
	        size++;
    	} else {
    		// insert this node to head
    		Node target = map.get(key);
    		target.value = value;	// remember update value
    		
    		// exact same as get
    		if (target != head) {
				target.prev.next = target.next;
    			if (target != tail) {
    				target.next.prev = target.prev;
    			} else {
    				tail = tail.prev;
    			}
				target.prev = null;
				target.next = head;
				head.prev = target;
				head = target;
    		}
    	}
    }
}
