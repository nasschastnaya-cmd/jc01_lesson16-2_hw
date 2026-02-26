package com.nastya.caffe.service;

import com.nastya.caffe.exception.NotEnoughResourcesException;
import com.nastya.caffe.model.DrinkMenu;
import com.nastya.caffe.ui.Notifications;
import com.nastya.caffe.model.Coffeemachine;
import java.util.ArrayList;
import java.util.List;

public class CoffeeMachineService {
	private List<Coffeemachine> machines = new ArrayList<>();

	public boolean addMachine(Coffeemachine machine) {
		machines.add(machine);
		return true;
	}

	public boolean removeMachine(int id) {
		boolean removed = machines.removeIf(m -> m.getId() == id);
		return removed;
	}

	public Coffeemachine findMachine(int id) {
		for (Coffeemachine m : machines) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	private DrinkMenu prepareDrink(Coffeemachine machine, DrinkMenu drink) throws NotEnoughResourcesException {

		if (machine.getWaterLevel() < drink.getWater()) {
			throw new NotEnoughResourcesException("Ошибка: недостаточно воды для " + drink.getName());
		}
		if (machine.getCoffeeBeans() < drink.getBeans()) {
			throw new NotEnoughResourcesException("Ошибка: недостаточно зерен для " + drink.getName());
		}
		if (machine.getMilkLevel() < drink.getMilk()) {
			throw new NotEnoughResourcesException("Ошибка: недостаточно молока для " + drink.getName());
		}
		 Notifications.showCookingProgress();

		machine.setWaterLevel(machine.getWaterLevel() - drink.getWater());
		machine.setCoffeeBeans(machine.getCoffeeBeans() - drink.getBeans());
		machine.setMilkLevel(machine.getMilkLevel() - drink.getMilk());

		 Notifications.showSuccess(drink.getName());
		 
		return drink;
	}

	public DrinkMenu prepareDrink(String drinkName, int machineId) throws NotEnoughResourcesException {

		DrinkMenu drink;
		try {
			drink = DrinkMenu.valueOf(drinkName.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new NotEnoughResourcesException("Напиток '" + drinkName + "' не найден в меню.");
		}

		Coffeemachine machine = findMachine(machineId);
		if (machine == null) {
			throw new NotEnoughResourcesException("Кофемашина с ID " + machineId + " не найдена.");
		}

		return prepareDrink(machine, drink);
	}

	public void refillResources(int id, double water, double beans, double milk) {
		Coffeemachine machine = findMachine(id);
		if (machine != null) {
			machine.addWater(water);
			machine.addBeans(beans);
			machine.addMilk(milk);
			Notifications.showSuccessRefill(id);
		} else {
			Notifications.showNotFound(id);
		}
	}

	public List<Coffeemachine> getMachines() {
		return this.machines;
	}

	public void setMachines(List<Coffeemachine> machines) {
		this.machines = machines;
	}

}
