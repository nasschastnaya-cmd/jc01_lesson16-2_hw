package com.nastya.caffe.ui;

import com.nastya.caffe.model.DrinkMenu;
import com.nastya.caffe.model.Coffeemachine;

public class Notifications {

	public static void showStart(String drinkName) {
		System.out.println(">>> Готовим " + drinkName + "...");
	}

	public static void showSuccess(String drinkName) {
		System.out.println("Успех! Ваш " + drinkName + " готов. Приятного аппетита!");
	}

	public static void showResourceError(String ingredient) {
		System.err.println("ВНИМАНИЕ: Недостаточно ресурса: " + ingredient);
	}

	public static void showMachineAdded(int id) {
		System.out.println("ИНФО: Машина №" + id + " успешно зарегистрирована.");
	}

	public static void showMachineRemoved(int id) {
		System.out.println("ВНИМАНИЕ: Машина №" + id + " удалена из системы.");
	}

	public static void showNotFound(int id) {
		System.err.println("ОШИБКА: Машина с ID " + id + " не найдена.");
	}

	public static void showMainMenuHeader() {
		System.out.println("\n======= МЕНЮ НАПИТКОВ =======");
	}

	public static void showMenuItem(int index, DrinkMenu drink) {
		// Используем %d для цены, так как в enum это int
		System.out.printf("[%d] %-10s\n", index, drink.getName());
	}

	public static void showExitOption() {
		System.out.println("[9] Выход из программы");
		System.out.print("Ваш выбор: ");
	}

	public static void showInvalidInput() {
		System.err.println("Ошибка: Пожалуйста, выберите номер из списка!");
	}

	public static void showCookingProgress() {
		System.out.print("Приготовление: ");
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(800); // Пауза 0.8 секунды
				System.out.print("☕ "); // Выводим иконку кофе
			}
			System.out.println(); // Переход на новую строку после завершения
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void showMachineMenuHeader() {
		System.out.println("\n=== ВЫБОР КОФЕМАШИНЫ ===");
	}

	public static void showMachineOption(int id, String brand) {
		System.out.println("[" + id + "] Кофемашина " + brand);
	}

	public static void showMachineSelectPrompt() {
		System.out.print("Выберите ID машины (или 0 для выхода): ");
	}

	public static void showSuccessRefill(int id) {
		System.out.println("✅ Ресурсы для машины #" + id + " успешно обновлены.");
	}

	public static void showStatus(Coffeemachine machine) {
		System.out.printf("☕ Машина №%d | Модель: %s | Вода: %.1f мл | Кофе: %.1f г | Молоко: %.1f мл%n",
				machine.getId(), machine.getBrand(), machine.getWaterLevel(), machine.getCoffeeBeans(),
				machine.getMilkLevel());
	}
}
