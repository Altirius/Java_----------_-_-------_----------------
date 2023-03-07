
//Реализовать простой калькулятор (+ - / *)
//Ввод числа ->
//Ввод знака ->
//Ввод числа ->
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		System.out.print("Ввод числа 1 -> ");
		Scanner inputScanner = new Scanner(System.in);
		int num1 = inputScanner.nextInt();
		System.out.print("Ввод знака ->  ");
		String znak = inputScanner.next();
		System.out.print("Ввод числа 2 -> ");
		int num2 = inputScanner.nextInt();
		inputScanner.close();
	
		int result = 0;
		switch (znak) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			default:
				System.out.println("Такого знака я ещё не знаю, но обязательно выучу его с:");
				break;
		}

		System.out.println("Результат -> " + result);
	}

}
