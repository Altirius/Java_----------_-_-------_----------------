public class Program {
	public static void main(String[] args) {
		System.out.println(Program.isPalindrome("0011221100"));
		System.out.println(Program.isPalindrome("123456789"));
	}

	static boolean isPalindrome(String value) {
		int middleIndex = value.length() / 2;
		int lastIndex = value.length() - 1;
		for(int i = 0; i < middleIndex; i++) {
			if (value.charAt(i) != value.charAt(lastIndex - i)) {
				return false;
			}
		}

		return true;
	}
}
