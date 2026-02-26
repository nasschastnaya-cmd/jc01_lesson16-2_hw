package com.nastya.caffe.ui;

import com.nastya.caffe.model.DrinkMenu;

import java.util.Scanner;

public class UserInterface {
	private Scanner scanner = new Scanner(System.in);

	public int showMenuAndGetChoice() {
		Notifications.showMainMenuHeader();

		DrinkMenu[] drinks = DrinkMenu.values();
		for (int i = 0; i < drinks.length; i++) {
			Notifications.showMenuItem(i, drinks[i]);
		}

		Notifications.showExitOption();
		while (!scanner.hasNextInt()) {
			System.out.println("⚠️ Ошибка: Пожалуйста, введите целое число (ID машины)!");
			scanner.next();
		}

		return scanner.nextInt();
	}

	public int getMachineChoice() {
		Notifications.showMachineMenuHeader();
		Notifications.showMachineSelectPrompt();
		while (!scanner.hasNextInt()) {
			System.out.println("⚠️ Ошибка: Пожалуйста, введите целое число (ID машины)!");
			scanner.next();
		}
		return scanner.nextInt();
	}

}
