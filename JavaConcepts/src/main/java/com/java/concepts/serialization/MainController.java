package com.java.concepts.serialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/serialization")
public class MainController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping("/savePizza")
    public ResponseEntity<String> savePizza() throws IOException {
        // byte[] hardcodedSerializedObject = serialize(Files.readAllBytes(Paths.get("src/main/resources/my-image.jpg")));
        byte[] hardcodedSerializedObject = Files.readAllBytes(Paths.get("src/main/resources/my-image.jpg"));

        Pizza pizza = new Pizza(1, "Pepperoni", 16, hardcodedSerializedObject);
        pizzaRepository.save(pizza);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/fetchAllPizza")
    public ResponseEntity<List<Pizza>> fetchAllPizza() throws IOException, ClassNotFoundException {
        List<Pizza> pizzaList = pizzaRepository.findAll();
        pizzaList.forEach(System.out::println);

        byte[] imageBytes = pizzaList.getFirst().getPizzaImage();
        //byte[] imageObject = deserialize(imageBytes);

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes)) {
            File outputFile = new File("src/main/resources/deserialized-image", "my-deserialized-image.jpg");
            BufferedImage image = ImageIO.read(byteArrayInputStream);
            ImageIO.write(image, "jpg", outputFile);
        } catch (IOException e) {
            System.out.println("Error in saving image!");
            e.printStackTrace();
        }

        return new ResponseEntity<>(pizzaList, HttpStatus.OK);
    }

    private byte[] serialize(Serializable obj) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        }
    }

    private byte[] deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        // Step 1: Deserialize the object from the byte array
        Object deserializedObject;
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            deserializedObject = objectInputStream.readObject();
        }

        // Step 2: Serialize the object back into a byte array
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(deserializedObject);
            return byteArrayOutputStream.toByteArray();
        }
    }

}
