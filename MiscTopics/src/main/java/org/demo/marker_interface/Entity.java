package org.demo.marker_interface;

// Entity class implementing the marker interface
public class Entity implements Deletable {
    private int id;
    private String name;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{id=" + id + ", name='" + name + "'}";
    }
}
