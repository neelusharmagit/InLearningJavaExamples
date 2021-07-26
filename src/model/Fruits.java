package model;

public class Fruits  {

    String name;
    Double Price;

    public Fruits(String name, Double price) {
        this.name = name;
        Price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }



}
