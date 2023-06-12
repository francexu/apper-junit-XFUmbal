package main.java.org.example.notes;

// record is like a typical java class, may automatic na getter setter
// final class
public record Account(String id, String name, Double balance) {

    public Account withId(String id) {
        return new Account(id, name(), balance());
    }
}
