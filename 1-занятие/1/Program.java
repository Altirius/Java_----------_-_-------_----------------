//Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
//Ввод:5
//Треугольное число 1 + 2 + 3 + 4 + 5 = 15
//n! 1 * 2 * 3 * 4 * 5 = 120

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		System.out.print("Введите число N: ");
	
		Scanner inputScanner = new Scanner(System.in);
		int num = inputScanner.nextInt();
		inputScanner.close();
		int i=0;
		int sumT=0;
		while (i <= num) {
			sumT=sumT+i;
			i++;
		}
		int j=1;
		int fct=1;
		while (j<=num){
			fct=fct*j;
			j++;
		}
		System.out.println("Треугольное число: "+sumT);
		System.out.println("n!: " + fct);
	}
}
