package org.demo.marker_interface;

// DAO class
public class ShapeDao {

    // Method to delete objects from the database
    public boolean delete(Object object) {
        if (!(object instanceof Deletable)) {
            System.out.println("Deletion failed: Object " + object + " is not deletable.");
            return false;
        }

        // Simulate deletion logic
        System.out.println("Object " + object + " deleted successfully.");
        return true;
    }
}
