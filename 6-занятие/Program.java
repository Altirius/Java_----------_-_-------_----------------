import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Filter;

import Devices.Notebook;
import Enums.Colors;
import Enums.Filters;
import Enums.OperatingSystems;
import Enums.RAM;
import Enums.ROM;
import Enums.UserActions;

public class Program {
	private Scanner input = new Scanner(System.in);
	
	private HashMap<Filters, Integer> filters = new HashMap<>();
	private UserActions action = UserActions.NOTHING;
	private ArrayList<Notebook> notebooks = new ArrayList<>();
	

	static public void main(String[] args) {
		Program prog = new Program();
		prog.start();
	}


	public void start() {
		this.prepareNotebooks();
		this.messageLoop();
	}

	private void prepareNotebooks() {
		this.notebooks.add(new Notebook("DELL", "G15", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", RAM.GB_8, ROM.GB_256, OperatingSystems.MAC, Colors.GRAY));
		this.notebooks.add(new Notebook("Samsung", "r530", RAM.GB_16, ROM.GB_512, OperatingSystems.LINUX, Colors.WHITE));
		this.notebooks.add(new Notebook("DELL", "G15", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", RAM.GB_8, ROM.GB_256, OperatingSystems.MAC, Colors.BLACK));
		this.notebooks.add(new Notebook("Samsung", "r530", RAM.GB_16, ROM.GB_512, OperatingSystems.LINUX, Colors.WHITE));
		this.notebooks.add(new Notebook("DELL", "G15", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("DELL", "G8", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", RAM.GB_8, ROM.GB_256, OperatingSystems.MAC, Colors.GRAY));
		this.notebooks.add(new Notebook("Samsung", "r530", RAM.GB_16, ROM.GB_1024, OperatingSystems.WINDOWS, Colors.PINK));
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
		Filters filterId = this.askAndGetFilterId();
		Integer filterValue = this.askAndGetFilterValue(filterId);
		this.filters.put(filterId, filterValue);
	}

	private Filters askAndGetFilterId() {
		this.askFilter();
		return Filters.getFilterByKey(this.input.nextInt());
	}

	private void askFilter() {
		ArrayList<Filters> filters = new ArrayList<>();
			filters.add(Filters.RAM);
			filters.add(Filters.ROM);
			filters.add(Filters.SYSTEM);
			filters.add(Filters.COLOR);
		
		filters.forEach(filter -> System.out.println(filter.getMenuItemString()));
	}

	private Integer askAndGetFilterValue(Filters filterId) {
		this.askFilterValue(filterId);
		return this.input.nextInt();
	}

	private void askFilterValue(Filters filterId) {
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
