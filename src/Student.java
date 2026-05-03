public class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student other = (Student) obj;

        return age == other.age
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName);
    }

    @Override
    public String toString() {
        return "Student{firstName='" + firstName + "', lastName='" + lastName + "', age=" + age + "}";
    }
}