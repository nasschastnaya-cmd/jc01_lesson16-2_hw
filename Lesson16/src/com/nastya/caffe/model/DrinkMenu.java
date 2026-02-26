package com.nastya.caffe.model;
import java.util.HashMap;
import java.util.Map;


public enum DrinkMenu {
	ESPRESSO("Эспрессо", 30, 7, 0),
    AMERICANO("Американо", 150, 7, 0),
    CAPPUCCINO("Капучино", 40, 7, 150),
    LATTE("Латте", 40, 7, 180);

    private final String name;
    private final double water;
    private final double beans;
    private final double milk;
    
    DrinkMenu(String name, double water, double beans, double milk) {
        this.name = name;
        this.water = water;
        this.beans = beans;
        this.milk = milk;
    }
    
    public String getName() { return name; }
    public double getWater() { return water; }
    public double getBeans() { return beans; }
    public double getMilk() { return milk; }
    
    
    private static final Map<String, DrinkMenu> DRINK_MAP = new HashMap<>();
    
    static {
        for (DrinkMenu drink : values()) {
            DRINK_MAP.put(drink.getName().toLowerCase(), drink);
        }
    }

    public static DrinkMenu getByName(String name) {
        return DRINK_MAP.get(name.toLowerCase());
    }
    
    public static Map<String, DrinkMenu> getFullMenu() {
        return DRINK_MAP;
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//public static final Drink ESPRESSO = new Drink("Эспрессо", 30, 7, 100);
    //public static final Drink AMERICANO = new Drink("Американо", 150, 7, 120);
    
    //public static final MilkDrink CAPPUCCINO = new MilkDrink("Капучино", 40, 7, 100, 150);
    //public static final MilkDrink LATTE = new MilkDrink("Латте", 40, 7, 150, 180);

    
    //public static Drink[] getAllDrinks() {
        //return new Drink[]{ESPRESSO, AMERICANO, CAPPUCCINO, LATTE};
    
