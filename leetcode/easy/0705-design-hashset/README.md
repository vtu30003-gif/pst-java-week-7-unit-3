# Design HashSet

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Design a HashSet without using any built-in hash table libraries.

Implement `MyHashSet` class:

- void add(key) Inserts the value key into the HashSet.
- bool contains(key) Returns whether the value key exists in the HashSet or not.
- void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

 

 **Example 1:** 

```
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
```

 

 **Constraints:** 

- 0 <= key <= 106
- At most 104 calls will be made to add, remove, and contains.

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 33.31%)  
**Memory:** 55.9 MB (beats 11.90%)  
**Submitted:** 2026-10-19T12:30:54.148Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/design-hashset/)