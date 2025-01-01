package com.example.demo.model;

public class old_Instrument__ {
    private String serial;
    private String brand;
    private String model;
    private String category;
    private String color;
    private String name;
    private String description;
    private float price;

    //EMPTY
    public old_Instrument__() {
    }

    //FULL CONSTRUCTOR
    public old_Instrument__(String id,
                            String brand,
                            String model,
                            String category,
                            String color,
                            String name,
                            String description,
                            float price) {
        this.serial = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.color = color;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //NO ID


    public old_Instrument__(String brand,
                            String model,
                            String category,
                            String color,
                            String name,
                            String description,
                            float price) {
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.color = color;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
