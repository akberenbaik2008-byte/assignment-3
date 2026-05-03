public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode<K, V>[] buckets;
    private int bucketCount;
    private int size;

    public MyHashTable() {
        bucketCount = 11;
        buckets = new HashNode[bucketCount];
        size = 0;
    }

    public MyHashTable(int bucketCount) {
        this.bucketCount = bucketCount;
        buckets = new HashNode[bucketCount];
        size = 0;
    }

    private int getIndex(K key) {
        return (key.hashCode() & 0x7fffffff) % bucketCount;
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        HashNode<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;

        size++;
    }

    public V get(K key) {
        int index = getIndex(key);

        HashNode<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);

        HashNode<K, V> current = buckets[index];
        HashNode<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return current.value;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < bucketCount; i++) {
            HashNode<K, V> current = buckets[i];

            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }

                current = current.next;
            }
        }

        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < bucketCount; i++) {
            HashNode<K, V> current = buckets[i];

            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }

                current = current.next;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public void printBucketSizes() {
        for (int i = 0; i < bucketCount; i++) {
            int count = 0;
            HashNode<K, V> current = buckets[i];

            while (current != null) {
                count++;
                current = current.next;
            }

            System.out.println("Bucket " + i + ": " + count);
        }
    }
}
