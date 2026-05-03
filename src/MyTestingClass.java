
public class MyTestingClass {
    private int number;
    private String text;

    public MyTestingClass(int number, String text) {
        this.number = number;
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 11;

        hash = 31 * hash + number;

        for (int i = 0; i < text.length(); i++) {
            hash = 31 * hash + text.charAt(i);
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        MyTestingClass other = (MyTestingClass) obj;

        return number == other.number && text.equals(other.text);
    }

    @Override
    public String toString() {
        return "MyTestingClass{number=" + number + ", text='" + text + "'}";
    }
}