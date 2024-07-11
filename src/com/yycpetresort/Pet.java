package com.yycpetresort;

public class Pet {
    private String name;
    private String type; // e.g., cat, dog, bird
    private String breed;
    private int age;
    private String specialInstructions;

    public Pet(String name, String type, String breed, int age, String specialInstructions) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.specialInstructions = specialInstructions;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // Other methods as needed (e.g., toString, equals, hashCode)
}