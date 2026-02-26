package com.nastya.caffe.main;

import com.nastya.caffe.ui.CoffeemachineUI;

import com.nastya.caffe.model.Coffeemachine;

import com.nastya.caffe.service.CoffeeMachineService;

public class Main {

	public static void main(String[] args) {

		CoffeeMachineService service = new CoffeeMachineService();

		CoffeemachineUI UI = new CoffeemachineUI(service);

		service.addMachine(new Coffeemachine(1, "DeLonghi", 500.0, 100.0, 300.0));
		service.addMachine(new Coffeemachine(2, "Philips", 1000.0, 200.0, 500.0));
		service.addMachine(new Coffeemachine(3, "Nespresso", 300.0, 50.0, 0.0));

		service.refillResources(3, 0, 100, 200);

		UI.start();

	}

}
