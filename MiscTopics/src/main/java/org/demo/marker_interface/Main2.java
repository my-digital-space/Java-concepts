package org.demo.marker_interface;

// Class implementing Cloneable
class CloneableClass implements Cloneable {
    private String name;
    private int age;

    public CloneableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Call Object's clone method
    }

    @Override
    public String toString() {
        return "CloneableClass{name='" + name + "', age=" + age + "}";
    }
}

// Class NOT implementing Cloneable
class NonCloneableClass {
    private String name;
    private int age;

    public NonCloneableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "NonCloneableClass{name='" + name + "', age=" + age + "}";
    }
}

public class Main2 {
    public static void main(String[] args) {
        CloneableClass cloneableObject = new CloneableClass("Amit", 30);
        NonCloneableClass nonCloneableObject = new NonCloneableClass("Rahul", 25);

        // Clone both objects
        System.out.println("=== Demonstrating with Cloneable ===");
        cloneObject(cloneableObject);

        System.out.println("\n=== Demonstrating without Cloneable ===");
        cloneObject(nonCloneableObject);
    }

    private static void cloneObject(Object obj) {
        try {
            if (obj instanceof Cloneable) {
                // Cast to Cloneable class and invoke clone() safely
                Object clonedObject = obj.getClass().getMethod("clone").invoke(obj);
                System.out.println("Cloning successful. Original: " + obj + ", Cloned: " + clonedObject);
            } else {
                throw new CloneNotSupportedException("Object does not implement Cloneable");
            }
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning failed! Object does not implement Cloneable: " + obj.getClass().getName());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

