import java.util.ArrayList;
import java.util.Scanner;

import Devices.Notebook;
import Enums.Colors;
import Enums.OperatingSystems;
import Enums.UserActions;

public class Program {
	private Scanner input = new Scanner(System.in);
	private Object filter = new Object();
	private ArrayList<Notebook> notebooks = new ArrayList<>();
	private UserActions action = UserActions.NOTHING;

	static public void main(String[] args) {
		Program prog = new Program();
		prog.start();
	}


	public void start() {
		this.prepareNoteBooks();
		this.messageLoop();
	}

	private void prepareNoteBooks() {
		this.notebooks.add(new Notebook("DELL", "G15", 16, 512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", 8, 256, OperatingSystems.MAC, Colors.GRAY));
		this.notebooks.add(new Notebook("Samsung", "r530", 16, 512, OperatingSystems.LINUX, Colors.WHITE));
		this.notebooks.add(new Notebook("DELL", "G15", 16, 512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", 8, 256, OperatingSystems.MAC, Colors.BLACK));
		this.notebooks.add(new Notebook("Samsung", "r530", 16, 512, OperatingSystems.LINUX, Colors.WHITE));
		this.notebooks.add(new Notebook("DELL", "G15", 16, 512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("DELL", "G8", 16, 512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", 8, 256, OperatingSystems.MAC, Colors.GRAY));
		this.notebooks.add(new Notebook("Samsung", "r530", 16, 1024, OperatingSystems.WINDOWS, Colors.PINK));
	}

	private void messageLoop() {
		while (isTimeToLeave()) {
			this.action = this.askAndGetUserAction();
			this.handleAction(action);
		}
	}

	private boolean isTimeToLeave() {
		return this.action == UserActions.EXIT;
	}

	private UserActions askAndGetUserAction() {
		return this.getUserAction();
	}

	private void askUserAction() {

		System.out.println();
	}

	private UserActions getUserAction() {
		Integer action = this.input.nextInt();

		if (UserActions.ADD_FILTER.getKey() == action)
			return UserActions.ADD_FILTER;
		if (UserActions.SHOW.getKey() == action)
			return UserActions.SHOW;
		if (UserActions.RESET_FILTER.getKey() == action)
			return UserActions.RESET_FILTER;
		if (UserActions.EXIT.getKey() == action)
			return UserActions.EXIT;

		return UserActions.NOTHING;
	}

	private void handleAction(UserActions action) {
		// TODO: Дописать обработчики
	}

	private void handleAddFilter() {

	}

	private void printNotebooks(ArrayList<Notebook> notebooks) {
		notebooks.forEach(notebook -> notebook.print());
	}

}
