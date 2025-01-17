package org.demo.marker_interface;

import java.io.Serializable;
import java.io.*;

// Class implementing Serializable
class SerializableClass implements Serializable {
    private static final long serialVersionUID = 1L; // Best practice for Serializable classes
    private String name;
    private int age;

    public SerializableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SerializableClass{name='" + name + "', age=" + age + "}";
    }
}

// Class NOT implementing Serializable
class NonSerializableClass {
    private String name;
    private int age;

    public NonSerializableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "NonSerializableClass{name='" + name + "', age=" + age + "}";
    }
}

public class Main1 {
    public static void main(String[] args) {
        SerializableClass serializableObject = new SerializableClass("Amit", 30);
        NonSerializableClass nonSerializableObject = new NonSerializableClass("Rahul", 25);

        // Serialize and Deserialize both objects
        System.out.println("=== Demonstrating with Serializable ===");
        serializeAndDeserialize(serializableObject);

        System.out.println("\n=== Demonstrating without Serializable ===");
        serializeAndDeserialize(nonSerializableObject);
    }

    private static void serializeAndDeserialize(Object obj) {
        try {
            // Serialize the object
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj); // Attempt to serialize the object
            oos.close();

            System.out.println("Serialization successful for object: " + obj);

            // Deserialize the object
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object deserializedObject = ois.readObject();
            ois.close();

            System.out.println("Deserialization successful for object: " + deserializedObject);
        } catch (NotSerializableException e) {
            System.err.println("Serialization failed! Object does not implement Serializable: " + obj.getClass().getName());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
