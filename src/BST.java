import java.util.ArrayList;
import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;

            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }

        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        size++;
    }

    public V get(K key) {
        Node current = root;

        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }

        return null;
    }

    public void delete(K key) {
        Node current = root;
        Node parent = null;

        while (current != null && !current.key.equals(key)) {
            parent = current;

            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return;
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            Node minParent = current;
            Node min = current.right;

            while (min.left != null) {
                minParent = min;
                min = min.left;
            }

            current.key = min.key;
            current.value = min.value;

            if (minParent.left == min) {
                minParent.left = min.right;
            } else {
                minParent.right = min.right;
            }
        }

        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        ArrayList<Entry<K, V>> list = new ArrayList<>();
        ArrayList<Node> stack = new ArrayList<>();

        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.remove(stack.size() - 1);

            list.add(new Entry<>(current.key, current.value));

            current = current.right;
        }

        return list.iterator();
    }
}