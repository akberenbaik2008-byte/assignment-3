import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("hash table test");

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100);

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int number = random.nextInt(100000);
            String text = "Text" + i + "_" + random.nextInt(100000);

            MyTestingClass key = new MyTestingClass(number, text);

            String firstName = "Name" + i;
            String lastName = "Surname" + i;
            int age = 18 + random.nextInt(10);

            Student value = new Student(firstName, lastName, age);

            table.put(key, value);
        }

        table.printBucketSizes();
        System.out.println("HashTable size: " + table.size());

        System.out.println();
        System.out.println("small hash table test");

        MyHashTable<MyTestingClass, Student> smallTable = new MyHashTable<>();

        MyTestingClass key1 = new MyTestingClass(10, "Apple");
        MyTestingClass key2 = new MyTestingClass(20, "Orange");

        Student student1 = new Student("Amina", "Sultanova", 19);
        Student student2 = new Student("Dana", "Karimova", 20);

        smallTable.put(key1, student1);
        smallTable.put(key2, student2);

        System.out.println("Get key1: " + smallTable.get(key1));
        System.out.println("Contains student1: " + smallTable.contains(student1));
        System.out.println("Get key by student2: " + smallTable.getKey(student2));

        smallTable.remove(key1);

        System.out.println("After removing key1:");
        System.out.println("Get key1: " + smallTable.get(key1));
        System.out.println("Small table size: " + smallTable.size());

        System.out.println();
        System.out.println("bst test");

        BST<Integer, Student> tree = new BST<>();

        tree.put(50, new Student("Aigerim", "Nurmullaeva", 16));
        tree.put(30, new Student("MARAL", "Omarova", 18));
        tree.put(70, new Student("Madina", "Gabdullina", 17));
        tree.put(20, new Student("Maksat", "Esirkepov", 19));
        tree.put(40, new Student("Nazerke", "Karamanova", 18));

        System.out.println("BST size: " + tree.size());
        System.out.println("Get key 30: " + tree.get(30));

        System.out.println();
        System.out.println("In-order traversal:");

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        tree.delete(30);

        System.out.println();
        System.out.println("After deleting key 30:");
        System.out.println("BST size: " + tree.size());

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
