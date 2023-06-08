package org.example;

// record is like a typical java class, may automatic na getter setter
// final class
public record Account(String id, String name, Double balance) {
}
