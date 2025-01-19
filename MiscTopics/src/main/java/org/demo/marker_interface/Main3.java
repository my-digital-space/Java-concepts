package org.demo.marker_interface;


// Main class to test the functionality
public class Main3 {
    public static void main(String[] args) {
        ShapeDao shapeDao = new ShapeDao();

        Entity deletableEntity = new Entity(1, "DeletableEntity");
        NonDeletableEntity nonDeletableEntity = new NonDeletableEntity(2, "NonDeletableEntity");

        System.out.println("=== Attempting to delete DeletableEntity ===");
        shapeDao.delete(deletableEntity); // Should succeed

        System.out.println("\n=== Attempting to delete NonDeletableEntity ===");
        shapeDao.delete(nonDeletableEntity); // Should fail
    }
}

