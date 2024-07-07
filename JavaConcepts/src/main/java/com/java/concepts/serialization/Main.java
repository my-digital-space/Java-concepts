package com.java.concepts.serialization;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        // saveDataInFile();
        readDataFromFile();
    }

    public static void saveDataInFile() {
        Person person = new Person("John Doe", 30);

        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readDataFromFile() {
        Person person = null;

        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            person = (Person) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }

        System.out.println("Deserialized Person...");
        System.out.println(person);
    }

}
