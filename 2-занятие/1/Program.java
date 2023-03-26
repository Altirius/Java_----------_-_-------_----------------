import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Program {
	Logger logger;
	FileHandler fileHandler;
	int[] array;
	int n;

	public static void main(String[] args) {
		Program prog = new Program();
		prog.inputArray();
		prog.initializeLogger("./logs.log");
		prog.bubbleSortWIthLogger();
	}

	void inputArray() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите количество элементов в массиве: ");
		this.n = sc.nextInt();

		this.array = new int[this.n];
		System.out.println("Поочерёдно введите элементы массива: ");
		for (int i = 0; i < this.n; i++) {
			this.array[i] = sc.nextInt();
		}

		sc.close();
	}

	void initializeLogger(String filePath) {
		this.logger = Logger.getLogger("Logs");
	
		try {
			fileHandler = new FileHandler(filePath);
			logger.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void bubbleSortWIthLogger() {
		this.logger.info("Начало сортировки");
		for (int i = 0; i < this.n; i++) {
			for (int j = 1; j < (this.n - i); j++) {
				if (isNeedToSwap(j)) {
					this.swapItems(j);
					this.logger.info(this.getArrayAsString());
				}
			}
		}
		this.logger.info("Сортировка завершена");
	}

	boolean isNeedToSwap(int index) {
		return this.array[index - 1] > this.array[index];
	}

	void swapItems(int index) {
		int temp = this.array[index - 1];
		this.array[index - 1] = this.array[index];
		this.array[index] = temp;
	}

	String getArrayAsString() {
		String[] result = new String[this.n];
		for(int i = 0; i < this.n; i++) {
			result[i] = String.valueOf(this.array[i]);
		}

		return String.join(" ", result);
	}

}
