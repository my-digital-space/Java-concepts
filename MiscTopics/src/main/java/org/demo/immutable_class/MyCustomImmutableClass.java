package org.demo.immutable_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class MyCustomImmutableClass {
    private final int id;
    private final String name;
    // For mutable objects, you need extra care (see point 5)
    private final Date birthDate;
    private final List<String> myBooksList;

    public MyCustomImmutableClass(int id, String name, Date birthDate, List<String> myBooksList) {
        this.id = id;
        this.name = name;
        this.birthDate = new Date(birthDate.getTime()); // Defensive copy to prevent external modification
        this.myBooksList = new ArrayList<>(myBooksList); // Defensive copy
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Date getBirthDate() {
        // Return a new copy to prevent modification of the internal state
        return new Date(birthDate.getTime());
    }
    public List<String> getMyBooksList() {
        return Collections.unmodifiableList(myBooksList); // Unmodifiable view
    }
}
