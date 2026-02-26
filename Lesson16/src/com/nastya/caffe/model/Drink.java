package com.nastya.caffe.model;

public class Drink {
	    private String name;
	    private double waterRequired;
	    private double beansRequired;
	    private double price;
	    
	    public Drink() {}

	    public Drink(String name, double waterRequired, double beansRequired, double price) {
	        this.name = name;
	        this.waterRequired = waterRequired;
	        this.beansRequired = beansRequired;
	        this.price = price;
	    }
	    public String getName() { return name; }
	    public double getWaterRequired() { return waterRequired; }
	    public double getBeansRequired() { return beansRequired; }
	    public double getPrice() { return price; }
	
}
