// *(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		System.out.print("Введите уравнение типа q + w = e, q, w, e >= 0  -> ");
		Scanner inputScanner = new Scanner(System.in);
		String inputString = inputScanner.nextLine();
		inputScanner.close();

		String[] inputParams = inputString.split(" ");
		for (int i = 0; i <= 4; i += 2) {
			System.out.print(inputParams[i] + " ");
		}
		
	}
}
