class MyHashSet {
    
    private static final int BUCKETS = 769; // A prime number to reduce collisions
    private LinkedList<Integer>[] bucketArray;

    public MyHashSet() {
        bucketArray = new LinkedList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            bucketArray[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BUCKETS;
    }
    
    public void add(int key) {
        int index = hash(key);
        if (!bucketArray[index].contains(key)) {
            bucketArray[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        bucketArray[index].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return bucketArray[index].contains(key);
    }
}