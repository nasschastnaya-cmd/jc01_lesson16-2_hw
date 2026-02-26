package com.nastya.caffe.ui;


import com.nastya.caffe.exception.NotEnoughResourcesException;
import com.nastya.caffe.model.Coffeemachine;
import com.nastya.caffe.model.DrinkMenu;
import com.nastya.caffe.service.CoffeeMachineService;


public class CoffeemachineUI {

	CoffeeMachineService service;
	private UserInterface ui = new UserInterface();

	public CoffeemachineUI() {
	}

	public CoffeemachineUI(CoffeeMachineService service) {
		this.service = service;
	}

	public void start() {
		showAll();
		boolean isAppRunning = true;

		while (isAppRunning) {

			int machineId = ui.getMachineChoice();

			if (machineId == 0) {
				isAppRunning = false;
				continue;
			}

			Coffeemachine selectedMachine = service.findMachine(machineId);
			if (selectedMachine != null) {
				runMachineLogic(selectedMachine);
			} else {
				Notifications.showNotFound(machineId);
			}
		}
			
	}

	public void runMachineLogic(Coffeemachine machine) {
		boolean isMachineActive = true;
		while (isMachineActive) {
			int choice = ui.showMenuAndGetChoice();
			if (choice == 9) {
				isMachineActive = false;
			} else if (choice >= 0 && choice < DrinkMenu.values().length) {
				String drinkName = DrinkMenu.values()[choice].name();
				try {

					service.prepareDrink(drinkName, machine.getId());

					Notifications.showStatus(machine);

				} catch (NotEnoughResourcesException e) {

					System.err.println(e.getMessage());
				}
			}
		}
	}

	public void showAll() {
		
		for (Coffeemachine m : service.getMachines()) {
			Notifications.showStatus(m);
		}
	}

}
