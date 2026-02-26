package com.nastya.caffe.model;

import java.util.Objects;

public class Coffeemachine {

	private final int id;
	private String brand;
	private double waterLevel; // в мл
	private double coffeeBeans; // в граммах
	private double milkLevel;

	public Coffeemachine(int id, String brand, double waterLevel, double coffeeBeans, double milkLevel) {
		this.id = id;
		this.brand = brand;
		this.waterLevel = waterLevel;
		this.coffeeBeans = coffeeBeans;
		this.milkLevel = milkLevel;

	}

	public void addWater(double amount) {
		this.waterLevel += amount;
	}

	public void addBeans(double amount) {
		this.coffeeBeans += amount;
	}

	public void addMilk(double amount) {
		this.milkLevel += amount;
	}

	public void useWater(double amount) {
		if (this.waterLevel < amount) {
			throw new IllegalStateException("not enough water!");
		}
		this.waterLevel -= amount;
	}

	// Метод для зерен
	public void useBeans(double amount) {
		if (this.coffeeBeans < amount) {
			throw new IllegalStateException("not enough beans!");
		}
		this.coffeeBeans -= amount;
	}

	// Метод для молока
	public void useMilk(double amount) {
		if (this.milkLevel < amount) {
			throw new IllegalStateException("not enough milk!");
		}
		this.milkLevel -= amount;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public double getWaterLevel() {
		return waterLevel;
	}

	public double getCoffeeBeans() {
		return coffeeBeans;
	}

	public double getMilkLevel() {
		return milkLevel;
	}

	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public void setCoffeeBeans(double coffeeBeans) {
		this.coffeeBeans = coffeeBeans;
	}

	public void setMilkLevel(double milkLevel) {
		this.milkLevel = milkLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, coffeeBeans, id, milkLevel, waterLevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coffeemachine other = (Coffeemachine) obj;
		return Objects.equals(brand, other.brand)
				&& Double.doubleToLongBits(coffeeBeans) == Double.doubleToLongBits(other.coffeeBeans) && id == other.id
				&& Double.doubleToLongBits(milkLevel) == Double.doubleToLongBits(other.milkLevel)
				&& Double.doubleToLongBits(waterLevel) == Double.doubleToLongBits(other.waterLevel);
	}

	@Override
	public String toString() {
		return "Coffeemachine [id=" + id + ", brand=" + brand + ", waterLevel=" + waterLevel + ", coffeeBeans="
				+ coffeeBeans + ", milkLevel=" + milkLevel + "]";
	}

}
