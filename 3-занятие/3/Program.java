import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	ArrayList<Integer> numbers = new ArrayList<>();

	public static void main(String[] args) {
		Program prog = new Program();
		prog.inputArrayList();
		prog.findMinMaxAndAverage();
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

	void findMinMaxAndAverage() {
		int max = this.numbers.get(0);
		int min = this.numbers.get(0);
		double sum = this.numbers.get(0);
		
		for(int i = 1; i < this.numbers.size(); i++) {
			int item = this.numbers.get(i);
			
			if (item > max)
				max = item;
			if (item < min)
				min = item;
			sum += item;
		}

		double average = sum / this.numbers.size();

		System.out.println("Максимум: " + String.valueOf(max));
		System.out.println("Минимум: " + String.valueOf(min));
		System.out.println("Среднее арифметическое: " + String.valueOf(average));
	}
}
