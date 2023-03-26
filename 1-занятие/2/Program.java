//Вывести все простые числа от 1 до 1000


public class Program {
	public static void main(String[] args) {
				int i=3;
				System.out.println(1);
				System.out.println(2);
				while (i<=1000) {
					boolean flag=true;
					for (int j=2; j<i; j++){
						if (i%j == 0) {
							flag=false;
							break;
						}
					}
					if (flag){
					System.out.println(i);
					}
					i++;
				}
		}
	}
