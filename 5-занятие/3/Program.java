public class Program {
	static int[] chessboard = { 0, 0, 0, 0, 0, 0, 0, 0 };
	static int index = 0;
	static int version = 0;

	public static void main(String[] args) {
		boolean isFounded = false;
		while(!isFounded) {
			if (checking()) {
				if (index == 7) {
					isFounded = true;
					printBoardVersion(chessboard);
					chessboard[index]++;
				} else {
					index++;
				}
			} else {
				chessboard[index]++;
			}
		} 
	}

	static void printBoardVersion(int[] chessboard) {
		for (int i = 0; i < 8; i++) {
			StringBuilder outString = new StringBuilder("00000000");
			outString.setCharAt(chessboard[i], 'X');;
			System.out.println(outString);
		}
	}

	static boolean checking() {
		int i;

		if (index == 0) {
			return true;
		}

		if (chessboard[index] > 7) {
			chessboard[index] = 0;
			index--;
			return false;
		}

		for (i = 0; i < index; i++) {
			if ((chessboard[index] == chessboard[i]) | ((Math.abs(chessboard[index] - chessboard[i])) == (index - i))) {
				return false;
			}
		}

		return true;
	}
}
