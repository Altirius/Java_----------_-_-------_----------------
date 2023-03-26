import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
	StringBuilder stringBuilder;

	public static void main(String[] args) {
		Program prog = new Program();
		prog.readStringFromFile("./data.txt");
		prog.parseString();
	}
	
	void readStringFromFile(String filePath) {
		this.stringBuilder = new StringBuilder();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			char[] buffer = new char[10];
			while (reader.read(buffer) != -1) {
				this.stringBuilder.append(new String(buffer));
				buffer = new char[10];
			}
			reader.close();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void parseString() {
		String regex = "\"фамилия\":\"([А-я]+)\",\"оценка\":\"([1-5])\",\"предмет\":\"([А-я]+)\"";

		Matcher matcher = Pattern
			.compile(regex)
			.matcher(this.stringBuilder);

		while (matcher.find()) {
			this.writeStudentInfo(matcher.group(1), matcher.group(2), matcher.group(3));
		}
	}

	void writeStudentInfo(String lastName, String grade, String subject) {
		System.out.println("Студент " + lastName + " получил " + grade + " по предмету " + subject);
	}
}