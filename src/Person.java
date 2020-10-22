public class Person {
    private String firstName;
    private String lastName;
    public Person(String fN, String lN) {
        firstName = fN;
        lastName = lN;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
