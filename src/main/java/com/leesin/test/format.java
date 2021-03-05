import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    Map<Integer, CacheNode> map = new HashMap<>();
    int capacity = 0;
    CacheNode head = new CacheNode(-1, -1);
    CacheNode tail = new CacheNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        CacheNode current = map.get(key);
        current.next.prev = current.prev;
        current.prev.next = current.next;
        moveToTail(current);
        return current.value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        CacheNode current = new CacheNode(key, value);
        map.put(key, current);
        moveToTail(current);
    }

    public void moveToTail(CacheNode current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
