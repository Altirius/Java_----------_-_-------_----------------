import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Filter;

import Devices.Notebook;
import Enums.Colors;
import Enums.FilterIds;
import Enums.OperatingSystems;
import Enums.UserActions;

public class Program {
	private Scanner input = new Scanner(System.in);
	
	private HashMap<FilterIds, Integer> filters = new HashMap<>();
	private UserActions action = UserActions.NOTHING;
	private ArrayList<Notebook> notebooks = new ArrayList<>();
	

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
		this.askUserAction();
		return UserActions.getUserActionByKey(this.input.nextInt());
	}

	private void askUserAction() {
		// Ask frase
	}

	private void handleAction(UserActions action) {
		switch (action) {
			case ADD_FILTER:
				this.handleAddFilter();
				break;
			case SHOW:
				this.handleShowFiltered();
			case RESET_FILTER:
				this.handleResetFilter();

			default:
				break;
		}
	}

	private void handleAddFilter() {
		this.askAndGetFilterId();
	}

	private FilterIds askAndGetFilterId() {
		this.askFilter();
		return FilterIds.getFilterByKey(this.input.nextInt());
	}

	private void askFilter() {
		// Ask Frase
	}

	private void handleShowFiltered() {

	}

	private void handleResetFilter() {

	}
	
	private void printNotebooks(ArrayList<Notebook> notebooks) {
		notebooks.forEach(notebook -> notebook.print());
	}

}
