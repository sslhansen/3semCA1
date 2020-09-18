package DTO;

import entities.Car;

public class CarDTO {

    private long id;
    private int year;
    private String make;
    private String model;
    private int price;

    public CarDTO(Car car) {
        id = car.getId();
        year = car.getYear();
        make = car.getMake();
        model = car.getModel();
        price = car.getPrice();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
