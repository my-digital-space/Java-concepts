package com.java.concepts.serialization;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "pizza")
public class Pizza implements Serializable {

    @Serial
    private static final long serialVersionUID = 13L; // Version 1.2

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String pizzaStyle;

    private Integer size;

    @Lob
    private byte[] pizzaImage; // serializedObject

    // No-argument constructor is needed by JPA
    public Pizza() {
    }

    public Pizza(Integer id, String pizzaStyle, Integer size, byte[] pizzaImage) {
        this.id = id;
        this.pizzaStyle = pizzaStyle;
        this.size = size;
        this.pizzaImage = pizzaImage;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", pizzaStyle='" + pizzaStyle + '\'' +
                ", size=" + size +
                ", pizzaImage=" + Arrays.toString(pizzaImage) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPizzaStyle() {
        return pizzaStyle;
    }

    public void setPizzaStyle(String pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public byte[] getPizzaImage() {
        return pizzaImage;
    }

    public void setPizzaImage(byte[] pizzaImage) {
        this.pizzaImage = pizzaImage;
    }
}
