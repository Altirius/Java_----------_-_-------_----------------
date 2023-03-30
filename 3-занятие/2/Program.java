import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	ArrayList<Integer> numbers = new ArrayList<>();

	public static void main(String[] args) {
		Program prog = new Program();
		prog.inputArrayList();
		prog.removeEvens();
	}

	void inputArrayList() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите количество элементов в массиве: ");
		int n = sc.nextInt();

		System.out.println("Поочерёдно введите элементы массива: ");
		for (int i = 0; i < n; i++) {
			this.numbers.add(sc.nextInt());
		}

		sc.close();
	}

	void removeEvens() {
		this.numbers.removeIf(n -> (n % 2 == 0));
		for (int i : this.numbers) {
			System.out.print(String.valueOf(i) + " ");
		}
	}
}
