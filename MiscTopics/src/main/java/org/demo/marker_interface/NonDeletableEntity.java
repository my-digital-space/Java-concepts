package org.demo.marker_interface;

// Another class NOT implementing the marker interface
public class NonDeletableEntity {
    private int id;
    private String name;

    public NonDeletableEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NonDeletableEntity{id=" + id + ", name='" + name + "'}";
    }
}
