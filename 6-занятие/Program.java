import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Devices.Notebook;
import Enums.Colors;
import Enums.Filters;
import Enums.OperatingSystems;
import Enums.RAM;
import Enums.ROM;
import Enums.UserActions;
import Interfaces.ISelectebleItem;

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
		while (!isTimeToLeave()) {
			this.action = this.askAndGetUserAction();
			this.handleAction(action);
		}
	}

	private boolean isTimeToLeave() {
		return this.action == UserActions.EXIT;
	}

	private UserActions askAndGetUserAction() {
		this.askUserAction();
		return UserActions.getEntityByKey(this.input.nextInt());
	}

	private void askUserAction() {
		UserActions[] options = UserActions.values();

		for (int i = 1; i < options.length; i++) {
			System.out.println(options[i].getMenuItemString());
		}
	}

	private void handleAction(UserActions action) {
		switch (action) {
			case ADD_FILTER:
				this.handleAddFilter();
				break;
			case SHOW:
				this.handleShowFiltered();
				break;
			case RESET_FILTER:
				this.handleResetFilter();
				break;
			default:
				break;
		}
	}

	private void handleAddFilter() {
		Filters filter = this.askAndGetFilter();
		if (this.isFilterNothing(filter))
			return;

		Integer filterValue = this.askAndGetFilterValue(filter);
		this.filters.put(filter, filterValue);
	}

	private Filters askAndGetFilter() {
		this.askFilter();
		return Filters.getEntityByKey(this.input.nextInt());
	}

	private void askFilter() {
		Filters[] options = Filters.values();

		for(int i=0; i < options.length; i++) {
			System.out.println(options[i].getMenuItemString());
		}
	}

	private boolean isFilterNothing(Filters filter) {
		return Filters.NOTHING == filter;
	}

	private Integer askAndGetFilterValue(Filters filter) {
		this.askFilterValue(filter);
		return this.getFilterValue();
	}

	private void askFilterValue(Filters filter) {
		switch (filter) {
			case RAM:
				this.askAnyFilterValue(RAM.values());
				break;
			case ROM:
				this.askAnyFilterValue(ROM.values());
				break;
			case SYSTEM:
				this.askAnyFilterValue(OperatingSystems.values());
				break;
			case COLOR:
				this.askAnyFilterValue(Colors.values());
				break;
			default:
				break;
		}
	}


	private <T extends ISelectebleItem> void askAnyFilterValue(T[] options) {
		for (int i = 0; i < options.length; i++) {
			System.out.println(options[i].getMenuItemString());
		}
	}

	private Integer getFilterValue() {
		return this.input.nextInt();
	}

	private void handleShowFiltered() {
		ArrayList<Notebook> notebooks = new ArrayList<>();
		notebooks.addAll(this.notebooks);
		notebooks.removeIf(notebook -> this.isNotebookNeedToRemove(notebook));

		this.printNotebooks(notebooks);
	}

	private boolean isNotebookNeedToRemove(Notebook notebook) {
		for (HashMap.Entry<Filters, Integer> entry : this.filters.entrySet()) {
			Filters filter = entry.getKey();
			Integer filterValue = entry.getValue();
			boolean filtered = false;

			if (filterValue > 0) {
				switch (filter) {
					case RAM:
						filtered = notebook.filterByRAM(filterValue);
						break;
					case ROM:
						filtered = notebook.filterByROM(filterValue);
						break;
					case SYSTEM:
						filtered = notebook.filterBySystem(filterValue);
						break;
					case COLOR:
						filtered = notebook.filterByColor(filterValue);
						break;
					default:
						break;
				}

				if (filtered) {
					return filtered;
				}
			}

			return false;
		}

		return false;
	}

	private void handleResetFilter() {
		this.filters.clear();
	}

	private void printNotebooks(ArrayList<Notebook> notebooks) {
		notebooks.forEach(notebook -> notebook.print());
	}

}
